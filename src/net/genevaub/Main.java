package net.genevaub;

import net.genevaub.file.LineReader;
import net.genevaub.file.LineReaderImpl;
import net.genevaub.file.Parser;
import net.genevaub.file.ParserImpl;
import net.genevaub.lawnmower.LawnBuilder;
import net.genevaub.lawnmower.LawnBuilderImpl;

public class Main {

    public static void main(final String[] args) {
        final LawnBuilder lawnBuilder = new LawnBuilderImpl(System.out);
        final LineReader lineReader = new LineReaderImpl(lawnBuilder);
        final Parser fileParser = new ParserImpl(lineReader);
        final String fileName = args[0];
        fileParser.parse(fileName);
    }

}
