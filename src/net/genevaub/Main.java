package net.genevaub;

import net.genevaub.file.LineReader;
import net.genevaub.file.LineReaderImpl;
import net.genevaub.file.Parser;
import net.genevaub.file.ParserImpl;
import net.genevaub.lawnmower.LawnBuilder;
import net.genevaub.lawnmower.LawnBuilderImpl;
import net.genevaub.lawnmower.LawnImpl;

public class Main {

    public static void main(String[] args) {
        Orchestrator runner = new Orchestrator(System.out);
        LawnBuilder lawnBuilder = new LawnBuilderImpl();
        LineReader lineReader = new LineReaderImpl(lawnBuilder);
        Parser fileParser = new ParserImpl(lineReader);
        String fileName = args[0];
        runner.compute(fileParser, fileName);
    }

}
