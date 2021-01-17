package gameoflife;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static gameoflife.CellsState.*;


public class ConwayLife {

    /**
     * @param cells       two dimensional array - initial state of the game
     * @param generations number of generations in the game
     * @return final state of Conway Life universe as a two dimensional array
     */

    public int[][] getGeneration(int[][] cells, int generations) {
        if (generations == 0) {
            return cells;
        }
        Map<Point, CellsState> aliveCells = arrayToMap(cells);

        for (int gen = 0; gen < generations; gen++) {
            for (Point point : aliveCells.keySet()) {
                markToBeRemoved(aliveCells, point);
            }
            putToBeAddedPoints(aliveCells);
            for (Map.Entry<Point, CellsState> entry : aliveCells.entrySet()) {
                if (entry.getValue().equals(TO_BE_ADDED)) {
                    entry.setValue(ALIVE);
                }
            }
            aliveCells.values().removeAll(Collections.singleton(TO_BE_REMOVED));
        }
        return mapTo2dArray(aliveCells);
    }

    public void markToBeRemoved(Map<Point, CellsState> pointsMap, Point point) {
        int neighbors = countNeighbors(pointsMap, point);

        if (pointsMap.containsKey(point) && (neighbors < 2 || neighbors > 3)) {
            pointsMap.replace(point, TO_BE_REMOVED);
        }
    }

    public void putToBeAddedPoints(Map<Point, CellsState> pointsMap) {
        for (int i = getMinX(pointsMap) - 1; i <= getMaxX(pointsMap) + 1; i++) {
            for (int j = getMinY(pointsMap) - 1; i <= getMaxY(pointsMap) + 1; i++) {
                Point point = new Point(i, j);
                if (!pointsMap.containsKey(point) && countNeighbors(pointsMap, point) == 3) {
                    pointsMap.put(point, TO_BE_ADDED);
                }
            }
        }
    }

    public Map<Point, CellsState> arrayToMap(int[][] cells) {
        Map<Point, CellsState> cellsMap = new HashMap<>();

        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[0].length; col++) {
                if (cells[row][col] == 1) {
                    cellsMap.put(new Point(row, col), ALIVE);
                }
            }
        }
        return cellsMap;
    }

    public int countNeighbors(Map<Point, CellsState> pointsMap, Point point) {
        int neighCounter = 0;

        for (int i = point.getX() - 1; i <= point.getX() + 1; i++) {
            for (int j = point.getY() - 1; j <= point.getY() + 1; j++) {
                Point neighPoint = new Point(i, j);
                if (!neighPoint.equals(point) && pointsMap.containsKey(neighPoint)
                        && pointsMap.get(neighPoint).isAliveOrToBeRemoved()) {
                    neighCounter++;
                }
            }
        }

        return neighCounter;
    }

    public int getMinX(Map<Point, CellsState> pointsMap) {
        return pointsMap.keySet()
                .stream()
                .map(Point::getX)
                .min(Integer::compareTo)
                .orElse(0);
    }

    public int getMaxX(Map<Point, CellsState> pointsMap) {
        return pointsMap.keySet()
                .stream()
                .map(Point::getX)
                .max(Integer::compareTo)
                .orElse(0);
    }

    public int getMinY(Map<Point, CellsState> pointsMap) {
        return pointsMap.keySet()
                .stream()
                .map(Point::getY)
                .min(Integer::compareTo)
                .orElse(0);
    }

    public int getMaxY(Map<Point, CellsState> pointsMap) {
        return pointsMap.keySet()
                .stream()
                .map(Point::getY)
                .max(Integer::compareTo)
                .orElse(0);
    }

    public int[][] mapTo2dArray(Map<Point, CellsState> pointsMap) {
        int minRow = getMinX(pointsMap);
        int minCol = getMinY(pointsMap);
        int rows = getMaxX(pointsMap);
        int cols = getMaxY(pointsMap);

        int[][] cells = new int[Math.abs(rows) + 1 + Math.abs(Math.min(minRow, 0))]
                [Math.abs(cols) + 1 + Math.abs(Math.min(minCol, 0))];
        for (Point point : pointsMap.keySet()) {
            cells[point.getX()][point.getY()] = 1;
        }
        return cells;
    }
}
