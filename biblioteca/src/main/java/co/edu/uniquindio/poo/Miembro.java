package co.edu.uniquindio.poo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Miembro {
    private String nombre;
    private int id;
    private List<Prestamo> prestamosActivos;
    private List<Prestamo> historialPrestamos;

    public Miembro(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
        this.prestamosActivos = new ArrayList<>();
        this.historialPrestamos = new ArrayList<>();
    }

    public static void agregarMiembro(Scanner scanner, List<Miembro> listaMiembros) {
        System.out.println("\n--- Agregar Miembro ---");
        System.out.print("Ingrese el nombre del miembro: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el ID del miembro: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        Miembro miembro = new Miembro(nombre, id);
        listaMiembros.add(miembro);
        System.out.println("Miembro agregado exitosamente: " + miembro.getNombre());
    }

    public static Miembro buscarMiembroPorId(int id, List<Miembro> listaMiembros) {
        for (Miembro miembro : listaMiembros) {
            if (miembro.getId() == id) {
                return miembro;
            }
        }
        return null; // Devuelve null si no se encuentra el miembro
    }




    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }
}
