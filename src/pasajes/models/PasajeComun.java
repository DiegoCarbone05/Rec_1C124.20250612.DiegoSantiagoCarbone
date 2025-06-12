package pasajes.models;

public class PasajeComun implements Pasaje {

    private String nombrePasajero;
    private VehiculoTransporte transporte;

    public PasajeComun(String nombrePasajero, VehiculoTransporte transporte) {
        this.nombrePasajero = nombrePasajero;
        this.transporte = transporte;
    }

    public double calcularCostoFinal() {
        return (transporte.capacidad * 2);
    }

    @Override
    public String getNombrePasajero() {
        return nombrePasajero;
    }

    @Override
    public String toString() {
        return "Pasaje Comun - " + nombrePasajero + " - $" + calcularCostoFinal();
    }
}
