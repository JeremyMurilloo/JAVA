/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab04;

/**
 *
 * @author fbarg
 */
public class ColaConArray {

    private int maxSize;
    private Carro[] cola;
    private int frente;
    private int fin;
    private int tamaño;


    //
    public ColaConArray(int size) {
        this.maxSize = size;
        this.cola = new Carro[maxSize];
        this.frente = 0;
        this.fin = -1;
        this.tamaño = 0;
    }

    @Override
    public String toString() {
        var sal = "";
        for (Carro carro : cola) {
            sal += carro + "\n";
        }
        return sal;
    }

    //AGREGA ELEMENTOS EN LA COLA
    public void enqueue(Carro elemento) {
        if (tamaño == maxSize) {
            throw new IllegalStateException("La cola está llena.");
        }
        fin = (fin + 1) % maxSize; // Circular
        cola[fin] = elemento;
        tamaño++;
        System.out.println("Se agrego a la cola el elemento: " + elemento);
    }

    public Carro dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("La cola está vacía.");
        }
        Carro elemento = cola[frente];
        frente = (frente + 1) % maxSize; // Circular
        tamaño--;
        return elemento;
    }

    public Carro peek() {
        if (isEmpty()) {
            throw new IllegalStateException("La cola está vacía.");
        }
        return cola[frente];
    }

    public boolean isEmpty() {
        return tamaño == 0;
    }

    public int size() {
        return tamaño;
    }
}
