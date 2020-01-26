package net.genevaub.lawnmower;

import java.util.Objects;

public class LawnImpl implements Lawn {

    private final Position size;
    private final MowerList mowerListMock;

    public LawnImpl(Position size, MowerList mowerListMock) {
        this.size = size;
        this.mowerListMock = mowerListMock;
    }

    @Override
    public void addMower(Position initialPosition, Direction direction) {
        mowerListMock.addMower(new Mower(initialPosition, direction));
    }

    @Override
    public void moveLastMower(Move move) {
        mowerListMock.moveLastMower(move, size);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LawnImpl lawn = (LawnImpl) o;
        return Objects.equals(size, lawn.size) &&
                Objects.equals(mowerListMock, lawn.mowerListMock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, mowerListMock);
    }

    @Override
    public String toString() {
        return "LawnImpl{" +
                "size=" + size +
                ", mowerListMock=" + mowerListMock +
                '}';
    }
}
