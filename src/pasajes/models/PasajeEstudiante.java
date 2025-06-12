package pasajes.models;

public class PasajeEstudiante implements Pasaje {
    private String nombrePasajero;
    private VehiculoTransporte transporte;

    public PasajeEstudiante(String nombrePasajero, VehiculoTransporte transporte) {
        this.nombrePasajero = nombrePasajero;
        this.transporte = transporte;
    }

    @Override
    public double calcularCostoFinal() {
        return (transporte.capacidad * 2) * 0.5;
    }

    @Override
    public String getNombrePasajero() {
        return nombrePasajero;
    }

    @Override
    public String toString() {
        return "Pasaje Estudiante - " + nombrePasajero + " - $" + calcularCostoFinal();
    }
}
