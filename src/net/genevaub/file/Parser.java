package net.genevaub.file;

import net.genevaub.lawnmower.LawnException;

public interface Parser {
    void parse(String input) throws ParserException, LawnException;
}
