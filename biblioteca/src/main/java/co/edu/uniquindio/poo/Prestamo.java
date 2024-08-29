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
    private static List<Prestamo> prestamosActivos = new ArrayList<>(); // Inicializar la lista aquí
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    public Prestamo(Libro libro, Miembro miembro, LocalDateTime fechaPrestamo, LocalDateTime fechaDevolucion) {
        this.libro = libro;
        this.miembro = miembro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;

        libro.setEstado("prestado");
        prestamosActivos.add(this); // Agregar el préstamo a la lista
    }
    public void agregarPrestamos(Prestamo prestamo) {
        prestamosActivos.add(prestamo);
    }
    public static void mostrarHistorialPrestamos(Scanner scanner, List<Miembro> listaMiembros) {
        System.out.print("Ingrese el nombre del miembro para ver el historial de préstamos: ");
        String nombreMiembro = scanner.nextLine();

        List<Prestamo> historialPrestamos = new ArrayList<>();

        for (Prestamo prestamo : prestamosActivos) {
            if (prestamo.getMiembro().getNombre().equalsIgnoreCase(nombreMiembro)) {
                historialPrestamos.add(prestamo);
            }
        }
        if (historialPrestamos.isEmpty()) {
            System.out.println("No hay préstamos registrados para este miembro.");
        } else {
            System.out.println("\n--- Historial de Préstamos ---");
            for (Prestamo prestamo : historialPrestamos) {
                String fechaPrestamoFormateada = prestamo.getFechaPrestamo().format(FORMATTER);
                String fechaDevolucionFormateada = prestamo.getFechaDevolucion() == null ? "No devuelto" :
                        prestamo.getFechaDevolucion().format(FORMATTER);

                System.out.println("Nombre: " + prestamo.getMiembro().getNombre() + " Libro: " + prestamo.getLibro().getTitulo() +
                        " - Fecha de Préstamo: " + fechaPrestamoFormateada +
                        " - Fecha de Devolución: " + fechaDevolucionFormateada);
            }
        }
    }
    public static void mostrarPrestamosActivos(Scanner scanner, List<Miembro> listaMiembros) {
        System.out.print("Ingrese el nombre del miembro: ");
        String nombreMiembro = scanner.nextLine();

        List<Prestamo> prestamosActivosMiembro = new ArrayList<>();

        for (Prestamo prestamo : prestamosActivos) {
            if (prestamo.getMiembro().getNombre().equalsIgnoreCase(nombreMiembro) && prestamo.getFechaDevolucion() == null) {
                prestamosActivosMiembro.add(prestamo);
            }
        }

        if (prestamosActivosMiembro.isEmpty()) {
            System.out.println("No hay préstamos activos para este miembro.");
        } else {
            System.out.println("\n--- Préstamos Activos ---");
            for (Prestamo prestamo : prestamosActivosMiembro) {
                String fechaPrestamoFormateada = prestamo.getFechaPrestamo().format(FORMATTER);
                System.out.println("Nombre: " + prestamo.getMiembro().getNombre() + " Libro: " + prestamo.getLibro().getTitulo() +
                        " - Fecha de Préstamo: " + fechaPrestamoFormateada);
            }
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

}
