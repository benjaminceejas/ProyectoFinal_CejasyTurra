import java.util.ArrayList;

public class Gremio {
    // Atributo: La lista que guardará a los aventureros
    private final ArrayList<Aventurero> listaAventureros;

    // Constructor: Crea la lista vacía al principio
    public Gremio() {
        this.listaAventureros = new ArrayList<>();
    }

    // Método para agregar un aventurero a la lista.
    // Devuelve true si se pudo registrar, false si el nombre ya existe (evita duplicados).
    public boolean registrarAventurero(Aventurero aventurero) {
        if (buscarPorNombre(aventurero.getNombre()) != null) {
            return false;
        }
        listaAventureros.add(aventurero);
        return true;
    }

    // Busca un aventurero por nombre (sin distinguir mayúsculas/minúsculas).
    // Devuelve el objeto si lo encuentra, o null si no existe en el gremio.
    public Aventurero buscarPorNombre(String nombre) {
        for (Aventurero a : listaAventureros) {
            if (a.getNombre().equalsIgnoreCase(nombre)) {
                return a;
            }
        }
        return null;
    }

    // Método para mostrar todos los aventureros en pantalla
    public void mostrarGremio() {
        if (listaAventureros.isEmpty()) {
            System.out.println("El gremio no tiene miembros todavía.");
            return;
        }
        System.out.println("\n--- MIEMBROS DEL GREMIO ---");
        for (Aventurero a : listaAventureros) {
            String estado = a.estaDerrotado() ? " [DERROTADO]" : "";
            System.out.println("Nombre: " + a.getNombre() +
                               " | Clase: " + a.getClase() +
                               " | Nivel: " + a.getNivel() +
                               " | HP: " + a.getHp() + "/" + a.getHpMaximo() +
                               estado);
        }
    }

    public boolean estaVacio() {
        return listaAventureros.isEmpty();
    }

    public int cantidadMiembros() {
        return listaAventureros.size();
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
            if (a.estaDerrotado()) {
                contador++;
            }
        }
        return contador; // Devuelve el total de caídos
    }

    // Método 3: Calcula el promedio de nivel del gremio (double para mayor precisión)
    public double calcularNivelPromedio() {
        if (listaAventureros.isEmpty()) {
            return 0.0;
        }
        return (double) calcularFuerzaTotal() / listaAventureros.size();
    }
}
