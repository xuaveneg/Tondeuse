package net.genevaub.lawnmower;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PositionTest {

    @Test
    public void should_decrease_y_when_translating_south() throws LawnException {
        // GIVEN
        final Position position = new Position(1, 2);

        // WHEN
        final Position translated = position.translate(Direction.SOUTH, new Position(4, 4));

        // THEN
        assertEquals(new Position(1, 1), translated);
    }

    @Test
    public void should_increase_y_when_translating_north() throws LawnException {
        // GIVEN
        final Position position = new Position(1, 2);

        // WHEN
        final Position translated = position.translate(Direction.NORTH, new Position(4, 4));

        // THEN
        assertEquals(new Position(1, 3), translated);
    }

    @Test
    public void should_decrease_x_when_translating_west() throws LawnException {
        // GIVEN
        final Position position = new Position(1, 2);

        // WHEN
        final Position translated = position.translate(Direction.WEST, new Position(4, 4));

        // THEN
        assertEquals(new Position(0, 2), translated);
    }

    @Test
    public void should_increase_x_when_translating_east() throws LawnException {
        // GIVEN
        final Position position = new Position(1, 2);

        // WHEN
        final Position translated = position.translate(Direction.EAST, new Position(4, 4));

        // THEN
        assertEquals(new Position(2, 2), translated);
    }

    @Test
    public void should_not_decrease_y_when_translating_south_at_board_limit() throws LawnException {
        // GIVEN
        final Position position = new Position(1, 0);

        // WHEN
        final Position translated = position.translate(Direction.SOUTH, new Position(3, 2));

        // THEN
        assertEquals(new Position(1, 0), translated);
    }

    @Test
    public void should_not_increase_y_when_translating_north_at_board_limit() throws LawnException {
        // GIVEN
        final Position position = new Position(1, 2);

        // WHEN
        final Position translated = position.translate(Direction.NORTH, new Position(3, 2));

        // THEN
        assertEquals(new Position(1, 2), translated);
    }

    @Test
    public void should_not_decrease_x_when_translating_west_at_board_limit() throws LawnException {
        // GIVEN
        final Position position = new Position(0, 2);

        // WHEN
        final Position translated = position.translate(Direction.WEST, new Position(2, 3));

        // THEN
        assertEquals(new Position(0, 2), translated);
    }

    @Test
    public void should_not_increase_x_when_translating_east_at_board_limit() throws LawnException {
        // GIVEN
        final Position position = new Position(2, 2);

        // WHEN
        final Position translated = position.translate(Direction.EAST, new Position(2, 3));

        // THEN
        assertEquals(new Position(2, 2), translated);
    }

    @Test
    public void should_print_position_in_string_builder() throws LawnException {
        // GIVEN
        final Position position = new Position(2, 3);
        final StringBuilder printer = new StringBuilder();

        // WHEN
        position.print(printer);

        // THEN
        assertEquals("2 3", printer.toString());
    }

    @Test
    public void should_print_other_position_in_string_builder() throws LawnException {
        // GIVEN
        final Position position = new Position(5, 4);
        final StringBuilder printer = new StringBuilder();

        // WHEN
        position.print(printer);

        // THEN
        assertEquals("5 4", printer.toString());
    }

    @Test(expected = LawnException.class)
    public void should_fail_with_negative_x() throws LawnException {
        // GIVEN

        // WHEN
        new Position(-1, 1);
    }

    @Test(expected = LawnException.class)
    public void should_fail_with_negative_y() throws LawnException {
        // GIVEN

        // WHEN
        new Position(1, -1);
    }
}
