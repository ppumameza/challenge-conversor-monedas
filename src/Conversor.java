import java.util.List;
import java.util.Scanner;

public class Conversor {
    //Clase que controla el flujo del programa
    private final Scanner scanner;
    private final List<Moneda> monedas;

    public Conversor(Scanner scanner){
        this.scanner = scanner;
        this.monedas = List.of(
                new Moneda("USD", "Dólar estadounidense"),
                new Moneda("EUR", "Euro"),
                new Moneda("PEN", "Sol peruano"),
                new Moneda("GBP", "Libra esterlina"),
                new Moneda("JPY", "Yen japonés")
        );
    }
    public void iniciar(){
        System.out.println("---CONVERSOR DE MONEDAS---");
        ejecutarConversor();
    }

    private void ejecutarConversor(){
        mostrarMonedas();
        int opcionBase = ValidarDatos.leerEntero(scanner, "Seleccione su moneda base: ", 1, monedas.size());
        Moneda base = monedas.get(opcionBase - 1);

        double monto = ValidarDatos.leerDoble(scanner, "ingrese el monto que desea convertir");

        System.out.println("\nSeleccione la moneda destino");
        mostrarMonedas();
        int opcionDestino = ValidarDatos.leerEntero(scanner, "seleccione su moneda destino: ",1, monedas.size());
        Moneda destino = monedas.get(opcionDestino - 1);

        try {
            double tasa = ConversorAPI.optenerTasaCambio(base.getCodigo(), destino.getCodigo());
            double convertido = monto * tasa;
            System.out.printf("💱 %.2f %s = %.2f %s%n", monto, base.getCodigo(), convertido, destino.getCodigo());
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
        System.out.println("\n¿Desea realizar otra conversión? (s/n): ");
        String respuesta = scanner.next().trim().toLowerCase();
        if (respuesta.equals("s")){
            ejecutarConversor();
        }else {
            System.out.println("👋 Gracias por usar el conversor.");
        }
    }
    private void mostrarMonedas(){
        for (int i = 0; i <monedas.size(); i++){
            System.out.println((i + 1) + "." + monedas.get(i));
        }
    }
}
