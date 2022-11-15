/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.segundoobligatorio;

public class Proceso {

    public static final int PRIORIDAD_MAXIMA = 0;
    public static final int PRIORIDAD_MINIMA = 50;

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
    private boolean SO;                 //SO = True, Usuario = False

    public enum Estado {
        FINALIZADO,
        BLOQUEADO,
        EN_EJECUCION,
        LISTO
    }

    public Proceso(long id, double tiempoEnCPU, double esperaES, double periodoES, short prioridad, short edad, Estado estado, boolean SO) {
        this.id = id;
        this.tiempoEnCPU = tiempoEnCPU;
        this.tiempoRestanteEnCPU = tiempoEnCPU;
        this.esperaES = esperaES;
        this.esperaRestanteES = esperaES;
        this.periodoES = periodoES;
        this.periodoRestanteES = periodoES;
        this.prioridad = prioridad;
        this.edad = edad;
        this.estado = estado;
        this.SO = SO;
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

    public boolean isSO() {
        return SO;
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
        if (prioridad >= PRIORIDAD_MAXIMA && prioridad <= PRIORIDAD_MINIMA) {
            this.prioridad = prioridad;
            return;
        }
        throw new IllegalArgumentException("La prioridad debe ser menor o igual que"
                + " " + PRIORIDAD_MINIMA + " y mayor o igual que " + PRIORIDAD_MAXIMA);
    }

    public void setEdad(short edad) {
        this.edad = edad;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setSO(boolean SO) {
        this.SO = SO;
    }

    public void incrementarEdad() {
        edad++;
    }
    
    public void envejecer() {
        if (prioridad > 0) {
            
        }
    }
}