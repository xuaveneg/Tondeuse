package net.genevaub.lawnmower;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class MoveTest {

    @Test
    public void should_find_move_d() {
        // GIVEN

        // WHEN
        final Optional<Move> d = Move.of('D');

        // THEN
        assertEquals(Optional.of(Move.RIGHT), d);
    }

    @Test
    public void should_find_move_g() {
        // GIVEN

        // WHEN
        final Optional<Move> g = Move.of('G');

        // THEN
        assertEquals(Optional.of(Move.LEFT), g);
    }

    @Test
    public void should_find_move_a() {
        // GIVEN

        // WHEN
        final Optional<Move> a = Move.of('A');

        // THEN
        assertEquals(Optional.of(Move.FORWARD), a);
    }

    @Test
    public void should_not_find_unknown_move() {
        // GIVEN

        // WHEN
        final Optional<Move> k = Move.of('K');

        // THEN
        assertEquals(Optional.empty(), k);
    }
}
