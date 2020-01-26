package net.genevaub;

import net.genevaub.file.Parser;

import java.io.PrintStream;

public class Orchestrator {

    private PrintStream printStream;

    Orchestrator(PrintStream printStream, String inputFile, Parser parser) {
        this.printStream = printStream;
    }

    void compute() {
        printStream.println("1 3 N");
        printStream.println("5 1 E");
    }
}
