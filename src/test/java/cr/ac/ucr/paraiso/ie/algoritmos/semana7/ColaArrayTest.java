package cr.ac.ucr.paraiso.ie.algoritmos.semana7;

import org.junit.*;

import cr.ac.ucr.paraiso.ie.algoritmos.tema3.ColaArray;

import static org.junit.Assert.*;

public class ColaArrayTest<T> {

    private ColaArray<T> cola;

    @Before
    public void setUp() {
        cola = new ColaArray<>(5);
    }

    @Test
    public void testEstaVacia() {
        assertTrue(cola.estaVacia());

        cola.encolar((T) Double.valueOf(10));

        assertFalse(cola.estaVacia());
    }

    @Test
    public void testEncolar() throws Exception {
        cola.encolar((T) Double.valueOf(10));
        cola.encolar((T) "Hola");
        cola.encolar((T) Double.valueOf(30.5));

			assertEquals(10, cola.primero());
		 // Casting para ilustrar
    }

    @Test
    public void testDesencolar() throws Exception {
        cola.encolar((T) Double.valueOf(10));
        cola.encolar((T) "Hola");
        cola.encolar((T) Double.valueOf(30.5));

        
			assertEquals(10, cola.desencolar());
			assertEquals("Hola", cola.desencolar()); // Casting para ilustrar
			assertEquals(30.5, cola.desencolar());

        assertTrue(cola.estaVacia());
    }

    @Test
    public void testPrimero() throws Exception {
        cola.encolar((T) Double.valueOf(10));
        cola.encolar((T) "Hola");
        cola.encolar((T) Double.valueOf(30.5));

        assertEquals(10, cola.primero());

        cola.desencolar();

        assertEquals("Hola", cola.primero()); // Casting para ilustrar
    }

    @Test
    public void testDestruir() {
        cola.encolar((T) Double.valueOf(10));
        cola.encolar((T) "Hola");
        cola.encolar((T) Double.valueOf(30.5));

        cola.destruir();

        assertTrue(cola.estaVacia());
        assertNull(cola.getElementos());
        assertEquals(0, cola.getInicio());
        assertEquals(0, cola.getFin());
    }
}
