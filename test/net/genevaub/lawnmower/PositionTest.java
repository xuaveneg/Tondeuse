package net.genevaub.lawnmower;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PositionTest {

    @Test
    public void should_decrease_y_when_translating_south() {
        // GIVEN
        Position position = new Position(1, 2);

        // WHEN
        Position translated = position.translate(Direction.SOUTH, new Position(4, 4));

        // THEN
        assertEquals(new Position(1, 1), translated);
    }

    @Test
    public void should_increase_y_when_translating_north() {
        // GIVEN
        Position position = new Position(1, 2);

        // WHEN
        Position translated = position.translate(Direction.NORTH, new Position(4, 4));

        // THEN
        assertEquals(new Position(1, 3), translated);
    }

    @Test
    public void should_decrease_x_when_translating_west() {
        // GIVEN
        Position position = new Position(1, 2);

        // WHEN
        Position translated = position.translate(Direction.WEST, new Position(4, 4));

        // THEN
        assertEquals(new Position(0, 2), translated);
    }

    @Test
    public void should_increase_x_when_translating_east() {
        // GIVEN
        Position position = new Position(1, 2);

        // WHEN
        Position translated = position.translate(Direction.EAST, new Position(4, 4));

        // THEN
        assertEquals(new Position(2, 2), translated);
    }

    @Test
    public void should_not_decrease_y_when_translating_south_at_board_limit() {
        // GIVEN
        Position position = new Position(1, 0);

        // WHEN
        Position translated = position.translate(Direction.SOUTH, new Position(3, 2));

        // THEN
        assertEquals(new Position(1, 0), translated);
    }

    @Test
    public void should_not_increase_y_when_translating_north_at_board_limit() {
        // GIVEN
        Position position = new Position(1, 2);

        // WHEN
        Position translated = position.translate(Direction.NORTH, new Position(3, 2));

        // THEN
        assertEquals(new Position(1, 2), translated);
    }

    @Test
    public void should_not_decrease_x_when_translating_west_at_board_limit() {
        // GIVEN
        Position position = new Position(0, 2);

        // WHEN
        Position translated = position.translate(Direction.WEST, new Position(2, 3));

        // THEN
        assertEquals(new Position(0, 2), translated);
    }

    @Test
    public void should_not_increase_x_when_translating_east_at_board_limit() {
        // GIVEN
        Position position = new Position(2, 2);

        // WHEN
        Position translated = position.translate(Direction.EAST, new Position(2, 3));

        // THEN
        assertEquals(new Position(2, 2), translated);
    }
}
