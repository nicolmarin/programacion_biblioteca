package co.edu.uniquindio.poo.model;

abstract class  ItemBiblioteca {
    private String titulo;
    public ItemBiblioteca(String titulo) {
        this.titulo = titulo;
    }
    public String getTitulo() {
        return titulo; 
    }
    public abstract void mostrarDetalles();
    public abstract void mostrarItem();
    public abstract void mostrarArchivo();


}


