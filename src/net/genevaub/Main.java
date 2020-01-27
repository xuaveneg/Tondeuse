package net.genevaub;

import net.genevaub.file.*;
import net.genevaub.lawnmower.LawnBuilder;
import net.genevaub.lawnmower.LawnBuilderImpl;
import net.genevaub.lawnmower.LawnException;

public class Main {

    public static void main(final String[] args) throws ParserException, LawnException {
        final LawnBuilder lawnBuilder = new LawnBuilderImpl(System.out);
        final LineReader lineReader = new LineReaderImpl(lawnBuilder);
        final Parser fileParser = new ParserImpl(lineReader);
        final String fileName = args[0];
        fileParser.parse(fileName);
    }

}
