package co.edu.uniquindio.poo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Bibliotecario extends Empleado implements IGestionInventario {
    
    public List<ItemBiblioteca> inventario = new ArrayList<>();
    public Bibliotecario(String nombre, int idEmpleado) {
        super(nombre, idEmpleado);
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
    
        // Buscar el ítem en el inventario del bibliotecario
        Libro libroARemover = null;
        for (ItemBiblioteca item : inventario) {
            if (item instanceof Libro && ((Libro) item).getIsbn() == isbnRemover) {
                libroARemover = (Libro) item;
                break;
            }
        }
    
        if (libroARemover != null) {
            // Remover del inventario del bibliotecario
            removerItem(libroARemover);
    
            // También eliminar de la lista de libros
            boolean libroEliminado = listaLibros.remove(libroARemover);
            if (libroEliminado) {
                System.out.println("Ítem removido del inventario y de la lista de libros: " + libroARemover.getTitulo());
            } else {
                System.out.println("Ítem removido del inventario, pero no se encontró en la lista de libros.");
            }
        } else {
            System.out.println("Ítem no encontrado en el inventario del bibliotecario.");
        }
    }
    
    @Override
    public void gestionarItem() {
        System.out.println("Sus ítems se están agregando al inventario.");
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
            item.mostrarDetalles();
        }
    }

    public List<ItemBiblioteca> getInventario() {
        return inventario;
    }

    public void setInventario(List<ItemBiblioteca> inventario) {
        this.inventario = inventario;
    }
    
  

}


