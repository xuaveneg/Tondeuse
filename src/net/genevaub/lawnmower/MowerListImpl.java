package net.genevaub.lawnmower;

import java.util.ArrayList;
import java.util.List;

public class MowerListImpl implements MowerList {

    protected List<Mower> mowers = new ArrayList<>();

    @Override
    public void addMower(Mower mower) {
        this.mowers.add(mower);
    }

    @Override
    public void moveLastMower(Move move, Position limit) {
        Mower lastMower = mowers.get(mowers.size() - 1);
        lastMower.move(move, limit);
    }
}
