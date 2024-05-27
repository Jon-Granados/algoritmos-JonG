package cr.ac.ucr.paraiso.ie.algoritmos.tema3;

import java.util.EmptyStackException;

public class ColaNodo <T>{
	 private Nodo frente;
	    private Nodo fin;

	    public ColaNodo() {
	        this.frente = null;
	        this.fin = null;
	    }

	    // Enqueue (Encolar)
	    public void enqueue(T dato) {
	        Nodo nuevoNodo = new Nodo(dato);
	        if (isEmpty()) {
	            frente = nuevoNodo;
	        } else {
	            fin.siguiente = nuevoNodo;
	        }
	        fin = nuevoNodo;
	    }

	    // Dequeue (Desencolar)
	    public T dequeue() {
	        if (isEmpty()) {
	            throw new EmptyStackException();
	        }
	        T dato = (T) frente.dato;
	        frente = frente.siguiente;
	        if (frente == null) {
	            fin = null;
	        }
	        return dato;
	    }

	    // First (Primero)
	    public T first() {
	        if (isEmpty()) {
	            throw new EmptyStackException();
	        }
	        return (T) frente.dato;
	    }

	    // Is Empty (Está vacía)
	    public boolean isEmpty() {
	        return frente == null;
	    }

	    // Destroy (Destruir)
	    public void destroy() {
	        frente = null;
	        fin = null;
	    }
	    // Destroy (Destruir)
	    public void destroyTwo() {
	    	while(!isEmpty())
	    		this.dequeue();
	    	
	        this.frente = null;
	        this.fin = null;
	    }
}
