package net.genevaub.file;

import net.genevaub.lawnmower.Direction;
import net.genevaub.lawnmower.Mower;
import net.genevaub.lawnmower.Position;
import net.genevaub.mocks.LawnBuilderMock;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LineReaderTest {

    @Test
    public void should_read_lawn_size_on_first_line() {
        // GIVEN
        final LawnBuilderMock lawnBuilderMock = new LawnBuilderMock();
        final LineReader lineReader = new LineReaderImpl(lawnBuilderMock);

        // WHEN
        lineReader.readLine("3 4");

        // THEN
        assertEquals(new Position(3, 4), lawnBuilderMock.getSize());
    }

    @Test
    public void should_read_mower_initial_position_on_second_line() {
        // GIVEN
        final LawnBuilderMock lawnBuilderMock = new LawnBuilderMock();
        final LineReader lineReader = new LineReaderImpl(lawnBuilderMock);

        // WHEN
        lineReader.readLine("4 5");
        lineReader.readLine("1 2 N");

        // THEN
        assertEquals(new Mower(new Position(1, 2), Direction.NORTH),
                lawnBuilderMock.getLawnMock().getMowers().get(0));
    }

    @Test
    public void should_read_mower_moves_on_third_line() {
        // GIVEN
        final LawnBuilderMock lawnBuilderMock = new LawnBuilderMock();
        final LineReader lineReader = new LineReaderImpl(lawnBuilderMock);

        // WHEN
        lineReader.readLine("5 4");
        lineReader.readLine("2 3 S");
        lineReader.readLine("ADDAGADA");

        // THEN
        assertEquals(new Mower(new Position(1, 4), Direction.NORTH),
                lawnBuilderMock.getLawnMock().getMowers().get(0));
    }
}
