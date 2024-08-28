package co.edu.uniquindio.poo;
import java.util.ArrayList;
import java.util.List;
public class Bibliotecario extends Empleado implements IGestionInventario {
    public List<ItemBiblioteca> inventario = new ArrayList<>(); // Lista para almacenar los ítems del inventario
    // Constructor para inicializar el bibliotecario con nombre y ID de empleado
    public Bibliotecario(String nombre, int idEmpleado) {
        super(nombre, idEmpleado);
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