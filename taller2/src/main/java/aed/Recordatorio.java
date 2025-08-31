package aed;

public class Recordatorio {
    private String _mensaje;
    private Fecha _fecha;
    private Horario _horario;

    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        _mensaje = new String(mensaje);
        _fecha = new Fecha(fecha);
        _horario = new Horario(horario);
    }

    public Recordatorio(Recordatorio recordatorio) {
        this._mensaje = new String(recordatorio.mensaje());
        this._fecha = new Fecha(recordatorio.fecha());
        this._horario = new Horario(recordatorio.horario());
    }


    public Horario horario() {
        return _horario;
    }

    public Fecha fecha() {
        Fecha fechita = new Fecha(_fecha);
        return fechita;
    }

    public String mensaje() {
        return _mensaje;
    }

    @Override
    public String toString() {
        
        return _mensaje + " @ " + _fecha.toString() + " " + _horario.toString();
    }

    @Override
    public boolean equals(Object otro) {
        Recordatorio otroRecordatorio = null;

        //
        boolean otroNoNull = (otro != null);
        boolean esObjetoDeLaMismaClase = otroNoNull &&  otro.getClass() == this.getClass();

        if(esObjetoDeLaMismaClase){
            otroRecordatorio = (Recordatorio) otro;
        }
            
        return esObjetoDeLaMismaClase && _mensaje.equals(otroRecordatorio.mensaje()) && _fecha.equals(otroRecordatorio.fecha()) && _horario.equals(otroRecordatorio.horario());
    }
}
