package net.genevaub.mocks;

import net.genevaub.lawnmower.Lawn;
import net.genevaub.lawnmower.LawnBuilder;
import net.genevaub.lawnmower.Position;

public class LawnBuilderMock implements LawnBuilder {
    private Position size;
    private LawnMock lawnMock;

    @Override
    public LawnBuilder withSize(final Position size) {
        this.size = size;
        return this;
    }

    @Override
    public Lawn build() {
        lawnMock = new LawnMock(size);
        return lawnMock;
    }

    public Position getSize() {
        return size;
    }

    public LawnMock getLawnMock() {
        return lawnMock;
    }
}
