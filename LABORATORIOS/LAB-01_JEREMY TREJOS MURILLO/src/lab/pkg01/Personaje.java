/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg01;

/**
 *
 * @author Jeremy Murillo
 */
public class Personaje {
    protected String nombre;
    protected int vida;
    protected int fuerza;
    protected int posicion;

    // ----------- Getters y Setters -----------
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getVida() { return vida; }
    /** No permite vida negativa: si baja de 0 queda en 0
     * @param vida */
    public void setVida(int vida) { this.vida = Math.max(0, vida); }

    public int getFuerza() { return fuerza; }
    public void setFuerza(int fuerza) { this.fuerza = fuerza; }

    public int getPosicion() { return posicion; }
    public void setPosicion(int posicion) { this.posicion = posicion; }

    // ----------- Constructores -----------
    public Personaje() {}

    public Personaje(String nombre, int vida, int fuerza, int posicion) {
        this.nombre   = nombre;
        this.vida     = vida;
        this.fuerza   = fuerza;
        this.posicion = posicion;
    }

    // ----------- Métodos -----------

    /** Ataque base: daño = fuerza / 2 */
    public void Atacar() {
        System.out.println(nombre + " atacó y causó "
                + (fuerza / 2) + " puntos de daño.");
    }

    public void Moverse() { Moverse(1); }

    public void Moverse(int numPasos) {
        this.posicion = this.posicion + numPasos;
    }

    /** Muestra nombre, vida, fuerza y posición */
    public void MostrarEstado() {
        System.out.println("[ " + nombre
                + " | Vida: "     + vida
                + " | Fuerza: "   + fuerza
                + " | Posición: " + posicion + " ]");
    }
    /**Secuencia de un turno**/
    public void Turno() {
        System.out.println("\n--- Turno de " + nombre + " ---");
        MostrarEstado();                                  
        Moverse();                                        
        System.out.println(nombre + " se movió a la posición " + posicion + ".");
        Atacar();                                         
    }

    public static void main(String[] args) {
        Personaje p = new Personaje("TurboMan", 200, 50, 0);
        p.Turno();
    }
}
