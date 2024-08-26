package co.edu.uniquindio.poo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Libro extends ItemBiblioteca {
    private String autor;
    private int isbn;
    private String estado; // "disponible" o "prestado"

    // Constructor que inicializa el libro con su título, autor, ISBN y estado
    public Libro(String titulo, String autor, int isbn) {
        super(titulo); 
        this.autor = autor;
        this.isbn = isbn;
        this.estado = "disponible"; // Estado inicial del libro
    }

    public static void agregarLibro(Scanner scanner, List<Libro> listaLibros) {
        System.out.println("\n--- Agregar Libro ---");
        System.out.print("Ingrese el título del libro: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el autor del libro: ");
        String autor = scanner.nextLine();
        System.out.print("Ingrese el ISBN del libro: ");
        int isbn = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada

        Libro libro = new Libro(titulo, autor, isbn);
        listaLibros.add(libro);
        System.out.println("Libro agregado exitosamente: " + libro.getTitulo());
    }

    public static Libro buscarLibroPorIsbn(int isbn, List<Libro> listaLibros) {
        for (Libro libro : listaLibros) {
            if (libro.getIsbn() == isbn) {
                return libro;
            }
        }
        return null; // Retorna null si el libro no se encuentra
    }

    public static void prestarLibro(Scanner scanner, List<Miembro> listaMiembros, List<Libro> listaLibros) {
        System.out.println("\n--- Realizar Préstamo ---");
        System.out.print("Ingrese el ID del miembro: ");
        int idMiembro = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada

        Miembro miembro = Miembro.buscarMiembroPorId(idMiembro, listaMiembros);

        if (miembro == null) {
            System.out.println("Miembro no encontrado.");
            return;
        }

        System.out.print("Ingrese el ISBN del libro: ");
        int isbn = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada

        Libro libro = buscarLibroPorIsbn(isbn, listaLibros);

        if (libro == null) {
            System.out.println("Libro no encontrado.");
            return;
        }

        if ("disponible".equals(libro.getEstado())) {
            Prestamo prestamo = new Prestamo(libro, miembro, LocalDateTime.now(), null);
            miembro.agregarPrestamos(prestamo);
            libro.setEstado("prestado"); 
            System.out.println("Préstamo realizado exitosamente: " + libro.getTitulo());
        } else {
            System.out.println("El libro no está disponible para préstamo.");
        }
    }

    public static void devolverLibro(Scanner scanner, List<Libro> listaLibros) {
        System.out.println("\n--- Devolver Libro ---");
        System.out.print("Ingrese el ISBN del libro: ");
        int isbn = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada

        Libro libro = buscarLibroPorIsbn(isbn, listaLibros);

        if (libro != null && "prestado".equals(libro.getEstado())) {
            libro.setEstado("disponible"); // Cambiar el estado a disponible
            System.out.println("Libro devuelto exitosamente: " + libro.getTitulo());
        } else {
            System.out.println("El libro ya está disponible o no se encontró.");
        }
    }

    public static Libro buscarLibroPorTitulo(String titulo, List<Libro> listaLibros) {
        for (Libro libro : listaLibros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null; // Retorna null si el libro no se encuentra
    }

    public static void verificarDisponibilidadLibro(Scanner scanner, List<Libro> listaLibros) {
        System.out.println("\n--- Verificar Disponibilidad de Libro ---");
        System.out.print("Ingrese el ISBN del libro: ");
        int isbn = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada
    
        Libro libro = Libro.buscarLibroPorIsbn(isbn, listaLibros);
    
        if (libro != null) {
            if (libro.estaDisponible()) {
                System.out.println("El libro \"" + libro.getTitulo() + "\" está disponible.");
            } else {
                System.out.println("El libro \"" + libro.getTitulo() + "\" está prestado.");
            }
        } else {
            System.out.println("Libro no encontrado.");
        }
    }

    public static void buscarLibroPorIsbn(Scanner scanner, List<Libro> listaLibros) {
        System.out.println("\n--- Buscar Libro por ISBN ---");
        System.out.print("Ingrese el ISBN del libro: ");
        int isbn = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada
    
        Libro libro = Libro.buscarLibroPorIsbn(isbn, listaLibros);
    
        if (libro != null) {
            libro.mostrarDetalles();
        } else {
            System.out.println("Libro no encontrado.");
        }
    }

    public static void buscarLibroPorTitulo(Scanner scanner, List<Libro> listaLibros) {
        System.out.println("\n--- Buscar Libro por Título ---");
        System.out.print("Ingrese el título del libro: ");
        String titulo = scanner.nextLine();
    
        Libro libro = Libro.buscarLibroPorTitulo(titulo, listaLibros);
    
        if (libro != null) {
            libro.mostrarDetalles();
        } else {
            System.out.println("Libro no encontrado.");
        }
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Libro: " + getTitulo() + ", Autor: " + autor + ", ISBN: " + isbn + ", Estado: " + estado);
    }
     // Implementación del método abstracto para verificar disponibilidad
    
    public boolean estaDisponible() {
        return "disponible".equals(estado);
    }

    // Métodos getters y setters
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public String getAutor() {
        return autor;
    }

    public int getIsbn() {
        return isbn;
    }
   
}


