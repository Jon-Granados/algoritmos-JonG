package cr.ac.ucr.paraiso.ie.algoritmos.semana7;

import static org.junit.Assert.*;

import org.junit.*;

import cr.ac.ucr.paraiso.ie.algoritmos.semana7.pilas.PilaArray;


public class PilaArrayTest<T> {

    private PilaArray<T> pila;

    @Before
    public void setUp() {
        pila = new PilaArray<>(5);
    }

    @Test
    public void testEstaVacia() {
        assertTrue(pila.estaVacia());

        pila.poner((T) "Elemento 1"); // Casting para ejemplo String

        assertFalse(pila.estaVacia());
    }

    @Test
    public void testPoner() {
        pila.poner((T) Double.valueOf(10));
        pila.poner((T) "Hola"); // Diferentes tipos para demostrar generics
        pila.poner((T) Double.valueOf(30.5));

        assertEquals(30.5, pila.tope()); // Casting para ilustrar
    }

    @Test
    public void testSacar() {
        pila.poner((T) Double.valueOf(10));
        pila.poner((T) "Hola");
        pila.poner((T) Double.valueOf(30.5));

        assertEquals(30.5, pila.sacar());
        assertEquals("Hola", pila.sacar()); // Casting para ilustrar
        assertEquals(10, pila.sacar());

        assertTrue(pila.estaVacia());
    }

    @Test
    public void testTope() {
        pila.poner((T) Double.valueOf(10));
        pila.poner((T) "Hola");
        pila.poner((T) Double.valueOf(30.5));

        assertEquals(30.5, pila.tope());

        pila.sacar();

        assertEquals("Hola", pila.tope()); // Casting para ilustrar
    }

    @Test
    public void testDestruir() {
        pila.poner((T) Double.valueOf(10));
        pila.poner((T) "Hola");
        pila.poner((T) Double.valueOf(30.5));

        pila.destruir();

        assertTrue(pila.estaVacia());
        assertNull(pila.getElementos());
        assertEquals(-1, pila.tope());
    }
}
