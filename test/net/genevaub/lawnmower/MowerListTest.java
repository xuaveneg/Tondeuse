package net.genevaub.lawnmower;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MowerListTest {

    @Test
    public void should_add_and_move_mower_in_mower_list() {
        // GIVEN
        final MowerListImpl mowerList = new MowerListImpl();
        final Mower mower = new Mower(new Position(2, 3), Direction.SOUTH);

        // WHEN
        mowerList.addMower(mower);
        mowerList.moveLastMower(Move.FORWARD, new Position(4, 4));

        // THEN
        assertEquals(new Mower(new Position(2, 2), Direction.SOUTH), mower);
    }

    @Test
    public void should_add_and_not_move_not_last_mower_in_mower_list() {
        // GIVEN
        final MowerListImpl mowerList = new MowerListImpl();
        final Mower firstMower = new Mower(new Position(2, 3), Direction.SOUTH);
        final Mower lastMower = new Mower(new Position(2, 3), Direction.SOUTH);

        // WHEN
        mowerList.addMower(firstMower);
        mowerList.addMower(lastMower);
        mowerList.moveLastMower(Move.FORWARD, new Position(4, 4));

        // THEN
        assertEquals(new Mower(new Position(2, 3), Direction.SOUTH), firstMower);
    }

    @Test
    public void should_add_and_move_last_mower_in_mower_list() {
        // GIVEN
        final MowerListImpl mowerList = new MowerListImpl();
        final Mower firstMower = new Mower(new Position(2, 3), Direction.SOUTH);
        final Mower lastMower = new Mower(new Position(2, 3), Direction.SOUTH);

        // WHEN
        mowerList.addMower(firstMower);
        mowerList.addMower(lastMower);
        mowerList.moveLastMower(Move.RIGHT, new Position(4, 4));

        // THEN
        assertEquals(new Mower(new Position(2, 3), Direction.WEST), lastMower);
    }

    @Test
    public void should_print_single_mower_list() {
        // GIVEN
        final StringBuilder printer = new StringBuilder();
        final MowerList mowerList = new MowerListImpl();
        mowerList.addMower(new Mower(new Position(2, 3), Direction.SOUTH));

        // WHEN
        mowerList.print(printer);

        // THEN
        assertEquals("2 3 S", printer.toString());
    }

    @Test
    public void should_print_three_mowers_list() {
        // GIVEN
        final StringBuilder printer = new StringBuilder();
        final MowerList mowerList = new MowerListImpl();
        mowerList.addMower(new Mower(new Position(2, 3), Direction.SOUTH));
        mowerList.addMower(new Mower(new Position(1, 4), Direction.NORTH));
        mowerList.addMower(new Mower(new Position(0, 2), Direction.EAST));

        // WHEN
        mowerList.print(printer);

        // THEN
        assertEquals("2 3 S\n1 4 N\n0 2 E", printer.toString());
    }
}
