import java.util.InputMismatchException;
import java.util.Scanner;
//Manejo de posibles errores
public class ValidarDatos {
    public static int leerEntero(Scanner scanner, String mensaje, int min, int max){
        while (true){
            try {
                System.out.println(mensaje);
                int opcion = scanner.nextInt();
                if (opcion < min || opcion > max){
                    System.out.println("⚠ Opción fuera del rango. Intente nuevamente");
                }else {
                    return opcion;
                }
            }catch (InputMismatchException e){
                System.out.println("⚠ Dato inválida. Debe ingresar un número entero");
                scanner.nextLine();
            }
        }
    }

    public static double leerDoble (Scanner scanner, String mensaje){
        while (true){
            try {
                System.out.println(mensaje);
                return scanner.nextDouble();
            }catch (InputMismatchException e){
                System.out.println("⚠ Dato inválido. Debe ingresar un número válido (Ejem: 10.5)");
                scanner.nextLine();
            }
        }
    }
}
