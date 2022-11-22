package so.segundoobligatorio;

import java.util.HashMap;

public class Planificador {

    private short cantProcesadores;
    private short cantProcesadoresLibres;
    private double quantum;
    private long ultimoId;
    private ColaMultiNivel<Long, Proceso> colaListos;
    private HashMap<Long, Proceso> procesosBloqueadosPorId;
    private TimerPlanificador timer;
    private Procesador[] procesadores;

    public Planificador(short cantProcesadores, final double quantum) {
        this.cantProcesadores = cantProcesadores;
        this.cantProcesadoresLibres = cantProcesadores;
        this.quantum = quantum;
        this.colaListos = new ColaMultiNivel<Long, Proceso>(100);
        this.procesosBloqueadosPorId = new HashMap<Long, Proceso>();
        this.procesadores = new Procesador[cantProcesadores];

        for (short i = 0; i < cantProcesadores; ++i) {
            this.procesadores[i] = new Procesador(i, quantum, this);
        }
        (this.timer = new TimerPlanificador(this)).iniciar();
    }

    public short getCantProcesadores() {
        return cantProcesadores;
    }

    public short getCantProcesadoresLibres() {
        return cantProcesadoresLibres;
    }

    public double getQuantum() {
        return quantum;
    }

    public ColaMultiNivel<Long, Proceso> getColaListos() {
        return colaListos;
    }

    public HashMap<Long, Proceso> getProcesosBloqueadosPorId() {
        return procesosBloqueadosPorId;
    }

    public Procesador[] getProcesadores() {
        return procesadores;
    }

    public void setCantProcesadores(short cantProcesadores) {
        this.cantProcesadores = cantProcesadores;
    }

    public void setQuantum(double quantum) {
        this.quantum = quantum;
    }

    public boolean setPrioridadProceso(final Proceso proc, final short prioridad) {
        final Proceso proceso = this.colaListos.remover(proc.getId(), proc.getPrioridad());
        if (proceso != null) {
            proceso.setPrioridad(prioridad);
            return this.colaListos.agregar(proceso.getId(), proceso, proceso.getPrioridad()) != null;
        }
        return false;
    }

    public boolean tieneProcesadoresLibres() {
        return cantProcesadoresLibres > 0;
    }

    public synchronized boolean bloquearProceso(final Long id) {
        Procesador[] procesadores;
        for (int i = 0; i < (procesadores = this.procesadores).length; ++i) {
            final Procesador procesador = procesadores[i];
            if (procesador.getProceso() != null) {
                if (procesador.getProceso().getId() == id) {
                    this.procesosBloqueadosPorId.put(id, procesador.removerProceso());
                    ++this.cantProcesadoresLibres;
                    this.actualizar();
                    return true;
                }
            }
        }
        final Proceso proc = this.colaListos.remover(id);
        if (proc != null) {
            this.procesosBloqueadosPorId.put(id, proc);
            this.actualizar();
            return true;
        }
        return false;
    }

    public synchronized boolean desbloquearProceso(final Long id) {
        if (this.procesosBloqueadosPorId.containsKey(id)) {
            final Proceso proc = this.procesosBloqueadosPorId.remove(id);
            //proceso.setEstado(Proceso.Estado.LISTO);
            this.colaListos.agregar(id, proc, proc.getPrioridad());
            this.actualizar();
            return true;
        }
        return false;
    }

    public synchronized void suspenderProceso(final Procesador procesador) {
        final Proceso proc = procesador.getProceso();
        if (proc != null && proc.getEstado() == Proceso.Estado.EN_EJECUCION) {
            final Proceso proceso = procesador.removerProceso();
            proceso.setEstado(Proceso.Estado.LISTO);
            ++this.cantProcesadoresLibres;
            this.colaListos.agregar(proceso.getId(), proceso, proceso.getPrioridad());
            this.actualizar();
        }
    }

    public synchronized boolean finalizarProceso(final Proceso proceso) {
        Procesador[] procesadores;
        for (int length = (procesadores = this.procesadores).length, i = 0; i < length; ++i) {
            final Procesador procesador = procesadores[i];
            if (procesador.getProceso() != null) {
                if (procesador.getProceso().equals(proceso)) {
                    final Proceso proc = procesador.removerProceso();
                    ++this.cantProcesadoresLibres;
                    this.actualizar();
                    return true;
                }
            }
        }
        return false;
    }

    public boolean insertarProceso(final double tiempoEnCPU, final double periodoES, final double esperaES, final short prioridad, Proceso.Tipo tipo) {
        final Proceso nuevoProc = new Proceso(++this.ultimoId, tiempoEnCPU, periodoES, esperaES, prioridad, tipo, this);
        final boolean resultado = this.colaListos.agregar(nuevoProc.getId(), nuevoProc, prioridad) != null;
        if (resultado) {
            this.actualizar();
        }
        return resultado;
    }

    private synchronized void actualizar() {
        if (this.tieneProcesadoresLibres()) {
            Proceso proceso;
            for (proceso = this.colaListos.siguiente(); this.cantProcesadoresLibres > 0 && proceso != null; proceso = this.colaListos.siguiente()) {
                this.despacharProceso(proceso);
            }
            if (proceso != null) {
                this.colaListos.agregar(proceso.getId(), proceso, proceso.getPrioridad());
            }
        }
    }

    private void despacharProceso(final Proceso proceso) {
        Procesador[] procesadores;
        for (int length = (procesadores = this.procesadores).length, i = 0; i < length; ++i) {
            final Procesador procesador = procesadores[i];
            if (procesador.getProceso() == null) {
                procesador.agregarProceso(proceso);
                break;
            }
        }
        --this.cantProcesadoresLibres;
        proceso.ejecutar();
    }

}