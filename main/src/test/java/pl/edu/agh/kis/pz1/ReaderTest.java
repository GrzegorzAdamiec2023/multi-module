package pl.edu.agh.kis.pz1;

import org.junit.Assert;
import org.junit.Test;

public class ReaderTest {
    @Test
    public void testReaderInitialization() {
        Library library = new Library();
        Reader reader = new Reader(library);

        Assert.assertEquals(library, reader.biblioteka);
        Assert.assertTrue(reader.ID >= 0);
    }

}