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
        // porque no puedo inicializar la valiable de otra manera
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
        while( actual != null && elem.compareTo(actual.valor) != 0  ){
            if(elem.compareTo(actual.valor) < 0){
                if(actual.izq == null){
                    // tengo que crear un nodo nuevo que referencie a otro etc... :/
                    Nodo nuevo = new Nodo(elem);
                    nuevo.padre = actual; 
                    actual.izq = nuevo;
                    actual = actual.izq;
                }else{
                actual = actual.izq;
                }
            } else {
                if(actual.der == null){
                    Nodo nuevo = new Nodo(elem);
                    nuevo.padre = actual; 
                    actual.der = nuevo;
                    actual = actual.der;
                }else{
                actual = actual.der;
                }
            }
        }
        if(actual == null){
        _raiz = new Nodo(elem);        
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
            if(elem.compareTo(nodo.valor) == 0){
                pertenece = true;
            } else if(elem.compareTo(nodo.valor) < 0 ){
                pertenece = pertenecerecursivo(elem, nodo.izq);
            }else{
                pertenece = pertenecerecursivo(elem, nodo.der);
            }
        } 
        return pertenece;
    }

    public void eliminar(T elem){
        if(pertenece(elem)){
            _raiz = eliminarRecursivo(_raiz, elem);
        }
    }

    private Nodo eliminarRecursivo(Nodo nodo, T elem){  
        Nodo respuesta; 
      
        if(nodo != null){
            Integer compare = elem.compareTo(nodo.valor);

            if (compare < 0){
                nodo.izq = eliminarRecursivo(nodo.izq, elem);
                if(nodo.izq != null){
                    nodo.izq.padre = nodo;
                }
                respuesta = nodo;
            } else if(compare > 0){
                nodo.der = eliminarRecursivo(nodo.der, elem);
                if(nodo.der != null){
                    nodo.der.padre = nodo;
                }
                respuesta = nodo;
            } else {
                // caso 1 -> nodo izq vacio -> hay nodo derecho?
                if(nodo.izq == null){
                    if (nodo.der != null){
                        nodo.der.padre = nodo.padre;
                    }
                    respuesta = nodo.der;
                } 
                // caso 2 -> nodo derecho vacio -> hay nodo izquierdo ? 
                else if(nodo.der == null){
                    if(nodo.izq != null){
                        nodo.izq.padre = nodo.padre;
                    }
                    respuesta = nodo.izq;
                } 
                // caso 3 -> ambos hijos existen 
                else{
                    T predescesor = predescesor(nodo);
                    nodo.valor = predescesor;

                    // borro el predescesor
                    nodo.izq = eliminarRecursivo(nodo.izq, predescesor);
                    if(nodo.izq != null){
                        nodo.izq.padre = nodo;
                    }
                    respuesta = nodo;
                }
            }
        } else { respuesta = null;}

        return respuesta;
    }

    private T predescesor(Nodo nodo){
        Nodo actual = nodo.izq;
        while(actual.der != null){
            actual = actual.der;
        }
        return actual.valor;
    }


    public String toString(){
        String salida = "{";
        // tengo que inicializar el iterador 
        ABB_Iterador it = iterador(); 
        Integer cant_copiados = 0;

        while(it.haySiguiente()){
            if(cant_copiados < this.cardinal() - 1){
            salida += it.siguiente() + ",";
            cant_copiados += 1;
            } else {
                salida += it.siguiente();
            }
        }


        return salida + "}";
    }

    public class ABB_Iterador {
        private Stack<Nodo> pila; 

        public ABB_Iterador() {
        pila = new Stack<>();
        apilarIzquierdos(_raiz);
        }

        private void apilarIzquierdos(Nodo nodo) {
            while (nodo != null) {
                pila.push(nodo);
                nodo = nodo.izq;
            }
        }
        public boolean haySiguiente() {            
            return !pila.isEmpty();
        }
        public T siguiente() {
            Nodo actual = pila.pop();
            if(actual.der != null){
                apilarIzquierdos(actual.der);
            }
            return actual.valor;
        }
    }



    public ABB_Iterador iterador() {
        return new ABB_Iterador();
    }

    }
