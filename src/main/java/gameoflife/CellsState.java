package gameoflife;

public enum CellsState {
    ALIVE,
    TO_BE_REMOVED,
    TO_BE_ADDED;

    public boolean isAliveOrToBeRemoved() {
        return this != TO_BE_ADDED;
    }
}
