package net.genevaub.file;

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
            String[] sizeTokens = line.split(" ");
            int x = Integer.parseInt(sizeTokens[0]);
            int y = Integer.parseInt(sizeTokens[1]);
            lawnBuilder.withSize(new Position(x, y));
        }
        switchToNextLineType();
    }

    private void switchToNextLineType() {
        switch (currentLineType) {
            case LAWN_SIZE:
            case MOWER_MOVES:
                currentLineType = LineType.MOWER_INITIAL_POSITION;
            case MOWER_INITIAL_POSITION:
                currentLineType = LineType.MOWER_MOVES;
        }
    }
}
