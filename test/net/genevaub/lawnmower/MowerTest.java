package net.genevaub.lawnmower;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MowerTest {

    @Test
    public void should_move_mower_forward() throws LawnException {
        // GIVEN
        final Position initialPosition = new Position(2, 3);
        final Mower mower = new Mower(initialPosition, Direction.NORTH, new Position(4, 4));

        // WHEN
        mower.move(Move.FORWARD);

        // THEN
        assertEquals(new Mower(new Position(2, 4), Direction.NORTH, new Position(4, 4)), mower);
    }

    @Test
    public void should_turn_mower_left() throws LawnException {
        // GIVEN
        final Position initialPosition = new Position(2, 3);
        final Mower mower = new Mower(initialPosition, Direction.NORTH, new Position(4, 4));

        // WHEN
        mower.move(Move.LEFT);

        // THEN
        assertEquals(new Mower(new Position(2, 3), Direction.WEST, new Position(4, 4)), mower);
    }

    @Test
    public void should_turn_mower_right() throws LawnException {
        // GIVEN
        final Position initialPosition = new Position(2, 3);
        final Mower mower = new Mower(initialPosition, Direction.NORTH, new Position(4, 4));

        // WHEN
        mower.move(Move.RIGHT);

        // THEN
        assertEquals(new Mower(new Position(2, 3), Direction.EAST, new Position(4, 4)), mower);
    }

    @Test
    public void should_not_move_forward_when_mower_at_board_limit() throws LawnException {
        // GIVEN
        final Position initialPosition = new Position(2, 4);
        final Mower mower = new Mower(initialPosition, Direction.NORTH, new Position(4, 4));

        // WHEN
        mower.move(Move.FORWARD);

        // THEN
        assertEquals(new Mower(new Position(2, 4), Direction.NORTH, new Position(4, 4)), mower);
    }

    @Test
    public void should_move_correctly_for_move_sequence() throws LawnException {
        // GIVEN
        final Position initialPosition = new Position(4, 4);
        final Mower mower = new Mower(initialPosition, Direction.NORTH, new Position(4, 4));

        // WHEN
        mower.move(Move.FORWARD);
        mower.move(Move.RIGHT);
        mower.move(Move.FORWARD);
        mower.move(Move.RIGHT);
        mower.move(Move.FORWARD);
        mower.move(Move.RIGHT);
        mower.move(Move.FORWARD);
        mower.move(Move.LEFT);

        // THEN
        assertEquals(new Mower(new Position(3, 3), Direction.SOUTH, new Position(4, 4)), mower);
    }

    @Test
    public void should_print_mower() throws LawnException {
        // GIVEN
        final Mower mower = new Mower(new Position(2, 3), Direction.EAST, new Position(4, 4));
        final StringBuilder printer = new StringBuilder();

        // WHEN
        mower.print(printer);

        // THEN
        assertEquals("2 3 E", printer.toString());
    }

    @Test
    public void should_print_other_mower() throws LawnException {
        // GIVEN
        final Mower mower = new Mower(new Position(4, 1), Direction.WEST, new Position(4, 4));
        final StringBuilder printer = new StringBuilder();

        // WHEN
        mower.print(printer);

        // THEN
        assertEquals("4 1 W", printer.toString());
    }
}
