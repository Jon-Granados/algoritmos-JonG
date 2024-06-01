package cr.ac.ucr.paraiso.ie.algoritmos.tema6;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ArbolAVL<T extends Comparable<T>> {
    private Nodo<T> raiz;

    /**
	 * @return the raiz
	 */
	public Nodo<T> getRaiz() {
		return raiz;
	}

	/**
	 * @param raiz the raiz to set
	 */
	public void setRaiz(Nodo<T> raiz) {
		this.raiz = raiz;
	}

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
        } else {
            // Valor duplicado, no se permite
            return nodo;
        }

        nodo.setAltura(1 + Math.max(obtenerAlturaRecursivo(nodo.getIzquierdo()), obtenerAlturaRecursivo(nodo.getDerecho())));

        int balance = obtenerBalance(nodo);

        if (balance > 1 && valor.compareTo(nodo.getIzquierdo().getDato()) < 0) {
            return rotarDerecha(nodo);
        }

        if (balance < -1 && valor.compareTo(nodo.getDerecho().getDato()) > 0) {
            return rotarIzquierda(nodo);
        }

        if (balance > 1 && valor.compareTo(nodo.getIzquierdo().getDato()) > 0) {
            nodo.setIzquierdo(rotarIzquierda(nodo.getIzquierdo()));
            return rotarDerecha(nodo);
        }

        if (balance < -1 && valor.compareTo(nodo.getDerecho().getDato()) < 0) {
            nodo.setDerecho(rotarDerecha(nodo.getDerecho()));
            return rotarIzquierda(nodo);
        }
        
        
        return nodo;
    }

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
    
    private int obtenerBalance(Nodo<T> nodo) {
        if (nodo == null) {
            return 0;
        }
        return obtenerAlturaRecursivo(nodo.getIzquierdo()) - obtenerAlturaRecursivo(nodo.getDerecho());
    }

    private Nodo<T> rotarDerecha(Nodo<T> nodo) {
        Nodo<T> temp = nodo.getIzquierdo();
        Nodo<T> temp2 = temp.getDerecho();

        temp.setDerecho(nodo);
        nodo.setIzquierdo(temp2);

        nodo.setAltura(Math.max(obtenerAlturaRecursivo(nodo.getIzquierdo()), obtenerAlturaRecursivo(nodo.getDerecho())) + 1);
        temp.setAltura(Math.max(obtenerAlturaRecursivo(temp.getIzquierdo()), obtenerAlturaRecursivo(temp.getDerecho())) + 1);

        return temp;
    }

    private Nodo<T> rotarIzquierda(Nodo<T> nodo) {
        Nodo<T> temp = nodo.getDerecho();
        Nodo<T> temp2 = temp.getIzquierdo();

        temp.setIzquierdo(nodo);
        nodo.setDerecho(temp2);

        nodo.setAltura(Math.max(obtenerAlturaRecursivo(nodo.getIzquierdo()), obtenerAlturaRecursivo(nodo.getDerecho())) + 1);
        temp.setAltura(Math.max(obtenerAlturaRecursivo(temp.getIzquierdo()), obtenerAlturaRecursivo(temp.getDerecho())) + 1);

        return temp;
    }
    public boolean esVacio() {
        return raiz == null;
    }
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

        return balancear(nodo);
    }

    private T obtenerMinimo(Nodo<T> nodo) {
        T minimo = nodo.getDato();
        while (nodo.getIzquierdo() != null) {
            minimo = nodo.getIzquierdo().getDato();
            nodo = nodo.getIzquierdo();
        }
        return minimo;
    }

    private Nodo<T> balancear(Nodo<T> nodo) {
        int balance = obtenerBalance(nodo);

        if (balance > 1) {
            if (obtenerBalance(nodo.getIzquierdo()) < 0) {
                nodo.setIzquierdo(rotarIzquierda(nodo.getIzquierdo()));
            }
            return rotarDerecha(nodo);
        }

        if (balance < -1) {
            if (obtenerBalance(nodo.getDerecho()) > 0) {
                nodo.setDerecho(rotarDerecha(nodo.getDerecho()));
            }
            return rotarIzquierda(nodo);
        }

        return nodo;
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
                System.out.println();
            }

            imprimirArbol(nodo.getIzquierdo(), nivel + 1);
        }
    }

    public void printInorden() {
        printInorden(raiz);
        System.out.println();
    }

    private void printInorden(Nodo<T> nodo) {
        if (nodo != null) {
            printInorden(nodo.getIzquierdo());
            System.out.print(nodo.getDato() + " ");
            printInorden(nodo.getDerecho());
        }
    }

    public void printPreorden() {
        printPreorden(raiz);
        System.out.println();
    }

    private void printPreorden(Nodo<T> nodo) {
        if (nodo != null) {
            System.out.print(nodo.getDato() + " ");
            printPreorden(nodo.getIzquierdo());
            printPreorden(nodo.getDerecho());
        }
    }

    public void printPostorden() {
        printPostorden(raiz);
        System.out.println();
    }

    private void printPostorden(Nodo<T> nodo) {
        if (nodo != null) {
            printPostorden(nodo.getIzquierdo());
            printPostorden(nodo.getDerecho());
            System.out.print(nodo.getDato() + " ");
        }
    }
    
    public void graficarArbol(String nombreArchivo) {
        try {
            // Generar el contenido del archivo Graphviz
            String contenido = generarContenidoGraphviz(raiz);

            // Escribir el contenido en un archivo temporal
            File archivoTemp = File.createTempFile("avl", ".dot");
            FileWriter writer = new FileWriter(archivoTemp);
            writer.write(contenido);
            writer.close();

            // Ejecutar Graphviz para generar la imagen
            String[] comando = { "dot", "-Tjpg", archivoTemp.getAbsolutePath(), "-o", nombreArchivo };
            Runtime.getRuntime().exec(comando);

            System.out.println("Árbol AVL graficado en: " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private String generarContenidoGraphviz(Nodo<T> nodo) {
        StringBuilder sb = new StringBuilder();
        sb.append("digraph ArbolAVL {\n");
        sb.append("node [shape=circle];\n");

        generarContenidoNodo(sb, nodo);

        sb.append("}\n");
        return sb.toString();
    }

    private void generarContenidoNodo(StringBuilder sb, Nodo<T> nodo) {
        if (nodo != null) {
            sb.append("\"").append(nodo.getDato()).append("\";\n");

            if (nodo.getIzquierdo() != null) {
                sb.append("\"").append(nodo.getDato()).append("\" -> \"").append(nodo.getIzquierdo().getDato()).append("\";\n");
                generarContenidoNodo(sb, nodo.getIzquierdo());
            }

            if (nodo.getDerecho() != null) {
                sb.append("\"").append(nodo.getDato()).append("\" -> \"").append(nodo.getDerecho().getDato()).append("\";\n");
                generarContenidoNodo(sb, nodo.getDerecho());
            }
        }
    }
}