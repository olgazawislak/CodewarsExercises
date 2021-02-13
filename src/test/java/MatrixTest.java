import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MatrixTest {

    @Test
    public void matrixMultiplicationTest() {
        Matrix matrix = new Matrix();

        int[][] a = {
                {1, 2},
                {3, 2}};

        int[][] b = {
                {3, 2},
                {1, 1}};

        int[][] expected = {
                {5, 4},
                {11, 8}};

        int[][] actual = matrix.matrixMultiplication(a, b);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void calculateOneCellTest() {
        Matrix matrix = new Matrix();

        int[][] a = {
                {2, 3},
                {4, 1},
                {1, 0}};

        int[][] b = {
                {3, 2, 4},
                {1, 1, 0}};

        int cellAfterMultiplication = matrix.calculateOneCell(1,0,a,b);

        assertThat(cellAfterMultiplication).isEqualTo(13);
    }
}
