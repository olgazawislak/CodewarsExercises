import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ConwayLife {

    /**
     * @param cells       2d array - initial state of the game
     * @param generations number of generations in the game
     * @return final state of Conway Life universe
     */

    public int[][] getGeneration(int[][] cells, int generations) {
        if (generations == 0) {
            return cells;
        }
        Map<Point, Integer> livingCells = createMapFrom2dArray(cells);

        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[0].length; col++) {
                Point point = new Point(row, col);
                if (livingCells.containsKey(point) && (countNeighbors(livingCells, point) > 3 ||
                        countNeighbors(livingCells, point) < 2)) {
                    livingCells.replace(point, -1);
                }
            }
        }
        livingCells.values().removeAll(Collections.singleton(-1));

        return mapTo2dArray(livingCells);
    }


    public Map<Point, Integer> createMapFrom2dArray(int[][] cells) {
        Map<Point, Integer> cellsMap = new HashMap<>();

        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[0].length; col++) {
                if (cells[row][col] == 1) {
                    cellsMap.put(new Point(row, col), 1);
                }
            }
        }
        return cellsMap;
    }

    public int countNeighbors(Map<Point, Integer> pointsMap, Point point) {
        int neighCounter = 0;

        for (int i = point.getX() - 1; i <= point.getX() + 1; i++) {
            for (int j = point.getY() - 1; j <= point.getY() + 1; j++) {
                neighCounter += pointsMap.getOrDefault(new Point(i, j), 0);
            }
        }
        return neighCounter - pointsMap.getOrDefault(point, 0);
    }

    public int numberOfRows(Map<Point, Integer> pointsMap) {
        int rows = 0;

        for (Point point : pointsMap.keySet()) {
            if (point.getX() > rows) {
                rows = point.getX();
            }
        }
        return rows + 1;
    }

    public int numberOfColumns(Map<Point, Integer> pointsMap) {
        int cols = 0;

        for (Point point : pointsMap.keySet()) {
            if (point.getY() > cols) {
                cols = point.getY();
            }
        }
        return cols + 1;
    }

    public int[][] mapTo2dArray(Map<Point, Integer> pointsMap) {
        int rows = numberOfRows(pointsMap);
        int cols = numberOfColumns(pointsMap);


        int[][] cells = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                cells[row][col] = pointsMap.getOrDefault(new Point(row, col), 0);
            }
        }
        return cells;
    }

}
