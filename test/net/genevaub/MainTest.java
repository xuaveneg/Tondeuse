package net.genevaub;

import net.genevaub.file.LineReaderImpl;
import net.genevaub.file.Parser;
import net.genevaub.file.ParserImpl;
import net.genevaub.lawnmower.LawnBuilderImpl;
import net.genevaub.utils.FileUtils;
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
        final LawnBuilderImpl lawnBuilder = new LawnBuilderImpl();
        Parser fileParser = new ParserImpl(lawnBuilder, new LineReaderImpl(lawnBuilder));

        // WHEN
        testRunner.compute(fileParser, FileUtils.getTestResourceFile("input.txt"));

        // THEN
        String output = new String(outputStream.toByteArray());
        assertEquals("1 3 N\r\n" +
                "5 1 E\r\n", output);
    }
}
