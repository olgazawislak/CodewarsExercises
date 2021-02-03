package gameoflife;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

import static gameoflife.CellsState.*;
import static org.assertj.core.api.Assertions.assertThat;

class ConwayLifeTest {

    private final ConwayLife conwayLife = new ConwayLife();

    @Test
    void getGenerationTest() {
        int generations = 1;
        int[][] initialCells = {
                {1, 0, 0},
                {0, 1, 1},
                {1, 1, 0}};
        int[][] expectedCells = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1}};

        assertThat(conwayLife.getGeneration(initialCells, generations)).isEqualTo(expectedCells);
    }

    @Test
    void getMoreThanOneGenerationTest() {
        int generations = 4;
        int[][] initialCells = {
                {1, 0, 0},
                {0, 1, 1},
                {1, 1, 0}};
        int[][] expectedCells = {
                {1, 0, 0},
                {0, 1, 1},
                {1, 1, 0}};

        assertThat(conwayLife.getGeneration(initialCells, generations)).isEqualTo(expectedCells);
    }

    @Test
    void markToBeRemovedTest() {
        Point firstPoint = new Point(0, 0);
        Point secondPoint = new Point(1, 0);
        Point thirdPoint = new Point(1, 1);
        Point fourthPoint = new Point(1, 2);
        Point fifthPoint = new Point(2, 1);

        Map<Point, CellsState> cellsMap = new HashMap<>();
        cellsMap.put(firstPoint, ALIVE);
        cellsMap.put(secondPoint, ALIVE);
        cellsMap.put(thirdPoint, ALIVE);
        cellsMap.put(fourthPoint, ALIVE);
        cellsMap.put(fifthPoint, ALIVE);

        conwayLife.markToBeRemoved(cellsMap, thirdPoint);

        assertThat(cellsMap.get(thirdPoint)).isEqualTo(TO_BE_REMOVED);
    }

    @Test
    void markToBeRemovedWhenThreeNeighborsTest() {
        Point firstPoint = new Point(0, 0);
        Point secondPoint = new Point(1, 0);
        Point thirdPoint = new Point(1, 1);
        Point fourthPoint = new Point(1, 2);

        Map<Point, CellsState> cellsMap = new HashMap<>();
        cellsMap.put(firstPoint, ALIVE);
        cellsMap.put(secondPoint, ALIVE);
        cellsMap.put(thirdPoint, ALIVE);
        cellsMap.put(fourthPoint, ALIVE);

        conwayLife.markToBeRemoved(cellsMap, thirdPoint);

        assertThat(cellsMap.get(thirdPoint)).isEqualTo(ALIVE);
    }

    @Test
    void putToBeAddedPointsTest() {
        Map<Point, CellsState> cellsMap = new HashMap<>();
        cellsMap.put(new Point(0, 0), ALIVE);
        cellsMap.put(new Point(0, 2), ALIVE);
        cellsMap.put(new Point(1, 2), ALIVE);
        cellsMap.put(new Point(2, 2), ALIVE);

        Point toBeAddedPoint = new Point(1, 3);
        conwayLife.putToBeAddedPoints(cellsMap);

        assertThat(cellsMap).containsKey(toBeAddedPoint);
        assertThat(cellsMap.get(toBeAddedPoint)).isEqualTo(TO_BE_ADDED);
    }

    @Test
    void createMapFrom2dArrayTest() {
        int[][] cells = {
                {1, 0, 0},
                {0, 0, 1},
                {0, 0, 0}};

        Map<Point, CellsState> cellsMap = new HashMap<>();
        cellsMap.put(new Point(0, 0), ALIVE);
        cellsMap.put(new Point(1, 2), ALIVE);

        assertThat(conwayLife.arrayToMap(cells)).usingRecursiveComparison().isEqualTo(cellsMap);
    }

    @Test
    void countNeighborsTest() {
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
    void countNeighborsForPointOutsideTest() {
        Map<Point, CellsState> cellsMap = new HashMap<>();
        cellsMap.put(new Point(0, 0), ALIVE);
        cellsMap.put(new Point(0, 2), ALIVE);
        cellsMap.put(new Point(1, 2), ALIVE);
        cellsMap.put(new Point(2, 2), ALIVE);

        Point toBeAddedPoint = new Point(1, 3);

        assertThat(conwayLife.countNeighbors(cellsMap, toBeAddedPoint)).isEqualTo(3);
    }

    @Test
    void countNeighborsWithToBeRemovedPointsTest() {
        Point firstPoint = new Point(0, 0);
        Point secondPoint = new Point(1, 0);
        Point thirdPoint = new Point(1, 1);
        Point fourthPoint = new Point(0, 1);

        Map<Point, CellsState> cellsMap = new HashMap<>();
        cellsMap.put(firstPoint, TO_BE_REMOVED);
        cellsMap.put(secondPoint, TO_BE_REMOVED);
        cellsMap.put(thirdPoint, ALIVE);

        assertThat(conwayLife.countNeighbors(cellsMap, fourthPoint)).isEqualTo(3);
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
        int[][] cells = {
                {1, 0, 0},
                {0, 0, 1}};
        Map<Point, CellsState> cellsMap = new HashMap<>();
        cellsMap.put(new Point(0, 0), ALIVE);
        cellsMap.put(new Point(1, 2), ALIVE);

        assertThat(conwayLife.mapTo2dArray(cellsMap)).isEqualTo(cells);
    }

    @Test
    void mapTo2dArrayWithAllCoordinatesBiggerThanZeroTest() {
        int[][] cells = {
                {1, 0, 0},
                {0, 0, 1}};
        Map<Point, CellsState> cellsMap = new HashMap<>();
        cellsMap.put(new Point(2, 1), ALIVE);
        cellsMap.put(new Point(3, 3), ALIVE);

        assertThat(conwayLife.mapTo2dArray(cellsMap)).isEqualTo(cells);
    }

    @Test
    void mapTo2dArrayWithNegativeCoordinatesTest() {
        int[][] cells = {
                {1, 0, 0},
                {0, 0, 1},
                {0, 0, 0},
                {0, 0, 1}};
        Map<Point, CellsState> cellsMap = new HashMap<>();
        cellsMap.put(new Point(-2, -1), ALIVE);
        cellsMap.put(new Point(-1, 1), ALIVE);
        cellsMap.put(new Point(1, 1), ALIVE);
        assertThat(conwayLife.mapTo2dArray(cellsMap)).isEqualTo(cells);
    }
}