import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Conversion {
    private final String monedaBase;
    private final String monedaDestino;
    private final double montoOriginal;
    private final double montoConvertido;
    private final double tasa;
    private final LocalDateTime fechaHora;

    public Conversion(String monedaBase, String monedaDestino, double montoOriginal, double montoConvertido, double tasa) {
        this.monedaBase = monedaBase;
        this.monedaDestino = monedaDestino;
        this.montoOriginal = montoOriginal;
        this.montoConvertido = montoConvertido;
        this.tasa = tasa;
        this.fechaHora = LocalDateTime.now();
    }

    @Override
    public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return String.format("[%s] %.2f %s → %.2f %s (tasa: %.4f)",
                fechaHora.format(formato), montoOriginal, monedaBase, montoConvertido, monedaDestino, tasa);
    }
}
