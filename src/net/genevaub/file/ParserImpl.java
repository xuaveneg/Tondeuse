package net.genevaub.file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ParserImpl implements Parser {
    private final LineReader lineReader;

    public ParserImpl(final LineReader lineReader) {
        this.lineReader = lineReader;
    }

    @Override
    public void parse(final String input) {
        try (final FileInputStream inputStream = new FileInputStream(input)) {
            readInputStream(inputStream);
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    private void readInputStream(final FileInputStream inputStream) throws IOException {
        try (final InputStreamReader reader = new InputStreamReader(inputStream)) {
            readBuffered(new BufferedReader(reader));
        }
    }

    private void readBuffered(final BufferedReader bufferedReader) throws IOException {
        String line = bufferedReader.readLine();
        while (line != null) {
            readLine(line);
            line = bufferedReader.readLine();
        }
        lineReader.print();
    }

    private void readLine(final String line) {
        lineReader.readLine(line);
    }
}
