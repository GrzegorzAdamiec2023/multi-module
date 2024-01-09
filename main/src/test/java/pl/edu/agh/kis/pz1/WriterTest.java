package pl.edu.agh.kis.pz1;

import org.junit.Assert;
import org.junit.Test;

public class WriterTest {
    @Test
    public void testWriterInitialization() {
        Library library = new Library();
        Writer writer = new Writer(library);

        Assert.assertEquals(library, writer.biblioteka);
        Assert.assertTrue(writer.ID >= 0);
    }

}