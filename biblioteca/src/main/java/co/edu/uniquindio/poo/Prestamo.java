package co.edu.uniquindio.poo;

<<<<<<< HEAD
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
=======
import java.time.LocalDate;
>>>>>>> bd69c696bf2ec3ca78af32a505a960c87377927d

public class Prestamo {
    private Libro libro;
    private Miembro miembro;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

<<<<<<< HEAD
    public Prestamo(Libro libro, Miembro miembro, LocalDateTime fechaPrestamo, LocalDateTime fechaDevolucion) {
=======
    public Prestamo(Libro libro, Miembro miembro, LocalDate fechaPrestamo, LocalDate fechaDevolucion) {
>>>>>>> bd69c696bf2ec3ca78af32a505a960c87377927d
        this.libro = libro;
        this.miembro = miembro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
<<<<<<< HEAD
        this.libro.prestar();
        this.miembro.agregarPrestamos(this);
    }
=======
        
    }
    
    
>>>>>>> bd69c696bf2ec3ca78af32a505a960c87377927d

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






