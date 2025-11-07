import java.util.ArrayList;
import java.util.List;

public class Historial {
    private final List<Conversion> conversiones = new ArrayList<>();

    public void agregar(Conversion conversion) {
        conversiones.add(conversion);
        HistorialArchivo.guardar(conversion); // 🔥 Guardamos también en archivo
    }

    public void mostrar() {
        if (conversiones.isEmpty()) {
            System.out.println("📭 No hay conversiones registradas aún (solo en memoria).");
            return;
        }
        System.out.println("\n📜 HISTORIAL DE CONVERSIONES (MEMORIA):");
        System.out.println("----------------------------------------");
        for (Conversion c : conversiones) {
            System.out.println(c);
        }
        System.out.println("----------------------------------------");
    }
}
