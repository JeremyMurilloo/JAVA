/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase.pkg02;

import javax.swing.JOptionPane;

/**
 *
 * @author Jeremy Murillo
 */

public class Meses {

    // RETO 1: Arreglo completo con los 12 meses (posición 0 = null)
    String[] meses = {null, "ENE", "FEB", "MAR", "ABR", "MAY","JUN", "JUL", "AGO", "SEP", "OCT", "NOV", "DIC"};

    public static void main(String[] args) {
        Meses m = new Meses();

        // Muestra ventana con todos los meses
        JOptionPane.showMessageDialog(null, m.meses, "MESES", JOptionPane.ERROR_MESSAGE);

        // Ventana para preguntar y obtener un valor
        String sMes = JOptionPane.showInputDialog(null, "CUAL ES TU MES (1-12)");

        // RETO 3: Bloque try-catch para blindar el código
        try {
            int mes = Integer.parseInt(sMes);

            // Validar que el número esté en el rango 1-12
            if (mes < 1 || mes > 12) {
                JOptionPane.showMessageDialog(null,"Error: Ingrese un número entre 1 y 12.","Número fuera de rango", JOptionPane.ERROR_MESSAGE);
                
            } else {
                // RETO 2: Mostrar el resultado con JOptionPane en lugar de System.out.println
                JOptionPane.showMessageDialog(null,"El mes seleccionado es: " + m.meses[mes],"Mes", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (NumberFormatException e) {
            // Captura cuando el usuario escribe texto en lugar de un número
            JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número entero válido.", "Entrada inválida", JOptionPane.ERROR_MESSAGE);
        }

        // Imprimir todos los meses en consola (ciclo original)
        for (int i = 1; i < m.meses.length; i++) {
            System.out.println(m.meses[i]);
        }
    }
}
