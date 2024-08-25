package co.edu.uniquindio.poo;

import java.time.LocalDate;

class Bibliotecario extends Empleado implements IGestionInventario {
    
    public Bibliotecario(String nombre,int idEmpleado){
        super(nombre, idEmpleado);

    }
    public void gestionarPrestamos(Libro libro,Miembro miembro){
        if (libro.isDisponible()) {
            Prestamo prestamo = new Prestamo(libro, miembro, LocalDate.now(), LocalDate.now().plusWeeks(2));
            miembro.agregarPrestamos(prestamo);
            libro.setDisponible(false);
            System.out.println("prestamos realizado"+libro.getTitulo()+"a"+ getNombre());


            
        } else {
            System.out.println("su prestamo no fue realizado ");
            
        }
        
    }
    @Override
    public void gestionarItem(){
        System.out.println("sus items se estan agregando al invenario");
    }






    
}
