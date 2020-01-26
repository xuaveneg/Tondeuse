package net.genevaub.lawnmower;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MowerListImpl implements MowerList {
    protected final List<Mower> mowers = new ArrayList<>();

    @Override
    public void addMower(Mower mower) {
        this.mowers.add(mower);
    }

    @Override
    public void moveLastMower(Move move, Position limit) {
        Mower lastMower = mowers.get(mowers.size() - 1);
        lastMower.move(move, limit);
    }

    @Override
    public void print(StringBuilder printer) {
        StringBuilder listPrinter = new StringBuilder();
        for (Mower mower : mowers) {
            appendNewlineIfNotEmpty(listPrinter);
            mower.print(listPrinter);
        }
        printer.append(listPrinter);
    }

    private void appendNewlineIfNotEmpty(StringBuilder listPrinter) {
        if (listPrinter.length() != 0) {
            listPrinter.append('\n');
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MowerListImpl mowerList = (MowerListImpl) o;
        Object[] mowersList = mowers.toArray();
        Object[] inputList = mowerList.mowers.toArray();
        return Arrays.equals(mowersList, inputList);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(mowers.toArray());
    }
}
