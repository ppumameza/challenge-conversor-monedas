package excepciones;

public class ConversionExcepcion extends RuntimeException {
    public ConversionExcepcion(String mensaje) {
        super(mensaje);
    }

    public ConversionExcepcion(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
