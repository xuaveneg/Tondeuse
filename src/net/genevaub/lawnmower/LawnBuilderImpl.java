package net.genevaub.lawnmower;

public class LawnBuilderImpl implements LawnBuilder {

    private Position size;

    @Override
    public LawnBuilder withSize(Position size) {
        this.size = size;
        return this;
    }

    @Override
    public Lawn build() {
        return new LawnImpl(size, new MowerListImpl());
    }
}
