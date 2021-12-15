package Lesson12;

import Lesson12.exceptions.MyArrayDataException;
import Lesson12.exceptions.MyArraySizeException;

import java.util.Arrays;

public class ArrayRunner {
    public static void main(String[] args) {
        String[][] tmpMatrix = new String[][]{
                {"4", "5", "1", "4"},
                {"2", "5", "8", "2"},
                {"7", "n", "5"}};

        printMatrix(tmpMatrix);
        // посчитаем по матрице, которая точно упадет с ошибкой
        try {
            System.out.print("Сумма элементов матрицы: ");
            System.out.println(sumOfMatrix4(tmpMatrix));
        } catch (RuntimeException e){
            System.out.println("Error: " + e);
        }

        // добавили строку
        tmpMatrix = Arrays.copyOf(tmpMatrix, 4);
        tmpMatrix[3] = new String[]{"4", "4", "0", "5"};
        printMatrix(tmpMatrix);
        try {
            System.out.print("Сумма элементов матрицы: ");
            System.out.println(sumOfMatrix4(tmpMatrix));
        } catch (RuntimeException e){
            System.out.println("Error: " + e);
        }

        // правим матрицу, чтобы стала 4 на 4
        tmpMatrix[2] = Arrays.copyOf(tmpMatrix[2], 4);
        tmpMatrix[2][3] = "3";
        printMatrix(tmpMatrix);
        try {
            System.out.print("Сумма элементов матрицы: ");
            System.out.println(sumOfMatrix4(tmpMatrix));
        } catch (RuntimeException e){
            System.out.println("Error: " + e);
        }

        // заменим буквенный элемент
        tmpMatrix[2][1] = "2";
        printMatrix(tmpMatrix);
        try {
            System.out.print("Сумма элементов матрицы: ");
            System.out.println(sumOfMatrix4(tmpMatrix));
        } catch (RuntimeException e){
            System.out.println("Error: " + e);
        }
    }

    public static long sumOfMatrix4(String[][] matrix) {
        final int LENGTH = 4;
        long sumOfElements = 0;
        if (matrix.length != LENGTH) {
            throw new MyArraySizeException(LENGTH, LENGTH);
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length != LENGTH) {
                throw new MyArraySizeException(LENGTH, LENGTH);
            }
            for (int j = 0; j < matrix[i].length; j++) {
                try {
                    sumOfElements += Integer.parseInt(matrix[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sumOfElements;
    }

    public static void printMatrix(String[][] matrix) {
        System.out.println("Матрица");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%s\t",matrix[i][j]);
            }
            System.out.println();
        }
    }
}
