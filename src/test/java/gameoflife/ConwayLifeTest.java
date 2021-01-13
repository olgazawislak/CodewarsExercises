package gameoflife;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

import static gameoflife.CellsState.ALIVE;
import static org.assertj.core.api.Assertions.assertThat;

class ConwayLifeTest {

    private ConwayLife conwayLife = new ConwayLife();

    @Test
    void createMapFrom2dArrayTest() {
        int[][] cells = {{1, 0, 0}, {0, 0, 1}, {0, 0, 0}};
        Point firstPoint = new Point(0, 0);
        Point secondPoint = new Point(1, 2);

        Map<Point, CellsState> cellsMap = new HashMap<>();
        cellsMap.put(firstPoint, ALIVE);
        cellsMap.put(secondPoint, ALIVE);

        assertThat(conwayLife.arrayToMap(cells)).usingRecursiveComparison().isEqualTo(cellsMap);
    }

    @Test
    void countNeighborsTest() {
        int[][] cells = {{1, 0, 0}, {1, 1, 1}, {0, 0, 0}};
        Point firstPoint = new Point(0, 0);
        Point secondPoint = new Point(1, 0);
        Point thirdPoint = new Point(1, 1);
        Point fourthPoint = new Point(1, 2);

        Map<Point, CellsState> cellsMap = new HashMap<>();
        cellsMap.put(firstPoint, ALIVE);
        cellsMap.put(secondPoint, ALIVE);
        cellsMap.put(thirdPoint, ALIVE);
        cellsMap.put(fourthPoint, ALIVE);

        assertThat(conwayLife.countNeighbors(cellsMap, thirdPoint)).isEqualTo(3);

    }

    @Test
    void numberOfRowsTest() {
        Map<Point, CellsState> cellsMap = new HashMap<>();
        cellsMap.put(new Point(0, 0), ALIVE);
        cellsMap.put(new Point(1, 2), ALIVE);

        assertThat(conwayLife.getMaxX(cellsMap)).isEqualTo(1);
    }

    @Test
    void numberOfColumnsTest() {
        Map<Point, CellsState> cellsMap = new HashMap<>();
        cellsMap.put(new Point(0, 0), ALIVE);
        cellsMap.put(new Point(1, 2), ALIVE);

        assertThat(conwayLife.getMaxY(cellsMap)).isEqualTo(2);
    }

    @Test
    void mapTo2dArrayTest() {
        int[][] cells = {{1, 0, 0}, {0, 0, 1}};
        Map<Point, CellsState> cellsMap = new HashMap<>();
        cellsMap.put(new Point(0, 0), ALIVE);
        cellsMap.put(new Point(1, 2), ALIVE);

        assertThat(conwayLife.mapTo2dArray(cellsMap)).isEqualTo(cells);
    }
}