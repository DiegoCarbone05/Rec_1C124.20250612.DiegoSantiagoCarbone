package pasajes.models;

public class Colectivo extends VehiculoTransporte {
    public Colectivo(String patente, int capacidad, String empresa){
        super(patente, capacidad, empresa);
    }

    @Override
    public double calcularCostoBase() {
        // El costo base depende de la capacidad del colectivo
        return getCapacidad() * 2;
    }
}
