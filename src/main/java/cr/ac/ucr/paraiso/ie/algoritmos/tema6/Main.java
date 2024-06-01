package cr.ac.ucr.paraiso.ie.algoritmos.tema6;

public class Main {
    public static void main(String[] args) {
    	ejecutarArbolAVL();
    	//ejecutarArbolBinario();    	
    }
    private static void ejecutarArbolAVL() {
    	ArbolAVL<Integer> arbol = new ArbolAVL<>();

        // Insertar valores en el árbol AVL
        arbol.insertar(10);
        arbol.insertar(5);
        arbol.insertar(15);
        arbol.insertar(3);       
        arbol.insertar(7);
        arbol.insertar(12);
        arbol.insertar(20);   
        arbol.insertar(8);
        arbol.insertar(14);
        arbol.insertar(22);        
        arbol.insertar(1);
        arbol.insertar(25);
        arbol.insertar(19);  
        arbol.insertar(2);
        arbol.insertar(11);
        arbol.insertar(13);
        arbol.insertar(9);
        arbol.insertar(6);
        
        arbol.graficarArbol("D://arbol_ins.jpg");
        // Imprimir el árbol AVL
        System.out.println("Árbol AVL:");
        arbol.imprimirArbol();

        // Imprimir recorridos en orden
        System.out.println("Recorrido Inorden:");
        arbol.printInorden();

        System.out.println("Recorrido Preorden:");
        arbol.printPreorden();

        System.out.println("Recorrido Postorden:");
        arbol.printPostorden();

        // Obtener la altura del árbol AVL
        System.out.println("Altura del árbol AVL: " + arbol.obtenerAltura());

        // Verificar si el árbol AVL está vacío
        System.out.println("¿El árbol AVL está vacío? " + arbol.esVacio());
        // Eliminar un valor del árbol AVL
        arbol.eliminar(5);

        // Imprimir el árbol AVL después de eliminar un valor
        System.out.println("Árbol AVL después de eliminar 5:");
        arbol.imprimirArbol();

        arbol.graficarArbol("D://arbol_eli.jpg");
		
	}
	private static void ejecutarArbolBinario() {
    	//Arbol Binario
        ArbolBinario<Integer> arbol = new ArbolBinario<>();

        // Insertar valores en el árbol
        arbol.insertar(10);
        arbol.insertar(5);
        arbol.insertar(15);
        arbol.insertar(3);
        arbol.insertar(7);
        arbol.insertar(12);
        arbol.insertar(20);

        System.out.println("Árbol en inorden:");
        arbol.printInorden();

        System.out.println("Árbol en preorden:");
        arbol.printPreorden();

        System.out.println("Árbol en postorden:");
        arbol.printPostorden();

        // Buscar valores en el árbol
        System.out.println("\nBuscando el valor 7: " + arbol.buscar(7));
        System.out.println("Buscando el valor 8: " + arbol.buscar(8));

        // Eliminar valores del árbol
        arbol.eliminar(5);
        arbol.eliminar(15);

        System.out.println("\nÁrbol después de eliminar 5 y 15:");
        arbol.printInorden();

        // Obtener altura del árbol
        System.out.println("\nAltura del árbol: " + arbol.obtenerAltura());

        // Verificar si el árbol está vacío
        System.out.println("\nÁrbol vacío: " + arbol.esVacio());
        
        arbol.imprimirArbol();
    }
}