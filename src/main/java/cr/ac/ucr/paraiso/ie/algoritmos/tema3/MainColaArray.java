package cr.ac.ucr.paraiso.ie.algoritmos.tema3;

public class MainColaArray {
	public static void main(String[] args) throws Exception {
        // Crear una cola de enteros
		ColaArray<Integer> colaEnteros = new ColaArray<>(5);

        // Agregar elementos a la cola
        colaEnteros.encolar(10);
        colaEnteros.encolar(20);
        colaEnteros.encolar(30);

        // Mostrar el primer elemento de la cola
        System.out.println("Primero: " + colaEnteros.primero());

        // Sacar un elemento de la cola
        int elementoSacado = colaEnteros.desencolar();
        System.out.println("Elemento sacado: " + elementoSacado);

        // Mostrar el nuevo primer elemento de la cola
        System.out.println("Nuevo primero: " + colaEnteros.primero());

        // Crear una cola de cadenas
        ColaArray<String> colaCadenas = new ColaArray<>(3);

        // Agregar elementos a la cola
        colaCadenas.encolar("Hola");
        colaCadenas.encolar("Mundo");
        colaCadenas.encolar("!");

        // Mostrar el primer elemento de la cola
        System.out.println("\nPrimero: " + colaCadenas.primero());

        // Sacar un elemento de la cola
        String elementoCadenaSacado = colaCadenas.desencolar();
        System.out.println("Elemento cadena sacado: " + elementoCadenaSacado);

        // Mostrar el nuevo primer elemento de la cola
        System.out.println("Nuevo primero: " + colaCadenas.primero());
    }
}
