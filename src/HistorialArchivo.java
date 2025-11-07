import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class HistorialArchivo {

    private static final String ARCHIVO = "historial.txt";

    // Guardar una conversión en el archivo
    public static void guardar(Conversion conversion) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO, true))) {
            writer.write(conversion.toString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("⚠️ No se pudo guardar en el archivo de historial: " + e.getMessage());
        }
    }

    // Mostrar el contenido del archivo (historial persistente)
    public static void mostrarHistorialArchivo() {
        Path path = Path.of(ARCHIVO);

        if (!Files.exists(path)) {
            System.out.println("📭 No hay historial guardado en archivo aún.");
            return;
        }

        try {
            List<String> lineas = Files.readAllLines(path);
            if (lineas.isEmpty()) {
                System.out.println("📭 El archivo de historial está vacío.");
            } else {
                System.out.println("\n📂 HISTORIAL GUARDADO EN ARCHIVO:");
                System.out.println("----------------------------------------");
                for (String linea : lineas) {
                    System.out.println(linea);
                }
                System.out.println("----------------------------------------");
            }
        } catch (IOException e) {
            System.out.println("⚠️ Error al leer el archivo de historial: " + e.getMessage());
        }
    }
}
