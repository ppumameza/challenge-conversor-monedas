import java.util.Scanner;

public class Principal {
    //Clae principal, punto de entrada del programa
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Conversor conversor = new Conversor(scanner);
        conversor.iniciar();

    }
}
