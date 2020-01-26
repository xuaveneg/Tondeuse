package net.genevaub.lawnmower;

import java.util.Optional;

public enum Direction {
    NORTH('N'),
    SOUTH('S'),
    EAST('E'),
    WEST('W');

    private final char direction;

    Direction(final char direction) {
        this.direction = direction;
    }

    public static Optional<Direction> of(final char direction) {
        for (final Direction toCompare : Direction.values()) {
            if (toCompare.direction == direction) {
                return Optional.of(toCompare);
            }
        }
        return Optional.empty();
    }

    private Direction leftValue() {
        switch (this) {
            case NORTH:
                return WEST;
            case EAST:
                return NORTH;
            case SOUTH:
                return EAST;
            case WEST:
                return SOUTH;
        }
        return this;
    }

    private Direction rightValue() {
        switch (this) {
            case NORTH:
                return EAST;
            case EAST:
                return SOUTH;
            case SOUTH:
                return WEST;
            case WEST:
                return NORTH;
        }
        return this;
    }

    public Direction rotate(final Move move) {
        switch (move) {
            case LEFT:
                return leftValue();
            case RIGHT:
                return rightValue();
        }
        return this;
    }

    public void print(final StringBuilder printer) {
        printer.append(direction);
    }
}
