package net.genevaub.lawnmower;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MowerListImpl implements MowerList {
    protected final List<Mower> mowers = new ArrayList<>();

    @Override
    public void addMower(final Mower mower) {
        mowers.add(mower);
    }

    @Override
    public void moveLastMower(final Move move, final Position limit) {
        final int lastIndex = mowers.size() - 1;
        final Mower lastMower = mowers.get(lastIndex);
        lastMower.move(move, limit);
    }

    @Override
    public void print(final StringBuilder printer) {
        final StringBuilder listPrinter = new StringBuilder();
        for (final Mower mower : mowers) {
            appendNewlineIfNotEmpty(listPrinter);
            mower.print(listPrinter);
        }
        printer.append(listPrinter);
    }

    private void appendNewlineIfNotEmpty(final StringBuilder listPrinter) {
        if (listPrinter.length() != 0) {
            listPrinter.append('\n');
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final MowerListImpl mowerList = (MowerListImpl) o;
        final Object[] mowersList = mowers.toArray();
        final Object[] inputList = mowerList.mowers.toArray();
        return Arrays.equals(mowersList, inputList);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(mowers.toArray());
    }
}
