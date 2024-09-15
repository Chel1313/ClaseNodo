import java.util.Scanner;
import java.util.HashMap;

public class SeguimientoHabitos {
    private static HashMap<String, Integer> habitos = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("--- Seguimiento de Hábitos Diarios ---");

        while (true) {
            System.out.println("\n1. Añadir hábito");
            System.out.println("2. Registrar progreso de hábito");
            System.out.println("3. Mostrar resumen de hábitos");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    añadirHabito();
                    break;
                case 2:
                    registrarProgreso();
                    break;
                case 3:
                    mostrarResumen();
                    break;
                case 4:
                    System.out.println("Saliendo del seguimiento de hábitos.");
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static void añadirHabito() {
        System.out.print("Ingrese el nombre del hábito: ");
        String habito = scanner.nextLine();
        habitos.put(habito, 0);
        System.out.println("Hábito añadido exitosamente.");
    }

    private static void registrarProgreso() {
        System.out.print("Ingrese el nombre del hábito: ");
        String habito = scanner.nextLine();
        if (habitos.containsKey(habito)) {
            habitos.put(habito, habitos.get(habito) + 1);
            System.out.println("Progreso registrado.");
        } else {
            System.out.println("Hábito no encontrado.");
        }
    }

    private static void mostrarResumen() {
        System.out.println("\n--- Resumen de Hábitos ---");
        for (String habito : habitos.keySet()) {
            System.out.println(habito + ": " + habitos.get(habito) + " veces");
        }
    }
}
