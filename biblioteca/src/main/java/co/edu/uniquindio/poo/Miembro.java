package co.edu.uniquindio.poo;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Miembro {
    private String nombre;
    private int idMiembro;
    private List<Prestamo> prestamosActivos;
    public Miembro(String nombre, int idMiembro) {
        this.nombre = nombre;
        this.idMiembro = idMiembro;
        this.prestamosActivos = new ArrayList<>();
    }
    public void agregarPrestamos(Prestamo prestamo) {
        if (!prestamosActivos.contains(prestamo)) {
            prestamosActivos.add(prestamo);
        } else {
            System.out.println("El préstamo ya existe para este miembro.");
        }
    }
    public static void agregarMiembro(Scanner scanner, List<Miembro> listaMiembros) {
        System.out.println("\n--- Agregar Miembro ---");
        System.out.print("Ingrese el nombre del miembro: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el ID del miembro: ");
        int idMiembro = scanner.nextInt();
        scanner.nextLine();
        if (idMiembro < 0 || nombre.isEmpty()) {
            System.out.println("ID inválido o nombre vacío. Intente de nuevo.");
            return;
        }
        Miembro miembro = new Miembro(nombre, idMiembro);
        listaMiembros.add(miembro);
        System.out.println("Miembro agregado exitosamente: " + miembro.getNombre());
    }
    public static Miembro buscarMiembroPorId(int idMiembro, List<Miembro> listaMiembros) {
        for (Miembro miembro : listaMiembros) {
            if (miembro.getIdMiembro() == idMiembro) {
                return miembro;
            }
        }
        return null;
    }
    @Override
    public String toString() {
        return "Miembro [Nombre=" + nombre + ", ID=" + idMiembro + "]";
    }
    public String getNombre() {
        return nombre;
    }
    public int getIdMiembro() {
        return idMiembro;
    }
    public List<Prestamo> getPrestamosActivos() {
        return prestamosActivos;
    }
}
