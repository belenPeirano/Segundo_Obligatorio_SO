/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.segundoobligatorio;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;


public class ProcesosBloqueadosTabla extends ProcesosTabla {
    
    private static final short TIEMPO_REFRESCO = 100;
    private static final int COLUMNAS = 4;
    
    private Map<Long, Proceso> procesosBloqueadosPorId;
    
    public ProcesosBloqueadosTabla(Map<Long, Proceso> procesosBloqueadosPorId) {
        super();
        this.procesosBloqueadosPorId = procesosBloqueadosPorId;
        LinkedList<Proceso> procesosBloqueados = new LinkedList<>(this.procesosBloqueadosPorId.values());
        Collections.sort(procesosBloqueados);
        this.procesos = procesosBloqueados.toArray(this.procesos);

        new Thread(() -> {
           while(true) {
                try {
                    Thread.sleep(TIEMPO_REFRESCO);
                    LinkedList<Proceso> procesos = new LinkedList<>(this.procesosBloqueadosPorId.values());
                    
                    Collections.sort(procesos, Collections.reverseOrder());
                    this.procesos = procesos.toArray(this.procesos);
                    this.fireTableDataChanged();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    
    @Override
    public int getColumnCount() {
        return COLUMNAS;
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "Id";
            case 1: return "Prioridad";
            case 2: return "Restante";
            case 3: return "Espera";
        }
        
        return null;
    }

    @Override
    public synchronized Object getValueAt(int rowIndex, int columnIndex) {
        Proceso p = this.procesos[rowIndex];
        if (p != null) {
            switch(columnIndex) {
                case 0: return p.getId();
                case 1: return String.valueOf(p.getPrioridad() + 1);
                case 2: return String.valueOf(p.getTiempoRestanteEnCPU());
                case 3: return String.valueOf(p.getEsperaRestanteES());
            }
        }
        
        return null;
    }
}