package lab.pkg03_jeremy.trejos.murillo;
 
/**
 *
 * @author Jeremy Murillo
 */
public class Carro {
 
    private String marca;
    private String modelo;
    private int anio;
    private String color;
 
    public Carro(String marca, String modelo, int anio, String color) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.color = color;
    }
 
    // Getters y Setters
    public String getMarca() {
        return marca;
    }
 
    public void setMarca(String marca) {
        this.marca = marca;
    }
 
    public String getModelo() {
        return modelo;
    }
 
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
 
    public int getAnio() {
        return anio;
    }
 
    public void setAnio(int anio) {
        this.anio = anio;
    }
 
    public String getColor() {
        return color;
    }
 
    public void setColor(String color) {
        this.color = color;
    }
 
    @Override
    public String toString() {
        return String.format("Carro [marca=%s, modelo=%s, año=%d, color=%s]",
        marca, modelo, anio, color);
    }
}
