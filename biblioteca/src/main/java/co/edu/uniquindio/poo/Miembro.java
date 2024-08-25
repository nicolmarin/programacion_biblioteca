package co.edu.uniquindio.poo;
import java.util.ArrayList;
import java.util.List;

public class Miembro {
    private String nombre;
    private int idMiembro;
    private List<Prestamo>prestamoActivos;
    
    
    public Miembro(String nombre, int idMiembro) {
        this.nombre = nombre;
        this.idMiembro = idMiembro;
        this.prestamosActivos=new ArrayList<>();
    }
    public void agregarPrestamos(Prestamo prestamo){
        prestamoActivos.add(prestamo);

    }
    public void removerPrestamo(Prestamo prestamo){
        prestamoActivos.remove(prestamo);
    }

    public List<Prestamo> getPrestamosActivos(){
        return prestamoActivos;

    }

    public String getNombre() {
        return nombre;
    }


    public int getIdMiembro() {
        return idMiembro;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void setIdMiembro(int idMiembro) {
        this.idMiembro = idMiembro;
    }


    


    public void setPrestamoActivos(List<Prestamo> prestamoActivos) {
        this.prestamoActivos = prestamoActivos;
    }

    

    
    
}
