package cr.ac.ucr.paraiso.ie.algoritmos.tema5;

import java.util.Comparator;

public class Cliente implements Comparator<Cliente>{
	 private int idCliente;
	  private int prioridadCliente; // 1: Adulto mayor, 2: Mujer embarazada, 3: Otros
	  private int tiempoAtencion; // En minutos basado en el tipo de transaccion
	  
	  public Cliente() {
		  
	  }
			  
	  public Cliente(int idCliente, int prioridadCliente, int tiempoAtencion) {
	    this.idCliente = idCliente;
	    this.prioridadCliente = prioridadCliente;
	    this.tiempoAtencion = tiempoAtencion;
	  }

	  public int getIdCliente() {
	    return this.idCliente;
	  }

	  public int getPrioridadCliente() {
	    return this.prioridadCliente;
	  }

	  public int getTiempoAtencion() {
	    return this.tiempoAtencion;
	  }

	  @Override
	  public String toString() {
	    return "Cliente{" +
	      "nombre='" + idCliente + '\'' +
	      ", tipoCliente=" + prioridadCliente +
	      ", tiempoAtencion=" + tiempoAtencion +
	      '}';
	  }


	@Override
	public int compare(Cliente cliente1, Cliente cliente2) {
		// Ordenar por prioridad (tipoCliente) y luego por tiempo de atención
	    if (cliente1.getPrioridadCliente() != cliente2.getPrioridadCliente()) {
	      return cliente1.getPrioridadCliente() - cliente2.getPrioridadCliente();
	    } else {
	      return cliente1.getTiempoAtencion() - cliente2.getTiempoAtencion();
	    }
	}
}