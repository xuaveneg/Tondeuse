package net.genevaub.lawnmower;

import java.util.Objects;

public class Mower {
    private Position position;
    private Direction direction;

    public Mower(final Position position, final Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public void move(final Move move, final Position limit) {
        if (Move.FORWARD.equals(move)) {
            position = position.translate(direction, limit);
            return;
        }
        direction = direction.rotate(move);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Mower mower = (Mower) o;
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

    public void print(final StringBuilder printer) {
        position.print(printer);
        printer.append(' ');
        direction.print(printer);
    }
}
