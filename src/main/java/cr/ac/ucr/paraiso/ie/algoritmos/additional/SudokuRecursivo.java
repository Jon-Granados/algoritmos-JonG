package cr.ac.ucr.paraiso.ie.algoritmos.additional;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jose
 */
public class SudokuRecursivo {
	
		             
     public boolean utilizado(int[][] A,int i,int j, int n){
     	boolean resultado = false;
     	
     	int k = 0;
     	while (k < A.length && A[i][k] != n && A[k][j] != n && A[((i/3)*3)+(k/3)][((j/3)*3)+(k%3)] !=n){
     		k++;
     	}
     	
     	if (k < A.length){
     		resultado = true;
     	}
     	
     	return resultado;
     }	 
     
     
     public boolean completa(int[][] A,int i, int j){
     	boolean terminado = false;
     	
     	if (i < A.length){
     		if (A[i][j] == 0){     		
	     		int n = 1;
	     		while (n <=9  && !terminado){
	     			if (!utilizado(A,i,j,n)){
	     				A[i][j] = n;
	     				terminado = completa(A,(i*9+j+1)/9,(i*9+j+1)%9);
	     			}
	     		    n++; 			     		
	     		}	
	     		
	     		if(!terminado){
	     		  A[i][j] = 0;	     			
	     		}
     		} else {
     			terminado = completa(A,(i*9+j+1)/9,(i*9+j+1)%9);
     		}
     	} else {
     		terminado = true;
     	}
     	
     	return terminado;
     	
     }
     
     public void muestraJuego(int[][] juego){
         for (int f = 0;f<juego.length;f++){
     		for (int c= 0;c < juego[f].length;c++){
     			System.out.print(juego[f][c]+ " ");
     		}
     		System.out.println(" ");
     	}
         
     }
     
     public static void main(String args[]){
     	
     	int [][] juego1 = {{0,4,8, 2,0,0, 0,0,1},
	                       {1,0,0, 3,8,4, 7,2,6},
	                       {3,0,0, 7,0,1, 9,4,8},
	                       
	                       {0,7,2, 6,4,5, 1,8,0},
	                       {8,0,0, 0,0,2, 4,0,0},
	                       {0,0,0, 0,0,0, 0,0,7},
	                       
	                       {0,8,4, 0,0,0, 3,0,0},
	                       {6,0,0, 4,1,0, 0,0,2},
	                       {0,0,3, 0,0,0, 0,7,4}
		           };
		                 
       int [][] juego2 = { {0,4,1, 0,0,0, 2,0,8},
	                       {9,0,0, 1,0,0, 0,0,0},
	                       {0,0,0, 0,2,0, 3,0,0},
	                       
	                       {2,0,0, 0,6,7, 0,0,0},
	                       {0,1,8, 0,0,0, 6,7,0},
	                       {0,0,0, 5,8,0, 0,0,2},
	                       
	                       {0,0,5, 0,7,0, 0,0,0},
	                       {0,0,0, 0,0,6, 0,0,4},
	                       {4,0,2, 0,0,0, 5,9,0}
		           };                 
		                 
     	int [][] juego3 = {{1,0,0, 0,3,0, 0,0,8},
	                       {0,7,0, 0,8,0, 0,6,0},
	                       {0,0,3, 9,0,2, 1,0,0},
	                       
	                       {0,8,0, 5,7,3, 0,4,0},
	                       {4,0,0, 0,0,0, 0,0,5},
	                       {0,2,0, 6,1,4, 0,8,0},
	                       
	                       {0,0,8, 1,0,9, 7,0,0},
	                       {0,9,0, 0,2,0, 0,1,0},
	                       {2,0,0, 0,6,0, 0,0,3}
		           }; 
		                 
     	SudokuRecursivo prueba = new SudokuRecursivo();
        
        // muestra el estado inicial del juego1
     	prueba.muestraJuego(juego1);       
        System.out.println();
        
     	if (prueba.completa(juego1,0,0)){      //0,0 es la posición de inicio
            System.out.println("El juego ha sido completado");
     	    prueba.muestraJuego(juego1);     //muestra el juego si lo logra completar
        } else {
            System.out.println("El juego no tiene solución");
        }
      
        // Nota: En las instrucciones anteriores puede reemplazar "juego1" por 
        //       "juego2", "juego3" o cualquier otro que quiera resolver
     }
     	             
}
