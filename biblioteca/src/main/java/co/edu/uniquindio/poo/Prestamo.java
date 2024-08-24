package co.edu.uniquindio.poo;

import java.time.LocalDateTime;

public class Prestamo {
    private libro Libro;
    private miembro Miembro;
    private LocalDateTime fechaPrestamo;
    private LocalDateTime fechaDevolucion;

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







