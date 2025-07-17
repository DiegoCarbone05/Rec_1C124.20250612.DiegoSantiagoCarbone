package pasajes.models;

public abstract class Pasaje {
    private double costoBase;
    private String nombrePasajero;

    public Pasaje(double costoBase, String nombrePasajero) {
        this.costoBase = costoBase;
        this.nombrePasajero = nombrePasajero;
    }

    public double getCostoBase() {
        return costoBase;
    }

    public String getNombrePasajero() {
        return nombrePasajero;
    }
    
    public abstract double calcularCostoFinal();
}
