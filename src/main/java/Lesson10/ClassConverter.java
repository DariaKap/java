package Lesson10;

import Lesson10.enums.TempUnit;
import Lesson10.interf.Convert;

public class ClassConverter implements Convert {

    public void TempConvert(int value, TempUnit fromUnit, TempUnit toUnit) {
        if (fromUnit == TempUnit.CELCIUS && toUnit == TempUnit.FAHRENHEIT) {
            System.out.println(value + " °C = " + (value * 1.8 + 32) + " °F");
        } else if (fromUnit == TempUnit.FAHRENHEIT && toUnit == TempUnit.CELCIUS) {
            System.out.println(value + " °F = " + (double) ((value - 32) / 1.8) + " °C");
        } else if (fromUnit == TempUnit.KELVIN && toUnit == TempUnit.FAHRENHEIT) {
            System.out.println(value + " K = " +  (1.8 * (value - 273.15) + 32) + " °F");
        } else if (fromUnit == TempUnit.FAHRENHEIT && toUnit == TempUnit.KELVIN) {
            System.out.println(value + " °F = " + ((value - 32) / 1.8 + 273.15) + " K");
        } else if (fromUnit == TempUnit.KELVIN && toUnit == TempUnit.CELCIUS) {
            System.out.println(value + " K = " + (value - 273.15) + "°C");
        } else if (fromUnit == TempUnit.CELCIUS && toUnit == TempUnit.KELVIN) {
            System.out.println(value + " °C = " + (value + 273.15) + " K");
        } else {
            System.out.println("Перевод невозможен");
        }
    }
}
