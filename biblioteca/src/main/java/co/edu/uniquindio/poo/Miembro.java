package co.edu.uniquindio.poo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Miembro {
    private String nombre;
    private int idMiembro;
    private List<Prestamo> prestamosActivos;

    public Miembro(String nombre, int idMiembro) {
        this.nombre = nombre;
        this.idMiembro = idMiembro;
        this.prestamosActivos = new ArrayList<>();
    }

    public static void agregarMiembro(Scanner scanner, List<Miembro> listaMiembros) {
        System.out.println("\n--- Agregar Miembro ---");
        System.out.print("Ingrese el nombre del miembro: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el ID del miembro: ");
        int idMiembro = scanner.nextInt();
        scanner.nextLine();

        Miembro miembro = new Miembro(nombre, idMiembro);
        listaMiembros.add(miembro);
        System.out.println("Miembro agregado exitosamente: " + miembro.getNombre());
    }

    public static Miembro buscarMiembroPorId(int idMiembro, List<Miembro> listaMiembros) {
        for (Miembro miembro : listaMiembros) {
            if (miembro.getIdMiembro() == idMiembro) {
                return miembro;
            }
        }
        return null;
    }

    public void agregarPrestamos(Prestamo prestamo) {
        prestamosActivos.add(prestamo);
    }

    public void removerPrestamo(Prestamo prestamo) {
        prestamosActivos.remove(prestamo);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdMiembro() {
        return idMiembro;
    }

    public void setIdMiembro(int idMiembro) {
        this.idMiembro = idMiembro;
    }

    public List<Prestamo> getPrestamosActivos() {
        return prestamosActivos;
    }

    public void setPrestamosActivos(List<Prestamo> prestamosActivos) {
        this.prestamosActivos = prestamosActivos;
    }
}

