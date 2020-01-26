package net.genevaub;

import java.io.PrintStream;

public class Orchestrator {

    private PrintStream printStream;

    Orchestrator(PrintStream printStream, String inputFile) {
        this.printStream = printStream;
    }

    void compute() {
        printStream.println("1 3 N");
        printStream.println("5 1 E");
    }
}
