package pl.edu.agh.kis.pz1;

import org.junit.Assert;
import org.junit.Test;

public class DisplayerTest {
    @Test
    public void testDisplayerInitialization() {
        Library biblioteka  = new Library();
        Writer[] writers = {new Writer(biblioteka), new Writer(biblioteka)};
        Reader[] readers = {new Reader(biblioteka), new Reader(biblioteka)};

        Displayer displayer = new Displayer(writers, readers);

        Assert.assertNotNull(displayer);
        Assert.assertNotNull(displayer.pis);
        Assert.assertNotNull(displayer.czyt);
        Assert.assertNotNull(displayer.gaps);
        Assert.assertNotNull(displayer.rowValues);
    }
}