package net.genevaub.lawnmower;

import java.util.Optional;

public enum Move {
    LEFT('G'),
    RIGHT('D'),
    FORWARD('A');

    private final char move;

    Move(char move) {
        this.move = move;
    }

    public static Optional<Move> of(char move) {
        for (Move toCompare : Move.values()) {
            if (toCompare.move == move) {
                return Optional.of(toCompare);
            }
        }
        return Optional.empty();
    }
}
