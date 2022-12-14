package so.segundoobligatorio;

public class Proceso implements Comparable {

    public static final int PRIORIDAD_SO_MAXIMA = 0;
    public static final int PRIORIDAD_SO_MINIMA = 50;

    public static final int PRIORIDAD_USUARIO_MAXIMA = 51;
    public static final int PRIORIDAD_USUARIO_MINIMA = 100;

    private long id;
    private double tiempoEnCPU;
    private double tiempoRestanteEnCPU;
    private double esperaES;
    private double esperaRestanteES;
    private double periodoES;
    private double periodoRestanteES;
    private short prioridad;
    private short edad;
    private Estado estado;
    private Planificador planificador;
    public static String SO;
    private Tipo tipo;

    public enum Estado {
        FINALIZADO,
        BLOQUEADO,
        EN_EJECUCION,
        LISTO
    }

    public enum Tipo {
        SO,
        USUARIO
    }

    public Proceso(long id, double tiempoEnCPU, double esperaES, double periodoES, short prioridad, Tipo tipo, final Planificador planificador) {
        this.id = id;
        this.tiempoEnCPU = tiempoEnCPU;
        this.tiempoRestanteEnCPU = tiempoEnCPU;
        this.esperaES = esperaES;
        this.esperaRestanteES = esperaES;
        this.periodoES = periodoES;
        this.periodoRestanteES = periodoES;
        this.prioridad = prioridad;
        this.edad = 0;
        this.estado = Estado.LISTO;
        this.tipo = tipo;
        this.planificador = planificador;
    }

    public long getId() {
        return id;
    }

    public double getTiempoEnCPU() {
        return tiempoEnCPU;
    }

    public double getTiempoRestanteEnCPU() {
        return tiempoRestanteEnCPU;
    }

    public double getEsperaES() {
        return esperaES;
    }

    public double getEsperaRestanteES() {
        return esperaRestanteES;
    }

    public double getPeriodoES() {
        return periodoES;
    }

    public double getPeriodoRestanteES() {
        return periodoRestanteES;
    }

    public short getPrioridad() {
        return prioridad;
    }

    public short getEdad() {
        return edad;
    }

    public Estado getEstado() {
        return estado;
    }

    public Tipo getTipo() {
        return this.tipo;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTiempoEnCPU(double tiempoEnCPU) {
        this.tiempoEnCPU = tiempoEnCPU;
    }

    public void setTiempoRestanteEnCPU(double tiempoRestanteEnCPU) {
        this.tiempoRestanteEnCPU = tiempoRestanteEnCPU;
    }

    public void setEsperaES(double esperaES) {
        this.esperaES = esperaES;
    }

    public void setEsperaRestanteES(double esperaRestanteES) {
        this.esperaRestanteES = esperaRestanteES;
    }

    public void setPeriodoES(double periodoES) {
        this.periodoES = periodoES;
    }

    public void setPeriodoRestanteES(double periodoRestanteES) {
        this.periodoRestanteES = periodoRestanteES;
    }

    public void setPrioridad(short prioridad) {
        if ((tipo.equals(Tipo.SO) && prioridad >= PRIORIDAD_SO_MAXIMA && prioridad <= PRIORIDAD_SO_MINIMA) || (tipo.equals(Tipo.USUARIO) && prioridad >= PRIORIDAD_USUARIO_MAXIMA && prioridad <= PRIORIDAD_USUARIO_MINIMA)) {
            this.prioridad = prioridad;
            return;
        }
    }

    public void setEdad(short edad) {
        this.edad = edad;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    /*public void setSO(String SO) {
        this.SO = SO;
    }*/

    public void incrementarEdad() {
        edad++;
    }

    public void envejecer() {
        if (prioridad > PRIORIDAD_SO_MAXIMA) {
            if (SO.equalsIgnoreCase("USUARIO") && this.prioridad > Proceso.PRIORIDAD_SO_MINIMA) {
                this.prioridad--;
                this.edad = 0;
                this.planificador.setPrioridadProceso(this, this.prioridad);
            } else if (SO.equalsIgnoreCase("SO")) {
                this.prioridad--;
                this.edad = 0;
                this.planificador.setPrioridadProceso(this, this.prioridad);
            }
        }
    }

    public void ejecutar() {
        this.estado = Estado.EN_EJECUCION;
    }

    public void bloquear() {
        this.estado = Estado.BLOQUEADO;
        this.periodoRestanteES = this.periodoES;
        this.planificador.bloquearProceso(this.getId());
    }

    public void desbloquear() {
        this.estado = Estado.LISTO;
        this.esperaRestanteES = this.esperaES;
        this.planificador.desbloquearProceso(this.id);
    }

    public void finalizar() {
        this.estado = Estado.FINALIZADO;
        this.planificador.finalizarProceso(this);
    }

    public String imprimir() {
        return "\nPID: " + this.getId() + "- Info Proceso" + "-" + " Edad: " + this.getEdad() + "-" + " Estado: " + this.getEstado().toString() + "-" + " Prioridad: " + this.getPrioridad() + "-" + " Tiempo restante CPU: " + this.getTiempoRestanteEnCPU() + "-" + " Espera restante ES: " + this.getEsperaRestanteES() + "-" + " Periodo restante hasta ES: " + this.getPeriodoRestanteES();
    }

    @Override
    public int compareTo(final Object o) {
        final Proceso otroProceso = (Proceso) o;
        if (otroProceso.getEsperaRestanteES() == this.esperaRestanteES) {
            return 0;
        }
        if (otroProceso.getEsperaRestanteES() > this.esperaRestanteES) {
            return 1;
        }
        return -1;
    }

}