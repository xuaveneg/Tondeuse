package net.genevaub.lawnmower;

import net.genevaub.mocks.MowerListMock;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class LawnTest {

    @Test
    public void should_add_one_mower_on_lawn() {
        // GIVEN
        MowerListMock mowerListMock = new MowerListMock();
        Lawn lawn = new LawnImpl(new Position(4, 4), mowerListMock, null);

        // WHEN
        lawn.addMower(new Position(3, 3), Direction.SOUTH);

        // THEN
        assertEquals(1, mowerListMock.getSize());
    }

    @Test
    public void should_add_three_mower_on_lawn() {
        // GIVEN
        MowerListMock mowerListMock = new MowerListMock();
        Lawn lawn = new LawnImpl(new Position(4, 4), mowerListMock, null);

        // WHEN
        lawn.addMower(new Position(3, 3), Direction.SOUTH);
        lawn.addMower(new Position(3, 3), Direction.NORTH);
        lawn.addMower(new Position(3, 3), Direction.EAST);

        // THEN
        assertEquals(3, mowerListMock.getSize());
    }

    @Test
    public void should_move_mower_on_lawn() {
        // GIVEN
        MowerListMock mowerListMock = new MowerListMock();
        Lawn lawn = new LawnImpl(new Position(4, 4), mowerListMock, null);

        // WHEN
        lawn.addMower(new Position(3, 3), Direction.EAST);
        lawn.moveLastMower(Move.FORWARD);

        // THEN
        assertArrayEquals(Collections.singletonList(Move.FORWARD).toArray(), mowerListMock.getMoves(0).toArray());
    }

    @Test
    public void should_move_last_mower_on_lawn() {
        // GIVEN
        MowerListMock mowerListMock = new MowerListMock();
        Lawn lawn = new LawnImpl(new Position(4, 4), mowerListMock, null);

        // WHEN
        lawn.addMower(new Position(3, 3), Direction.EAST);
        lawn.addMower(new Position(3, 3), Direction.NORTH);
        lawn.addMower(new Position(3, 3), Direction.EAST);
        lawn.moveLastMower(Move.FORWARD);
        lawn.moveLastMower(Move.RIGHT);

        // THEN
        assertArrayEquals(Arrays.asList(Move.FORWARD, Move.RIGHT).toArray(), mowerListMock.getMoves(2).toArray());
    }

    @Test
    public void should_move_intermediate_mower_on_lawn() {
        // GIVEN
        MowerListMock mowerListMock = new MowerListMock();
        Lawn lawn = new LawnImpl(new Position(4, 4), mowerListMock, null);

        // WHEN
        lawn.addMower(new Position(3, 3), Direction.EAST);
        lawn.addMower(new Position(3, 3), Direction.NORTH);
        lawn.moveLastMower(Move.LEFT);
        lawn.moveLastMower(Move.FORWARD);
        lawn.addMower(new Position(3, 3), Direction.EAST);
        lawn.moveLastMower(Move.FORWARD);
        lawn.moveLastMower(Move.RIGHT);

        // THEN
        assertArrayEquals(Arrays.asList(Move.LEFT, Move.FORWARD).toArray(), mowerListMock.getMoves(1).toArray());
    }

    @Test
    public void should_print_in_stream_when_calling_print() {
        // GIVEN
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        MowerList mowerList = new MowerListImpl();
        Lawn lawn = new LawnImpl(new Position(4, 4), mowerList, printStream);
        lawn.addMower(new Position(3, 3), Direction.EAST);
        lawn.addMower(new Position(3, 3), Direction.NORTH);
        lawn.moveLastMower(Move.LEFT);
        lawn.moveLastMower(Move.FORWARD);
        lawn.addMower(new Position(3, 3), Direction.EAST);
        lawn.moveLastMower(Move.FORWARD);
        lawn.moveLastMower(Move.RIGHT);

        // WHEN
        lawn.print();

        // THEN
        String output = new String(outputStream.toByteArray());
        assertEquals("3 3 E\n" +
                "2 3 W\n" +
                "4 3 S", output);
    }
}
