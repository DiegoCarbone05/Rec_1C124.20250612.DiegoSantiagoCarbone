package pasajes.models;

public class PasajeComun extends Pasaje implements Calculable {

    public PasajeComun(double costoBase, String nombrePasajero) {
        super(costoBase, nombrePasajero);
    }

    @Override
    public double calcularCostoFinal() {
        // El pasaje común paga el costo base completo
        return getCostoBase();
    }

    @Override
    public String toString() {
        return "Pasaje Comun - " + getNombrePasajero() + " - $" + calcularCostoFinal();
    }
}
