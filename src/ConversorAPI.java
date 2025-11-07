import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorAPI {
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/74f877e5da1ce7ff6d3f4bd0/latest/";

    public static double obtenerTasaCambio(String base, String destino) {
        try {
            URI direccion = URI.create(BASE_URL + base);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(direccion)
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();
            RespuestaAPI datos = gson.fromJson(response.body(), RespuestaAPI.class);

            if (datos.getConversion_rates().containsKey(destino)) {
                return datos.getConversion_rates().get(destino);
            } else {
                throw new RuntimeException("No se encontró la tasa para " + destino);
            }

        } catch (Exception e) {
            throw new RuntimeException("Error al obtener tasas: " + e.getMessage());
        }
    }
}

