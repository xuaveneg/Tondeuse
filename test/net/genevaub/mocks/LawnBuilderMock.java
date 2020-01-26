package net.genevaub.mocks;

import net.genevaub.lawnmower.LawnBuilder;
import net.genevaub.lawnmower.Position;

public class LawnBuilderMock implements LawnBuilder {
    private Position size;

    @Override
    public void withSize(Position size) {
        this.size = size;
    }

    public Position getSize() {
        return size;
    }
}
