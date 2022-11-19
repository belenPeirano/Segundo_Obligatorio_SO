package so.segundoobligatorio;

class TimerProcesador {

    private static final int TICK_PROCESO = 100;
    private Procesador procesador;
    private double quantumRestante;
    private Thread hilo;

    public TimerProcesador(Procesador procesador) {
        this.procesador = procesador;
        this.quantumRestante = procesador.getQuantum();
        this.hilo = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(TICK_PROCESO);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (this.procesador.getProceso() != null) {
                    this.quantumRestante -= TICK_PROCESO;
                    this.tick(this.procesador.getProceso());
                    if (this.quantumRestante <= 0) {
                        this.quantumRestante = this.procesador.getQuantum();
                        this.procesador.getPlanificador().suspenderProceso(this.procesador);

                    }
                } else {
                    continue;
                }
            }
        });
    }

    private void tick(final Proceso proc) {
        final double tiempoRestanteEnCPU = proc.getTiempoRestanteEnCPU() - TICK_PROCESO;
        proc.setTiempoRestanteEnCPU(tiempoRestanteEnCPU);
        if (tiempoRestanteEnCPU <= 0) {
            proc.finalizar();
            this.quantumRestante = this.procesador.getQuantum();
        }
        final double periodoRestanteES = proc.getPeriodoRestanteES() - TICK_PROCESO;
        proc.setPeriodoRestanteES(periodoRestanteES);
        if (periodoRestanteES <= 0) {
            proc.bloquear();
            this.quantumRestante = this.procesador.getQuantum();
        }
    }

    void ejecutar() {
        if (!this.hilo.isAlive()) {
            this.hilo.start();
        }
    }

}
