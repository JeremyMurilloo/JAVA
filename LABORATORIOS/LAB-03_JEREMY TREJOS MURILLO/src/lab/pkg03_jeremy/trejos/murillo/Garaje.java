package lab.pkg03_jeremy.trejos.murillo;

import java.util.ArrayList;

/**
 *
 * @author Jeremy Murillo
 */
public class Garaje {

    private ArrayList<Carro> carros;
    private int capacidadMaxima;

    public Garaje(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.carros = new ArrayList<>();
    }

    /**
     * Agrega un carro al garaje, validando que no se exceda la capacidad máxima.
     */
    public void aparcarCarro(Carro carro) {
        if (carros.size() >= capacidadMaxima) {
            System.out.println("No se puede aparcar el carro: el garaje está lleno "
                    + "(capacidad máxima: " + capacidadMaxima + ").");
            return;
        }
        carros.add(carro);
        System.out.println("Carro aparcado correctamente: " + carro);
    }

    /**
     * Muestra todos los carros aparcados en el garaje.
     */
    public void listarCarros() {
        if (carros.isEmpty()) {
            System.out.println("El garaje no tiene carros aparcados.");
            return;
        }
        System.out.println("Carros aparcados en el garaje:");
        for (Carro carro : carros) {
            System.out.println(" - " + carro);
        }
    }

    @Override
    public String toString() {
        return String.format("Garaje [capacidadMaxima=%d, espaciosOcupados=%d, espaciosLibres=%d]",
                capacidadMaxima, carros.size(), capacidadMaxima - carros.size());
    }
}