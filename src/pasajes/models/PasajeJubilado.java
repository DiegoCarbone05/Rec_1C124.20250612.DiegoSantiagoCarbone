package pasajes.models;

public class PasajeJubilado extends Pasaje implements Calculable {

    public PasajeJubilado(double costoBase, String nombrePasajero) {
        super(costoBase, nombrePasajero);
    }

    @Override
    public double calcularCostoFinal() {
        // El pasaje de jubilado paga el 25% del costo base
        return getCostoBase() * 0.25;
    }

    @Override
    public String toString() {
        return "Pasaje Jubilado - " + getNombrePasajero() + " - $" + calcularCostoFinal();
    }
}
