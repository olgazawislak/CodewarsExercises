package gameoflife;

public enum CellsState {
    ALIVE,
    TO_BE_REMOVED,
    TO_BORN;

    public boolean isStillAlive() {
        return this != TO_BORN;
    }
}
