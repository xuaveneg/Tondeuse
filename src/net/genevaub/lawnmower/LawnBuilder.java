package net.genevaub.lawnmower;

public interface LawnBuilder {

    void withSize(Position size);

    void addMower(Position initialPosition, Direction direction);

    void moveLastMower(Move move);
}
