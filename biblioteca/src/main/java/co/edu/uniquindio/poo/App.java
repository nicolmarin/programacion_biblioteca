package co.edu.uniquindio.poo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private final static List<Miembro> listaMiembros = new ArrayList<>();
    private final static List<Libro> listaLibros = new ArrayList<>();
    private final static List<Prestamo> listaPrestamos = new ArrayList<>();
    private final static Scanner scanner = new Scanner(System.in);
    private static Bibliotecario bibliotecario;

    public static void main(String[] args) {
        inicializarDatos();
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- Sistema de Gestión de Biblioteca ---");
            System.out.println("1. Agregar Miembro");
            System.out.println("2. Agregar Libro");
            System.out.println("3. Realizar Préstamo");
            System.out.println("4. Devolver Libro");
            System.out.println("5. Mostrar Préstamos Activos");
            System.out.println("6. Mostrar Historial de Préstamos");
            System.out.println("7. Verificar disponibilidad de libro ");
            System.out.println("8. Buscar libro por ISBN ");
            System.out.println("9. Buscar libro por título ");
            System.out.println("10. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    Miembro.agregarMiembro(scanner, listaMiembros);
                    break;
                case 2:
                    Libro.agregarLibro(scanner, listaLibros);
                    break;
                case 3:
                    Libro.prestarLibro(scanner, listaMiembros, listaLibros, listaPrestamos);
                    break;
                case 4:
                    Libro.devolverLibro(scanner, listaLibros, listaPrestamos);
                    break;
                case 5:
                    Prestamo.mostrarPrestamosActivos(scanner, listaMiembros);
                    break;
                case 6:
                    Prestamo.mostrarHistorialPrestamos(scanner, listaMiembros);
                    break;
                case 7:
                    Libro.verificarDisponibilidadLibro(scanner, listaLibros);
                    break;
                case 8:
                    Libro.buscarLibroPorIsbn(scanner, listaLibros);
                    break;
                case 9:
                    Libro.buscarLibroPorTitulo(scanner, listaLibros);
                    break;
                case 10:
                    salir = true;
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }

    public static void inicializarDatos() {
        bibliotecario = new Bibliotecario("Pepito El letras", 18902345);

        Libro libro1 = new Libro("La Divina Comedia", "Dante Alighieri", 4589);
        Libro libro2 = new Libro("Boulevard", "Flor M. Salvador", 89021);
        Libro libro3 = new Libro("Cien Años de Soledad", "Gabriel García Márquez", 12345);
        Libro libro4 = new Libro("El Amor en los Tiempos del Cólera", "Gabriel García Márquez", 67890);
        Libro libro5 = new Libro("1984", "George Orwell", 11223);
        Libro libro6 = new Libro("Orgullo y Prejuicio", "Jane Austen", 44556);
        Libro libro7 = new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", 77889);
        Libro libro8 = new Libro("El Principito", "Antoine de Saint-Exupéry", 99887);
        Libro libro9 = new Libro("La Sombra del Viento", "Carlos Ruiz Zafón", 66554);
        Libro libro10 = new Libro("Ficciones", "Jorge Luis Borges", 54321);

        // Lista de Libros
        listaLibros.add(libro1);
        listaLibros.add(libro2);
        listaLibros.add(libro3);
        listaLibros.add(libro4);
        listaLibros.add(libro5);
        listaLibros.add(libro6);
        listaLibros.add(libro7);
        listaLibros.add(libro8);
        listaLibros.add(libro9);
        listaLibros.add(libro10);

        Miembro miembro1 = new Miembro("Duvan Felipe", 1);
        Miembro miembro2 = new Miembro("Nicol Marin", 2);
        Miembro miembro3 = new Miembro("Majo Tovar", 3);

        // Listado de Miembros
        listaMiembros.add(miembro1);
        listaMiembros.add(miembro2);
        listaMiembros.add(miembro3);
    }
}
