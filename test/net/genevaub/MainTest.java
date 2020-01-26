package net.genevaub;

import net.genevaub.file.Parser;
import net.genevaub.file.ParserImpl;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void should_handle_main_test_from_pdf() {
        // GIVEN
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        Orchestrator testRunner = new Orchestrator(printStream);
        Parser fileParser = new ParserImpl();

        // WHEN
        testRunner.compute(fileParser, "input.txt");

        // THEN
        String output = new String(outputStream.toByteArray());
        assertEquals("1 3 N\r\n" +
                "5 1 E\r\n", output);
    }
}
