import java.util.Scanner;

public class Conversor {
    private final Scanner scanner;
    private final Historial historial = new Historial();

    public Conversor(Scanner scanner) {
        this.scanner = scanner;
    }

    public void iniciar() {
        System.out.println("=========================================");
        System.out.println("   CONVERSOR DE MONEDAS - EN TIEMPO REAL ");
        System.out.println("=========================================");

        while (true) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Realizar nueva conversión");
            System.out.println("2. Ver historial de esta sesión");
            System.out.println("3. Ver todo el historial de conversiones");
            System.out.println("4. Salir");
            int opcion = ValidarDatos.leerEntero(scanner, "Ingrese una opción: ", 1, 4);

            switch (opcion) {
                case 1 -> realizarConversion();
                case 2 -> historial.mostrar();
                case 3 -> HistorialArchivo.mostrarHistorialArchivo();
                case 4 -> {
                    System.out.println("👋 Gracias por usar el conversor.");
                    return;
                }
            }
        }
    }

    private void realizarConversion() {
        String base = ValidarDatos.leerMoneda(scanner, "Ingrese el código de la moneda base (ej. USD, PEN, EUR): ");
        double monto = ValidarDatos.leerDoble(scanner, "Ingrese el monto a convertir: ");
        String destino = ValidarDatos.leerMoneda(scanner, "Ingrese el código de la moneda destino (ej. JPY, GBP, CLP): ");

        System.out.println("\n🔄 Obteniendo tasas desde la API...\n");

        try {
            double tasa = ConversorAPI.obtenerTasaCambio(base, destino);
            double convertido = monto * tasa;

            System.out.printf("💱 Resultado:\n%.2f %s = %.2f %s%n", monto, base.toUpperCase(), convertido, destino.toUpperCase());
            System.out.printf("(Tasa de cambio: %.4f)%n", tasa);

            // Guardar en historial (memoria y archivo)
            historial.agregar(new Conversion(base.toUpperCase(), destino.toUpperCase(), monto, convertido, tasa));

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}
