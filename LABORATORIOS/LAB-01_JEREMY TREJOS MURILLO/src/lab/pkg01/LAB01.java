/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab.pkg01;

import java.time.LocalDate;
/**
 *
 * @author Jeremy Murillo
 */


public class LAB01 {
 public static void main(String[] args) {

        // Demo original de Persona
        Persona p1 = new Persona();
        LocalDate fechaNac = LocalDate.of(2005, 9, 12);
        Persona p2 = new Persona("Juan", fechaNac);
        System.out.println(p1);
        p2.saludar();

        System.out.println("\n========================================");
        System.out.println("         DEMOSTRACIÓN DEL JUEGO");
        System.out.println("========================================");

        // Crear personajes
        Guerrero guerrero = new Guerrero("Aragorn", 150, 40, 0);
        Mago     mago     = new Mago("Gandalf", 100, 35, 5, 60);
     

        System.out.println("\n--- Estado inicial ---");
        guerrero.MostrarEstado();
        mago.MostrarEstado();

        // Ejecutar 3 turnos normales
        for (int i = 1; i <= 3; i++) {
            System.out.println("\n>>> TURNO " + i + " <<<");
            guerrero.Turno(); // llama a Atacar() del Guerrero
            mago.Turno();     // llama a Atacar() del Mago (consume maná)
        }

        // Turno extra: el mago ya no tiene maná
        System.out.println("\n>>> TURNO EXTRA: maná agotado <<<");
        mago.Turno();

        // Demostración de getters y setters
        System.out.println("\n--- Getters y Setters ---");
        System.out.println("Nombre: " + guerrero.getNombre());
        System.out.println("Vida actual: " + guerrero.getVida());
        guerrero.setVida(guerrero.getVida() - 30); // recibe 30 de daño
        System.out.println("Vida tras recibir daño: " + guerrero.getVida());
        System.out.println("Maná del mago: " + mago.getMana());
    }
}
