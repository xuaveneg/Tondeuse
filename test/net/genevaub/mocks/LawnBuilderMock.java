package net.genevaub.mocks;

import net.genevaub.lawnmower.*;

import java.util.ArrayList;
import java.util.List;

public class LawnBuilderMock implements LawnBuilder {
    private Position size;
    private List<Mower> mowers = new ArrayList<>();

    @Override
    public void withSize(Position size) {
        this.size = size;
    }

    @Override
    public void addMower(Position initialPosition, Direction direction) {
        mowers.add(new Mower(initialPosition, direction));
    }

    @Override
    public void moveLastMower(Move move) {
        mowers.get(mowers.size() - 1).move(move);
    }

    public Position getSize() {
        return size;
    }

    public List<Mower> getMowers() {
        return mowers;
    }
}
