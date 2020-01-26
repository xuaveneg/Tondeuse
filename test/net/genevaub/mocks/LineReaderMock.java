package net.genevaub.mocks;

import net.genevaub.file.LineReader;

public class LineReaderMock implements LineReader {
    private int nLineRead;

    @Override
    public void readLine(final String line) {
        nLineRead++;
    }

    @Override
    public void print() {

    }

    public int getNLineRead() {
        return nLineRead;
    }
}
