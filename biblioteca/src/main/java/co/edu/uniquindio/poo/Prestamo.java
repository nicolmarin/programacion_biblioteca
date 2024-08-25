package co.edu.uniquindio.poo;

import java.time.LocalDateTime;

public class Prestamo {
    private Libro libro;
    private Miembro miembro;
    private LocalDateTime fechaPrestamo;
    private LocalDateTime fechaDevolucion;

    public Prestamo(Libro libro, Miembro miembro, LocalDateTime fechaPrestamo, LocalDateTime fechaDevolucion) {
        libro = libro;
        miembro = miembro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.libro.prestar();
        this.miembro.agregarPrestamos(this);
    }
    public void devolverLibro(){
        this.libro.devolver();
        this.miembro.removerPrestamo(this);
    }


    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        libro = Libro;
    }

    public Miembro getMiembro() {
        return miembro;
    }

    public void setMiembro(Miembro miembro) {
        miembro = miembro;
    }

    public LocalDateTime getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDateTime fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDateTime getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDateTime fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
}







