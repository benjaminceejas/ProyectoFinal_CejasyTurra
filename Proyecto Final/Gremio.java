import java.util.ArrayList;

public class Gremio {
    // Atributo: La lista que guardará a los aventureros
    private ArrayList<Aventurero> listaAventureros;

    // Constructor: Crea la lista vacía al principio
    public Gremio() {
        this.listaAventureros = new ArrayList<>();
    }

    // Método para agregar un aventurero a la lista
    public void registrarAventurero(Aventurero aventurero) {
        listaAventureros.add(aventurero);
    }

    // Método para mostrar todos los aventureros en pantalla
    public void mostrarGremio() {
        if (listaAventureros.isEmpty()) {
            System.out.println("El gremio no tiene miembros todavía.");
            return;
        }
        System.out.println("\n--- MIEMBROS DEL GREMIO ---");
        for (Aventurero a : listaAventureros) {
            System.out.println("Nombre: " + a.getNombre() + 
                               " | Clase: " + a.getClase() + 
                               " | Nivel: " + a.getNivel() + 
                               " | HP: " + a.getHp());
        }
    }

    // --- LÓGICA AVANZADA (Métodos con return) ---

    // Método 1: Calcula la fuerza total sumando los niveles
    public int calcularFuerzaTotal() {
        int totalFuerza = 0;
        for (Aventurero a : listaAventureros) {
            totalFuerza += a.getNivel();
        }
        return totalFuerza; // Devuelve el cálculo entero
    }

    // Método 2: Cuenta cuántos aventureros tienen HP igual a 0
    public int contarDerrotados() {
        int contador = 0;
        for (Aventurero a : listaAventureros) {
            if (a.getHp() == 0) {
                contador++;
            }
        }
        return contador; // Devuelve el total de caídos
    }
}