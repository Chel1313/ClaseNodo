import java.util.Scanner;

public class CineReserva {
    private static String[] peliculas = {"1. Rompiendo el circulo", "2. Intensamente", "3. Resurreción mostruosa"};
    private static boolean[][] asientos = new boolean[5][5]; // Asientos de 5 filas y 5 columnas
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Sistema de Reserva de Tickets de Cine ---");
            System.out.println("1. Ver películas disponibles");
            System.out.println("2. Reservar asiento");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    mostrarPeliculas();
                    break;
                case 2:
                    reservarAsiento();
                    break;
                case 3:
                    System.out.println("¡Gracias por usar el sistema de reserva de tickets!");
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static void mostrarPeliculas() {
        System.out.println("\n--- Películas Disponibles ---");
        for (String pelicula : peliculas) {
            System.out.println(pelicula);
        }
    }

    private static void reservarAsiento() {
        System.out.println("\n--- Reservar Asiento ---");
        mostrarPeliculas();
        System.out.print("Seleccione la película (1-3): ");
        int peliculaSeleccionada = scanner.nextInt();

        if (peliculaSeleccionada < 1 || peliculaSeleccionada > peliculas.length) {
            System.out.println("Película no válida. Intente de nuevo.");
            return;
        }

        mostrarAsientos();
        System.out.print("Seleccione una fila (1-5): ");
        int fila = scanner.nextInt();
        System.out.print("Seleccione una columna (1-5): ");
        int columna = scanner.nextInt();

        if (fila < 1 || fila > 5 || columna < 1 || columna > 5) {
            System.out.println("Asiento no válido. Intente de nuevo.");
            return;
        }

        if (asientos[fila - 1][columna - 1]) {
            System.out.println("El asiento ya está reservado. Intente con otro.");
        } else {
            asientos[fila - 1][columna - 1] = true;
            System.out.println("Asiento reservado exitosamente. ¡Disfrute la película!");
        }
    }

    private static void mostrarAsientos() {
        System.out.println("\n--- Asientos ---");
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                if (asientos[i][j]) {
                    System.out.print("[X] ");
                } else {
                    System.out.print("[ ] ");
                }
            }
            System.out.println();
        }
    }
}
