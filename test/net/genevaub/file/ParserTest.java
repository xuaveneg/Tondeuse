package net.genevaub.file;

import net.genevaub.lawnmower.Position;
import net.genevaub.mocks.LawnBuilderMock;
import net.genevaub.mocks.LineReaderMock;
import net.genevaub.utils.FileUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTest {

    @Test
    public void should_create_lawn_with_right_size_from_first_line() {
        // GIVEN
        LawnBuilderMock lawnBuilderMock = new LawnBuilderMock();
        Parser parser = new ParserImpl(new LineReaderImpl(lawnBuilderMock));

        // WHEN
        parser.parse(FileUtils.getTestResourceFile("one-line-file.txt"));

        // THEN
        assertEquals(new Position(3, 7), lawnBuilderMock.getSize());
    }

    @Test
    public void should_read_one_line() {
        // GIVEN
        LineReaderMock lineReaderMock = new LineReaderMock();
        Parser parser = new ParserImpl(lineReaderMock);

        // WHEN
        parser.parse(FileUtils.getTestResourceFile("one-line-file.txt"));

        // THEN
        assertEquals(1, lineReaderMock.getNLineRead());
    }

    @Test
    public void should_read_three_line() {
        // GIVEN
        LineReaderMock lineReaderMock = new LineReaderMock();
        Parser parser = new ParserImpl(lineReaderMock);

        // WHEN
        parser.parse(FileUtils.getTestResourceFile("one-mower-file.txt"));

        // THEN
        assertEquals(3, lineReaderMock.getNLineRead());
    }

    @Test
    public void should_read_five_line() {
        // GIVEN
        LineReaderMock lineReaderMock = new LineReaderMock();
        Parser parser = new ParserImpl(lineReaderMock);

        // WHEN
        parser.parse(FileUtils.getTestResourceFile("input.txt"));

        // THEN
        assertEquals(5, lineReaderMock.getNLineRead());
    }
}