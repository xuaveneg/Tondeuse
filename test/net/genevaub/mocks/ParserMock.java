package net.genevaub.mocks;

import net.genevaub.file.Parser;

public class ParserMock implements Parser {

    private String input;

    @Override
    public void parse(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }
}
