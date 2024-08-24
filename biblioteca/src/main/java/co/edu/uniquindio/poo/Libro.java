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
        this.estado=estado;


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
