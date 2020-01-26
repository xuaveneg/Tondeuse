package net.genevaub.lawnmower;

import java.util.Optional;

public enum Move {
    LEFT('G'),
    RIGHT('D'),
    FORWARD('A');

    private final char move;

    Move(final char move) {
        this.move = move;
    }

    public static Optional<Move> of(final char move) {
        for (final Move toCompare : Move.values()) {
            if (toCompare.move == move) {
                return Optional.of(toCompare);
            }
        }
        return Optional.empty();
    }
}
