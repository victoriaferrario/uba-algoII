package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> {
    // Agregar atributos privados del Conjunto
    private Nodo _raiz;

    private class Nodo {
        // Agregar atributos privados del Nodo
         T valor; 
         Nodo izq;
         Nodo der; 
         Nodo padre; 

        // Crear Constructor del nodo

         Nodo(T v){
            valor = v; 
            izq = null;
            der = null;
            padre = null;
         }
    }

    public ABB() {
        _raiz = null;
    }

    public int cardinal() {
        return cardinalrecursivo(_raiz, 0);
    }

    private Integer cardinalrecursivo(Nodo nodo, Integer contador){
        if(nodo == null){
            contador = 0;
        }else{
            contador += 1 + cardinalrecursivo(nodo.izq,0) + cardinalrecursivo(nodo.der,0);
        }
        return contador;

    }
    // arboles binarios el menor de la raiz va por la izquierda siempre
    public T minimo(){
        Nodo actual = _raiz;
        while(actual.izq != null){
            actual = actual.izq;
        }
        return actual.valor;

    }

    // arboles binarios el mayor de la raiz va por la derecha siempre
    public T maximo(){
        Nodo actual = _raiz;
        while(actual.der != null){
            actual = actual.der;
        }
        return actual.valor;
    }

    // odos los tipos de datos comparables tienen definido el m´etodo compareTo(). Sean elem1 y elem2 dos instancias de un mismo tipo de datos comparable,
    // luego elem1.compareTo(elem2) devuelve un entero: 
    // 1) mayor a 0 si elem1 > elem2, 
    // 2) menor a 0 si elem1 < elem2 y 
    // 3) 0 si elem1 = elem2.

    public void insertar(T elem){
        Nodo actual = _raiz;
        while( elem.compareTo(actual.valor) = 0 ){
            if(elem.compareTo(actual.valor) < 0){
                if(actual.izq == null){
                    actual.izq = new Nodo(elem);
                    actual.izq.padre = actual; 
                }else{
                actual = actual.izq;
                }
            } else {
                if(actual.der == null){
                    actual.der = new Nodo(elem);
                    actual.der.padre = actual; 
                }else{
                actual = actual.der;
                }
            }
        }
    }

    public boolean pertenece(T elem){
        return pertenecerecursivo(elem, _raiz);
    }

    private boolean pertenecerecursivo(T elem, Nodo nodo){
        Boolean pertenece;
        if (nodo == null){
            pertenece = false;
        } else {
        if(elem.compareTo(nodo.valor) < 0 ){
            pertenece = elem == nodo.valor || pertenecerecursivo(elem, nodo.izq);
        }else{
            pertenece = elem == nodo.valor || pertenecerecursivo(elem, nodo.der);
        }
        } 
        return pertenece;
    }

    public void eliminar(T elem){
        throw new UnsupportedOperationException("No implementada aun");
    }

    public String toString(){
        throw new UnsupportedOperationException("No implementada aun");
    }

    public class ABB_Iterador {
        private Nodo _actual;

        public boolean haySiguiente() {            
            throw new UnsupportedOperationException("No implementada aun");
        }
    
        public T siguiente() {
            throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public ABB_Iterador iterador() {
        return new ABB_Iterador();
    }

}
