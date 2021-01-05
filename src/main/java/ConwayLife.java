import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ConwayLife {
    /**
     * @param cells 2d array - initial state of the game
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
                    cellsMap.put(new Point(row, col), 0);
                }
            }
        }
//        IntStream stream = range(0, cells.length).flatMap(row -> range(0, cells[row].length).filter();
        return cellsMap;
    }

    public int countNeighbors(Map<Point, Integer> pointsMap, Point point) {
        int neighCounter = 0;

        for (int i = point.getX() - 1; i <= point.getX() + 1; i++) {
            for (int j = point.getY() - 1; j <= point.getY() + 1; j++) {
                if (pointsMap.containsKey(new Point(i, j))) {
                    ++neighCounter;
                }
            }
        }
        return neighCounter;
    }

    public int[][] mapTo2dArray(Map<Point, Integer> pointsMap) {
        int rows = 0;
        int cols = 0;

        for (Point point : pointsMap.keySet()) {
            if (point.getX() > rows) {
                rows = point.getX();
            }
            if (point.getY() > cols) {
                cols = point.getY();
            }
        }

        int[][] cells = new int[rows][cols];
        for (int row = 0; row <= rows; row++) {
            for (int col = 0; col <= cols; col++) {
                Point point = new Point(row, col);
                if (pointsMap.containsKey(point)) {
                    cells[row][col] = 1;
                }
                cells[row][col] = 0;
            }
        }
        return cells;
    }

}
