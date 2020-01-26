package net.genevaub.file;

import net.genevaub.lawnmower.Position;
import net.genevaub.mocks.LawnBuilderMock;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LineReaderTest {

    @Test
    public void should_read_lawn_size_on_lawn_size_line() {
        // GIVEN
        LawnBuilderMock lawnBuilderMock = new LawnBuilderMock();
        LineReader lineReader = new LineReaderImpl(lawnBuilderMock);

        // WHEN
        lineReader.readLine("3 4");

        // THEN
        assertEquals(new Position(3, 4), lawnBuilderMock.getSize());
    }
}
