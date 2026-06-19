import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Gremio miGremio = new Gremio(); // Creamos el control del gremio
        int opcion = 0;

        do {
            System.out.println("\n=============================");
            System.out.println("   RPG GUILD MANAGER v1.0    ");
            System.out.println("=============================");
            System.out.println("1. Registrar Aventurero");
            System.out.println("2. Ver Miembros del Gremio");
            System.out.println("3. Calcular Fuerza Total");
            System.out.println("4. Ver Aventureros Derrotados");
            System.out.println("5. Salir");
            System.out.print("Elija una opción: ");

            // Control de errores para el menú
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("¡Aviso! Debe ingresar un número entero para el menú.");
                opcion = 0; // Resetea para que continúe el ciclo
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese nombre del héroe: ");
                    String nombre = scanner.nextLine();
                    // Validación de lógica: nombre vacío
                    if (nombre.trim().isEmpty()) {
                        System.out.println("Error: El nombre no puede estar en blanco.");
                        break;
                    }

                    System.out.print("Ingrese clase (Guerrero, Mago, Pícaro): ");
                    String clase = scanner.nextLine();
                    if (clase.trim().isEmpty()) {
                        System.out.println("Error: La clase no puede estar en blanco.");
                        break;
                    }

                    int nivel = 0;
                    int hp = 0;

                    // Control de errores para números
                    try {
                        System.out.print("Ingrese nivel (Mayor a 0): ");
                        nivel = Integer.parseInt(scanner.nextLine());
                        System.out.print("Ingrese HP (Puntos de Vida): ");
                        hp = Integer.parseInt(scanner.nextLine());

                        // Validación de lógica: Rangos de números imposibles
                        if (nivel <= 0 || hp < 0) {
                            System.out.println("Error: El nivel debe ser mínimo 1 y la HP no puede ser negativa.");
                            break; 
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("¡Aviso! El nivel y la HP deben ser números enteros. Registro cancelado.");
                        break; // Sale del caso sin guardar nada defectuoso
                    }

                    // Si pasó los filtros, creamos el aventurero y lo metemos al gremio
                    Aventurero nuevoHeroe = new Aventurero(nombre, clase, nivel, hp);
                    miGremio.registrarAventurero(nuevoHeroe);
                    System.out.println("¡" + nombre + " se ha unido al gremio con éxito!");
                    break;

                case 2:
                    miGremio.mostrarGremio();
                    break;

                case 3:
                    int fuerza = miGremio.calcularFuerzaTotal();
                    System.out.println("La fuerza total combinada del gremio es: " + fuerza);
                    break;

                case 4:
                    int muertos = miGremio.contarDerrotados();
                    System.out.println("Cantidad de aventureros actualmente derrotados (HP=0): " + muertos);
                    break;

                case 5:
                    System.out.println("Cerrando el sistema del Gremio... ¡Suerte en la taberna!");
                    break;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }

        } while (opcion != 5);

        scanner.close();
    }
}