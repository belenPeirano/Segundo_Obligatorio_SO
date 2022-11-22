package so.segundoobligatorio;

public class ProcesosTabla extends javax.swing.table.AbstractTableModel {

    private static final int COLUMNAS = 4;
    protected Proceso[] procesos;

    public ProcesosTabla() {
        this.procesos = new Proceso[0];
    }

    @Override
    public int getRowCount() {
        return this.procesos.length;
    }

    @Override
    public int getColumnCount() {
        return COLUMNAS;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Id";
            case 1:
                return "Tipo";
            case 2:
                return "Prioridad";
            case 3:
                return "Restante";
            case 4:
                return "Estado";
        }

        return null;
    }

    public Proceso obtenerProcesoEn(int fila) {
        return this.procesos[fila];
    }

    @Override
    public synchronized Object getValueAt(int rowIndex, int columnIndex) {
        Proceso p = this.procesos[rowIndex];
        if (p != null) {
            switch (columnIndex) {
                case 0:
                    return p.getId();
                case 1:
                    return p.getTipo().toString();
                case 2:
                    return String.valueOf(p.getPrioridad() + 1);
                case 3:
                    return String.valueOf(p.getTiempoRestanteEnCPU());
                case 4:
                    return p.getEstado().toString();
            }
        }
        return null;
    }
}
