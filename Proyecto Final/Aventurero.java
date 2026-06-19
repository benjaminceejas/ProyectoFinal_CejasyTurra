public class Aventurero {
    // Atributos privados (Requisito de Encapsulamiento)
    private String nombre;
    private String clase;
    private int nivel;
    private int hp;

    // Constructor: Para inicializar el aventurero con sus datos
    public Aventurero(String nombre, String clase, int nivel, int hp) {
        this.nombre = nombre;
        this.clase = clase;
        this.nivel = nivel;
        this.hp = hp;
    }

    // --- GETTERS Y SETTERS ---
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getClase() { return clase; }
    public void setClase(String clase) { this.clase = clase; }

    public int getNivel() { return nivel; }
    public void setNivel(int nivel) { this.nivel = nivel; }

    public int getHp() { return hp; }
    public void setHp(int hp) { this.hp = hp; }
}