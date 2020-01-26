package net.genevaub.file;

public interface LineReader {
    void readLine(String line) throws ParserException;

    void print();
}
