package co.edu.uniquindio.poo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private static List<Miembro> listaMiembros = new ArrayList<>();
    private static List<Libro> listaLibros = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
<<<<<<< HEAD
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- Sistema de Gestión de Biblioteca ---");
            System.out.println("1. Agregar Miembro");
            System.out.println("2. Agregar Libro");
            System.out.println("3. Realizar Préstamo");
            System.out.println("4. Devolver Libro");
            System.out.println("5. Mostrar Préstamos Activos");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            switch (opcion) {
                case 1:
                    Miembro.agregarMiembro(scanner, listaMiembros);
                    break;
                case 2:
                    Libro.agregarLibro(scanner, listaLibros);
                    break;
                case 3:
                    Libro.prestarLibro(scanner, listaMiembros, listaLibros);
                    break;
                case 4:
                    Libro.devolverLibro(scanner, listaLibros);
                    break;
                case 5:
                    Prestamo.mostrarPrestamosActivos(scanner, listaMiembros);
                    break;
                case 6:
                    salir = true;
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
=======
        
        Libro libro1 = new Libro("la divina comedia", "dante", 4589);
        Libro libro2 = new Libro("boulevard", "flor m salvador", 89021);

        Miembro miembro1 =new Miembro("nicol marin", 1234567);
        Miembro miembro2 =new Miembro("majo tovar", 2345890);

        Bibliotecario bibliotecario= new Bibliotecario("fernando perez", 18902345);

        bibliotecario.gestionarPrestamos(libro1,miembro1);
        bibliotecario.gestionarPrestamos(libro2, miembro2);
        


>>>>>>> bd69c696bf2ec3ca78af32a505a960c87377927d
    }
}
