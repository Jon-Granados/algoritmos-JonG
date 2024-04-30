package cr.ac.ucr.paraiso.ie.algoritmos.semana7.pilas;

public class MainPilaNodo {
	
	    public static void main(String[] args) {
	    	PilaNodo<Integer> pila = new PilaNodo<>();

	        // Agregar elementos a la pila
	        pila.push(10);
	        pila.push(20);
	        pila.push(30);

	        // Imprimir la pila
	        System.out.println("Elementos en la pila:");
	        while (!pila.isEmpty()) {
	            System.out.println(pila.pop());
	        }
	    }
}
