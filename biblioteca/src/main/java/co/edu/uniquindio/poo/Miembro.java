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

    
    
}
