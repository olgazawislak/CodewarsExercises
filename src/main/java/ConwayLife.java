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

        int cellsRows = cells.length;
        int cellsColumns = cells[0].length;

        int[][] cellsAfterGeneration = new int[cellsRows][cellsColumns];

        for (int row = 0; row < cellsRows; row++) {
            for (int col = 0; col < cellsColumns; col++) {
                int sumOfNeighbors = numberOfNeighbors(cells, row, col);
                if (sumOfNeighbors == 3 || (sumOfNeighbors == 2 && cells[row][col] == 1)) {
                    cellsAfterGeneration[row][col] = 1;
                } else {
                    cellsAfterGeneration[row][col] = 0;
                }
            }
        }
        return getGeneration(cellsAfterGeneration, generations - 1);
    }

    public int numberOfNeighbors(int[][] array, int row, int column) {
        int startRow = Math.max(row - 1, 0);
        int startColumn = Math.max(column - 1, 0);
        int endRow = Math.min(row + 1, array.length - 1);
        int endColumn = Math.min(column + 1, array[0].length - 1);
        int sumOfNeighbors = 0;

        for (int neighRow = startRow; neighRow <= endRow; neighRow++) {
            for (int neighColumn = startColumn; neighColumn <= endColumn; neighColumn++) {
                if (!(neighRow == row && neighColumn == column)) {
                    sumOfNeighbors += array[neighRow][neighColumn];
                }
            }
        }
        return sumOfNeighbors;
    }
}
