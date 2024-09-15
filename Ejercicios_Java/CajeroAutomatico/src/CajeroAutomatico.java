import java.util.HashMap;
import java.util.Scanner;

public class CajeroAutomatico {
    private static HashMap<String, HashMap<String, Double>> cuentas = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Cajero Automático ---");
            System.out.println("1. Registrar una cuenta");
            System.out.println("2. Menú");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    registrarCuenta(scanner);
                    break;
                case 2:
                    iniciarSesion(scanner);
                    break;
                case 3:
                    System.out.println("Gracias por usar el cajero automático.");
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static void registrarCuenta(Scanner scanner) {
        System.out.print("Ingrese el número de cuenta: ");
        String numeroCuenta = scanner.nextLine();

        if (cuentas.containsKey(numeroCuenta)) {
            System.out.println("La cuenta ya está registrada.");
            return;
        }

        System.out.print("Ingrese el PIN: ");
        double pin = scanner.nextDouble();
        System.out.print("Ingrese el saldo inicial: ");
        double saldoInicial = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer

        // Crear una nueva cuenta
        HashMap<String, Double> nuevaCuenta = new HashMap<>();
        nuevaCuenta.put("pin", pin);
        nuevaCuenta.put("saldo", saldoInicial);
        cuentas.put(numeroCuenta, nuevaCuenta);

        System.out.println("Cuenta registrada exitosamente.");
    }

    private static void iniciarSesion(Scanner scanner) {
        System.out.print("Ingrese su número de cuenta: ");
        String numeroCuenta = scanner.nextLine();

        if (!cuentas.containsKey(numeroCuenta)) {
            System.out.println("La cuenta no está registrada.");
            return;
        }

        System.out.print("Ingrese su PIN: ");
        double pinIngresado = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer

        if (!cuentas.get(numeroCuenta).get("pin").equals(pinIngresado)) {
            System.out.println("PIN incorrecto.");
            return;
        }

        // Menú de operaciones
        while (true) {
            System.out.println("\n--- Operaciones de la Cuenta ---");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Retirar dinero");
            System.out.println("3. Depositar dinero");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    consultarSaldo(numeroCuenta);
                    break;
                case 2:
                    retirarDinero(numeroCuenta, scanner);
                    break;
                case 3:
                    depositarDinero(numeroCuenta, scanner);
                    break;
                case 4:
                    System.out.println("Saliendo de la cuenta.");
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static void consultarSaldo(String numeroCuenta) {
        double saldo = cuentas.get(numeroCuenta).get("saldo");
        System.out.println("Su saldo actual es: $" + saldo);
    }

    private static void retirarDinero(String numeroCuenta, Scanner scanner) {
        System.out.print("Ingrese la cantidad a retirar: ");
        double cantidad = scanner.nextDouble();

        double saldo = cuentas.get(numeroCuenta).get("saldo");
        if (cantidad > saldo) {
            System.out.println("Fondos insuficientes.");
        } else {
            saldo -= cantidad;
            cuentas.get(numeroCuenta).put("saldo", saldo);
            System.out.println("Retiro exitoso. Su nuevo saldo es: $" + saldo);
        }
    }

    private static void depositarDinero(String numeroCuenta, Scanner scanner) {
        System.out.print("Ingrese la cantidad a depositar: ");
        double cantidad = scanner.nextDouble();

        double saldo = cuentas.get(numeroCuenta).get("saldo");
        saldo += cantidad;
        cuentas.get(numeroCuenta).put("saldo", saldo);
        System.out.println("Depósito exitoso. Su nuevo saldo es: $" + saldo);
    }
}
