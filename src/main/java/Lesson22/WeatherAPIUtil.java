package Lesson22;

import com.ibm.icu.text.Transliterator;
import lombok.SneakyThrows;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class WeatherAPIUtil {

    public static final String CYRILLIC_TO_LATIN = "Cyrillic-Latin";

    /*
    * Вызов API получение погоды по имени города
    * @param cityName название города на любом языке
    * @return строка с информацией о погоде
    */
    @SneakyThrows
    public static String getWeatherByCityName(String cityName){
        Transliterator toLatinTrans = Transliterator.getInstance(CYRILLIC_TO_LATIN);
        String transliterateName = toLatinTrans.transliterate(cityName);
        transliterateName = transliterateName.replaceAll("[^a-zA-Z]", "");
        String result;
        Path path = Path.of("src", "main", "resources", "data.properties");
        Properties properties = new Properties();
        properties.load(Files.newInputStream(path));
        String weatherKey = properties.getProperty("weatherKey");
        if (weatherKey != null) {
            WeatherAPI w = new WeatherAPI();
            JSONObject resultJSON = w.getAPI(weatherKey, transliterateName);
            if (resultJSON.getInt("cod") != 200){
                result = "Ошибка при отправке запросе. Error: " + resultJSON.getString("message");
            } else {
                JSONObject main = resultJSON.getJSONObject("main");
                double temp = main.getDouble("temp");
                double feelTemp = main.getDouble("feels_like");
                result = "Город " + resultJSON.getString("name") + " Температура: " + temp + ", ощущается на " + feelTemp;
            }
        }
        else {
            result = "Не определен ключ, для отправки запроса";
        }
        return result;
    }
}
