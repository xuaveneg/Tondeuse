package net.genevaub.mocks;

import net.genevaub.lawnmower.Move;
import net.genevaub.lawnmower.Mower;
import net.genevaub.lawnmower.MowerList;
import net.genevaub.lawnmower.Position;

import java.util.*;

public class MowerListMock implements MowerList {

    final List<List<Move>> moves = new ArrayList<>();

    @Override
    public void addMower(final Mower mower) {
        moves.add(new ArrayList<>());
    }

    @Override
    public void moveLastMower(final Move move, final Position limit) {
        moves.get(moves.size()-1).add(move);
    }

    @Override
    public void print(final StringBuilder printer) {

    }

    public int getSize() {
        return moves.size();
    }

    public List<Move> getMoves(final int i) {
        return moves.get(i);
    }
}
