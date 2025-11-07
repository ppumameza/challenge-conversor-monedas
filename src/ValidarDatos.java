import java.util.Scanner;

public class ValidarDatos {

    public static int leerEntero(Scanner scanner, String mensaje, int min, int max) {
        int valor;
        while (true) {
            System.out.print(mensaje);
            try {
                valor = Integer.parseInt(scanner.nextLine());
                if (valor < min || valor > max) {
                    System.out.println("⚠️ Ingrese un número entre " + min + " y " + max);
                } else {
                    return valor;
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Por favor, ingrese un número válido.");
            }
        }
    }

    public static double leerDoble(Scanner scanner, String mensaje) {
        double valor;
        while (true) {
            System.out.print(mensaje);
            try {
                valor = Double.parseDouble(scanner.nextLine());
                if (valor <= 0) {
                    System.out.println("⚠️ El monto debe ser mayor que cero.");
                } else {
                    return valor;
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Ingrese un número válido.");
            }
        }
    }

    public static String leerMoneda(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String codigo = scanner.nextLine().trim().toUpperCase();
            if (codigo.matches("^[A-Z]{3}$")) {
                return codigo;
            } else {
                System.out.println("⚠️ Ingrese un código de moneda válido (3 letras, ej. USD, EUR, PEN).");
            }
        }
    }
}
