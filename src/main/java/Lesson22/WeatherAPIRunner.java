package Lesson22;

import lombok.SneakyThrows;
import java.util.Scanner;

public class WeatherAPIRunner {
    @SneakyThrows
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String cityName = "";
        String textForInput = "Введите название города, для получения температуры, для выхода введите слово exit";
        while (!cityName.equals("exit")){
            System.out.println(textForInput);
            cityName = in.nextLine();
            System.out.println(WeatherAPIUtil.getWeatherByCityName(cityName));
        }
    }
}
