package net.genevaub.mocks;

import net.genevaub.lawnmower.*;

import java.util.ArrayList;
import java.util.List;

public class LawnMock implements Lawn {
    private final Position size;
    private final List<Mower> mowers = new ArrayList<>();

    public LawnMock(final Position size) {
        this.size = size;
    }

    @Override
    public void addMower(final Position initialPosition, final Direction direction) throws LawnException {
        mowers.add(new Mower(initialPosition, direction, size));
    }

    @Override
    public void moveLastMower(final Move move) throws LawnException {
        final int lastIndex = mowers.size() - 1;
        final Mower lastMower = mowers.get(lastIndex);
        lastMower.move(move);
    }

    @Override
    public void print() {

    }

    public List<Mower> getMowers() {
        return mowers;
    }
}
