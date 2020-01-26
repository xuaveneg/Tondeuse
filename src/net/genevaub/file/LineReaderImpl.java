package net.genevaub.file;

import net.genevaub.lawnmower.Direction;
import net.genevaub.lawnmower.LawnBuilder;
import net.genevaub.lawnmower.Position;

public class LineReaderImpl implements LineReader {

    private final LawnBuilder lawnBuilder;
    private LineType currentLineType = LineType.LAWN_SIZE;

    public LineReaderImpl(LawnBuilder lawnBuilder) {
        this.lawnBuilder = lawnBuilder;
    }

    public void readLine(String line) {
        if (LineType.LAWN_SIZE.equals(currentLineType)) {
            readLawnSizeLine(line);
        } else if (LineType.MOWER_INITIAL_POSITION.equals(currentLineType)) {
            readMowerInitialPositionLine(line);
        }
        switchToNextLineType();
    }

    private void readMowerInitialPositionLine(String line) {
        String[] initialPositionTokens = line.split(" ");
        int x = Integer.parseInt(initialPositionTokens[0]);
        int y = Integer.parseInt(initialPositionTokens[1]);
        char direction = initialPositionTokens[2].charAt(0);
        lawnBuilder.addMower(new Position(x, y), Direction.of(direction));
    }

    private void readLawnSizeLine(String line) {
        String[] sizeTokens = line.split(" ");
        int x = Integer.parseInt(sizeTokens[0]);
        int y = Integer.parseInt(sizeTokens[1]);
        lawnBuilder.withSize(new Position(x, y));
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
