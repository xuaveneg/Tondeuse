package net.genevaub.file;

import net.genevaub.lawnmower.*;

public class LineReaderImpl implements LineReader {
    private Lawn lawn;
    private LineType currentLineType = LineType.LAWN_SIZE;
    private final LawnBuilder lawnBuilder;

    public LineReaderImpl(final LawnBuilder lawnBuilder) {
        this.lawnBuilder = lawnBuilder;
    }

    @Override
    public void readLine(final String line) throws ParserException, LawnException {
        if (LineType.LAWN_SIZE.equals(currentLineType)) {
            readLawnSizeLine(line);
        } else if (LineType.MOWER_INITIAL_POSITION.equals(currentLineType)) {
            readMowerInitialPositionLine(line);
        } else if (LineType.MOWER_MOVES.equals(currentLineType)) {
            readMowerMovesLine(line);
        }
        switchToNextLineType();
    }

    @Override
    public void print() {
        lawn.print();
    }

    private void readMowerMovesLine(final String line) throws ParserException, LawnException {
        for (final char token : line.toCharArray()) {
            final Move move = Move.of(token)
                    .orElseThrow(() -> new ParserException(ParserException.ParserTypeException.MOVE_NOT_FOUND));
            lawn.moveLastMower(move);
        }
    }

    private void readMowerInitialPositionLine(final String line) throws ParserException, LawnException {
        final String[] initialPositionTokens = line.split(" ");
        if (initialPositionTokens.length != 3) {
            throw new ParserException(ParserException.ParserTypeException.MOWER_INITIAL_POSITION_LINE_UNREADABLE);
        }
        try {
            final int x = Integer.parseInt(initialPositionTokens[0]);
            final int y = Integer.parseInt(initialPositionTokens[1]);
            final char direction = initialPositionTokens[2].charAt(0);
            final Direction directionEnum = Direction.of(direction)
                    .orElseThrow(() -> new ParserException(ParserException.ParserTypeException.DIRECTION_NOT_FOUND));
            lawn.addMower(new Position(x, y), directionEnum);
        } catch (final NumberFormatException e) {
            throw new ParserException(ParserException.ParserTypeException.POSITION_NOT_COMPLETE);
        }
    }

    private void readLawnSizeLine(final String line) throws ParserException, LawnException {
        final String[] sizeTokens = line.split(" ");
        if (sizeTokens.length != 2) {
            throw new ParserException(ParserException.ParserTypeException.LAWN_SIZE_LINE_UNREADABLE);
        }
        try {
            final int x = Integer.parseInt(sizeTokens[0]);
            final int y = Integer.parseInt(sizeTokens[1]);
            lawn = lawnBuilder.withSize(new Position(x, y))
                    .build();
        } catch (final NumberFormatException e) {
            throw new ParserException(ParserException.ParserTypeException.POSITION_NOT_COMPLETE);
        }
    }

    private void switchToNextLineType() {
        switch (currentLineType) {
            case LAWN_SIZE:
            case MOWER_MOVES:
                currentLineType = LineType.MOWER_INITIAL_POSITION;
                break;
            case MOWER_INITIAL_POSITION:
                currentLineType = LineType.MOWER_MOVES;
                break;
        }
    }
}
