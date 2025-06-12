package pasajes.models;

public class Viaje implements Comparable<Viaje> {

    private Pasaje pasaje;
    private VehiculoTransporte transporte;

    public Viaje(Pasaje pasaje, VehiculoTransporte transporte) {
        this.pasaje = pasaje;
        this.transporte = transporte;
    }

    public double getCosto() {
        return pasaje.calcularCostoFinal();
    }

    public String getNombrePasajero() {
        return pasaje.getNombrePasajero();
    }

    @Override
    public String toString() {
        return pasaje.toString() + " | " + transporte.toString();
    }

    @Override
    public int compareTo(Viaje o) {
        return Double.compare(this.getCosto(), o.getCosto());
    }
}
