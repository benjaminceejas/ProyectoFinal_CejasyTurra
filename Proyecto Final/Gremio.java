import java.util.ArrayList;

public class Gremio {

    private final ArrayList<Aventurero> listaAventureros;

    public Gremio() {
        this.listaAventureros = new ArrayList<>();
    }

    public boolean registrarAventurero(Aventurero aventurero) {
        if (buscarPorNombre(aventurero.getNombre()) != null) {
            return false;
        }
        listaAventureros.add(aventurero);
        return true;
    }

    public Aventurero buscarPorNombre(String nombre) {
        for (Aventurero a : listaAventureros) {
            if (a.getNombre().equalsIgnoreCase(nombre)) {
                return a;
            }
        }
        return null;
    }

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

    public int calcularFuerzaTotal() {
        int totalFuerza = 0;

        for (Aventurero a : listaAventureros) {
            totalFuerza += a.getNivel();
        }

        return totalFuerza;
    }

    public int contarDerrotados() {
        int contador = 0;

        for (Aventurero a : listaAventureros) {
            if (a.estaDerrotado()) {
                contador++;
            }
        }

        return contador;
    }

    public double calcularNivelPromedio() {
        if (listaAventureros.isEmpty()) {
            return 0.0;
        }

        return (double) calcularFuerzaTotal() / listaAventureros.size();
    }
}
