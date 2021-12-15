package Lesson12.exceptions;

public class MyArrayDataException extends RuntimeException {
    public MyArrayDataException(int i) {
        super("Неверное значение в ячейке [" + i + "]");
    }

    public MyArrayDataException(int i, int j) {
        super("Неверное значение в ячейке [" + i + ", " + j + "]");
    }

    public MyArrayDataException(int i, int j, int k) {
        super("Неверное значение в ячейке [" + i + ", " + j + ", " + k + "]");
    }
}
