package cr.ac.ucr.paraiso.ie.algoritmos.tema5;

public class MainBanco {
	  public static void main(String[] args) {
	        Banco banco = new Banco();

	        banco.llegadaDeCliente(1, 3, 5);
	        banco.llegadaDeCliente(2, 2, 10);
	        banco.llegadaDeCliente(3, 1, 5);
	        banco.llegadaDeCliente(4, 3, 15);

	        banco.atenderSiguienteCliente();
	        banco.atenderSiguienteCliente();
	        banco.atenderSiguienteCliente();
	        banco.atenderSiguienteCliente();
	    }
}
