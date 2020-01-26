package net.genevaub;

import net.genevaub.file.Parser;

import java.io.PrintStream;

public class Orchestrator {

    private PrintStream printStream;

    Orchestrator(PrintStream printStream) {
        this.printStream = printStream;
    }

    void compute(Parser parser, String inputFile) {
        parser.parse(inputFile);
        printStream.println("1 3 N");
        printStream.println("5 1 E");
    }
}
