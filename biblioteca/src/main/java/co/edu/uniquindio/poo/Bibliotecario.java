package co.edu.uniquindio.poo;

class Bibliotecario extends Empleado implements IGestionInventario {
    
    // Constructor para inicializar el bibliotecario con nombre y ID de empleado
    public Bibliotecario(String nombre, int idEmpleado) {
        super(nombre, idEmpleado);
    }

     // Implementación del método para gestionar ítems en el inventario
    @Override
    public void gestionarItem() {
        System.out.println("Sus ítems se están agregando al inventario.");
    }
}


