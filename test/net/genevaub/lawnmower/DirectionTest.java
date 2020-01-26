package net.genevaub.lawnmower;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class DirectionTest {

    @Test
    public void should_find_south_direction_for_s() {
        // GIVEN

        // WHEN
        Optional<Direction> s = Direction.of('S');

        // THEN
        assertEquals(Optional.of(Direction.SOUTH), s);
    }

    @Test
    public void should_find_north_direction_for_n() {
        // GIVEN

        // WHEN
        Optional<Direction> n = Direction.of('N');

        // THEN
        assertEquals(Optional.of(Direction.NORTH), n);
    }

    @Test
    public void should_find_east_direction_for_e() {
        // GIVEN

        // WHEN
        Optional<Direction> e = Direction.of('E');

        // THEN
        assertEquals(Optional.of(Direction.EAST), e);
    }

    @Test
    public void should_find_west_direction_for_w() {
        // GIVEN

        // WHEN
        Optional<Direction> w = Direction.of('W');

        // THEN
        assertEquals(Optional.of(Direction.WEST), w);
    }

    @Test
    public void should_find_no_direction_for_unknown_direction() {
        // GIVEN

        // WHEN
        Optional<Direction> a = Direction.of('A');

        // THEN
        assertEquals(Optional.empty(), a);
    }

    @Test
    public void should_turn_south_from_west_when_left() {
        // GIVEN
        Direction direction = Direction.WEST;

        // WHEN
        Direction rotated = direction.rotate(Move.LEFT);

        // THEN
        assertEquals(Direction.SOUTH, rotated);
    }

    @Test
    public void should_turn_east_from_south_when_left() {
        // GIVEN
        Direction direction = Direction.SOUTH;

        // WHEN
        Direction rotated = direction.rotate(Move.LEFT);

        // THEN
        assertEquals(Direction.EAST, rotated);
    }

    @Test
    public void should_turn_west_from_north_when_left() {
        // GIVEN
        Direction direction = Direction.NORTH;

        // WHEN
        Direction rotated = direction.rotate(Move.LEFT);

        // THEN
        assertEquals(Direction.WEST, rotated);
    }

    @Test
    public void should_turn_north_from_east_when_left() {
        // GIVEN
        Direction direction = Direction.EAST;

        // WHEN
        Direction rotated = direction.rotate(Move.LEFT);

        // THEN
        assertEquals(Direction.NORTH, rotated);
    }

    @Test
    public void should_turn_north_from_west_when_right() {
        // GIVEN
        Direction direction = Direction.WEST;

        // WHEN
        Direction rotated = direction.rotate(Move.RIGHT);

        // THEN
        assertEquals(Direction.NORTH, rotated);
    }

    @Test
    public void should_turn_west_from_south_when_right() {
        // GIVEN
        Direction direction = Direction.SOUTH;

        // WHEN
        Direction rotated = direction.rotate(Move.RIGHT);

        // THEN
        assertEquals(Direction.WEST, rotated);
    }

    @Test
    public void should_turn_east_from_north_when_right() {
        // GIVEN
        Direction direction = Direction.NORTH;

        // WHEN
        Direction rotated = direction.rotate(Move.RIGHT);

        // THEN
        assertEquals(Direction.EAST, rotated);
    }

    @Test
    public void should_turn_south_from_east_when_right() {
        // GIVEN
        Direction direction = Direction.EAST;

        // WHEN
        Direction rotated = direction.rotate(Move.RIGHT);

        // THEN
        assertEquals(Direction.SOUTH, rotated);
    }

    @Test
    public void should_not_turn_from_west_when_forward() {
        // GIVEN
        Direction direction = Direction.WEST;

        // WHEN
        Direction rotated = direction.rotate(Move.FORWARD);

        // THEN
        assertEquals(Direction.WEST, rotated);
    }

    @Test
    public void should_not_turn_from_south_when_forward() {
        // GIVEN
        Direction direction = Direction.SOUTH;

        // WHEN
        Direction rotated = direction.rotate(Move.FORWARD);

        // THEN
        assertEquals(Direction.SOUTH, rotated);
    }

    @Test
    public void should_not_turn_from_north_when_forward() {
        // GIVEN
        Direction direction = Direction.NORTH;

        // WHEN
        Direction rotated = direction.rotate(Move.FORWARD);

        // THEN
        assertEquals(Direction.NORTH, rotated);
    }

    @Test
    public void should_not_turn_from_east_when_forward() {
        // GIVEN
        Direction direction = Direction.EAST;

        // WHEN
        Direction rotated = direction.rotate(Move.FORWARD);

        // THEN
        assertEquals(Direction.EAST, rotated);
    }

    @Test
    public void should_print_east() {
        // GIVEN
        StringBuilder printer = new StringBuilder();

        // WHEN
        Direction.EAST.print(printer);

        // THEN
        assertEquals("E", printer.toString());
    }

    @Test
    public void should_print_north() {
        // GIVEN
        StringBuilder printer = new StringBuilder();

        // WHEN
        Direction.NORTH.print(printer);

        // THEN
        assertEquals("N", printer.toString());
    }

    @Test
    public void should_print_south() {
        // GIVEN
        StringBuilder printer = new StringBuilder();

        // WHEN
        Direction.SOUTH.print(printer);

        // THEN
        assertEquals("S", printer.toString());
    }

    @Test
    public void should_print_west() {
        // GIVEN
        StringBuilder printer = new StringBuilder();

        // WHEN
        Direction.WEST.print(printer);

        // THEN
        assertEquals("W", printer.toString());
    }
}
