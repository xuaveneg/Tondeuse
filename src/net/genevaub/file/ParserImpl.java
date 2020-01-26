package net.genevaub.file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ParserImpl implements Parser {
    private final LineReader lineReader;

    public ParserImpl(LineReader lineReader) {
        this.lineReader = lineReader;
    }

    @Override
    public void parse(String input) {
        try (FileInputStream inputStream = new FileInputStream(input)) {
            readInputStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readInputStream(FileInputStream inputStream) throws IOException {
        try (InputStreamReader reader = new InputStreamReader(inputStream)) {
            readBuffered(new BufferedReader(reader));
        }
    }

    private void readBuffered(BufferedReader bufferedReader) throws IOException {
        String line = bufferedReader.readLine();
        while (line != null) {
            readLine(line);
            line = bufferedReader.readLine();
        }
        lineReader.print();
    }

    private void readLine(String line) {
        lineReader.readLine(line);
    }
}
