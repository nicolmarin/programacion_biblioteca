package co.edu.uniquindio.poo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prestamo {
    private Libro libro;
    private Miembro miembro;
    private LocalDateTime fechaPrestamo;
    private LocalDateTime fechaDevolucion;
    private List<Prestamo> prestamosActivos;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    

   
    public Prestamo(Libro libro, Miembro miembro, LocalDateTime fechaPrestamo, LocalDateTime fechaDevolucion, List<Prestamo> prestamosActivos) {
        this.libro = libro;
        this.miembro = miembro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.prestamosActivos = new ArrayList<>();

        libro.setEstado("prestado");
        ((Prestamo) prestamosActivos).agregarPrestamos(this);
        }
       
    public void marcarComoDevuelto() {
        this.fechaDevolucion = LocalDateTime.now();
        libro.setEstado("disponible");
    }

    
    public void agregarPrestamos(Prestamo prestamo) {
        if (!prestamosActivos.contains(prestamo)) {
            prestamosActivos.add(prestamo);
        } else {
            System.out.println("El préstamo ya existe para este miembro.");
        }
    }

    public boolean removerPrestamo(Prestamo prestamo) {
        return prestamosActivos.remove(prestamo); // Devuelve true si se eliminó
    }
    public static void mostrarHistorialPrestamos(Scanner scanner, List<Miembro> listaMiembros) {
        System.out.print("Ingrese el ID del miembro para ver el historial de préstamos: ");
        int idMiembro = scanner.nextInt();
        scanner.nextLine();
        Miembro miembro = Miembro.buscarMiembroPorId(idMiembro, listaMiembros);

        if (miembro == null) {
            System.out.println("Miembro no encontrado.");
            return;
        }

        Prestamo prestamo;
        List<Prestamo> historialPrestamos = prestamo.getPrestamosActivos();

        System.out.println("\n--- Historial de Préstamos para " + miembro.getNombre() + " ---");
        if (historialPrestamos.isEmpty()) {
            System.out.println("No hay préstamos registrados para este miembro.");
        } else {
            for (Prestamo prestamo : historialPrestamos) {
                String fechaPrestamoFormateada = prestamo.getFechaPrestamo().format(FORMATTER);
                String fechaDevolucion = prestamo.getFechaDevolucion() == null ? "No devuelto" :
                        prestamo.getFechaDevolucion().format(FORMATTER);
                System.out.println("Libro: " + prestamo.getLibro().getTitulo() +
                        " - Fecha de Préstamo: " + fechaPrestamoFormateada +
                        " - Fecha de Devolución: " + fechaDevolucion);
            }
        }
    }

    public static void mostrarPrestamosActivos(Scanner scanner, List<Miembro> listaMiembros) {
        System.out.println("\n--- Mostrar Préstamos Activos ---");
        System.out.print("Ingrese el ID del miembro: ");
        int idMiembro = scanner.nextInt();
        scanner.nextLine();

        Miembro miembro = Miembro.buscarMiembroPorId(idMiembro, listaMiembros);

        if (miembro != null) {
            Prestamo prestamo;
            for (Prestamo prestamo : prestamo.getPrestamosActivos()) {
                String fechaPrestamoFormateada = prestamo.getFechaPrestamo().format(FORMATTER);
                System.out.println("Libro: " + prestamo.getLibro().getTitulo() +
                        " - Fecha de Préstamo: " + fechaPrestamoFormateada);
            }
        } else {
            System.out.println("Miembro no encontrado.");
        }
    }

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

    public void setFechaDevolucion(LocalDateTime fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
    public List<Prestamo> getPrestamosActivos() {
        return prestamosActivos;
    }

    public void setPrestamosActivos(List<Prestamo> prestamosActivos) {
        this.prestamosActivos = prestamosActivos;
    }
    



}
