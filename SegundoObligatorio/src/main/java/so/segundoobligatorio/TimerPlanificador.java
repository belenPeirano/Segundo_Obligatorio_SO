package so.segundoobligatorio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TimerPlanificador {

    private static final int EDAD_ENVEJECIMIENTO = 5;
    private static final int TICK_PROCESO = 1000;       //PQ es 1000 y no 100?
    private Planificador planificador;
    private Thread hilo;

    public TimerPlanificador(final Planificador planificador) {
        this.planificador = planificador;
 
        this.hilo = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(TICK_PROCESO);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                try {
                    LinkedHashMap[] copiaColaMultiNivel = this.planificador.getColaListos().getColaMultiNivel().clone();
                    for (LinkedHashMap<Long, Proceso> nivel : copiaColaMultiNivel) {
                        for (Proceso proceso : nivel.values()) {
                            proceso.incrementarEdad();
                            if (proceso.getEdad() == EDAD_ENVEJECIMIENTO) {
                                proceso.envejecer();
                            }
                        }
                    }
                   List<Proceso> copiaBloqueados = new ArrayList<Proceso>();
                    copiaBloqueados.addAll(this.planificador.getProcesosBloqueadosPorId().values());
                    for (Proceso proceso : copiaBloqueados) {
                        proceso.setEsperaRestanteES(proceso.getEsperaRestanteES() - TICK_PROCESO);
                        if (proceso.getEsperaRestanteES() <= 0) {
                            proceso.desbloquear();
                        }
                    }
                } catch (Exception ex) {
                }
            }
        });
    }

    void iniciar() {
        if (!this.hilo.isAlive()) {
            this.hilo.start();
        }
    }

}
