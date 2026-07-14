/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase.pkg02;

import java.util.Arrays;

/**
 *
 * @author Jeremy Murillo
 */
public class CLASE02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Creacion e inicalizacion de array
       int [] numeros = new int [3];
       String [] nombres = {"Jeremy", "Alexandra", "Apollo"};
       
       //Agregar valores a los Arrays
       numeros [0] = 9;
       numeros [1] = 5;
       numeros [2] = 6;
       
       //Ciclo for con indices
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Cuando i es " + i + " el valor del numero es " + numeros[i]);
        }
       
        //Ciclo for con variables
        int i = 0;
        for (String nombre : nombres) {
            System.out.println((++i) + ". " + nombre);  
        }
        
       //Impresion de Arrays
       System.out.println("Numeros" + Arrays.toString(numeros)); 
       System.out.println("Nombres" + Arrays.toString(nombres));
       
       
       //Array bidimensional
       String [][] gato = new  String[3][3];
       gato [0][0] = "O";
       gato [1][1] = "O";
       gato [2][2] = "O";
       
       for (int fila = 0; fila < gato.length; fila++) {
           for (int columna = 0; columna < gato[fila].length; columna++) {
               
                String valor;
                // expresion ternaria
                valor = gato[fila][columna] == null ? "" : gato[fila][columna];
               
                //expresion completa
                if (gato[fila][columna] == null) {
                    valor = "";
                }
                else{
                    valor = gato[fila][columna];
                }
                
                System.out.print("[" + valor + "]");
           }
           System.out.println();
       }
    }
    
}
