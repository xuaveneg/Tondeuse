package net.genevaub;

import net.genevaub.file.Parser;
import net.genevaub.file.ParserImpl;

public class Main {

    public static void main(String[] args) {
        Parser fileParser = new ParserImpl();
        String fileName = args[0];
        Orchestrator runner = new Orchestrator(System.out, fileName, fileParser);
        runner.compute();
    }

}
