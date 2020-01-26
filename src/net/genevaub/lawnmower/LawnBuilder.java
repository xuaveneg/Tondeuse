package net.genevaub.lawnmower;

public interface LawnBuilder {
    LawnBuilder withSize(Position size);

    Lawn build();
}
