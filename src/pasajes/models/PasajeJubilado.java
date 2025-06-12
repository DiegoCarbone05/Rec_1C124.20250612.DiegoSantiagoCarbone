package pasajes.models;

public class PasajeJubilado implements Pasaje {
    private String nombrePasajero;
    private VehiculoTransporte transporte;

    public PasajeJubilado(String nombrePasajero, VehiculoTransporte transporte) {
        this.nombrePasajero = nombrePasajero;
        this.transporte = transporte;
    }

    @Override
    public double calcularCostoFinal() {
        return (transporte.capacidad * 2) * 0.25;
    }

    @Override
    public String getNombrePasajero() {
        return nombrePasajero;
    }

    @Override
    public String toString() {
        return "Pasaje Jubilado - " + nombrePasajero + " - $" + calcularCostoFinal();
    }
}
