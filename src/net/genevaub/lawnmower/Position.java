package net.genevaub.lawnmower;

import java.util.Objects;

public class Position {
    private int x;
    private  int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position translate(Direction direction, Position limit) {
        int newX = this.x;
        int newY = this.y;
        switch (direction) {
            case NORTH:
                newY = Math.min(this.y + 1, limit.y);
                break;
            case EAST:
                newX = Math.min(this.x + 1, limit.x);
                break;
            case SOUTH:
                newY = Math.max(this.y - 1, 0);
                break;
            case WEST:
                newX = Math.max(this.x - 1, 0);
                break;
        }
        return new Position(newX, newY);
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
