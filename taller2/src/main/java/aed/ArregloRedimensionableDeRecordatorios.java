package aed;

class ArregloRedimensionableDeRecordatorios {
    private Recordatorio[] _Recordatorios;

    public ArregloRedimensionableDeRecordatorios() {
        _Recordatorios = new Recordatorio[0];
    }

    public int longitud() {
        Integer cont = 0; 
        for (Recordatorio recordatorio: _Recordatorios){
            cont += 1;
        }
        return cont;
    }

    public void agregarAtras(Recordatorio i) {
        Recordatorio[] _nuevoRecordatorios = new Recordatorio[_Recordatorios.length + 1];
        for(Integer c = 0; c < this.longitud(); c++){
            _nuevoRecordatorios[c] = this.obtener(c);
        }
        _nuevoRecordatorios[_Recordatorios.length] = i; 
        _Recordatorios = _nuevoRecordatorios;
    }

    public Recordatorio obtener(int i) {
        return _Recordatorios[i];
    }

    public void quitarAtras() {
        Recordatorio[] _nuevoRecordatorioSinUlt = new Recordatorio[_Recordatorios.length - 1];
        for(Integer c = 0; c < this.longitud() - 1; c++){
            _nuevoRecordatorioSinUlt[c] = this.obtener(c);
        }
        _Recordatorios = _nuevoRecordatorioSinUlt;    
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        // 
        Recordatorio[] _nuevoRecModificado = new Recordatorio[_Recordatorios.length];
        for(Integer c = 0; c < this.longitud(); c++){
            if(c != indice){
            _nuevoRecModificado[c] = this.obtener(c);
            }else{
                _nuevoRecModificado[c] = valor;

            }
        }
        _Recordatorios = _nuevoRecModificado;
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        // Un metodo constructor de copia, construye una nueva iteración ¡¡¡¡ 
        _Recordatorios = new Recordatorio[vector.longitud()];
        for(Integer i = 0; i < vector.longitud(); i++){
            _Recordatorios[i] = new Recordatorio(vector.obtener(i));
        }
    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        // 
        ArregloRedimensionableDeRecordatorios _copiaArreglo = new ArregloRedimensionableDeRecordatorios(this);
        return _copiaArreglo;
    }
}


