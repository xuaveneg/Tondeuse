package net.genevaub;

import net.genevaub.file.LineReaderImpl;
import net.genevaub.file.Parser;
import net.genevaub.file.ParserImpl;
import net.genevaub.lawnmower.LawnBuilderImpl;

public class Main {

    public static void main(String[] args) {
        Orchestrator runner = new Orchestrator(System.out);
        final LawnBuilderImpl lawnBuilder = new LawnBuilderImpl();
        LineReaderImpl lineReader = new LineReaderImpl(lawnBuilder);
        Parser fileParser = new ParserImpl(lineReader);
        String fileName = args[0];
        runner.compute(fileParser, fileName);
    }

}
