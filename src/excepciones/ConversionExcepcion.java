package excepciones;
//Lanza errores específicos cuando ocurre erro en la conversión (Conversor/ConversorAPI)
public class ConversionExcepcion extends Exception{
    public ConversionExcepcion(String mensaje){
        super(mensaje);
    }
}
