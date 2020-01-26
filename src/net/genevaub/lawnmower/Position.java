package net.genevaub.lawnmower;

import java.util.Objects;

public class Position {
    private int x;
    private  int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position translate(Direction direction) {
        switch (direction) {
            case NORTH:
                return new Position(x, y+1);
            case EAST:
                return new Position(x+1, y);
            case SOUTH:
                return new Position(x, y-1);
            case WEST:
                return new Position(x-1, y);
        }
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
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
