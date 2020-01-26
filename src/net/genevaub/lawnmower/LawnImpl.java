package net.genevaub.lawnmower;

import java.io.PrintStream;
import java.util.Objects;

public class LawnImpl implements Lawn {
    private final Position size;
    private final MowerList mowerList;
    private final PrintStream stream;

    public LawnImpl(final Position size, final MowerList mowerList, final PrintStream stream) {
        this.size = size;
        this.mowerList = mowerList;
        this.stream = stream;
    }

    @Override
    public void addMower(final Position initialPosition, final Direction direction) {
        mowerList.addMower(new Mower(initialPosition, direction));
    }

    @Override
    public void moveLastMower(final Move move) {
        mowerList.moveLastMower(move, size);
    }

    @Override
    public void print() {
        final StringBuilder printer = new StringBuilder();
        mowerList.print(printer);
        stream.print(printer);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final LawnImpl lawn = (LawnImpl) o;
        return Objects.equals(size, lawn.size) &&
                Objects.equals(mowerList, lawn.mowerList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, mowerList);
    }

    @Override
    public String toString() {
        return "LawnImpl{" +
                "size=" + size +
                ", mowerListMock=" + mowerList +
                '}';
    }
}
