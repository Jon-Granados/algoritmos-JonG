package cr.ac.ucr.paraiso.ie.algoritmos.tema3;

import java.util.EmptyStackException;

public class StackExample <T>{
    private Nodo<T> cima;

    // Constructor para crear una pila vacía
    public StackExample() {
        cima = null;
    }

    // Apilar un elemento
    public void apilar(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        nuevoNodo.siguiente = cima;
        cima = nuevoNodo;
    }

    // Desapilar un elemento
    public T desapilar() {
        if (estaVacia()) {
            throw new EmptyStackException(); // Manejar la excepción de pila vacía
        }

        Nodo<T> aux = cima;
        cima = cima.siguiente;
        return aux.dato;
    }

    // Obtener el elemento superior (top)
    public T top() {
        if (estaVacia()) {
            throw new EmptyStackException(); // Manejar la excepción de pila vacía
        }

        return cima.dato;
    }

    // Verificar si la pila está vacía
    public boolean estaVacia() {
        return cima == null;
    }

    // Clase interna para representar un nodo de la pila
    private static class Nodo<T> {
        private T dato;
        private Nodo<T> siguiente;

        public Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }
    public static void main(String []args) {
    	StackExample<String> pila = new StackExample<>(); // Crea una pila de cadenas

    	pila.apilar("Hola");
    	pila.apilar("Mundo");
    	pila.apilar("!");

    	System.out.println(pila.top()); // Imprime "!"
    	System.out.println(pila.desapilar()); // Imprime "!"
    	System.out.println(pila.desapilar()); // Imprime "Mundo"
    	System.out.println(pila.desapilar()); // Imprime "Hola"

    	System.out.println(pila.estaVacia()); // Imprime "true"
    }
    
}
