package co.edu.uniquindio.poo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Prestamo {
    private Libro libro;
    private Miembro miembro;
    private String estado; // Estado del préstamo
    private LocalDateTime fechaPrestamo;
    private LocalDateTime fechaDevolucion;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    private static List<Prestamo> prestamosActivos = new ArrayList<>();
    private static List<Prestamo> historialPrestamos = new ArrayList<>();

    public Prestamo(Libro libro, Miembro miembro) {
        this.libro = libro;
        this.miembro = miembro;
        this.fechaPrestamo = LocalDateTime.now();
        this.fechaDevolucion = null;

        libro.setEstado("prestado");
        agregarPrestamos(this);
    }

    public void setFechaDevolucion(LocalDateTime fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
        historialPrestamos.add(this); // Agrega el préstamo al historial al devolver
        prestamosActivos.remove(this); // Remueve el préstamo de los activos
    }

    public static void agregarPrestamos(Prestamo prestamo) {
        prestamosActivos.add(prestamo);
        historialPrestamos.add(prestamo);
    }

    public void setEstado(String estado) {
        this.estado = estado; // Cambia el estado del préstamo
    }


    public static Prestamo buscarPrestamoPorLibro(Libro libro) {
        for (Prestamo prestamo : prestamosActivos) {
            if (prestamo.getLibro().equals(libro) && prestamo.getFechaDevolucion() == null) {
                return prestamo;
            }
        }
        return null;
    }

    public static void mostrarPrestamosActivos(Scanner scanner, List<Prestamo> prestamosActivos) {
        if (prestamosActivos.isEmpty()) {
            System.out.println("No hay préstamos activos.");
            return;
        }

        System.out.println("╔══════════════════════════════════════════════");
        System.out.println("║             📚 Préstamos Activos 📚          ");
        System.out.println("╠══════════════════════════════════════════════");

        for (Prestamo prestamo : prestamosActivos) {
            System.out.println("Título: " + prestamo.getLibro().getTitulo());
            System.out.println("Miembro: " + prestamo.getMiembro().getNombre());
            System.out.println("Fecha de Préstamo: " + prestamo.getFechaPrestamo());
            System.out.println("Estado: " + (prestamo.getFechaDevolucion() == null ? "Activo" : "Devuelto"));
            System.out.println("╚══════════════════════════════════════════════");
        }
    }

    public static void mostrarHistorialPrestamos(Scanner scanner, List<Prestamo> historialPrestamos) {
        if (historialPrestamos.isEmpty()) {
            System.out.println("No hay historial de préstamos.");
            return;
        }

        System.out.println("╔══════════════════════════════════════════════");
        System.out.println("║            📚 Historial de Préstamos 📚     ");
        System.out.println("╠══════════════════════════════════════════════");

        for (Prestamo prestamo : historialPrestamos) {
            System.out.println("Título: " + prestamo.getLibro().getTitulo());
            System.out.println("Miembro: " + prestamo.getMiembro().getNombre());
            System.out.println("Fecha de Préstamo: " + prestamo.getFechaPrestamo());
            System.out.println("Fecha de Devolución: " + (prestamo.getFechaDevolucion() != null ? prestamo.getFechaDevolucion() : "No devuelto"));
            System.out.println("╚══════════════════════════════════════════════");
        }
    }

    public static List<Prestamo> getPrestamosActivos() {
        return prestamosActivos;
    }

    public static List<Prestamo> getHistorialPrestamos() {
        return historialPrestamos;
    }



    public static List<Prestamo> buscarPrestamosPorMiembro(Miembro miembro) {
        List<Prestamo> prestamosMiembro = new ArrayList<>();
        for (Prestamo prestamo : prestamosActivos) {
            if (prestamo.getMiembro().equals(miembro)) {
                prestamosMiembro.add(prestamo);
            }
        }
        return prestamosMiembro;
    }

    public static List<Prestamo> buscarPrestamosVencidos() {
        List<Prestamo> prestamosVencidos = new ArrayList<>();
        for (Prestamo prestamo : prestamosActivos) {
            if (prestamo.getFechaDevolucion() == null && prestamo.getFechaPrestamo().plusDays(30).isBefore(LocalDateTime.now())) {
                prestamosVencidos.add(prestamo);
            }
        }
        return prestamosVencidos;
    }

    // Getters
    public Libro getLibro() {
        return libro;
    }

    public Miembro getMiembro() {
        return miembro;
    }

    public LocalDateTime getFechaPrestamo() {
        return fechaPrestamo;
    }

    public LocalDateTime getFechaDevolucion() {
        return fechaDevolucion;
    }
}
