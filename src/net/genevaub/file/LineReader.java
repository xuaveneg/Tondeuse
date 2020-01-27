package net.genevaub.file;

import net.genevaub.lawnmower.LawnException;

public interface LineReader {
    void readLine(String line) throws ParserException, LawnException;

    void print();
}
