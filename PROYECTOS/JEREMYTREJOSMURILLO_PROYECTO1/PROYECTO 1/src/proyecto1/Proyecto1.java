/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto1;

import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.JOptionPane;

/**
 *
 * @author Jeremy Murillo
 */

public class Proyecto1 {

    private static Acumulador acu = new Acumulador();

    public static String mostrarMenu() {
        String[] opciones = {
            "Mostrar historial",
            "Mostrar acumulador",
            "Agregar operacion",
            "Undo",
            "Rendo",
            "Salir",
        };
        String menu = "=== SIMULADOR DE OPERACIONES ===\n";
        int i = 1;
        for (String o : opciones) {
            menu += (i++) + ". " + o + "\n";
        }
        return menu;
    }

    public static void main(String[] args) {
        while (true) {
            String input = JOptionPane.showInputDialog(null, mostrarMenu());

            // Cancelar o cerrar la ventana = salir
            if (input == null) {
                return;
            }

            try {
                int opcion = Integer.parseInt(input.trim());

                switch (opcion) {
                    case 1:
                        mostrarHistorial();
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null,
                            "Acumulador actual: " + acu.getTotal(),
                            "Acumulador", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case 3:
                        manejarOperar();
                        break;
                    case 4:
                        manejarUndo();
                        break;
                    case 5:
                        manejarRedo();
                        break;
                    case 6:
                        return;
                    default:
                        JOptionPane.showMessageDialog(null,
                            "Opcion no valida. Ingrese un numero del 1 al 6.",
                            "Error", JOptionPane.WARNING_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                    "Debe ingresar un numero del 1 al 6.",
                        "Entrada invalida", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static void manejarOperar() {
        String input = JOptionPane.showInputDialog(null,
            "Ingrese la operacion en formato +N o -N\nEjemplos: +10   -4   +25");

        if (input == null) {
            return; // usuario cancelo
        }
        input = input.trim();

        // Validar que empiece con + o -
        if (input.isEmpty() || (input.charAt(0) != '+' && input.charAt(0) != '-')) {
            JOptionPane.showMessageDialog(null,
                "Formato invalido. Use +N o -N  (ej: +10, -4)",
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            char signo = input.charAt(0);
            int valor = Integer.parseInt(input.substring(1));

            String tipo = (signo == '+') ? "SUMA" : "RESTA";
            Operacion op = new Operacion(valor, tipo);
            acu.aplicar(op);

            JOptionPane.showMessageDialog(null,
                "Operacion aplicada: " + op + "\nAcumulador: " + acu.getTotal(),
                "Operacion exitosa", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                "Valor no valido. Use +N o -N con un numero entero  (ej: +10, -4)",
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void manejarUndo() {
        boolean exito = acu.undo();
        if (exito) {
            JOptionPane.showMessageDialog(null,
                "Undo aplicado.\nAcumulador: " + acu.getTotal(),
                "Undo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
                    "No hay operaciones para deshacer.",
                    "Undo", JOptionPane.WARNING_MESSAGE);
        }
    }

    private static void manejarRedo() {
        boolean exito = acu.redo();
        if (exito) {
            JOptionPane.showMessageDialog(null,
                "Redo aplicado.\nAcumulador: " + acu.getTotal(),
                "Redo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
                "No hay operaciones para rehacer.",
                "Redo", JOptionPane.WARNING_MESSAGE);
        }
    }

    private static void mostrarHistorial() {
        ArrayList<Operacion> undoList = acu.getHistorialUndo();
        ArrayList<Operacion> redoList = acu.getHistorialRedo();

        StringBuilder sb = new StringBuilder();
        sb.append("=== HISTORIAL DE OPERACIONES ===\n\n");

        // Mostrar undoStack de tope a fondo
        sb.append("-- UNDO (historial aplicado) --\n");
        if (undoList.isEmpty()) {
            sb.append("  (vacio)\n");
        } else {
            for (int i = undoList.size() - 1; i >= 0; i--) {
                if (i == undoList.size() - 1) {
                    sb.append("  [TOPE]  ").append(undoList.get(i)).append("\n");
                } else if (i == 0) {
                    sb.append("  [FONDO] ").append(undoList.get(i)).append("\n");
                } else {
                    sb.append("           ").append(undoList.get(i)).append("\n");
                }
            }
        }

        // Mostrar redoStack de tope a fondo
        sb.append("\n-- REDO (operaciones deshechas) --\n");
        if (redoList.isEmpty()) {
            sb.append("  (vacio)\n");
        } else {
            for (int i = redoList.size() - 1; i >= 0; i--) {
                if (i == redoList.size() - 1) {
                    sb.append("  [TOPE]  ").append(redoList.get(i)).append("\n");
                } else if (i == 0) {
                    sb.append("  [FONDO] ").append(redoList.get(i)).append("\n");
                } else {
                    sb.append("           ").append(redoList.get(i)).append("\n");
                }
            }
        }

        sb.append("\nAcumulador actual: ").append(acu.getTotal());

        JOptionPane.showMessageDialog(null, sb.toString(),
                "Historial", JOptionPane.INFORMATION_MESSAGE);
    }
}
