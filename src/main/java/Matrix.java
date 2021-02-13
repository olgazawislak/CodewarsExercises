import java.util.stream.IntStream;

public class Matrix {

    public int[][] matrixMultiplication(int[][] a, int[][] b) {
        int rows = a.length;
        int cols = b[0].length;
        int[][] matrixProduct = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrixProduct[i][j] = calculateOneCell(i, j, a, b);
            }
        }
        return matrixProduct;
    }

    public int calculateOneCell(int row, int col, int[][] a, int[][] b) {
        return IntStream.range(0, a[0].length)
                .map(i -> a[row][i] * b[i][col])
                .reduce(0, Integer::sum);
    }
}
