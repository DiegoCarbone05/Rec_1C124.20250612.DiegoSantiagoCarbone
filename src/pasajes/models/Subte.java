package pasajes.models;

public class Subte extends VehiculoTransporte {

    public Subte(String patente, int capacidad, String empresa){
        super(patente, capacidad, empresa);
    }

    @Override
    public double calcularCostoBase() {
        return 0;
    }


}
