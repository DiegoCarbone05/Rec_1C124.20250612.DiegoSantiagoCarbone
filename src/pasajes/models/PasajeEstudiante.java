package pasajes.models;

public class PasajeEstudiante extends Pasaje implements Calculable {

    public PasajeEstudiante(double costoBase, String nombrePasajero) {
        super(costoBase, nombrePasajero);
    }

    @Override
    public double calcularCostoFinal() {
        // El pasaje de estudiante paga el 50% del costo base
        return getCostoBase() * 0.5;
    }

    @Override
    public String toString() {
        return "Pasaje Estudiante - " + getNombrePasajero() + " - $" + calcularCostoFinal();
    }
}
