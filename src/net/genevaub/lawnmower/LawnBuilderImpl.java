package net.genevaub.lawnmower;

import java.io.PrintStream;

public class LawnBuilderImpl implements LawnBuilder {
    private final PrintStream stream;
    private Position size;

    public LawnBuilderImpl(PrintStream stream) {
        this.stream = stream;
    }

    @Override
    public LawnBuilder withSize(Position size) {
        this.size = size;
        return this;
    }

    @Override
    public Lawn build() {
        return new LawnImpl(size, new MowerListImpl(), stream);
    }
}
