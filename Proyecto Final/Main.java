import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Gremio miGremio = new Gremio(); // Creamos el control del gremio
            int opcion = 0;
            
            do {
                System.out.println("\n=============================");
                System.out.println("   RPG GUILD MANAGER v2.0    ");
                System.out.println("=============================");
                System.out.println("1. Registrar Aventurero");
                System.out.println("2. Ver Miembros del Gremio");
                System.out.println("3. Calcular Fuerza Total");
                System.out.println("4. Ver Aventureros Derrotados");
                System.out.println("5. Subir de Nivel a un Aventurero");
                System.out.println("6. Aplicar Daño a un Aventurero");
                System.out.println("7. Ver Nivel Promedio del Gremio");
                System.out.println("8. Salir");
                System.out.print("Elija una opción: ");
                
                // Control de errores para el menú
                try {
                    opcion = Integer.parseInt(scanner.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("¡Aviso! Debe ingresar un número entero para el menú.");
                    opcion = 0; // Resetea para que continúe el ciclo
                    continue;
                }
                
                switch (opcion) {
                    case 1 -> registrarAventurero(scanner, miGremio);
                    
                    case 2 -> miGremio.mostrarGremio();
                    
                    case 3 -> {
                        int fuerza = miGremio.calcularFuerzaTotal();
                        System.out.println("La fuerza total combinada del gremio es: " + fuerza);
                    }
                    
                    case 4 -> {
                        int muertos = miGremio.contarDerrotados();
                        System.out.println("Cantidad de aventureros actualmente derrotados (HP=0): " + muertos);
                    }
                    
                    case 5 -> subirNivelAventurero(scanner, miGremio);
                    
                    case 6 -> aplicarDanioAventurero(scanner, miGremio);
                    
                    case 7 -> System.out.printf("El nivel promedio del gremio es: %.2f%n", miGremio.calcularNivelPromedio());
                    
                    case 8 -> System.out.println("Cerrando el sistema del Gremio... ¡Suerte en la taberna!");
                    
                    default -> System.out.println("Opción inválida. Intente de nuevo.");
                }
                
            } while (opcion != 8);
        } // Creamos el control del gremio
    }

    // --- Registrar un nuevo aventurero, con todas sus validaciones ---
    private static void registrarAventurero(Scanner scanner, Gremio miGremio) {
        System.out.print("Ingrese nombre del héroe: ");
        String nombre = scanner.nextLine();
        // Validación de lógica: nombre vacío
        if (nombre.trim().isEmpty()) {
            System.out.println("Error: El nombre no puede estar en blanco.");
            return;
        }

        if (miGremio.buscarPorNombre(nombre.trim()) != null) {
            System.out.println("Error: Ya existe un aventurero con ese nombre en el gremio.");
            return;
        }

        System.out.print("Ingrese clase (Guerrero, Mago, Pícaro): ");
        String clase = scanner.nextLine();
        if (clase.trim().isEmpty()) {
            System.out.println("Error: La clase no puede estar en blanco.");
            return;
        }

        int nivel;
        int hp;

        // Control de errores para números
        try {
            System.out.print("Ingrese nivel (Mayor a 0): ");
            nivel = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Ingrese HP (Puntos de Vida): ");
            hp = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("¡Aviso! El nivel y la HP deben ser números enteros. Registro cancelado.");
            return;
        }

        // Validación de lógica: Rangos de números imposibles
        if (nivel <= 0 || hp < 0) {
            System.out.println("Error: El nivel debe ser mínimo 1 y la HP no puede ser negativa.");
            return;
        }

        Aventurero nuevoHeroe = new Aventurero(nombre.trim(), clase.trim(), nivel, hp);
        miGremio.registrarAventurero(nuevoHeroe);
        System.out.println("¡" + nombre.trim() + " se ha unido al gremio con éxito!");
    }

    // --- Subir de nivel a un aventurero existente, buscándolo por nombre ---
    private static void subirNivelAventurero(Scanner scanner, Gremio miGremio) {
        if (miGremio.estaVacio()) {
            System.out.println("El gremio no tiene miembros todavía.");
            return;
        }
        System.out.print("Ingrese el nombre del aventurero a subir de nivel: ");
        String nombre = scanner.nextLine().trim();

        Aventurero a = miGremio.buscarPorNombre(nombre);
        if (a == null) {
            System.out.println("Error: No se encontró ningún aventurero con ese nombre.");
            return;
        }

        int nuevoNivel = a.subirNivel();
        System.out.println(a.getNombre() + " ha subido a nivel " + nuevoNivel +
                            " y recuperó toda su HP (" + a.getHp() + "/" + a.getHpMaximo() + ").");
    }

    // --- Aplicar daño a un aventurero, demostrando otro método con return ---
    private static void aplicarDanioAventurero(Scanner scanner, Gremio miGremio) {
        if (miGremio.estaVacio()) {
            System.out.println("El gremio no tiene miembros todavía.");
            return;
        }
        System.out.print("Ingrese el nombre del aventurero que recibirá daño: ");
        String nombre = scanner.nextLine().trim();

        Aventurero a = miGremio.buscarPorNombre(nombre);
        if (a == null) {
            System.out.println("Error: No se encontró ningún aventurero con ese nombre.");
            return;
        }

        int danio;
        try {
            System.out.print("Ingrese la cantidad de daño a aplicar: ");
            danio = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("¡Aviso! El daño debe ser un número entero. Acción cancelada.");
            return;
        }

        if (danio < 0) {
            System.out.println("Error: El daño no puede ser un número negativo.");
            return;
        }

        int hpRestante = a.recibirDanio(danio);
        if (hpRestante == 0) {
            System.out.println(a.getNombre() + " ha sido derrotado.");
        } else {
            System.out.println(a.getNombre() + " ahora tiene " + hpRestante + " HP.");
        }
    }
}
