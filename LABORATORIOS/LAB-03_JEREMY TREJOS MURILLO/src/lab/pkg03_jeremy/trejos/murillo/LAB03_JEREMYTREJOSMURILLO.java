/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab.pkg03_jeremy.trejos.murillo;

import java.time.Year;

/**
 *
 * @author Jeremy Murillo
 */
public class LAB03_JEREMYTREJOSMURILLO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("===== PRUEBA DE GARAJE =====");
        Garaje garaje = new Garaje(3);
        System.out.println(garaje);

        garaje.aparcarCarro(new Carro("Toyota", "Corolla", 2020, "Rojo"));
        garaje.aparcarCarro(new Carro("Honda", "Civic", 2019, "Azul"));
        garaje.aparcarCarro(new Carro("Mazda", "3", 2022, "Negro"));
        garaje.aparcarCarro(new Carro("Kia", "Rio", 2021, "Blanco")); // Debe rechazar, garaje lleno

        garaje.listarCarros();
        System.out.println(garaje);

        System.out.println("\n===== PRUEBA DE CARRETERA =====");
        Carretera carretera = new Carretera("Autopista A1");
        int anioActual = Year.now().getValue();

        // Carros recientes para probar los distintos estados de tráfico
        carretera.agregarCarro(new Carro("Toyota", "Yaris", 2018, "Gris"));
        carretera.agregarCarro(new Carro("Hyundai", "Tucson", 2021, "Plata"));
        carretera.agregarCarro(new Carro("Ford", "Focus", 2017, "Negro"));
        carretera.agregarCarro(new Carro("Chevrolet", "Spark", 2022, "Rojo"));
        carretera.agregarCarro(new Carro("Nissan", "Sentra", 2016, "Azul"));
        carretera.agregarCarro(new Carro("Suzuki", "Swift", 2020, "Blanco"));
        carretera.agregarCarro(new Carro("Volkswagen", "Jetta", 2019, "Verde"));
        carretera.agregarCarro(new Carro("Subaru", "Impreza", 2015, "Gris"));
        carretera.agregarCarro(new Carro("BMW", "320i", 2023, "Negro"));
        carretera.agregarCarro(new Carro("Audi", "A3", 2014, "Blanco"));
        carretera.agregarCarro(new Carro("Mitsubishi", "Lancer", 2012, "Rojo"));
        carretera.agregarCarro(new Carro("Renault", "Logan", 2013, "Azul"));

        System.out.println("\nTotal de carros en la carretera: " + carretera.cantidadDeCarros());

        // Carros viejos para probar removerCarrosAntiguos()
        carretera.agregarCarro(new Carro("Datsun", "180", anioActual - 25, "Café"));
        carretera.agregarCarro(new Carro("Lada", "Niva", anioActual - 30, "Beige"));

        System.out.println("\n===== PRUEBA DE removerCarrosAntiguos() =====");
        carretera.removerCarrosAntiguos();

        System.out.println("\nTotal de carros después de remover antiguos: " + carretera.cantidadDeCarros());
        System.out.println(carretera);
    }

}