package pasajes.models;

public class Tren extends VehiculoTransporte {
    public Tren(String patente, int capacidad, String empresa){
        super(patente, capacidad, empresa);
    }

    @Override
    public double calcularCostoBase() {
        // El costo base depende de la capacidad del tren
        return getCapacidad() * 2;
    }

}
