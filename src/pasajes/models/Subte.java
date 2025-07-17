package pasajes.models;

public class Subte extends VehiculoTransporte {

    public Subte(String patente, int capacidad, String empresa){
        super(patente, capacidad, empresa);
    }

    @Override
    public double calcularCostoBase() {
        // El costo base depende de la capacidad del subte
        return getCapacidad() * 2;
    }


}
