package pasajes.models;

public abstract class VehiculoTransporte {
    protected String patente;
    protected int capacidad;
    protected String empresa;

    public VehiculoTransporte(String patente, int capacidad, String empresa){
        this.patente = patente;
        this.capacidad = capacidad;
        this.empresa = empresa;
    }

    /**
     * El precio del vehiculo depende de la cantidad de asientos o capacidad del mismo
     * @return Precio v
     */
    public abstract double calcularCostoBase();

    public int getCapacidad() {
        return capacidad;
    }

    public String getEmpresa() {
        return empresa;
    }

    public String getPatente() {
        return patente;
    }


    @Override
    public String toString() {
        return "Patente: '" + patente + '\'' +
                ", Capacidad: " + capacidad +
                ", Empresa: '" + empresa + '\'';
    }
}
