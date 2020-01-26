package net.genevaub.mocks;

import net.genevaub.lawnmower.LawnBuilder;
import net.genevaub.lawnmower.Mower;
import net.genevaub.lawnmower.Direction;
import net.genevaub.lawnmower.Position;

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

    public Position getSize() {
        return size;
    }

    public List<Mower> getMowers() {
        return mowers;
    }
}
