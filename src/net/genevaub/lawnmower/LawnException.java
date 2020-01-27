package net.genevaub.lawnmower;

public final class LawnException extends Exception {
    enum LawnExceptionType {
        POSITION_NEGATIVE("Une position doit être positive."),
        MOWER_OUT_OF_BOUND("Une tondeuse n'est pas sur la pelouse.");

        private final String message;

        LawnExceptionType(final String message) {
            this.message = message;
        }
    }

    LawnException(final LawnExceptionType type) {
        super(type.message);
    }
}
