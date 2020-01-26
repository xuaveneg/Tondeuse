package net.genevaub.lawnmower;

import java.util.Objects;

public class Mower {

    private Position position;
    private Direction direction;

    public Mower(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public void move(Move move) {
        System.out.println("Move " + move + " from position " + position + " for direction " + direction);
        if (Move.FORWARD.equals(move)) {
            position = position.translate(direction);
            return;
        }
        direction = direction.rotate(move);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mower mower = (Mower) o;
        return Objects.equals(position, mower.position) &&
                direction == mower.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, direction);
    }

    @Override
    public String toString() {
        return "Mower{" +
                "position=" + position +
                ", direction=" + direction +
                '}';
    }
}
