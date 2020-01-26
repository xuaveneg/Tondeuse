package net.genevaub.lawnmower;

public interface Lawn {
    void addMower(Position initialPosition, Direction direction);

    void moveLastMower(Move move);

    void print();
}
