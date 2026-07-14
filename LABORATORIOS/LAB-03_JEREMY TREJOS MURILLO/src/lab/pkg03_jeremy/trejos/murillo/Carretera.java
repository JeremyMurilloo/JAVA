package lab.pkg03_jeremy.trejos.murillo;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Jeremy Murillo
 */
public class Carretera {

    private String nombre;
    private ArrayList<Carro> carros;

    public Carretera(String nombre) {
        this.nombre = nombre;
        this.carros = new ArrayList<>();
    }

    /**
     * Añade un carro a la carretera y muestra el estado actual del tráfico.
     */
    public void agregarCarro(Carro carro) {
        carros.add(carro);
        verificarEstado();
    }

    /**
     * Devuelve el número total de carros en la carretera.
     */
    public int cantidadDeCarros() {
        return carros.size();
    }

    /**
     * Determina el mensaje de estado del tráfico según la cantidad de carros.
     */
    public String obtenerEstadoTrafico(int cantidad) {
        if (cantidad <= 3) return "tiene un flujo ligero";
        if (cantidad <= 5) return "tiene un flujo moderado";
        if (cantidad <= 8) return "está comenzando a congestionarse";
        if (cantidad <= 11) return "está generando un embotellamiento";
        return "está colapsada, hay mucho embotellamiento";
    }

    /**
     * Muestra un mensaje según la cantidad de carros en la carretera.
     */
    public void verificarEstado() {
        int cantidad = this.cantidadDeCarros();
        String estado = obtenerEstadoTrafico(cantidad);
        System.out.printf("La carretera %s %s.%n", nombre, estado);
    }

    /**
     * Recorre la colección de carros con un Iterator y elimina aquellos
     * que tengan más de 20 años de antigüedad.
     */
    public void removerCarrosAntiguos() {
        int anioActual = java.time.Year.now().getValue();
        Iterator<Carro> iterator = carros.iterator();

        while (iterator.hasNext()) {
            Carro carro = iterator.next();
            int antiguedad = anioActual - carro.getAnio();
            if (antiguedad > 20) {
                System.out.println("Removiendo carro antiguo (" + antiguedad + " años): " + carro);
                iterator.remove();
            }
        }
    }

    @Override
    public String toString() {
        return String.format("Carretera [nombre=%s, cantidadCarros=%d]", nombre, cantidadDeCarros());
    }
}
