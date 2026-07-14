/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg01;

/**
 *
 * @author Jeremy Murillo
 */
public class Mago extends Personaje {

    // Atributo exclusivo del Mago
    private int mana;

    // ----------- Getters y Setters -----------
    public int getMana() { return mana; }

    /** No permite maná negativo
     * @param mana */
    public void setMana(int mana) { this.mana = Math.max(0, mana); }

    // ----------- Constructores -----------
    public Mago() {}

    /**
     * @param nombre   Nombre del mago
     * @param vida     Puntos de vida
     * @param fuerza   Fuerza mágica
     * @param posicion Posición inicial
     * @param mana     Maná inicial
     */
    public Mago(String nombre, int vida, int fuerza, int posicion, int mana) {
        super(nombre, vida, fuerza, posicion); // llama al constructor de Personaje
        this.mana = mana;
    }

    // ----------- Métodos -----------
    /** Muestra el estado incluyendo el maná */
    @Override
    public void MostrarEstado() {
        System.out.println("[ " + nombre + " (Mago)"
                + " | Vida: "     + vida
                + " | Fuerza: "   + fuerza
                + " | Maná: "     + mana
                + " | Posición: " + posicion + " ]");
    }

    /**
     * Ataque mágico:
     * - Daño = fuerza * 2
     * - Costo = 20 de maná por ataque
     * - Si no hay maná, no se puede atacar
     */
    @Override
    public void Atacar() {
        int costoMana = 20;

        // Verificar si hay maná suficiente
        if (mana <= 0) {
            System.out.println(nombre
                    + " no tiene energía mágica para atacar. ¡Maná agotado!");
            return; // sale sin atacar
        }

        int dano = fuerza * 2; // daño del mago
        mana -= costoMana;     // consumir maná

        System.out.println(nombre + " lanzó un hechizo y causó "
                + dano + " puntos de daño mágico."
                + " [Maná restante: " + mana + "]");

        if (mana == 0) {
            System.out.println("¡" + nombre + " se ha quedado sin maná!");
        }
    }
}
