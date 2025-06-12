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
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar

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

    public static void registrarViaje() {

        //Nombre
        System.out.print("Nombre del pasajero: ");
        String nombre = sc.nextLine();

        //------------------------------------------------------------------------------------Pasaje
        int tipoPasaje;
        System.out.print("Tipo de pasaje (1: Común, 2: Estudiante, 3: Jubilado): ");

        //-----------------------VALIDATIONS
        invalidValueDetector();
        tipoPasaje = sc.nextInt();
        while (tipoPasaje < 0 ||tipoPasaje > 4) {
            System.out.print("[ERROR] Ingrese un numero valido: ");
            tipoPasaje = sc.nextInt();
        }


        //------------------------------------------------------------------------------------Transporte
        int transporte;
        System.out.print("Tipo de transporte (1: Colectivo, 2: Tren, 3: Subte): ");


        //-----------------------VALIDATIONS
        invalidValueDetector();
        transporte = sc.nextInt();
        while (transporte < 0 ||transporte > 4) {
            System.out.print("[ERROR] Ingrese un numero valido: ");
            transporte = sc.nextInt();
        }

        //------------------------------------------------------------------------------------Patente
        System.out.print("Ingrese patente de vehiculo: ");
        String patente = sc.nextLine();

        //------------------------------------------------------------------------------------Capacidad
        System.out.print("Ingrese capacidad: ");
        invalidValueDetector();
        int capacidad = sc.nextInt();
        sc.nextLine();

        //Empresa
        System.out.print("Ingrese empresa: ");
        String empresa = sc.nextLine();


        VehiculoTransporte vehiculo = null;
        switch (transporte) {
            case 1 -> vehiculo = new Colectivo(patente, capacidad, empresa);
            case 2 -> vehiculo = new Tren(patente, capacidad, empresa);
            case 3 -> vehiculo = new Subte(patente, capacidad, empresa);
            default -> {
                System.out.println("Tipo de vehiculo inválido.");
            }
        }

        Pasaje pasaje = null;
        switch (tipoPasaje) {
            case 1 -> pasaje = new PasajeComun(nombre, vehiculo);
            case 2 -> pasaje = new PasajeEstudiante(nombre, vehiculo);
            case 3 -> pasaje = new PasajeJubilado(nombre, vehiculo);
            default -> {
                System.out.println("Tipo de pasaje inválido.");
            }
        }

        Viaje viaje = new Viaje(pasaje, vehiculo);
        viajes.add(viaje);
        System.out.println("Viaje registrado con éxito.");


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

}


