/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

/**
 *
 * @author Jeremy Murillo
 */
public class Operacion {
private int valor;
    private String tipo; // "SUMA" o "RESTA"

    public Operacion(int valor, String tipo) {
        this.valor = valor;
        this.tipo = tipo;
    }

    public int getValor() {
        return valor;
    }

    public String getTipo() {
        return tipo;
    }

    // Retorna una NUEVA operacion contraria: si era SUMA devuelve RESTA y viceversa
    public Operacion inversa() {
        if (tipo.equals("SUMA")) {
            return new Operacion(valor, "RESTA");
        } else {
            return new Operacion(valor, "SUMA");
        }
    }

    @Override
    public String toString() {
        String signo = tipo.equals("SUMA") ? "+" : "-";
        return signo + valor;
    }
}
