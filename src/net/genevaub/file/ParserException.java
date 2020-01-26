package net.genevaub.file;

import java.io.IOException;

public class ParserException extends Exception {

    enum ParserTypeException {
        DIRECTION_NOT_FOUND("Direction inconnue."),
        MOVE_NOT_FOUND("Déplacement inconnu."),
        POSITION_NOT_COMPLETE("Position incomplète."),
        LAWN_SIZE_LINE_UNREADABLE("Ligne de taille de la pelouse illisible."),
        MOWER_INITIAL_POSITION_LINE_UNREADABLE("Ligne de position initiale d'une tondeuse illisible."),
        IO_EXCEPTION("Erreur d'I/O.");

        private final String message;

        ParserTypeException(final String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    ParserException(final ParserTypeException type) {
        super(type.getMessage());
    }

    ParserException(final ParserTypeException type, final String message) {
        super(type.getMessage() + message);
    }

    ParserException(final IOException ioException) {
        super(ParserTypeException.IO_EXCEPTION.getMessage(), ioException);
    }
}
