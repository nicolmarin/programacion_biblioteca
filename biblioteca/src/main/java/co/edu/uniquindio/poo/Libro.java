package co.edu.uniquindio.poo;

public class Libro {
    private String titulo;
    private String autor;
    private int isbn;
    private String estado;

    public Libro(String titulo,String autor,int isbn,String estado){
        this.titulo=titulo;
        this.autor=autor;
        this.isbn=isbn;
        this.estado="disponible";


    }
    public void prestar() {
        if ("disponible".equals(estado)) {
            estado = "prestado";
            System.out.println("El libro \"" + titulo + "\" ha sido prestado.");
        } else {
            System.out.println("El libro \"" + titulo + "\" ya está prestado.");
        }
    }

    public void devolver() {
        if ("prestado".equals(estado)) {
            estado = "disponible";
            System.out.println("El libro \"" + titulo + "\" ha sido devuelto.");
        } else {
            System.out.println("El libro \"" + titulo + "\" ya está disponible.");
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
