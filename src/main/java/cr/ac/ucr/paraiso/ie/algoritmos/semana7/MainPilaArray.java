package cr.ac.ucr.paraiso.ie.algoritmos.semana7;

public class MainPilaArray {
	

	    public static void main(String[] args) {
	        // Crear una pila de enteros
	    	PilaArray<Integer> pilaEnteros = new PilaArray<>(5);

	        // Agregar elementos a la pila
	        pilaEnteros.poner(10);
	        pilaEnteros.poner(20);
	        pilaEnteros.poner(30);

	        // Mostrar el tope de la pila
	        System.out.println("Tope de la pila de enteros: " + pilaEnteros.tope());

	        // Sacar un elemento de la pila
	        int elementoSacado = pilaEnteros.sacar();
	        System.out.println("Elemento sacado: " + elementoSacado);

	        // Mostrar el nuevo tope de la pila
	        System.out.println("Nuevo tope de la pila de enteros: " + pilaEnteros.tope());

	        // Crear una pila de cadenas
	        PilaArray<String> pilaCadenas = new PilaArray<>(3);

	        // Agregar elementos a la pila
	        pilaCadenas.poner("Hola");
	        pilaCadenas.poner("Mundo");
	        pilaCadenas.poner("!");

	        // Mostrar el tope de la pila
	        System.out.println("\nTope de la pila de cadenas: " + pilaCadenas.tope());

	        // Sacar un elemento de la pila
	        String elementoCadenaSacado = pilaCadenas.sacar();
	        System.out.println("Elemento cadena sacado: " + elementoCadenaSacado);

	        // Mostrar el nuevo tope de la pila
	        System.out.println("Nuevo tope de la pila de cadenas: " + pilaCadenas.tope());
	    }
	

}
