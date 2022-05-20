import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class EjemploParse {
    public static void main(String args[]) throws URISyntaxException, IOException, InterruptedException {

        // creamos la petición
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://api.openweathermap.org/data/2.5/weather?q=vigo&appid=214d3edca1f88b6812bfef609598d5aa"))
                .GET()
                .build();

        // creamos el cliente
        HttpClient client = HttpClient.newHttpClient();

        // Enviamos la petición y obtenemos la respuesta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


        // Mostramos el cuerpo de la respuesta
        switch(response.statusCode()){

            case 200->{
                // Almacenamos el cuerpo de la respuesta
                System.out.println(response.body());
            }

            case 404->{
                System.out.println("Error 404: Whoops! Página web no encontrada.");
            }

            case 403->{
                System.out.println("Error 403: No estas autorizado para ver esto.");
            }
            case 500->{
                System.out.println("Error 500: Error del servidor.");
            }
            case 410->{
                System.out.println("Error 410: Servidor caído.");
            }


            default->{




            }

        }

        /*String cadenaJSON = "";
        JSONObject obj = new JSONObject(cadenaJSON);
        String vivo = obj.getJSONObject("pageInfo").getString("pageName");
        JSONArray arr = obj.getJSONArray("posts");
        for (int i = 0; i < arr.length(); i++) {
            String post_id = arr.getJSONObject(i).getString("post_id");
            System.out.println(post_id);
        }
        System.out.println(vivo);*/
    }
}