package cr.ac.ucr.paraiso.ie.algoritmos.clase6;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import cr.ac.ucr.paraiso.ie.algoritmos.semana6.ListaSimple;

public class ListaSimpleTest {
    private ListaSimple lista;

    @Before
    public void setUp() {
        lista = new ListaSimple();
    }

    @Test
    public void testCrear() {
        lista.crear();
        assertTrue(lista.estaVacia());
    }

    @Test
    public void testInsertar() {
        lista.insertar(10);
        assertFalse(lista.estaVacia());
        assertEquals(1, lista.elementos());
        assertEquals(10, lista.elementoEnPosicion(0));

        lista.insertar(20);
        assertEquals(2, lista.elementos());
        assertEquals(10, lista.elementoEnPosicion(0));
        assertEquals(20, lista.elementoEnPosicion(1));

        lista.insertar(30);
        assertEquals(3, lista.elementos());
        assertEquals(10, lista.elementoEnPosicion(0));
        assertEquals(20, lista.elementoEnPosicion(1));
        assertEquals(30, lista.elementoEnPosicion(2));
    }

    @Test
    public void testBorrar() {
        lista.insertar(10);
        lista.insertar(20);
        lista.insertar(30);

        lista.borrar();
        assertEquals(2, lista.elementos());
        assertEquals(10, lista.elementoEnPosicion(0));
        assertEquals(30, lista.elementoEnPosicion(1));

        lista.borrar();
        assertEquals(1, lista.elementos());
        assertEquals(10, lista.elementoEnPosicion(0));

        lista.borrar();
        assertTrue(lista.estaVacia());
    }

    @Test
    public void testUltimo() {
        lista.insertar(10);
        lista.insertar(20);
        lista.insertar(30);

        assertEquals(30, lista.ultimo());
    }

    @Test
    public void testEstaVacia() {
        assertTrue(lista.estaVacia());

        lista.insertar(10);
        assertFalse(lista.estaVacia());

        lista.borrar();
        assertTrue(lista.estaVacia());
    }

    @Test
    public void testElementos() {
        assertEquals(0, lista.elementos());

        lista.insertar(10);
        assertEquals(1, lista.elementos());

        lista.insertar(20);
        lista.insertar(30);
        assertEquals(3, lista.elementos());

        lista.borrar();
        assertEquals(2, lista.elementos());

        lista.borrar();
        lista.borrar();
        assertEquals(0, lista.elementos());
    }

    @Test
    public void testInsertarEnPosicion() {
        lista.insertar(10);
        lista.insertar(20);
        lista.insertar(30);

        lista.insertarEnPosicion(15, 1);
        assertEquals(4, lista.elementos());
        assertEquals(10, lista.elementoEnPosicion(0));
        assertEquals(15, lista.elementoEnPosicion(1));
        assertEquals(20, lista.elementoEnPosicion(2));
        assertEquals(30, lista.elementoEnPosicion(3));

        lista.insertarEnPosicion(5, 0);
        assertEquals(5, lista.elementoEnPosicion(0));
        assertEquals(10, lista.elementoEnPosicion(1));
        assertEquals(15, lista.elementoEnPosicion(2));
        assertEquals(20, lista.elementoEnPosicion(3));
        assertEquals(30, lista.elementoEnPosicion(4));

        lista.insertarEnPosicion(40, 5);
        assertEquals(5, lista.elementoEnPosicion(0));
        assertEquals(10, lista.elementoEnPosicion(1));
        assertEquals(15, lista.elementoEnPosicion(2));
        assertEquals(20, lista.elementoEnPosicion(3));
        assertEquals(30, lista.elementoEnPosicion(4));
        assertEquals(40, lista.elementoEnPosicion(5));
    }

    @Test
    public void testBorrarEnPosicion() {
        lista.insertar(10);
        lista.insertar(20);
        lista.insertar(30);

        lista.borrarEnPosicion(1);
        assertEquals(2, lista.elementos());
        assertEquals(10, lista.elementoEnPosicion(0));
        assertEquals(30, lista.elementoEnPosicion(1));

        lista.borrarEnPosicion(0);
        assertEquals(1, lista.elementos());
        assertEquals(30, lista.elementoEnPosicion(0));

        lista.borrarEnPosicion(0);
        assertTrue(lista.estaVacia());
    }
}
