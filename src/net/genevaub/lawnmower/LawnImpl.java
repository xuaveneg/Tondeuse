package net.genevaub.lawnmower;

import java.io.PrintStream;
import java.util.Objects;

public class LawnImpl implements Lawn {
    private final Position size;
    private final MowerList mowerList;
    private final PrintStream stream;

    public LawnImpl(Position size, MowerList mowerList, PrintStream stream) {
        this.size = size;
        this.mowerList = mowerList;
        this.stream = stream;
    }

    @Override
    public void addMower(Position initialPosition, Direction direction) {
        mowerList.addMower(new Mower(initialPosition, direction));
    }

    @Override
    public void moveLastMower(Move move) {
        mowerList.moveLastMower(move, size);
    }

    @Override
    public void print() {
        StringBuilder printer = new StringBuilder();
        mowerList.print(printer);
        stream.print(printer.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LawnImpl lawn = (LawnImpl) o;
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
