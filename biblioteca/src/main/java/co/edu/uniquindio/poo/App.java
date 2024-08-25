package co.edu.uniquindio.poo;

public class App {
    public static void main(String[] args) {
        
        Libro libro1 = new Libro("la divina comedia", "dante", 4589);
        Libro libro2 = new Libro("boulevard", "flor m salvador", 89021);

        Miembro miembro1 =new Miembro("nicol marin", 1234567);
        Miembro miembro2 =new Miembro("majo tovar", 2345890);

        Bibliotecario bibliotecario= new Bibliotecario("fernando perez", 18902345);

        bibliotecario.gestionarPrestamos(libro1,miembro1);
        bibliotecario.gestionarPrestamos(libro2, miembro2);
        


    }
}