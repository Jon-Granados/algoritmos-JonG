package cr.ac.ucr.paraiso.ie.algoritmos.tema6;

public class ArbolBinario<T extends Comparable<T>> {
    Nodo<T> raiz;
    
    // Método para insertar un valor en el árbol
    public void insertar(T valor) {
        raiz = insertarRecursivo(raiz, valor);
    }



    private Nodo<T> insertarRecursivo(Nodo<T> nodo, T valor) {
        if (nodo == null) {
            return new Nodo<>(valor);
        }

        if (valor.compareTo(nodo.getDato()) < 0) {
            nodo.setIzquierdo(insertarRecursivo(nodo.getIzquierdo(), valor));
        } else if (valor.compareTo(nodo.getDato()) > 0) {
            nodo.setDerecho(insertarRecursivo(nodo.getDerecho(), valor));
        }

        return nodo;
    }

    public boolean buscar(T valor) {
        return buscarRecursivo(raiz, valor);
    }

    private boolean buscarRecursivo(Nodo<T> nodo, T valor) {
        if (nodo == null) {
            return false;
        }

        if (valor.compareTo(nodo.getDato()) == 0) {
            return true;
        }

        if (valor.compareTo(nodo.getDato()) < 0) {
            return buscarRecursivo(nodo.getIzquierdo(), valor);
        } else {
            return buscarRecursivo(nodo.getDerecho(), valor);
        }
    }


    // Método para eliminar un valor del árbol
    public void eliminar(T valor) {
        raiz = eliminarRecursivo(raiz, valor);
    }


    private Nodo<T> eliminarRecursivo(Nodo<T> nodo, T valor) {
        if (nodo == null) {
            return null;
        }

        if (valor.compareTo(nodo.getDato()) < 0) {
            nodo.setIzquierdo(eliminarRecursivo(nodo.getIzquierdo(), valor));
        } else if (valor.compareTo(nodo.getDato()) > 0) {
            nodo.setDerecho(eliminarRecursivo(nodo.getDerecho(), valor));
        } else {
            if (nodo.getIzquierdo() == null) {
                return nodo.getDerecho();
            } else if (nodo.getDerecho() == null) {
                return nodo.getIzquierdo();
            }

            nodo.setDato(obtenerMinimo(nodo.getDerecho()));
            nodo.setDerecho(eliminarRecursivo(nodo.getDerecho(), nodo.getDato()));
        }

        return nodo;
    }


    // Método para obtener el valor mínimo del árbol
    private T obtenerMinimo(Nodo<T> nodo) {
        T minimo = nodo.getDato();
        while (nodo.getIzquierdo() != null) {
            minimo = nodo.getIzquierdo().getDato();
            nodo = nodo.getIzquierdo();
        }
        return minimo;
    }

    // Método para verificar si el árbol está vacío
    public boolean esVacio() {
        return raiz == null;
    }

    // Método para obtener la altura del árbol
    public int obtenerAltura() {
        return obtenerAlturaRecursivo(raiz);
    }

    private int obtenerAlturaRecursivo(Nodo<T> nodo) {
        if (nodo == null) {
            return 0;
        }

        int alturaIzquierda = obtenerAlturaRecursivo(nodo.getIzquierdo());
        int alturaDerecha = obtenerAlturaRecursivo(nodo.getDerecho());

        return Math.max(alturaIzquierda, alturaDerecha) + 1;
    }



    public void printInorden(Nodo<T> nodo) {
        if (nodo != null) {
            printInorden(nodo.izquierdo);
            System.out.print(nodo.getDato() + " ");
            printInorden(nodo.derecho);
        }
    }

    public void printPreorden(Nodo<T> nodo) {
        if (nodo != null) {
            System.out.print(nodo.getDato() + " ");
            printPreorden(nodo.izquierdo);
            printPreorden(nodo.derecho);
        }
    }

    public void printPostorden(Nodo<T> nodo) {
        if (nodo != null) {
            printPostorden(nodo.izquierdo);
            printPostorden(nodo.derecho);
            System.out.print(nodo.getDato() + " ");
        }
    }

    public void printInorden() {
        printInorden(raiz);
        System.out.println();
    }

    public void printPreorden() {
        printPreorden(raiz);
        System.out.println();
    }

    public void printPostorden() {
        printPostorden(raiz);
        System.out.println();
    }
    
    public void imprimirArbol() {
        imprimirArbol(raiz, 0);
    }

    private void imprimirArbol(Nodo<T> nodo, int nivel) {
        if (nodo != null) {
            imprimirArbol(nodo.getDerecho(), nivel + 1);

            for (int i = 0; i < nivel; i++) {
                System.out.print("    ");
            }
            System.out.println(nodo.getDato());

            if (nivel != 0) {
                for (int i = 0; i < nivel; i++) {
                    System.out.print("    ");
                }
                System.out.print("│");
                System.out.println();;
            }

            imprimirArbol(nodo.getIzquierdo(), nivel + 1);
        }
    }
}