package net.genevaub.mocks;

import net.genevaub.file.LineReader;

public class LineReaderMock implements LineReader {
    private int nLineRead;

    @Override
    public void readLine(String line) {
        nLineRead++;
    }

    public int getNLineRead() {
        return nLineRead;
    }
}
