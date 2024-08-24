package co.edu.uniquindio.poo;
import java.util.ArrayList;
import java.util.List;

public class Miembro {
    private String nombre;
    private int idMiembro;
    private List<PrestamoActivos>prestamoActivos;
    
    
    public Miembro(String nombre, int idMiembro) {
        this.nombre = nombre;
        this.idMiembro = idMiembro;
        this.prestamosActivos=new ArrayList<>();
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

    

    
    
}
