package pasajes.components;

import pasajes.models.Viaje;

import java.util.Comparator;


public class ComparatorNombrePasajero implements Comparator<Viaje> {

    @Override
    public int compare(Viaje o1, Viaje o2) {
        return o1.getNombrePasajero().compareToIgnoreCase(o2.getNombrePasajero());
    }
}
