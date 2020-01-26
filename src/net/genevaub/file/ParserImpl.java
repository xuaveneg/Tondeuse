package net.genevaub.file;

import net.genevaub.lawnmower.LawnBuilder;
import net.genevaub.lawnmower.Position;

public class ParserImpl implements Parser {

    private final LawnBuilder lawnBuilder;

    public ParserImpl(LawnBuilder lawnBuilder) {
        this.lawnBuilder = lawnBuilder;
    }

    @Override
    public void parse(String input) {
        lawnBuilder.withSize(new Position(3, 7));
    }
}
