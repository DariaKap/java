package Lesson8;

public class MatrixMain {

    public static void main(String[] args) {
        Matrix matrixA = new Matrix();
        System.out.println("Матрица A");
        matrixA.fillRandom();
        matrixA.printMatrix();

        Matrix matrixB = new Matrix();
        System.out.println("----------------------");
        System.out.println("Матрица B");
        matrixB.fillRandom();
        matrixB.printMatrix();

        System.out.println("----------------------");
        System.out.println("A + B");
        Matrix matrixC = matrixA.sumMatrix(matrixB);
        matrixC.printMatrix();

        System.out.println("----------------------");
        System.out.println("A + B");
        matrixC = matrixA.diffMatrix(matrixB);
        matrixC.printMatrix();

        System.out.println("----------------------");
        System.out.println("Транспонирование матрицы A");
        matrixC = matrixA.invertMatrix();
        matrixC.printMatrix();

        System.out.println("----------------------");
        System.out.println("Единичная матрица");
        matrixC.fillUnitMatrix();
        matrixC.printMatrix();

        System.out.println("----------------------");
        System.out.println("A * 2 ");
        matrixC = matrixA.multyMatrixOnValue(2);
        matrixC.printMatrix();

        System.out.println("----------------------");
        System.out.println("A * B ");
        matrixC = matrixA.multyOnMatrix(matrixB);
        matrixC.printMatrix();

        System.out.println("----------------------");
        System.out.println("A^2 ");
        matrixC = matrixA.exponentMatrix(2);
        matrixC.printMatrix();

        System.out.println("----------------------");
        System.out.println("Определитель матрицы А = " + matrixA.getDeterm());

        System.out.println("----------------------");
        matrixC = new Matrix(3,3);
        matrixC.fillRandom();
        matrixC.printMatrix();
        System.out.println("Определитель матрицы C = " + matrixC.getDeterm());

        System.out.println("----------------------");
        Matrix matrixD = matrixC.getInverseMatrix();
        System.out.println("Обратная матрица С");
        matrixD.printMatrix();
        System.out.println("-------------------------");
        System.out.println("Проверяем обратную матрицу(произведение матрицы на обратную матрицу = единичной матрице)");
        matrixC.multyOnMatrix(matrixD).printMatrix();
    }
}
