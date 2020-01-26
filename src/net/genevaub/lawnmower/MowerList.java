package net.genevaub.lawnmower;

import java.util.ArrayList;
import java.util.List;

public class MowerList {

    protected List<Mower> mowers = new ArrayList<>();

    void addMower(Mower mower) {
        this.mowers.add(mower);
    }

    void moveLastMower(Move move, Position limit) {
        Mower lastMower = mowers.get(mowers.size() - 1);
        lastMower.move(move, limit);
    }
}
