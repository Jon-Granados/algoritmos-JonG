package cr.ac.ucr.paraiso.ie.algoritmos.tema5.quickSort;



public class QuickSort {

    private int [] arreglo;

    public QuickSort(int[] arreglo) {
        this.arreglo = arreglo;
    }

    public int pivote( int i, int j){ //devuelve la posicion del pivote

        boolean encontrado = false;

        int indice = i; //Para no modificar el parametro
        int pivote = -1;//en caso de no encontrar dos elementos diferentes devuelve -1

        while (indice < j && !encontrado ){ //Pregunta si el índice está fuera de rango o si ya lo encontró

            if (arreglo[indice] != arreglo[indice+1]){

                if(arreglo[indice] > arreglo[indice + 1]){ // selecciona al índice con el elemento mayor
                    pivote = indice;
                    encontrado = true;
                }
                else {
                    pivote = indice + 1;
                    encontrado = true;
                }

            }
            indice++;
        }

        return pivote;

    }


    public void quickSort(int i,int j){
        int indiceParticiones = pivote(i,j); //Guarda el posicion del pivote


        if (indiceParticiones != -1){ //No entra si la partición era de elementos iguales o de solo un elemento

           int k = particiones(i,j,arreglo[indiceParticiones]);

           quickSort(i,k);
           quickSort(k+1,j);


        }



    }

    public int particiones(int i, int j, int pivote){

        int indice_izquierda = i;
        int indice_derecha = j;


        do {
            intercambia(indice_izquierda,indice_derecha);

            while (arreglo[indice_izquierda] < pivote) { //Si lo de la izquierda es menor que el pivote
                indice_izquierda++;
            }

            while (arreglo[indice_derecha] >=  pivote) { //si lo de la derecha es mayor o igual
                indice_derecha--;
            }

        }while (indice_derecha >   indice_izquierda);


        return indice_derecha;


    }

    public void intercambia(int i, int j) {

        int temp = arreglo[i];
        arreglo[i] = arreglo[j];
        arreglo[j] = temp;

    }


}
