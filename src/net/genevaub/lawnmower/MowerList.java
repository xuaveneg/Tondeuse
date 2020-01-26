package net.genevaub.lawnmower;

public interface MowerList {
    void addMower(Mower mower);

    void moveLastMower(Move move, Position limit);

    void print(StringBuilder printer);
}
