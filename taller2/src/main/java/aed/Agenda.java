package aed;

public class Agenda {
    private Fecha _fechaActual;
    private ArregloRedimensionableDeRecordatorios _Recordatorios;

    public Agenda(Fecha fechaActual) {
        // 
        _fechaActual = fechaActual;
        _Recordatorios = new ArregloRedimensionableDeRecordatorios();
        
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        // 
        this._Recordatorios.agregarAtras(recordatorio);
    }

    @Override
    public String toString() {
        String recordatoriosenfecha = fechaActual().toString() + "\n=====\n";
        for (Integer i = 0; i < _Recordatorios.longitud(); i++){
            if (_Recordatorios.obtener(i).fecha().equals(fechaActual())){
                recordatoriosenfecha += _Recordatorios.obtener(i).toString() + "\n";
            }
        }
        return recordatoriosenfecha;
    }

    public void incrementarDia() {
        // 
        _fechaActual.incrementarDia();
    }

    public Fecha fechaActual() {
        // 
        Fecha fechaAct = new Fecha(_fechaActual);
        return fechaAct;
    }

}
