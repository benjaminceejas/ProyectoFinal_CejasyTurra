public class Aventurero {

    private String nombre;
    private String clase;
    private int nivel;
    private int hp;
    private int hpMaximo;

    public Aventurero(String nombre, String clase, int nivel, int hp) {
        this.nombre = nombre;
        this.clase = clase;
        this.nivel = nivel;
        this.hp = hp;
        this.hpMaximo = hp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        if (nivel > 0) {
            this.nivel = nivel;
        }
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        if (hp < 0) {
            this.hp = 0;
        } else if (hp > hpMaximo) {
            this.hp = hpMaximo;
        } else {
            this.hp = hp;
        }
    }

    public int getHpMaximo() {
        return hpMaximo;
    }

    public int subirNivel() {
        this.nivel++;
        int aumentoHp = 10;
        this.hpMaximo += aumentoHp;
        this.hp = this.hpMaximo;
        return this.nivel;
    }

    public int recibirDanio(int cantidad) {
        if (cantidad < 0) {
            cantidad = 0;
        }
        this.hp -= cantidad;
        if (this.hp < 0) {
            this.hp = 0;
        }
        return this.hp;
    }

    public boolean estaDerrotado() {
        return this.hp == 0;
    }
}
