package jeremytrejosmurillo_investigacion1;

import javax.swing.JOptionPane;

public class JEREMYTREJOSMURILLO_INVESTIGACION1 {

    // Metodo que aplica el ordenamiento de burbuja
    public static void bubbleSort(int[] arreglo) {
        int n = arreglo.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                
                // Si el elemento actual es mayor al siguiente, los intercambia
                if (arreglo[j] > arreglo[j + 1]) {
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }
    }

    // Metodo que convierte el arreglo a texto para mostrarlo
    public static String arregloATexto(int[] arreglo) {
        String resultado = "";
        for (int i = 0; i < arreglo.length; i++) {
            resultado += arreglo[i];
            if (i < arreglo.length - 1) {
                resultado += ", ";
            }
        }
        return resultado;
    }

    public static void main(String[] args) {
        
        // Arreglo de ejemplo sin ordenar
        int[] numeros = {64, 34, 25, 12, 22, 11, 90};

        // Mostrar arreglo original
        JOptionPane.showMessageDialog(null,
                "Arreglo original:\n" + arregloATexto(numeros),
                "Bubble Sort", JOptionPane.INFORMATION_MESSAGE);

        // Aplicar bubble sort
        bubbleSort(numeros);

        // Mostrar arreglo ordenado
        JOptionPane.showMessageDialog(null,
                "Arreglo ordenado:\n" + arregloATexto(numeros),
                "Bubble Sort", JOptionPane.INFORMATION_MESSAGE);
    }
}