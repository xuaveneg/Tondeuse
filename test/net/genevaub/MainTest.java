package net.genevaub;

import net.genevaub.file.*;
import net.genevaub.lawnmower.LawnBuilder;
import net.genevaub.lawnmower.LawnBuilderImpl;
import net.genevaub.lawnmower.LawnException;
import net.genevaub.utils.FileUtils;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void should_handle_main_test_from_pdf() throws ParserException, LawnException {
        // GIVEN
        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        final PrintStream printStream = new PrintStream(outputStream);
        final LawnBuilder lawnBuilder = new LawnBuilderImpl(printStream);
        final LineReader lineReader = new LineReaderImpl(lawnBuilder);
        final Parser fileParser = new ParserImpl(lineReader);

        // WHEN
        fileParser.parse(FileUtils.getTestResourceFile("input.txt"));

        // THEN
        final String output = new String(outputStream.toByteArray());
        assertEquals("1 3 N\n" +
                "5 1 E", output);
    }
}
