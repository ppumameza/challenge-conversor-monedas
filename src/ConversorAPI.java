import com.google.gson.Gson;
import com.google.gson.JsonObject;
import excepciones.ConversionExcepcion;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
//Conexión con la API, interpretar las respuestas JSON y manejo de posibles errores
public class ConversorAPI {
    //Clase encargada de conectar a la API para optener tasas de cambio
    private static final String API_URL = "https://open.er-api.com/v6/latest/";
    private static final Gson gson = new Gson();

    public static double optenerTasaCambio(String from, String to) throws ConversionExcepcion{
        String url = API_URL + from;

        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200){
                throw new ConversionExcepcion("Error al optener datos de la API: " + response.statusCode());
            }
            JsonObject json = gson.fromJson(response.body(), JsonObject.class);
            JsonObject rates = json.getAsJsonObject("rates");
            if (!rates.has(to)) throw new ConversionExcepcion("No se encontró la moneda de destino: " + to);
            return rates.get(to).getAsDouble();
        }catch (IOException | InterruptedException e){
            throw new ConversionExcepcion("No se pudo conectar con la API. Verifique su conexión.");
        }

    }
}
