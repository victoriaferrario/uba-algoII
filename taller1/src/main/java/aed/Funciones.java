package aed;

class Funciones {

/***  Primera parte: Funciones en java ***/

    int cuadrado(int x) {
        int res = x * x; 
        return res;
    }

    double distancia(double x, double y) {
        double res = Math.sqrt(x*x + y*y);
        return res;
    }

    boolean esPar(int n) {
        // % -> mod
        return n%2 == 0;
    }

    boolean esBisiesto(int n) {
        // (divideA(4, n) ∧ ¬divideA(100, n)) ∨ divideA(400, n)
        return (( n%4==0 & (n%100!=0)) || (n%400 == 0));
    }


    int factorialIterativo(int n) {
        int res = 1;
        for (int i = 1; i <= n; i++){
            res = res * i;
        } 
        return res ;
    }

    int factorialRecursivo(int n) {
        int res = 1;
        if(n == 1 || n == 0){
            res = 1;
        }
        else{
            res = n * factorialRecursivo(n-1);
        }
        return res ;
    }

    boolean esPrimo(int n) {
        int cont = 0;
        for (int i = 2; i<n; i++){
            if(n%i == 0){
                cont += 1;
            }
        }
        return cont == 0 && n!=0 && n!=1;
    }

    int sumatoria(int[] numeros) {
        int res = 0;
        for(int i = 0;i<numeros.length;i++){
            res = res + numeros[i];
        }
        return res;
    }

    int busqueda(int[] numeros, int buscado) {
        int res = 0;
        boolean encontrado = false;
        int i = 0;
        while(encontrado == false && i < numeros.length){
            if (numeros[i] == buscado){
                encontrado = true;
                res = i;
            }
            i += 1;
        }
        return res;
    }

    boolean tienePrimo(int[] numeros) {
        boolean res = false;
        for (int i = 0; i < numeros.length; i++){
            if(esPrimo(numeros[i])){
                res = true;
            }
        }
        return res;
    }

    boolean todosPares(int[] numeros) {
        boolean res = true;
        int i = 0;
        while(res == true & i < numeros.length){
            if(!esPar(numeros[i])){
                res = false;
            }
            i += 1;
        }
        return res;
    }

    boolean esPrefijo(String s1, String s2) {
        boolean res = true;
        int i = 0;
        while(res == true & i < s1.length() & s1.length() < s2.length()){
            if(s1.charAt(i)!=s2.charAt(i)){
                res = false;
            }
            i += 1;
        }
        return res & s1.length() <= s2.length();
    }

    String Inverso(String s){
        String res = "";
        for(int i = s.length()-1; i >= 0; i--){
            res += s.charAt(i);
        }
        return res;
    }

    boolean esSufijo(String s1, String s2) {
        return esPrefijo(Inverso(s1), Inverso(s2));
    }

/***  Segunda parte: Debugging ***/

    boolean xor(boolean a, boolean b) {
        return a || b && !(a && b);
    }

    boolean iguales(int[] xs, int[] ys) {
        boolean res = true;

        for (int i = 0; i < xs.length; i++) {
            if (xs[i] != ys[i]) {
                res = false;
            }
        }
        return res;
    }

    boolean ordenado(int[] xs) {
        boolean res = true;
        for (int i = 0; i < xs.length; i++) {
            if (xs[i] > xs [i+1]) {
                res = false;
            }
        }
        return res;
    }

    int maximo(int[] xs) {
        int res = 0;
        for (int i = 0; i <= xs.length; i++) {
            if (xs[i] > res) res = i;
        }
        return res;
    }

    boolean todosPositivos(int[] xs) {
        boolean res = false;
        for (int x : xs) {
            if (x > 0) {
                res = true;
            } else {
                res = false;
            }
        }
        return res;
    }

}
