package net.genevaub.lawnmower;

import net.genevaub.mocks.MowerListMock;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LawnBuilderTest {

    @Test
    public void should_build_lawn_with_correct_size() {
        // GIVEN
        LawnBuilder lawnBuilder = new LawnBuilderImpl();

        // WHEN
        Lawn lawn = lawnBuilder.withSize(new Position(4, 5))
                .build();

        // THEN
        assertEquals(new LawnImpl(new Position(4, 5), new MowerListMock()), lawn);
    }
}
