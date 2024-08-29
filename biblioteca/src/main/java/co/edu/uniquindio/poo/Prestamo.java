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

    public Prestamo(Libro libro, Miembro miembro, LocalDateTime fechaPrestamo, LocalDateTime fechaDevolucion, List<Prestamo> listaprestamosActivos ) {
        this.libro = libro;
        this.miembro = miembro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.prestamosActivos= prestamosActivos;

        libro.setEstado("prestado");
        ((Prestamo) prestamosActivos).agregarPrestamos(this);
    }
    public void mostrarHistorialPrestamos(Scanner scanner) {
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
                System.out.println("Nombre: "+miembro.getNombre()+" Libro: " + prestamo.getLibro().getTitulo() +
                        " - Fecha de Préstamo: " + fechaPrestamoFormateada +
                        " - Fecha de Devolución: " + fechaDevolucionFormateada);
            }
        }
    }
    
    public void mostrarPrestamosActivos(Scanner scanner) {
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
                System.out.println("Nombre: "+miembro.getNombre()+" Libro: " + prestamo.getLibro().getTitulo() +
                        " - Fecha de Préstamo: " + fechaPrestamoFormateada);
            }
        }
    }
    
    
    
    public List<Prestamo> getPrestamosActivos() {
        return prestamosActivos;
    }
    public void setPrestamosActivos(List<Prestamo> prestamosActivos) {
        this.prestamosActivos = prestamosActivos;
    }
    public void agregarPrestamos(Prestamo prestamo) {
        prestamosActivos.add(prestamo);
    }
    
    public void marcarComoDevuelto() {
        this.fechaDevolucion = LocalDateTime.now();
        libro.setEstado("disponible");
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


    

}
