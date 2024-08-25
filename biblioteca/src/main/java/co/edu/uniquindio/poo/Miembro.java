package co.edu.uniquindio.poo;

import java.util.ArrayList;
import java.util.List;

public class Miembro {
    private String nombre;
    private int idMiembro;
    private List<Prestamo> prestamosActivos; // El nombre estaba en singular

    public Miembro(String nombre, int idMiembro) {
        this.nombre = nombre;
        this.idMiembro = idMiembro;
        this.prestamosActivos = new ArrayList<>();
    }

    public void mostrarPrestamosActivos() {
        if (prestamosActivos.isEmpty()) {
            System.out.println("No hay préstamos activos para el miembro " + nombre);
        } else {
            System.out.println("Préstamos activos para el miembro " + nombre + ":");
            for (Prestamo prestamo : prestamosActivos) {
                System.out.println("Libro: " + prestamo.getLibro().getTitulo() + ", Fecha de Préstamo: " + prestamo.getFechaPrestamo());
            }
        }
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdMiembro() {
        return idMiembro;
    }

    public void setIdMiembro(int idMiembro) {
        this.idMiembro = idMiembro;
    }

    public List<Prestamo> getPrestamosActivos() {
        return prestamosActivos;
    }

    public void setPrestamosActivos(List<Prestamo> prestamosActivos) {
        this.prestamosActivos = prestamosActivos;
    }

    public void agregarPrestamo(Prestamo prestamo) {
        prestamosActivos.add(prestamo);
    }

    public void eliminarPrestamo(Prestamo prestamo) {
        prestamosActivos.remove(prestamo);
    }


}
