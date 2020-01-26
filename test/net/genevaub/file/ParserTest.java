package net.genevaub.file;

import net.genevaub.lawnmower.Position;
import net.genevaub.mocks.LawnBuilderMock;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTest {

    @Test
    public void should_create_lawn_with_right_size_from_first_line() {
        // GIVEN
        LawnBuilderMock lawnBuilderMock = new LawnBuilderMock();
        Parser parser = new ParserImpl(lawnBuilderMock);

        // WHEN
        parser.parse("one-line-file.txt");

        // THEN
        assertEquals(new Position(3, 7), lawnBuilderMock.getSize());
    }
}
