package net.genevaub.lawnmower;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MowerTest {

    @Test
    public void should_move_mower_forward() {
        // GIVEN
        Position initialPosition = new Position(2, 3);
        Mower mower = new Mower(initialPosition, Direction.NORTH);

        // WHEN
        mower.move(Move.FORWARD, new Position(4, 4));

        // THEN
        assertEquals(new Mower(new Position(2, 4), Direction.NORTH), mower);
    }

    @Test
    public void should_turn_mower_left() {
        // GIVEN
        Position initialPosition = new Position(2, 3);
        Mower mower = new Mower(initialPosition, Direction.NORTH);

        // WHEN
        mower.move(Move.LEFT, new Position(4, 4));

        // THEN
        assertEquals(new Mower(new Position(2, 3), Direction.WEST), mower);
    }

    @Test
    public void should_turn_mower_right() {
        // GIVEN
        Position initialPosition = new Position(2, 3);
        Mower mower = new Mower(initialPosition, Direction.NORTH);

        // WHEN
        mower.move(Move.RIGHT, new Position(4, 4));

        // THEN
        assertEquals(new Mower(new Position(2, 3), Direction.EAST), mower);
    }

    @Test
    public void should_not_move_forward_when_mower_at_board_limit() {
        // GIVEN
        Position initialPosition = new Position(2, 4);
        Mower mower = new Mower(initialPosition, Direction.NORTH);

        // WHEN
        mower.move(Move.FORWARD, new Position(4, 4));

        // THEN
        assertEquals(new Mower(new Position(2, 4), Direction.NORTH), mower);
    }

    @Test
    public void should_move_correctly_for_move_sequence() {
        // GIVEN
        Position initialPosition = new Position(4, 4);
        Mower mower = new Mower(initialPosition, Direction.NORTH);

        // WHEN
        mower.move(Move.FORWARD, new Position(4, 4));
        mower.move(Move.RIGHT, new Position(4, 4));
        mower.move(Move.FORWARD, new Position(4, 4));
        mower.move(Move.RIGHT, new Position(4, 4));
        mower.move(Move.FORWARD, new Position(4, 4));
        mower.move(Move.RIGHT, new Position(4, 4));
        mower.move(Move.FORWARD, new Position(4, 4));
        mower.move(Move.LEFT, new Position(4, 4));

        // THEN
        assertEquals(new Mower(new Position(3, 3), Direction.SOUTH), mower);
    }

    @Test
    public void should_print_mower() {
        // GIVEN
        Mower mower = new Mower(new Position(2, 3), Direction.EAST);
        StringBuilder printer = new StringBuilder();

        // WHEN
        mower.print(printer);

        // THEN
        assertEquals("2 3 E", printer.toString());
    }

    @Test
    public void should_print_other_mower() {
        // GIVEN
        Mower mower = new Mower(new Position(4, 1), Direction.WEST);
        StringBuilder printer = new StringBuilder();

        // WHEN
        mower.print(printer);

        // THEN
        assertEquals("4 1 W", printer.toString());
    }
}
