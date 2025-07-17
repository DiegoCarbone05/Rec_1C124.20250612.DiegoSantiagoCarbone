package pasajes;

import pasajes.components.ComparatorNombrePasajero;
import pasajes.models.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author diego
 */
public class Pasajes {

    static Scanner sc = new Scanner(System.in);
    static List<Viaje> viajes = new ArrayList<>();

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            opcion = obtenerOpcionMenu();

            switch (opcion) {
                case 1 -> registrarViaje();
                case 2 -> mostrarViajes();
                case 3 -> ordenarCosto();
                case 4 -> ordenarNombre();
                case 5 -> mostrarTotal();
                case 0 -> System.out.println("Saliendo del sistema");
                default -> System.out.println("Opcion invalida");
            }

        } while (opcion != 0);

        sc.close();
    }

    public static void mostrarMenu() {
        System.out.println("\n--- Menú ---");
        System.out.println("1. Registrar un nuevo viaje");
        System.out.println("2. Mostrar todos los viajes realizados");
        System.out.println("3. Ordenar los viajes por costo");
        System.out.println("4. Ordenar los viajes por nombre de pasajero");
        System.out.println("5. Mostrar el total recaudado");
        System.out.println("0. Salir");
        System.out.print("Opción: ");
    }

    public static int obtenerOpcionMenu() {
        int opcion = -1;
        boolean valido = false;
        while (!valido) {
            invalidValueDetector();
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer
            if (opcion >= 0 && opcion <= 5) {
                valido = true;
            } else {
                System.out.print("[ERROR] Ingrese una opción válida: ");
            }
        }
        return opcion;
    }

    public static void registrarViaje() {
        //Nombre
        System.out.print("Nombre del pasajero: ");
        String nombre = sc.nextLine();

        //------------------------------------------------------------------------------------Transporte
        int transporte;
        System.out.print("Tipo de transporte (1: Colectivo, 2: Tren, 3: Subte): ");
        transporte = obtenerOpcionRango(1, 3);

        //------------------------------------------------------------------------------------Patente
        System.out.print("Ingrese patente de vehiculo: ");
        String patente = sc.nextLine();
        if (patente.isEmpty()) {
            patente = sc.nextLine(); // Por si quedó salto de línea pendiente
        }

        //------------------------------------------------------------------------------------Capacidad
        int capacidad = -1;
        do {
            System.out.print("Ingrese capacidad: ");
            invalidValueDetector();
            capacidad = sc.nextInt();
            if (capacidad <= 0) {
                System.out.println("[ERROR] La capacidad debe ser mayor a 0.");
            }
        } while (capacidad <= 0);
        sc.nextLine();

        //Empresa
        System.out.print("Ingrese empresa: ");
        String empresa = sc.nextLine();

        VehiculoTransporte vehiculo = null;
        switch (transporte) {
            case 1 -> vehiculo = new Colectivo(patente, capacidad, empresa);
            case 2 -> vehiculo = new Tren(patente, capacidad, empresa);
            case 3 -> vehiculo = new Subte(patente, capacidad, empresa);
        }

        //------------------------------------------------------------------------------------Pasaje
        int tipoPasaje;
        System.out.print("Tipo de pasaje (1: Común, 2: Estudiante, 3: Jubilado): ");
        tipoPasaje = obtenerOpcionRango(1, 3);

        // Calcular el costo base del vehículo
        double costoBase = vehiculo.calcularCostoBase();

        Pasaje pasaje = null;
        switch (tipoPasaje) {
            case 1 -> pasaje = new PasajeComun(costoBase, nombre);
            case 2 -> pasaje = new PasajeEstudiante(costoBase, nombre);
            case 3 -> pasaje = new PasajeJubilado(costoBase, nombre);
        }

        // Validar duplicados antes de registrar el viaje
        boolean duplicado = false;
        for (Viaje v : viajes) {
            if (v.getNombrePasajero().equalsIgnoreCase(nombre) && v.toString().contains(patente)) {
                duplicado = true;
                break;
            }
        }
        if (duplicado) {
            System.out.println("[ERROR] Ya existe un viaje con ese pasajero y patente.");
            return;
        }

        if (vehiculo != null && pasaje != null) {
            Viaje viaje = new Viaje(pasaje, vehiculo);
            viajes.add(viaje);
            System.out.println("Viaje registrado con éxito.");
        } else {
            System.out.println("No se pudo registrar el viaje por datos inválidos.");
        }
    }

    public static void mostrarViajes() {
        if (viajes.isEmpty()) {
            System.out.println("No hay viajes registrados");
            return;
        }

        for (Viaje v : viajes) {
            System.out.println(v.toString());
        }
    }

    public static void ordenarCosto() {
        Collections.sort(viajes);
        System.out.println("Viajes ordenados por costos");
        mostrarViajes();
    }

    public static void ordenarNombre() {
        Collections.sort(viajes, new ComparatorNombrePasajero());
        System.out.println("Viajes ordenados por nombre");
        mostrarViajes();
    }

    public static void mostrarTotal() {
        double total = 0;
        for (Viaje v : viajes) {
            total += v.getCosto();
        }
        System.out.println("Total recaudado: $" + total);
    }



    public static void invalidValueDetector(){
        while (!sc.hasNextInt()){
            System.out.println("Entrada inválida. Ingrese un número entero:");
            sc.nextLine();
        }
    }

    // Nueva función para validar opciones en un rango específico
    public static int obtenerOpcionRango(int min, int max) {
        int opcion = -1;
        boolean valido = false;
        while (!valido) {
            invalidValueDetector();
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer
            if (opcion >= min && opcion <= max) {
                valido = true;
            } else {
                System.out.print("[ERROR] Ingrese un número válido: ");
            }
        }
        return opcion;
    }

}


