package pasajes.models;

public abstract class VehiculoTransporte {
    private String patente;
    private int capacidad;
    private String empresa;

    public VehiculoTransporte(String patente, int capacidad, String empresa){
        setPatente(patente);
        setCapacidad(capacidad);
        setEmpresa(empresa);
    }

    /**
     * El precio base del vehículo depende de la capacidad o tipo.
     * @return Precio base
     */
    public abstract double calcularCostoBase();

    // Getter y setter con validación para capacidad
    public int getCapacidad() {
        return capacidad;
    }
    public void setCapacidad(int capacidad) {
        if (capacidad > 0) {
            this.capacidad = capacidad;
        } else {
            throw new IllegalArgumentException("La capacidad debe ser mayor a cero.");
        }
    }

    public String getEmpresa() {
        return empresa;
    }
    public void setEmpresa(String empresa) {
        if (empresa != null && !empresa.trim().isEmpty()) {
            this.empresa = empresa;
        } else {
            throw new IllegalArgumentException("La empresa no puede estar vacía.");
        }
    }

    public String getPatente() {
        return patente;
    }
    public void setPatente(String patente) {
        if (patente != null && !patente.trim().isEmpty()) {
            this.patente = patente;
        } else {
            throw new IllegalArgumentException("La patente no puede estar vacía.");
        }
    }

    @Override
    public String toString() {
        return "Patente: '" + patente + '\'' +
                ", Capacidad: " + capacidad +
                ", Empresa: '" + empresa + '\'';
    }
}
