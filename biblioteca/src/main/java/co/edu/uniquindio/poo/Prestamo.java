package co.edu.uniquindio.poo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Prestamo {
    private Libro libro;
    private Miembro miembro;
    private LocalDateTime fechaPrestamo;
    private LocalDateTime fechaDevolucion;

    public Prestamo(Libro libro, Miembro miembro, LocalDateTime fechaPrestamo, LocalDateTime fechaDevolucion) {
        this.libro = libro;
        this.miembro = miembro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.libro.prestar();
        this.miembro.agregarPrestamos(this);
    }

    public static void mostrarPrestamosActivos(Scanner scanner, List<Miembro> listaMiembros) {
        System.out.println("\n--- Mostrar Préstamos Activos ---");
        System.out.print("Ingrese el ID del miembro: ");
        int idMiembro = scanner.nextInt();
        scanner.nextLine();

        Miembro miembro = Miembro.buscarMiembroPorId(idMiembro, listaMiembros);

        if (miembro != null) {
            for (Prestamo prestamo : miembro.getPrestamosActivos()) {
                System.out.println("Libro: " + prestamo.getLibro().getTitulo() + " - Fecha de Préstamo: " + prestamo.getFechaPrestamo());
            }
        } else {
            System.out.println("Miembro no encontrado.");
        }
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Miembro getMiembro() {
        return miembro;
    }

    public void setMiembro(Miembro miembro) {
        this.miembro = miembro;
    }

    public LocalDateTime getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDateTime fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDateTime getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDateTime fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
}






