/**
 * 
 */
package cr.ac.ucr.paraiso.ie.algoritmos.tema6;

/**
 * 
 */
import java.util.Comparator;

public class Nodo<T> {

    public T dato;
    public Nodo<T> izquierdo;
    public Nodo<T> derecho;
    public int altura;

    public Nodo(T dato) {
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
        this.altura = 1;
    }


	/**
	 * @return the dato
	 */
	public T getDato() {
		return dato;
	}


	/**
	 * @param dato the dato to set
	 */
	public void setDato(T dato) {
		this.dato = dato;
	}


	/**
	 * @return the izquierdo
	 */
	public Nodo<T> getIzquierdo() {
		return izquierdo;
	}

	/**
	 * @param izquierdo the izquierdo to set
	 */
	public void setIzquierdo(Nodo<T> izquierdo) {
		this.izquierdo = izquierdo;
	}

	/**
	 * @return the derecho
	 */
	public Nodo<T> getDerecho() {
		return derecho;
	}

	/**
	 * @param derecho the derecho to set
	 */
	public void setDerecho(Nodo<T> derecho) {
		this.derecho = derecho;
	}

	/**
	 * @return the altura
	 */
	public int getAltura() {
		return altura;
	}

	/**
	 * @param altura the altura to set
	 */
	public void setAltura(int altura) {
		this.altura = altura;
	}

 
  
}
