package net.genevaub.file;

import net.genevaub.lawnmower.LawnException;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public final class ParserImpl implements Parser {
    private final LineReader lineReader;

    public ParserImpl(final LineReader lineReader) {
        this.lineReader = lineReader;
    }

    @Override
    public void parse(final String input) throws ParserException, LawnException {
        try (final FileInputStream inputStream = new FileInputStream(input)) {
            readInputStream(inputStream);
        } catch (final IOException e) {
            throw new ParserException(e);
        }
    }

    private void readInputStream(final FileInputStream inputStream) throws IOException, ParserException, LawnException {
        try (final InputStreamReader reader = new InputStreamReader(inputStream)) {
            readBuffered(new BufferedReader(reader));
        }
    }

    private void readBuffered(final BufferedReader bufferedReader) throws IOException, ParserException, LawnException {
        String line = bufferedReader.readLine();
        while (line != null) {
            readLine(line);
            line = bufferedReader.readLine();
        }
        lineReader.print();
    }

    private void readLine(final String line) throws ParserException, LawnException {
        lineReader.readLine(line);
    }
}
