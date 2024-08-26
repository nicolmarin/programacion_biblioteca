package co.edu.uniquindio.poo;

import java.util.ArrayList;
import java.util.List;

class Bibliotecario extends Empleado implements IGestionInventario {
    
    public List<ItemBiblioteca> inventario = new ArrayList<>(); // Lista para almacenar los ítems del inventario
    // Constructor para inicializar el bibliotecario con nombre y ID de empleado
    public Bibliotecario(String nombre, int idEmpleado) {
        super(nombre, idEmpleado);
    }

     // Implementación del método para gestionar ítems en el inventario
    @Override
    public void gestionarItem() {
        System.out.println("Sus ítems se están agregando al inventario.");
    }
    @Override
    public void agregarItem(ItemBiblioteca item) {
        inventario.add(item);
        System.out.println("Ítem agregado al inventario: " + item.getTitulo());
    }

    // función para remover un ítem del inventario
    @Override
    public void removerItem(ItemBiblioteca item) {
        inventario.remove(item);
        System.out.println("Ítem removido del inventario: " + item.getTitulo());
    }

    // función para mostrar todos los ítems del inventario
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


