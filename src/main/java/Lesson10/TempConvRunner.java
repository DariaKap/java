package Lesson10;

import Lesson10.enums.TempUnit;
import Lesson10.interf.Convert;

public class TempConvRunner {
    public static void main(String[] args) {
        Convert convert = new ClassConverter();
        convert.TempConvert(15, TempUnit.CELCIUS, TempUnit.FAHRENHEIT);
        convert.TempConvert(15, TempUnit.FAHRENHEIT, TempUnit.CELCIUS);
        convert.TempConvert(15, TempUnit.FAHRENHEIT, TempUnit.KELVIN);
        convert.TempConvert(15, TempUnit.KELVIN, TempUnit.FAHRENHEIT);
        convert.TempConvert(15, TempUnit.KELVIN, TempUnit.CELCIUS);
        convert.TempConvert(15, TempUnit.CELCIUS, TempUnit.KELVIN);
    }
}
