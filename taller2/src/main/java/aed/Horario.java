package aed;

public class Horario {
    private int _hora;
    private int _minutos;

    public Horario(int hora, int minutos) {
        _hora = hora;
        _minutos = minutos;
    }

    public int hora() {
        return _hora;
    }

    public Horario(Horario horario) {
        // Implementar
        this._minutos = horario.minutos();
        this._hora = horario.hora();
    }

    public int minutos() {
        return _minutos;
    }

    @Override
    public String toString() {
        // Implementar
        return Integer.toString(_hora)+":"+Integer.toString(_minutos);
    }

    @Override
    public boolean equals(Object otro) {
        // Implementar
        Horario otroHorario = null;

        //
        boolean otroNoNull = (otro != null);
        boolean esObjetoDeLaMismaClase = otroNoNull &&  otro.getClass() == this.getClass();

        if(esObjetoDeLaMismaClase){
            otroHorario = (Horario) otro;
        }
            
        return esObjetoDeLaMismaClase && otroHorario.hora() == this.hora() && otroHorario.minutos() == this.minutos();
    }

}
