package net.genevaub.file;

import net.genevaub.lawnmower.*;

public class LineReaderImpl implements LineReader {
    private Lawn lawn;
    private LineType currentLineType = LineType.LAWN_SIZE;
    private final LawnBuilder lawnBuilder;

    public LineReaderImpl(LawnBuilder lawnBuilder) {
        this.lawnBuilder = lawnBuilder;
    }

    public void readLine(String line) {
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

    private void readMowerMovesLine(String line) {
        for (char token : line.toCharArray()) {
            lawn.moveLastMower(Move.of(token).orElse(null));
        }
    }

    private void readMowerInitialPositionLine(String line) {
        String[] initialPositionTokens = line.split(" ");
        int x = Integer.parseInt(initialPositionTokens[0]);
        int y = Integer.parseInt(initialPositionTokens[1]);
        char direction = initialPositionTokens[2].charAt(0);
        lawn.addMower(new Position(x, y), Direction.of(direction).orElse(null));
    }

    private void readLawnSizeLine(String line) {
        String[] sizeTokens = line.split(" ");
        int x = Integer.parseInt(sizeTokens[0]);
        int y = Integer.parseInt(sizeTokens[1]);
        lawn = lawnBuilder.withSize(new Position(x, y)).build();
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
