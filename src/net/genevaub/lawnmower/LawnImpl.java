package net.genevaub.lawnmower;

import java.util.Objects;

public class LawnImpl implements Lawn {

    private final Position size;

    public LawnImpl(Position size) {
        this.size = size;
    }

    @Override
    public void addMower(Position initialPosition, Direction direction) {

    }

    @Override
    public void moveLastMower(Move move) {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LawnImpl lawn = (LawnImpl) o;
        return Objects.equals(size, lawn.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size);
    }

    @Override
    public String toString() {
        return "LawnImpl{" +
                "size=" + size +
                '}';
    }
}