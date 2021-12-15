package Lesson12.exceptions;

public class MyArraySizeException extends RuntimeException {

    public MyArraySizeException() {
        super("Неверный размер массива.");
    }

    public MyArraySizeException(int i) {
        super("Неверный размер массива. Массив должен быть " + i);
    }

    public MyArraySizeException(int i, int j) {
        super("Неверный размер массива. Массив должен быть " + i + "x" + j);
    }

    public MyArraySizeException(int i, int j, int k) {
        super("Неверный размер массива. Массив должен быть " + i + "x" + j + "x" + k);
    }

}
