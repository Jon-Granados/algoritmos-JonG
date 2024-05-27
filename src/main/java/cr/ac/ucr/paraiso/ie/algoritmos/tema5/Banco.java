package cr.ac.ucr.paraiso.ie.algoritmos.tema5;

import java.util.PriorityQueue;

public class Banco {
	private PriorityQueue<Cliente> colaDeEspera;

    public Banco() {
        colaDeEspera = new PriorityQueue<>(new Cliente());//compare 2 clients by priority
    }

    public void llegadaDeCliente(int idCliente, int prioridadCliente, int tiempoAtencion) {
        Cliente nuevoCliente = new Cliente(idCliente, prioridadCliente,tiempoAtencion);
        colaDeEspera.offer(nuevoCliente);
        System.out.println("El cliente " + idCliente + " con prioridad " + prioridadCliente + " ha llegado.");
    }

    public void atenderSiguienteCliente() {
        if (!colaDeEspera.isEmpty()) {
            Cliente clienteAtendido = colaDeEspera.poll();
            System.out.println("Atendiendo al cliente " + clienteAtendido.getIdCliente() + " con prioridad " + clienteAtendido.getPrioridadCliente() + ".");
        } else {
            System.out.println("No hay clientes en la cola de espera.");
        }
    }
}
