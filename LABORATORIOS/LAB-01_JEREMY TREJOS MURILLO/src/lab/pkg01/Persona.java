/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg01;

import java.time.LocalDate;
import java.time.Period;


/**
 *
 * @author Jeremy Murillo
 */
public class Persona {
    private String nombre;
    private LocalDate fechaNacimiento;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEdad() {
        // ALGORITMOS
        //1. Necesito la fecha de nacimiento
        if (this.fechaNacimiento == null) {
            return 0;
        }
        
        //2. Necesito la fecha actual
        LocalDate hoy = LocalDate.now();
        
        //3. Calculo la diferencia entre las fechas
        Period periodo = Period.between(fechaNacimiento, hoy);
        return periodo.getYears();
    }

    public Persona() {
        this.nombre = "NO INDICA NOMBRE";
        this.fechaNacimiento = LocalDate.now();
    }

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public Persona(String nombre, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Persona(LocalDate fechaNacimiento) {
        this.nombre = "NO INDICA NOMBRE";
        this.fechaNacimiento = fechaNacimiento;
    }

    //Quiere decir que estoy sobreescribiendo 
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nombre).append(" Edad: ").append(getEdad());
        return sb.toString();
    }

    public void saludar() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hola soy ");
        sb.append(nombre).append(" y tengo ").append(getEdad());
        sb.append(" años");
        System.out.println(sb.toString());
    }
}

