package pl.edu.agh.kis.pz1;

import org.junit.Assert;
import org.junit.Test;

public class LibraryTest {
    @Test
    public void testLibraryInitialization() {
        Library library = new Library();

        Assert.assertEquals(42, library.getDane());
    }

    @Test
    public void testSetDane() {
        Library library = new Library();

        library.setDane(123);

        Assert.assertEquals(123, library.getDane());
    }
}