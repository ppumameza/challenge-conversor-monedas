public class Moneda {
    //Clase que representa las monedas
    private String codigo;
    private String nombre;

    public Moneda(String codigo, String nombre){
        this.codigo = codigo;
        this.nombre = nombre;
    }
    /*Getters*/
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }
    //Definimos como se mostrará la moneda en la ejecución
    @Override
    public String toString(){
        return nombre + "(" + codigo + ")";
    }
}
