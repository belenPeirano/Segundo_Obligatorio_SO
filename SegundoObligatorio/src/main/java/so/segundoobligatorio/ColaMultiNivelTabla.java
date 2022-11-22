
package so.segundoobligatorio;

import java.util.LinkedHashMap;
import java.util.LinkedList;


public class ColaMultiNivelTabla extends ProcesosTabla {
    private static final short TIEMPO_REFRESCO = 500;

    private ColaMultiNivel colaProcesos;
    
    public ColaMultiNivelTabla(ColaMultiNivel colaProcesos) {
        super();
        this.colaProcesos = colaProcesos;
        LinkedList<Proceso> procesos = new LinkedList<Proceso>();
        for (LinkedHashMap<Long, Proceso> nivel : this.colaProcesos.getColaMultiNivel()) {
            for (Proceso proceso : nivel.values()) {
                procesos.add(proceso);
            }
        }
        this.procesos = procesos.toArray(this.procesos);
        
        new Thread(() -> {
            while(true) {
                try {
                    Thread.sleep(TIEMPO_REFRESCO);
                    LinkedList<Proceso> procesosOrdenados = new LinkedList<Proceso>();
                    for (LinkedHashMap<Long, Proceso> nivel : this.colaProcesos.getColaMultiNivel()) {
                        for (Proceso proceso : nivel.values()) {
                            procesosOrdenados.add(proceso);
                        }
                    }
                    this.procesos = procesosOrdenados.toArray(this.procesos);
                    this.fireTableDataChanged();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
            }
        }).start(); 
    }
}