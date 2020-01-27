package net.genevaub.lawnmower;

public interface Lawn {
    void addMower(Position initialPosition, Direction direction) throws LawnException;

    void moveLastMower(Move move) throws LawnException;

    void print();
}
