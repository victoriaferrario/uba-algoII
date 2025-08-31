package aed;

public class Fecha {
    private int _dia;
    private int _mes;

    public Fecha(int dia, int mes) {
        // Implementar
        _dia = new Integer(dia);
        _mes = new Integer(mes);
    }

    public Fecha(Fecha fecha) {
        // Implementar
        this._dia = new Integer(fecha.dia());
        this._mes = new Integer(fecha.mes());
    }

    public Integer dia() {
        // Implementar
        return this._dia;
    }

    public Integer mes( ) {
        // Implementar
        return this._mes;
    }

    //Ejercicio 2
    @Override
    public String toString() {
        // Implementar
        return Integer.toString(this._dia)+"/"+Integer.toString(this._mes);
        // llamo a la clase Integer si uso toString() con la clase Fecha me toma esta definición
    }

    @Override
    public boolean equals(Object otra) {
        // Chequeos 
        Fecha otraFecha = null;

        boolean otraNoesNull = (otra != null);
        boolean esObjetoDeLaMismaClase = otraNoesNull && otra.getClass() == this.getClass();

        if (esObjetoDeLaMismaClase){
            //casting -> cambio el tipo (ya se que tienen la misma clase)
            otraFecha = (Fecha) otra;
        }

        // comparar iten a ítem 
        return esObjetoDeLaMismaClase  && this.dia() == otraFecha.dia() &&  this.mes() == otraFecha.mes();
    }

    public void incrementarDia() {
        if(this.dia() < diasEnMes(_mes)){
            _dia += 1;
        }else{
            if(_mes == 12){
                _mes = 1;
                _dia = 1;
            }else{
                _dia = 1;
                _mes += 1;
            }
        }
    }

    private int diasEnMes(int mes) {
        int dias[] = {
                // ene, feb, mar, abr, may, jun
                31, 28, 31, 30, 31, 30,
                // jul, ago, sep, oct, nov, dic
                31, 31, 30, 31, 30, 31
        };
        return dias[mes - 1];
    }

}
