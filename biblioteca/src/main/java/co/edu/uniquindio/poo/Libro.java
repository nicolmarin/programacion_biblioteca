package co.edu.uniquindio.poo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Libro extends ItemBiblioteca {
    private String autor;
    private int isbn;
    private String estado;

    public Libro(String titulo, String autor, int isbn) {
        super(titulo);
        this.autor = autor;
        this.isbn = isbn;
        this.estado = "disponible";
    }

    public static void devolverLibro(Scanner scanner, List<Libro> listaLibros, List<Prestamo> listaPrestamos, List<Prestamo> historialPrestamos) {
        System.out.print("Ingrese el ISBN del libro que desea devolver: ");
        int isbn = scanner.nextInt();
        scanner.nextLine();

        // Buscando el libro por su ISBN
        Libro libroEncontrado = buscarLibroPorIsbn(isbn, listaLibros);

        if (libroEncontrado == null) {
            System.out.println("No se encontró un libro con ese ISBN.");
            return;
        }

        // Buscando el préstamo activo
        Prestamo prestamoEncontrado = buscarPrestamoPorLibro(libroEncontrado, listaPrestamos);

        if (prestamoEncontrado != null) {
            // Actualizando la fecha de devolución
            prestamoEncontrado.setFechaDevolucion(LocalDateTime.now()); // Uso correcto de LocalDateTime
            libroEncontrado.setEstado("disponible"); // Cambiar el estado del libro

            // Cambiar el estado del préstamo a "devuelto"
            prestamoEncontrado.setEstado("devuelto"); // Asegúrate de tener un método setEstado en la clase Prestamo
            historialPrestamos.add(prestamoEncontrado); // Agregar el préstamo al historial
            listaPrestamos.remove(prestamoEncontrado); // Eliminar el préstamo de la lista activa

            System.out.println("El libro ha sido devuelto exitosamente.");
        } else {
            System.out.println("No hay un préstamo activo para este libro.");
        }
    }

    private static Prestamo buscarPrestamoPorLibro(Libro libro, List<Prestamo> listaPrestamos) {
        for (Prestamo prestamo : listaPrestamos) {
            if (prestamo.getLibro().equals(libro) && prestamo.getFechaDevolucion() == null) {
                return prestamo;
            }
        }
        return null;
    }

    public static Libro buscarLibroPorIsbn(int isbn, List<Libro> listaLibros) {
        for (Libro libro : listaLibros) {
            if (libro.getIsbn() == isbn) {
                return libro; // Retorna el libro encontrado
            }
        }
        return null; // Retorna null si no se encuentra el libro
    }
    public static Libro buscarLibroPorIsbn(Scanner scanner, List<Libro> listaLibros) {
        System.out.print("Ingrese el ISBN del libro a buscar: ");
        int isbn = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner

        for (Libro libro : listaLibros) {
            if (libro.getIsbn() == isbn) {
                return libro; // Retorna el libro encontrado
            }
        }
        System.out.println("Libro no encontrado.");
        return null; // Retorna null si no se encuentra el libro
    }

    public static void agregarLibro(Scanner scanner, List<Libro> listaLibros) {
        System.out.println("\n--- Agregar Libro ---");
        System.out.print("Ingrese el título del libro: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el autor del libro: ");
        String autor = scanner.nextLine();
        System.out.print("Ingrese el ISBN del libro: ");
        int isbn = scanner.nextInt();
        scanner.nextLine();  // Limpiar buffer

        Libro libro = new Libro(titulo, autor, isbn);
        listaLibros.add(libro);
        System.out.println("Libro agregado exitosamente: " + libro.getTitulo());
    }
    public static void prestarLibro(Scanner scanner, List<Miembro> listaMiembros, List<Libro> listaLibros, List<Prestamo> listaPrestamos) {
        System.out.println("\n--- Prestar Libro ---");
        System.out.print("Ingrese el ID del miembro: ");
        int idMiembro = scanner.nextInt();
        scanner.nextLine();
        Miembro miembro = Miembro.buscarMiembroPorId(idMiembro, listaMiembros);
        if (miembro == null) {
            System.out.println("Miembro no encontrado.");
            return;
        }
        Libro libro = buscarLibroPorIsbn(scanner, listaLibros);
        if (libro != null && libro.estaDisponible()) {
            Prestamo prestamo = new Prestamo(libro, miembro);
            listaPrestamos.add(prestamo); // Agregar el préstamo a la lista
            libro.setEstado("no disponible"); // Cambiar el estado del libro
            System.out.println("Libro prestado exitosamente: " + libro.getTitulo());
        } else {
            System.out.println("El libro no está disponible o no se encontró.");
        }
    }
    public static void verificarDisponibilidadLibro(Scanner scanner, List<Libro> listaLibros) {
        System.out.println("\n--- Verificar Disponibilidad del Libro ---");
        Libro libro = buscarLibroPorIsbn(scanner, listaLibros);

        if (libro != null) {
            System.out.println("El libro " + libro.getTitulo() + " está " + libro.getEstado() + ".");
        }
    }
    public static Libro buscarLibroPorTitulo(Scanner scanner, List<Libro> listaLibros) {
        System.out.println("\n--- Buscar Libro por Título ---");
        System.out.print("Ingrese el título del libro: ");
        String titulo = scanner.nextLine(); // Leer el título
        for (Libro libro : listaLibros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                libro.mostrarDetalles(); // Mostrar detalles del libro
                return libro; // Retorna el libro encontrado
            }
        }
        System.out.println("Libro no encontrado.");
        return null; // Retorna null si no se encuentra el libro
    }
    // Getters
    public int getIsbn() {
        return isbn;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public boolean estaDisponible() {
        return "disponible".equals(estado);
    }
    @Override
    public void mostrarDetalles() {
        System.out.println("Título: " + getTitulo());
        System.out.println("Autor: " + autor);
        System.out.println("ISBN: " + isbn);
        System.out.println("Estado: " + estado);
    }
    @Override
    public void mostrarItem() {
        System.out.println("Item: " + getTitulo());
    }
}
