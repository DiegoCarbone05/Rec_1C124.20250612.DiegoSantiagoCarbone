package pasajes.models;

public class Viaje implements Comparable<Viaje> {

    // Relación con pasaje y transporte
    private Pasaje pasaje;
    private VehiculoTransporte transporte;
    private double costoFinal;

    public Viaje(Pasaje pasaje, VehiculoTransporte transporte) {
        this.pasaje = pasaje;
        this.transporte = transporte;
        this.costoFinal = pasaje.calcularCostoFinal();
    }

    // Devuelve el costo final del viaje
    public double getCosto() {
        return costoFinal;
    }

    // Devuelve el nombre del pasajero
    public String getNombrePasajero() {
        return pasaje.getNombrePasajero();
    }

    @Override
    public String toString() {
        return pasaje.toString() + " | " + transporte.toString();
    }

    // Ordena por costo de menor a mayor
    @Override
    public int compareTo(Viaje o) {
        return Double.compare(this.getCosto(), o.getCosto());
    }
}
