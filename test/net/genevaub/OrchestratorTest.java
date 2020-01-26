package net.genevaub;

import net.genevaub.mocks.ParserMock;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class OrchestratorTest {

    @Test
    public void should_parse_input_file() {
        // GIVEN
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        Orchestrator testRunner = new Orchestrator(printStream);
        ParserMock parserMock = new ParserMock();

        // WHEN
        testRunner.compute(parserMock, "input.txt");

        // THEN
        assertEquals("input.txt", parserMock.getInput());
    }
}
