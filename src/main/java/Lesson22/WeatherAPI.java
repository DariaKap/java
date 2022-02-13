package Lesson22;

import lombok.SneakyThrows;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.apache.http.client.utils.URIBuilder;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;


public class WeatherAPI {

    private final String stringURI = "https://api.openweathermap.org/data/2.5/weather?";
    private final String unitsParam = "metric";


    @SneakyThrows
    public JSONObject getAPI(String apiKey, String cityName){
        URI uri = new URI(this.stringURI);
        // добавим в ссылку параметры
        uri = new URIBuilder(uri.toString()).addParameter("q", cityName).build();
        uri = new URIBuilder(uri.toString()).addParameter("appid", apiKey).build();
        uri = new URIBuilder(uri.toString()).addParameter("units", unitsParam).build();

        URL url = uri.toURL();
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.connect();
        InputStream inputStream;
        // если город не найден, API возвращает 404 ошибку, поэтому обработаем, чтобы не упасть
        if (urlConnection.getResponseCode() != HttpURLConnection.HTTP_OK){
            inputStream = urlConnection.getErrorStream();
        } else {
            inputStream = urlConnection.getInputStream();
        }
        JSONTokener tokener = new JSONTokener(inputStream);
        JSONObject result = new JSONObject(tokener);
        return result;
    }
}
