public class Aventurero {
    // Atributos privados (Requisito de Encapsulamiento)
    private String nombre;
    private String clase;
    private int nivel;
    private int hp;
    private int hpMaximo; // Guardamos el HP máximo para calcular curaciones/daño con tope

    // Constructor: Para inicializar el aventurero con sus datos
    public Aventurero(String nombre, String clase, int nivel, int hp) {
        this.nombre = nombre;
        this.clase = clase;
        this.nivel = nivel;
        this.hp = hp;
        this.hpMaximo = hp;
    }

    // --- GETTERS Y SETTERS ---
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getClase() { return clase; }
    public void setClase(String clase) { this.clase = clase; }

    public int getNivel() { return nivel; }

    // Setter con validación de lógica: no se permiten niveles imposibles (Requisito 3)
    public void setNivel(int nivel) {
        if (nivel > 0) {
            this.nivel = nivel;
        }
    }

    public int getHp() { return hp; }

    // Setter con validación de lógica: la HP nunca puede ser negativa
    public void setHp(int hp) {
        if (hp < 0) {
            this.hp = 0;
        } else if (hp > hpMaximo) {
            this.hp = hpMaximo;
        } else {
            this.hp = hp;
        }
    }

    public int getHpMaximo() { return hpMaximo; }

    // --- LÓGICA AVANZADA (Métodos con return) ---

    // Sube de nivel al aventurero y aumenta su HP máximo y actual proporcionalmente.
    // Devuelve el nuevo nivel para que Main pueda informarlo.
    public int subirNivel() {
        this.nivel++;
        int aumentoHp = 10; // Cada nivel otorga 10 puntos de HP máximo extra
        this.hpMaximo += aumentoHp;
        this.hp = this.hpMaximo; // Al subir de nivel, se cura por completo
        return this.nivel;
    }

    // Aplica daño al aventurero, sin permitir que la HP baje de 0.
    // Devuelve el HP restante después del golpe.
    public int recibirDanio(int cantidad) {
        if (cantidad < 0) {
            cantidad = 0; // Un "daño negativo" no tiene sentido; se ignora
        }
        this.hp -= cantidad;
        if (this.hp < 0) {
            this.hp = 0;
        }
        return this.hp;
    }

    // Indica si el aventurero está derrotado (HP = 0)
    public boolean estaDerrotado() {
        return this.hp == 0;
    }
}
