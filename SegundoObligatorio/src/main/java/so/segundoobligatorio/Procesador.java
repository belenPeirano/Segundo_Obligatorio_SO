
package so.segundoobligatorio;


public class Procesador {
    
    private double quantum;
    private short id;
    private Proceso proceso;
    private Planificador planificador;
    private TimerProcesador timerProcesador;

    public Procesador(short id, double quantum, Planificador planificador) {
        this.quantum = quantum;
        this.id = id;
        this.planificador = planificador;
        this.timerProcesador = new TimerProcesador(this);
    }

    public double getQuantum() {
        return quantum;
    }

    public short getId() {
        return id;
    }

    public Proceso getProceso() {
        return proceso;
    }

    public Planificador getPlanificador() {
        return planificador;
    }

    Proceso removerProceso() {
        final Proceso proc = this.proceso;
        this.proceso = null;
        return proc;
    }

    void agregarProceso(Proceso proceso) {
        this.proceso = proceso;
        this.timerProcesador.ejecutar();
    }

}