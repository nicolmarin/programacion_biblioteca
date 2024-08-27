package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Prestamo {
    private Libro libro;
    private Miembro miembro;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

    // Constructor que inicializa el préstamo con libro, miembro, fecha de préstamo y fecha de devolución
    public Prestamo(Libro libro, Miembro miembro, LocalDateTime fechaPrestamo, LocalDateTime fechaDevolucion) {
        this.libro = libro;
        this.miembro = miembro;
        this.fechaPrestamo = fechaPrestamo.toLocalDate(); // Convertir a LocalDate
        this.fechaDevolucion = fechaDevolucion.toLocalDate();

        libro.setEstado("prestado"); // Marcar el libro como prestado
        miembro.agregarPrestamos(this); // Agregar préstamo al miembro
    }

    // Método para mostrar los préstamos activos de un miembro
    public static void mostrarPrestamosActivos(Scanner scanner, List<Miembro> listaMiembros) {
        System.out.println("\n--- Mostrar Préstamos Activos ---");
        System.out.print("Ingrese el ID del miembro: ");
        int idMiembro = scanner.nextInt();
        scanner.nextLine();

        Miembro miembro = Miembro.buscarMiembroPorId(idMiembro, listaMiembros);

        if (miembro != null) {
            for (Prestamo prestamo : miembro.getPrestamosActivos()) {
                System.out.println("Libro: " + prestamo.getLibro().getTitulo() + 
                                   " - Fecha de Préstamo: " + prestamo.getFechaPrestamo() +
                                   " - Fecha de Devolución: " + prestamo.getFechaDevolucion());
            }
        } else {
            System.out.println("Miembro no encontrado.");
        }
    }

    // Getters y setters
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

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
}






