package net.genevaub.mocks;

import net.genevaub.lawnmower.Move;
import net.genevaub.lawnmower.Mower;
import net.genevaub.lawnmower.MowerList;
import net.genevaub.lawnmower.Position;

import java.util.*;

public class MowerListMock implements MowerList {

    List<List<Move>> moves = new ArrayList<>();

    @Override
    public void addMower(Mower mower) {
        moves.add(new ArrayList<>());
    }

    @Override
    public void moveLastMower(Move move, Position limit) {
        moves.get(moves.size()-1).add(move);
    }

    @Override
    public void print(StringBuilder printer) {

    }

    public int getSize() {
        return moves.size();
    }

    public List<Move> getMoves(int i) {
        return moves.get(i);
    }
}
