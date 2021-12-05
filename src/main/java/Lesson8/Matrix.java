package Lesson8;

import com.sun.source.tree.NewArrayTree;

import java.util.Arrays;

public class Matrix {
    private final int m;
    private final int n;
    private double[][] matrix;

    public Matrix() {
        this.m = 2;
        this.n = 2;
        this.matrix = new double[this.m][this.n];
    }

    public Matrix(int m, int n) {
        if (m > 0 && n > 0) {
            this.m = m;
            this.n = n;
        } else {
            this.m = 2;
            this.n = 2;
        }
        this.matrix = new double[this.m][this.n];
    }

    /**
     * Возвращает кол-во строк в матрцие
     *
     * @return m
     */
    public int lenRowsMatrix() {
        return m;
    }

    /**
     * Возвращает кол-во столбцов в матрице
     *
     * @return n
     */
    public int lenColumnsMatrix() {
        return n;
    }

    /**
     * Присваивание значение элементу матрицы по координатам
     *
     * @param row    - строка
     * @param column - столбец
     * @param value  - присваиваемое значение
     */
    public void setValue(int row, int column, double value) {
        if (row < this.lenRowsMatrix() || column < this.lenColumnsMatrix()) {
            this.matrix[row][column] = value;
        } else {
            System.out.println("Матрица меньше размерности чем полученный адрес элемента для заполнения");
        }
    }

    /**
     * Получение элемента массива по координатам
     *
     * @param row    - строка
     * @param column - столбец
     * @return значение
     */
    public double getValue(int row, int column) {
        if (row < this.lenRowsMatrix() || column < this.lenColumnsMatrix()) {
            return this.matrix[row][column];
        } else {
            return 0;
        }
    }

    /**
     * Заполнение матрицы рандомными значениями от -10 до 10
     */
    public void fillRandom() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                this.setValue(i, j, (int) (Math.random() * 11 - 5));
            }
        }
    }

    /**
     * Печать матрицы
     */
    public void printMatrix() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%2.2f ", this.getValue(i, j));
            }
            System.out.println();
        }

    }

    /**
     * Сложение матриц
     *
     * @param matrix - слогаемая матрица
     * @return Matrix
     */
    public Matrix sumMatrix(Matrix matrix) {
        Matrix tmpMatrix = new Matrix();
        if (this.lenColumnsMatrix() == matrix.lenColumnsMatrix() &&
                this.lenRowsMatrix() == matrix.lenRowsMatrix()) {
            tmpMatrix = new Matrix(m, n);
            for (int i = 0; i < this.m; i++) {
                for (int j = 0; j < this.n; j++) {
                    tmpMatrix.setValue(i, j, this.getValue(i, j) + matrix.getValue(i, j));
                }
            }
        }
        return tmpMatrix;
    }

    /**
     * Разность матриц
     *
     * @param matrix - вычитаемая матрица
     * @return матрица
     */
    public Matrix diffMatrix(Matrix matrix) {
        Matrix tmpMatrix = new Matrix();
        if (this.lenColumnsMatrix() == matrix.lenColumnsMatrix() &&
                this.lenRowsMatrix() == matrix.lenRowsMatrix()) {
            tmpMatrix = new Matrix(this.m, this.n);
            for (int i = 0; i < this.m; i++) {
                for (int j = 0; j < this.n; j++) {
                    tmpMatrix.setValue(i, j, this.getValue(i, j) - matrix.getValue(i, j));
                }
            }
        }
        return tmpMatrix;
    }

    /**
     * Ивертирование матрцы
     *
     * @return Matrix
     */
    public Matrix invertMatrix() {
        Matrix tmpMatrix = new Matrix(this.lenColumnsMatrix(), this.lenRowsMatrix());
        for (int i = 0; i < tmpMatrix.lenRowsMatrix(); i++) {
            for (int j = 0; j < tmpMatrix.lenColumnsMatrix(); j++) {
                tmpMatrix.setValue(i, j, this.getValue(j, i));
            }
        }
        return tmpMatrix;
    }

    /**
     * Инвертирование матрицы (статическая реализация)
     *
     * @param matrix - инвертируемая матрица
     * @return Matrix
     */
    public static Matrix invertMatrix(Matrix matrix) {
        Matrix tmpMatrix = new Matrix(matrix.lenColumnsMatrix(), matrix.lenRowsMatrix());
        for (int i = 0; i < tmpMatrix.lenRowsMatrix(); i++) {
            for (int j = 0; j < tmpMatrix.lenColumnsMatrix(); j++) {
                tmpMatrix.setValue(i, j, matrix.getValue(j, i));
            }
        }
        return tmpMatrix;
    }

    /**
     * Умножение матрицы на число
     *
     * @param value - число, на которое умножаем матрицу
     * @return Matrix
     */
    public Matrix multyMatrixOnValue(int value) {
        Matrix tmpMatrix = new Matrix(this.m, this.n);
        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                tmpMatrix.setValue(i, j, this.getValue(i, j) * value);
            }
        }
        return tmpMatrix;
    }

    /**
     * Умножение матрицы на число(статическая реализация)
     *
     * @param matrix - умножаемая матрица
     * @param value  - число, на которое умножаем
     * @return Matrix
     */
    public static Matrix multyMatrixOnValue(Matrix matrix, int value) {
        int m = matrix.lenRowsMatrix();
        int n = matrix.lenColumnsMatrix();
        Matrix tmpMatrix = new Matrix(m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                tmpMatrix.setValue(i, j, matrix.getValue(i, j) * value);
            }
        }
        return tmpMatrix;
    }

    /**
     * Произведение матрицы
     *
     * @param matrix - матрица, на которую умножаем
     * @return Matrix, в случае ошибки возрвщается матрица 2х2 со значениями -9999
     */
    public Matrix multyOnMatrix(Matrix matrix) {
        int m = matrix.lenRowsMatrix();
        int n = matrix.lenColumnsMatrix();
        if (this.lenColumnsMatrix() == n) {
            Matrix tmpMatrix = new Matrix(this.lenRowsMatrix(), n);
            for (int i = 0; i < tmpMatrix.lenRowsMatrix(); i++) {
                for (int j = 0; j < tmpMatrix.lenColumnsMatrix(); j++) {
                    for (int k = 0; k < this.lenColumnsMatrix(); k++) {
                        tmpMatrix.setValue(i, j, tmpMatrix.getValue(i, j) + this.getValue(i, k) * matrix.getValue(k, j));
                    }
                }
            }
            return tmpMatrix;
        }
        return errMatrix();
    }

    /**
     * Получение единичной матрицы
     */
    public void fillUnitMatrix() {
        if (this.lenRowsMatrix() == this.lenColumnsMatrix()) {
            for (int i = 0; i < this.lenRowsMatrix(); i++) {
                for (int j = 0; j < this.lenColumnsMatrix(); j++) {
                    setValue(i, j, i == j ? 1 : 0);
                }
            }
        }
    }

    /**
     * Получение единичной матрицы
     *
     * @param size - размерность матрицы
     * @return Matrix, в случае ошибки возрвщается матрица 2х2 со значениями -9999
     */
    public static Matrix getUnitMatrix(int size) {
        if (size > 0) {
            Matrix tmpMatrix = new Matrix(size, size);
            for (int i = 0; i < size; i++) {
                tmpMatrix.setValue(i, i, 1);
            }
            return tmpMatrix;
        }
        return Matrix.errMatrix();
    }

    /**
     * Возведение матрицы в степень
     *
     * @param pow - степень возведения
     * @return Matrix - результат возведенеия
     */
    public Matrix exponentMatrix(int pow) {
        Matrix tmpMatrix = this;
        for (int i = 1; i < pow; i++) {
            tmpMatrix = tmpMatrix.multyOnMatrix(this);
        }
        return tmpMatrix;
    }

    /**
     * Получение определителя матрицы 2 на 2
     *
     * @return double определитель
     */
    private double getBaseDeterminant() {
        double determinant = 0;
        if (this.lenRowsMatrix() == 2) {
            determinant = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }
        return determinant;
    }

    /**
     * Получение определетиеля квадратной матрицы(рекурсией)
     *
     * @return определитель матрицы, если не квадратная возвращает 0
     */
    public double getDeterm() {
        double determinant = 0;
        if (this.lenRowsMatrix() == this.lenColumnsMatrix()) {
            int len = this.lenRowsMatrix();
            if (len >= 3) {
                /*
                 * раскрываем определитель всегда по первому столбцу
                 * считаем до тех пор, пока минор(оставшаяся часть матрицы) не будет 2х2
                 */
                double[] coefs = new double[len];
                Matrix[] tmp = new Matrix[len];
                for (int i = 0; i < len; i++) {
                    coefs[i] = getValue(i, 0) * (int) Math.pow(-1, i + 2);
                    tmp[i] = this.getMinorMatrix(i, 0);
                }
                for (int i = 0; i < len; i++) {
                    determinant += coefs[i] * tmp[i].getDeterm();
                }
            } else {
                determinant = this.getBaseDeterminant();
            }
        }
        return determinant;
    }

    /**
     * Получение минора таблицы 2на2
     *
     * @return матрица минор
     */
    private Matrix getMinorMatrix() {
        int len = this.lenRowsMatrix();
        Matrix tmpMatrix = new Matrix(len, len);
        tmpMatrix.setValue(0, 0, this.getValue(1, 1));
        tmpMatrix.setValue(0, 1, this.getValue(1, 0));
        tmpMatrix.setValue(1, 1, this.getValue(0, 0));
        tmpMatrix.setValue(1, 0, this.getValue(0, 1));
        return tmpMatrix;
    }

    /**
     * Получение минора таблицы, исключив строку и столбец
     *
     * @param row исключаемая строка
     * @param col исключаемый столбец
     * @return матрица минор
     */
    private Matrix getMinorMatrix(int row, int col) {
        int len = this.lenRowsMatrix();
        Matrix tmpMatrix;
        tmpMatrix = new Matrix(len - 1, len - 1);
        int cntC = 0;
        for (int j = 0; j < len; j++) { // идем по столбцам матрицы
            if (j != col) {
                int cntR = 0;               // итерации по заполнению доп матрицы
                for (int i = 0; i < len; i++) { // элементы столбца
                    if (i != row) {
                        tmpMatrix.setValue(cntR, cntC, getValue(i, j));
                        cntR++;
                    }
                }
                cntC++;
            }
        }
        return tmpMatrix;
    }

    /**
     * Обратная матрица
     *
     * @return матрица, в случае ошибки возрвщается матрица 2х2 со значениями -9999
     */
    public Matrix getInverseMatrix() {
        if (this.lenRowsMatrix() == this.lenColumnsMatrix()) {
            int len = this.lenRowsMatrix();
            double determ = getDeterm();
            if (determ == 0) {
                return null;
            }
            if (len == 2) {
                Matrix minorMatrix = this.getMinorMatrix();
            } else {
                Matrix Matrix = new Matrix(len, len);
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        Matrix.setValue(j, i, getMinorMatrix(i, j).getDeterm() * Math.pow(-1, i + j + 2) / determ);
                    }
                }
                return Matrix;
            }
        }
        return errMatrix();
    }

    /**
     * В случае необратнного события, возращать матрицу 2на2 со значения -9999
     *
     * @return матрица
     */
    static Matrix errMatrix() {
        Matrix tmpMat = new Matrix();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                tmpMat.setValue(i, j, -9999);
            }
        }
        return tmpMat;
    }
}
