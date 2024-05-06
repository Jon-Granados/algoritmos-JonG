package cr.ac.ucr.paraiso.ie.algoritmos.semana7;

import org.junit.Test;

import cr.ac.ucr.paraiso.ie.algoritmos.semana7.ColaNodo;
import cr.ac.ucr.paraiso.ie.algoritmos.semana7.PilaNodo;

import static org.junit.Assert.*;

public class TestPilaColaNodo {

    @Test
    public void testPila() {
        PilaNodo<Integer> pila = new PilaNodo<>();

        assertTrue(pila.isEmpty());

        pila.push(10);
        pila.push(20);
        pila.push(30);

        assertEquals(30, (int) pila.top());
        assertEquals(3, pila.size());

        assertEquals(30, (int) pila.pop());
        assertEquals(20, (int) pila.pop());
        assertEquals(10, (int) pila.pop());

        assertTrue(pila.isEmpty());
    }

    @Test
    public void testCola() {
        ColaNodo<String> cola = new ColaNodo<>();

        assertTrue(cola.isEmpty());

        cola.enqueue("A");
        cola.enqueue("B");
        cola.enqueue("C");

        assertEquals("A", cola.first());

        assertEquals("A", cola.dequeue());
        assertEquals("B", cola.dequeue());
        assertEquals("C", cola.dequeue());

        assertTrue(cola.isEmpty());
    }
}
