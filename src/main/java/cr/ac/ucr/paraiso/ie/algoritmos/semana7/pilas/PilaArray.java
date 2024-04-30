package cr.ac.ucr.paraiso.ie.algoritmos.semana7.pilas;

import java.util.EmptyStackException;

public class PilaArray <T>{
	  private Object[] elementos; // Arreglo de objetos para almacenar los elementos de la pila
      private int tope; // Índice del último elemento en la pila

	    // Constructor para crear una pila con un tamaño inicial
	    public PilaArray(int tamañoInicial) {
	        elementos = new Object[tamañoInicial];
	        tope = -1;
	    }

	    // Método para verificar si la pila está vacía
	    public boolean estaVacia() {
	        return tope < 0;
	    }

	    // Método para agregar un elemento a la pila (push)
	    public void poner(T elemento) { // Se utiliza el tipo genérico 'T' para el elemento
	        if (tope == elementos.length - 1) {
	            Object[] nuevoElementos = new Object[elementos.length * 2];
	            System.arraycopy(elementos, 0, nuevoElementos, 0, elementos.length);
	            elementos = nuevoElementos;
	        }
	        tope++;
	        elementos[tope] = elemento;
	    }

	    // Método para eliminar el último elemento de la pila (pop)
	    public T sacar() {
	        if (estaVacia()) {
	            throw new EmptyStackException();
	        }
	        T elemento = (T) elementos[tope]; // Se realiza un casting para obtener el elemento del tipo correcto
	        tope--;
	        return elemento;
	    }

	    // Método para obtener el último elemento de la pila (top)
	    public T tope() {
	        if (estaVacia()) {
	            throw new EmptyStackException();
	        }
	        T elemento = (T) elementos[tope];
	        return elemento;
	    }

	    // Método para destruir la pila (destroy)
	    public void destruir() {
	    	vaciarPila();
	        elementos = null;
	        tope = -1;
	    }
		public Object[] getElementos() {
			return elementos;
		}

		public void setElementos(Object[] elementos) {
			this.elementos = elementos;
		}

	    public void vaciarPila() {
	        while (!estaVacia()) {
	            sacar();
	        }
	    }
}
