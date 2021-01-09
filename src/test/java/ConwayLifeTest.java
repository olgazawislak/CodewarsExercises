import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ConwayLifeTest {

    private ConwayLife conwayLife = new ConwayLife();

    @Test
    void createMapFrom2dArrayTest() {
        int[][] cells = {{1, 0, 0}, {0, 0, 1}, {0, 0, 0}};
        Point firstPoint = new Point(0, 0);
        Point secondPoint = new Point(1, 2);

        Map<Point, Integer> cellsMap = new HashMap<>();
        cellsMap.put(firstPoint, 1);
        cellsMap.put(secondPoint, 1);

        assertThat(conwayLife.createMapFrom2dArray(cells)).usingRecursiveComparison().isEqualTo(cellsMap);
    }

    @Test
    void countNeighborsTest() {
        int[][] cells = {{1, 0, 0}, {1, 1, 1}, {0, 0, 0}};
        Point firstPoint = new Point(0, 0);
        Point secondPoint = new Point(1, 0);
        Point thirdPoint = new Point(1, 1);
        Point fourthPoint = new Point(1, 2);

        Map<Point, Integer> cellsMap = new HashMap<>();
        cellsMap.put(firstPoint, 1);
        cellsMap.put(secondPoint, 1);
        cellsMap.put(thirdPoint, 1);
        cellsMap.put(fourthPoint, 1);

        assertThat(conwayLife.countNeighbors(cellsMap, thirdPoint)).isEqualTo(3);

    }

    @Test
    void numberOfRowsTest() {
        Map<Point, Integer> cellsMap = new HashMap<>();
        cellsMap.put(new Point(0, 0), 1);
        cellsMap.put(new Point(1, 2), 1);

        assertThat(conwayLife.numberOfRows(cellsMap)).isEqualTo(2);
    }

    @Test
    void numberOfColumnsTest() {
        Map<Point, Integer> cellsMap = new HashMap<>();
        cellsMap.put(new Point(0, 0), 1);
        cellsMap.put(new Point(1, 2), 1);

        assertThat(conwayLife.numberOfColumns(cellsMap)).isEqualTo(3);
    }

    @Test
    void mapTo2dArrayTest() {
        int[][] cells = {{1, 0, 0}, {0, 0, 1}};
        Map<Point, Integer> cellsMap = new HashMap<>();
        cellsMap.put(new Point(0, 0), 1);
        cellsMap.put(new Point(1, 2), 1);

        assertThat(conwayLife.mapTo2dArray(cellsMap)).isEqualTo(cells);
    }
}