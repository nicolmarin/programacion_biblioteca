package co.edu.uniquindio.poo;

public class Libro extends ItemBiblioteca {
    private String autor;
    private int isbn;
    private boolean disponible;

    public Libro(String titulo,String autor,int isbn){
        super(titulo);
        
        this.autor=autor;
        this.isbn=isbn;
        this.disponible=true;


    }
    @Override
    public void mostrarDetalles() {
        System.out.println("Libro: " + getTitulo() + ", Autor: " + autor + ", ISBN: " + isbn);
    }
    public void setDisponible(boolean disponible){
        this.disponible=disponible;

    }
    public boolean isDisponible() {
        
        return disponible;
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

    
    
}
