package cr.ac.ucr.paraiso.ie.algoritmos.semana7;

public class MainColaNodo {
	   public static void main(String[] args) {
	        ColaNodo<Integer> cola = new ColaNodo<>();

	        // Verificar si la cola está vacía
	        System.out.println("La cola está vacía: " + cola.isEmpty());

	        // Agregar elementos a la cola
	        cola.enqueue(10);
	        cola.enqueue(20);
	        cola.enqueue(30);

	        // Mostrar el primer elemento de la cola
	        System.out.println("Primer elemento de la cola: " + cola.first());

	        // Desencolar elementos y mostrarlos
	        System.out.println("Elementos desencolados:");
	        while (!cola.isEmpty()) {
	            System.out.println(cola.dequeue());
	        }

	        // Verificar si la cola está vacía después de desencolar
	        System.out.println("La cola está vacía: " + cola.isEmpty());
	    }
}
