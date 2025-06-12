package pasajes.models;

public class Tren extends VehiculoTransporte {
    public Tren(String patente, int capacidad, String empresa){
        super(patente, capacidad, empresa);
    }

    @Override
    public double calcularCostoBase() {
        return 0;
    }

}
