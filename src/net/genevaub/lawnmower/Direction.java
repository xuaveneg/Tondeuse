package net.genevaub.lawnmower;

public enum Direction {
    NORTH;

    public static Direction of(char direction) {
        if (direction == 'N') {
            return NORTH;
        }
        return null;
    }
}
