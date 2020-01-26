package net.genevaub;

import net.genevaub.file.Parser;
import net.genevaub.file.ParserImpl;

public class Main {

    public static void main(String[] args) {
        Orchestrator runner = new Orchestrator(System.out);
        Parser fileParser = new ParserImpl();
        String fileName = args[0];
        runner.compute(fileParser, fileName);
    }

}
