package net.genevaub;

public class Main {

    public static void main(String[] args) {
        Orchestrator runner = new Orchestrator(System.out, args[0], null);
        runner.compute();
    }

}
