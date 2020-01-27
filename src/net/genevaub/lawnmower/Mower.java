package net.genevaub.lawnmower;

import java.util.Objects;

public final class Mower {
    private final Position limit;
    private Position position;
    private Direction direction;

    public Mower(final Position position, final Direction direction, final Position limit) throws LawnException {
        this.limit = limit;
        if (position.isOutOf(limit)) {
            throw new LawnException(LawnException.LawnExceptionType.MOWER_OUT_OF_BOUND);
        }
        this.position = position;
        this.direction = direction;
    }

    public void move(final Move move) throws LawnException {
        if (Move.FORWARD.equals(move)) {
            position = position.translate(direction, limit);
            return;
        }
        direction = direction.rotate(move);
    }

    public void print(final StringBuilder printer) {
        position.print(printer);
        printer.append(' ');
        direction.print(printer);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Mower mower = (Mower) o;
        return Objects.equals(limit, mower.limit) &&
                Objects.equals(position, mower.position) &&
                direction == mower.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(limit, position, direction);
    }

    @Override
    public String toString() {
        return "Mower{" +
                "limit=" + limit +
                ", position=" + position +
                ", direction=" + direction +
                '}';
    }
}
