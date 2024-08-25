package co.edu.uniquindio.poo;

<<<<<<< HEAD
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Libro {
    private String titulo;
=======
public class Libro extends ItemBiblioteca {
>>>>>>> bd69c696bf2ec3ca78af32a505a960c87377927d
    private String autor;
    private int isbn;
    private boolean disponible;

<<<<<<< HEAD
    public Libro(String titulo, String autor, int isbn, String estado) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.estado = estado;
    }

    public static void agregarLibro(Scanner scanner, List<Libro> listaLibros) {
        System.out.println("\n--- Agregar Libro ---");
        System.out.print("Ingrese el título del libro: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el autor del libro: ");
        String autor = scanner.nextLine();
        System.out.print("Ingrese el ISBN del libro: ");
        int isbn = scanner.nextInt();
        scanner.nextLine();

        Libro libro = new Libro(titulo, autor, isbn, "disponible");
        listaLibros.add(libro);
        System.out.println("Libro agregado exitosamente: " + libro.getTitulo());
    }

    public static Libro buscarLibroPorIsbn(int isbn, List<Libro> listaLibros) {
        for (Libro libro : listaLibros) {
            if (libro.getIsbn() == isbn) {
                return libro;
            }
        }
        return null;
    }

    public static void prestarLibro(Scanner scanner, List<Miembro> listaMiembros, List<Libro> listaLibros) {
        System.out.println("\n--- Realizar Préstamo ---");
        System.out.print("Ingrese el ID del miembro: ");
        int idMiembro = scanner.nextInt();
        scanner.nextLine();

        Miembro miembro = Miembro.buscarMiembroPorId(idMiembro, listaMiembros);

        if (miembro == null) {
            System.out.println("Miembro no encontrado.");
            return;
        }

        System.out.print("Ingrese el ISBN del libro: ");
        int isbn = scanner.nextInt();
        scanner.nextLine();

        Libro libro = buscarLibroPorIsbn(isbn, listaLibros);

        if (libro == null) {
            System.out.println("Libro no encontrado.");
            return;
        }

        if ("disponible".equals(libro.getEstado())) {
            Prestamo prestamo = new Prestamo(libro, miembro, LocalDateTime.now(), null);
            miembro.agregarPrestamos(prestamo);
            System.out.println("Préstamo realizado exitosamente.");
        } else {
            System.out.println("El libro no está disponible para préstamo.");
        }
    }

    public static void devolverLibro(Scanner scanner, List<Libro> listaLibros) {
        System.out.println("\n--- Devolver Libro ---");
        System.out.print("Ingrese el ISBN del libro: ");
        int isbn = scanner.nextInt();
        scanner.nextLine();

        Libro libro = buscarLibroPorIsbn(isbn, listaLibros);

        if (libro != null && "prestado".equals(libro.getEstado())) {
            libro.devolver();
            System.out.println("Libro devuelto exitosamente.");
        } else {
            System.out.println("El libro ya está disponible o no se encontró.");
        }
    }

    public void prestar() {
        if ("disponible".equals(estado)) {
            estado = "prestado";
            System.out.println("El libro \"" + titulo + "\" ha sido prestado.");
        } else {
            System.out.println("El libro \"" + titulo + "\" ya está prestado.");
        }
=======
    public Libro(String titulo,String autor,int isbn){
        super(titulo);
        
        this.autor=autor;
        this.isbn=isbn;
        this.disponible=true;


    }
    @Override
    public void mostrarDetalles() {
        System.out.println("Libro: " + getTitulo() + ", Autor: " + autor + ", ISBN: " + isbn);
>>>>>>> bd69c696bf2ec3ca78af32a505a960c87377927d
    }
    public void setDisponible(boolean disponible){
        this.disponible=disponible;

    }
    public boolean isDisponible() {
        
        return disponible;
    }
    

    

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

<<<<<<< HEAD
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
=======
    
    
>>>>>>> bd69c696bf2ec3ca78af32a505a960c87377927d
}

