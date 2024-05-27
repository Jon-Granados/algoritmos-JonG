package cr.ac.ucr.paraiso.ie.algoritmos.tema3;
public class PilaNodo <T>{
	
	    private Nodo top;
	    private int tamanio;

	    // Crear pila
	    public PilaNodo() {
	        top = null;
	        this.tamanio = 0;
	    }

	    // Poner (push)
	    public void push(T dato) {
	        Nodo nuevoNodo = new Nodo(dato);
	        nuevoNodo.siguiente = top;
	        top = nuevoNodo;
	        tamanio++;
	    }

	    // Sacar (pop)
		public T pop() {
	        if (isEmpty()) {
	            throw new RuntimeException("La pila está vacía");
	        }
	        T dato = (T) top.dato;
	        top = top.siguiente;
	        tamanio--;
	        return dato;
	    }

	    // Tope (top)
		public T top() {
	        if (isEmpty()) {
	            throw new RuntimeException("La pila está vacía");
	        }
	        return (T) top.dato;
	    }

	    // Está vacía (is empty)
	    public boolean isEmpty() {
	        return top == null;
	    }

	    // Destruir (destroy)
	    public void destroy() {
	    	emptyStack();
	        this.top = null;
	        this.tamanio = 0;
	    }

	    // Obtener tamaño
	    public int size() {
	        return this.tamanio;
	    }
	    
	    public void emptyStack() {
	        while (!isEmpty()) {
	            pop();
	        }
	    }
	}


