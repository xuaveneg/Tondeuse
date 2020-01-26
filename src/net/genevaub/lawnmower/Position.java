package net.genevaub.lawnmower;

import java.util.Objects;

public class Position {
    private final int x;
    private final int y;

    public Position(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public Position translate(final Direction direction, final Position limit) {
        int newX = x;
        int newY = y;
        switch (direction) {
            case NORTH:
                newY = Math.min(y + 1, limit.y);
                break;
            case EAST:
                newX = Math.min(x + 1, limit.x);
                break;
            case SOUTH:
                newY = Math.max(y - 1, 0);
                break;
            case WEST:
                newX = Math.max(x - 1, 0);
                break;
        }
        return new Position(newX, newY);
    }

    public void print(final StringBuilder printer) {
        printer.append(x);
        printer.append(' ');
        printer.append(y);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Position position = (Position) o;
        return x == position.x &&
                y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
