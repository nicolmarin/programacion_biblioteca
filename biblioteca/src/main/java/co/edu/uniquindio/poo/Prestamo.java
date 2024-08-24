package co.edu.uniquindio.poo;
import

public class Prestamo {
    private libro Libro;
    private miembro Miembro;
    private Date fechaPrestamo;
    private Date fechaDevolucion;

    public Prestamo(libro libro, miembro miembro, Date fechaPrestamo, Date fechaDevolucion) {
        Libro = libro;
        Miembro = miembro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }
}

    public libro getLibro() {
        return Libro;
    }

    public void setLibro(libro libro) {
        Libro = libro;
    }

    public miembro getMiembro() {
        return Miembro;
    }

    public void setMiembro(miembro miembro) {
        Miembro = miembro;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }






