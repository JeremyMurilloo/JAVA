/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg01;

/**
 *
 * @author Jeremy Murillo
 */
public class Guerrero extends Personaje {

    public Guerrero() {
    }

    public Guerrero(String nombre, int vida, int fuerza, int posicion) {
        super(nombre, vida, fuerza, posicion);
    }

    public Guerrero(Personaje p) {
        super(p.nombre, p.vida, p.fuerza, p.posicion);
    }

    @Override
    public void Atacar() {
        System.out.println(nombre + " ataco y hizo " + (fuerza / 1.25) + " daño.");
    }

}
