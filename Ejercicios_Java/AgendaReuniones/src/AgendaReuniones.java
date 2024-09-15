import java.util.ArrayList;
import java.util.Scanner;

class Reunion {
    String titulo;
    String hora;
    ArrayList<String> participantes;

    public Reunion(String titulo, String hora) {
        this.titulo = titulo;
        this.hora = hora;
        this.participantes = new ArrayList<>();
    }

    public void agregarParticipante(String participante) {
        participantes.add(participante);
    }

    @Override
    public String toString() {
        return "Título: " + titulo + ", Hora: " + hora + ", Participantes: " + participantes;
    }
}

public class AgendaReuniones {
    private static ArrayList<Reunion> reuniones = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("--- Simulador de Agenda de Reuniones ---");

        while (true) {
            System.out.println("\n1. Crear reunión");
            System.out.println("2. Editar reunión");
            System.out.println("3. Eliminar reunión");
            System.out.println("4. Mostrar reuniones");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    crearReunion();
                    break;
                case 2:
                    editarReunion();
                    break;
                case 3:
                    eliminarReunion();
                    break;
                case 4:
                    mostrarReuniones();
                    break;
                case 5:
                    System.out.println("Saliendo de la agenda de reuniones.");
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static void crearReunion() {
        System.out.print("Ingrese el título de la reunión: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese la hora de la reunión: ");
        String hora = scanner.nextLine();

        Reunion reunion = new Reunion(titulo, hora);
        System.out.print("¿Desea agregar participantes? (s/n): ");
        String respuesta = scanner.nextLine();
        while (respuesta.equalsIgnoreCase("s")) {
            System.out.print("Ingrese el nombre del participante: ");
            String participante = scanner.nextLine();
            reunion.agregarParticipante(participante);
            System.out.print("¿Desea agregar otro participante? (s/n): ");
            respuesta = scanner.nextLine();
        }

        reuniones.add(reunion);
        System.out.println("Reunión creada exitosamente.");
    }

    private static void editarReunion() {
        mostrarReuniones();
        System.out.print("Ingrese el número de la reunión a editar: ");
        int indice = scanner.nextInt() - 1;
        scanner.nextLine(); // Limpiar el buffer
        if (indice >= 0 && indice < reuniones.size()) {
            Reunion reunion = reuniones.get(indice);
            System.out.print("Ingrese el nuevo título de la reunión: ");
            reunion.titulo = scanner.nextLine();
            System.out.print("Ingrese la nueva hora de la reunión: ");
            reunion.hora = scanner.nextLine();
            System.out.println("Reunión editada exitosamente.");
        } else {
            System.out.println("Reunión no encontrada.");
        }
    }

    private static void eliminarReunion() {
        mostrarReuniones();
        System.out.print("Ingrese el número de la reunión a eliminar: ");
        int indice = scanner.nextInt() - 1;
        if (indice >= 0 && indice < reuniones.size()) {
            reuniones.remove(indice);
            System.out.println("Reunión eliminada exitosamente.");
        } else {
            System.out.println("Reunión no encontrada.");
        }
    }

    private static void mostrarReuniones() {
        System.out.println("\n--- Lista de Reuniones ---");
        for (int i = 0; i < reuniones.size(); i++) {
            System.out.println((i + 1) + ". " + reuniones.get(i).toString());
        }
    }
}
