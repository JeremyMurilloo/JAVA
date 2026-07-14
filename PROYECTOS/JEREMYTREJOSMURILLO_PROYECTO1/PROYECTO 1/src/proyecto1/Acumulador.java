/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

import java.util.ArrayList;

/**
 *
 * @author Jeremy Murillo
 */
public class Acumulador {
private int total;
    private ArrayList<Operacion> undoStack;
    private ArrayList<Operacion> redoStack;

    public Acumulador() {
        total = 0;
        undoStack = new ArrayList<>();
        redoStack = new ArrayList<>();
    }

    public int getTotal() {
        return total;
    }

    public ArrayList<Operacion> getHistorialUndo() {
        return undoStack;
    }

    public ArrayList<Operacion> getHistorialRedo() {
        return redoStack;
    }

    // Metodo privado que aplica la operacion al total segun su tipo
    private void aplicarAlTotal(Operacion op) {
        if (op.getTipo().equals("SUMA")) {
            total += op.getValor();
        } else {
            total -= op.getValor();
        }
    }

    // Aplica una nueva operacion, la guarda en undoStack y limpia el redoStack
    public void aplicar(Operacion op) {
        aplicarAlTotal(op);
        undoStack.add(op);   // insertar al final = tope de la pila
        redoStack.clear();   // nueva operacion borra el historial de redo
    }

    // Deshace la ultima operacion (saca del tope del undoStack)
    public boolean undo() {
        if (undoStack.isEmpty()) {
            return false;
        }
        // Extraer el ultimo elemento (tope) del undoStack
        Operacion op = undoStack.remove(undoStack.size() - 1);
        // Aplicar la operacion inversa al total
        aplicarAlTotal(op.inversa());
        // Mover la operacion al redoStack
        redoStack.add(op);
        return true;
    }

    // Rehace la ultima operacion deshecha (saca del tope del redoStack)
    public boolean redo() {
        if (redoStack.isEmpty()) {
            return false;
        }
        // Extraer el ultimo elemento (tope) del redoStack
        Operacion op = redoStack.remove(redoStack.size() - 1);
        // Volver a aplicar la operacion al total
        aplicarAlTotal(op);
        // Devolver la operacion al undoStack
        undoStack.add(op);
        return true;
    } 
    
}
