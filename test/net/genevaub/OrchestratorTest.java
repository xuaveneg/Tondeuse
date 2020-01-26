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
        ParserMock parserMock = new ParserMock();
        Orchestrator testRunner = new Orchestrator(printStream, "input.txt", parserMock);

        // WHEN
        testRunner.compute();

        // THEN
        assertEquals("input.txt", parserMock.getInput());
    }
}
