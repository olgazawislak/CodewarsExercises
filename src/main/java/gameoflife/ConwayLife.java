package gameoflife;

import java.util.HashMap;
import java.util.Map;

import static gameoflife.CellsState.*;


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
        Map<Point, CellsState> livingCells = arrayToMap(cells);

        for(int gen = 0; gen < generations; gen++) {

        }
//            for (int row = getMinX(livingCells) - 1; row <= getMaxX(livingCells) + 1; row++) {
//                for (int col = getMinY(livingCells) - 1; col <= getMaxY(livingCells) + 1; col++) {
//                }
//            livingCells.values().removeAll(Collections.singleton(-1));
//        }
        return mapTo2dArray(livingCells);
    }

    public void markToBeRemoved(Map<Point, CellsState> pointsMap, Point point) {
        int neighbors = countNeighbors(pointsMap, point);

        if (pointsMap.containsKey(point) && (neighbors < 2 || neighbors > 3)) {
            pointsMap.replace(point, TO_BE_REMOVED);
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
                Point neighPoint = new Point(i,j);
                if( !neighPoint.equals(point) && pointsMap.containsKey(neighPoint)
                        && pointsMap.get(neighPoint).isStillAlive()) {
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

        int[][] cells = new int[rows + 1 + Math.abs(Math.min(minRow, 0))]
                [cols + 1 + Math.abs(Math.min(minCol, 0))];
        for (Point point : pointsMap.keySet()) {
            cells[point.getX()][point.getY()] = 1;
        }
        return cells;
    }
}
