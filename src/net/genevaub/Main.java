package net.genevaub;

import net.genevaub.file.LineReaderImpl;
import net.genevaub.file.Parser;
import net.genevaub.file.ParserImpl;
import net.genevaub.lawnmower.LawnBuilderImpl;

public class Main {

    public static void main(String[] args) {
        Orchestrator runner = new Orchestrator(System.out);
        final LawnBuilderImpl lawnBuilder = new LawnBuilderImpl();
        Parser fileParser = new ParserImpl(lawnBuilder, new LineReaderImpl(lawnBuilder));
        String fileName = args[0];
        runner.compute(fileParser, fileName);
    }

}
