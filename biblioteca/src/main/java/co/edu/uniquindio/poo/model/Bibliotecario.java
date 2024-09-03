package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Bibliotecario extends Empleado implements IGestionInventario {
    public List<ItemBiblioteca> inventario = new ArrayList<>();
    public Bibliotecario(String nombre, int idEmpleado) {
        super(nombre, idEmpleado);
        // Agregar ítems predeterminados al inventario
        inventario.add(new Libro("Avengers Comic", "Stan Lee", 123456));
        inventario.add(new Libro("Comic - Superman", "Joe Shuster", 654321));
        inventario.add(new Libro("Revista National Geographic", "National Geographic Society", 112233));
        inventario.add(new Libro("Comic - Batman: The Dark Knight Returns", "Frank Miller", 334455));
        inventario.add(new Libro("Revista Time - Edición Especial", "Time Inc.", 556677));
        inventario.add(new Libro("Comic - Spider-Man", "Stan Lee", 778899));
        inventario.add(new Libro("Revista Science", "American Association for the Advancement of Science", 998877));
        inventario.add(new Libro("Comic - X-Men", "Stan Lee", 445566));
    }
    public void agregarItem(Scanner scanner) {
        System.out.print("Ingrese el título del ítem: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el autor del ítem: ");
        String autor = scanner.nextLine();
        System.out.print("Ingrese el ISBN del ítem: ");
        int isbn = scanner.nextInt();
        scanner.nextLine();
        Libro nuevoLibro = new Libro(titulo, autor, isbn);
        agregarItem(nuevoLibro);
    }
    public void removerItemConScanner(Scanner scanner, List<Libro> listaLibros) {
        System.out.print("Ingrese el ISBN del ítem a remover: ");
        int isbnRemover = scanner.nextInt();
        scanner.nextLine();
        Libro libroARemover = null;
        for (ItemBiblioteca item : inventario) {
            if (item instanceof Libro && ((Libro) item).getIsbn() == isbnRemover) {
                libroARemover = (Libro) item;
                break;
            }
        }
        if (libroARemover != null) {
            removerItem(libroARemover);
            boolean libroEliminado = listaLibros.remove(libroARemover);
            if (libroEliminado) {
                System.out.println("Ítem removido del inventario y de la lista de libros: " + libroARemover.getTitulo());
            }
        } else {
            System.out.println("Ítem no encontrado en el inventario del bibliotecario.");
        }
    }
    @Override
    public void gestionarItem() {
        System.out.println("\n--- Gestión de Ítems ---");
        for (ItemBiblioteca item : inventario) {
            item.mostrarArchivo();
        }
        System.out.println("Puede agregar o remover ítems del inventario.");
    }
    @Override
    public void agregarItem(ItemBiblioteca item) {
        inventario.add(item);
        System.out.println("Ítem agregado al inventario: " + item.getTitulo());
    }
    @Override
    public void removerItem(ItemBiblioteca item) {
        inventario.remove(item);
        System.out.println("Ítem removido del inventario: " + item.getTitulo());
    }
    @Override
    public void mostrarInventario() {
        System.out.println("Inventario:");
        for (ItemBiblioteca item : inventario) {
            item.mostrarItem();
        }
    }

}
