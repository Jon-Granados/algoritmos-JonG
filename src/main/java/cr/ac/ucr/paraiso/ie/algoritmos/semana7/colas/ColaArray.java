package cr.ac.ucr.paraiso.ie.algoritmos.semana7.colas;

public class ColaArray<T> {

    private Object[] elementos; // Arreglo de objetos para almacenar los elementos de la cola
   

	private int inicio; // Índice del primer elemento en la cola
    private int fin; // Índice del siguiente espacio disponible en la cola

    // Constructor para crear una cola con un tamaño inicial
    public ColaArray(int tamañoInicial) {
        elementos = new Object[tamañoInicial];
        inicio = 0;
        fin = 0;
    }

    // Método para verificar si la cola está vacía
    public boolean estaVacia() {
        return inicio == fin;
    }

    // Método para encolar un elemento a la cola (enqueue)
    public void encolar(T elemento) {
        if (fin == elementos.length) { // Si la cola está llena, se expande
            Object[] nuevoElementos = new Object[elementos.length * 2];
            System.arraycopy(elementos, inicio, nuevoElementos, 0, elementos.length - inicio);
            elementos = nuevoElementos;
            inicio = 0; // Ajustar el índice de inicio
            fin = elementos.length - inicio; // Ajustar el índice de fin
        }
        elementos[fin++] = elemento;
    }

    // Método para desencolar un elemento de la cola (dequeue)
    public T desencolar() throws Exception {
        if (estaVacia()) {
            throw new Exception("La cola está vacía");
        }
        T elemento = (T) elementos[inicio]; // Se realiza un casting para obtener el elemento del tipo correcto
        inicio++;
        return elemento;
    }

    // Método para obtener el primer elemento de la cola (first)
    public T primero() throws Exception {
        if (estaVacia()) {
            throw new Exception("La cola está vacía");
        }
        return (T) elementos[inicio]; // Se realiza un casting para obtener el elemento del tipo correcto
    }

    // Método para destruir la cola (destroy)
    public void destruir() {
        elementos = null;
        inicio = 0;
        fin = 0;
    }
    public Object[] getElementos() {
		return elementos;
	}

	public void setElementos(Object[] elementos) {
		this.elementos = elementos;
	}

	public int getInicio() {
		return inicio;
	}

	public void setInicio(int inicio) {
		this.inicio = inicio;
	}

	public int getFin() {
		return fin;
	}

	public void setFin(int fin) {
		this.fin = fin;
	}
}
