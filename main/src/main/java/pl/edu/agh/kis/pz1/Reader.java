package pl.edu.agh.kis.pz1;

import java.util.Random;

public class Reader extends ReaderWriter{
    Library biblioteka;
    int ID;
    static int instanceCounter = 0;
    public Reader(Library bib){
        this.ID = instanceCounter;
        this.biblioteka = bib;
        instanceCounter++;
    }
    @Override
    public void run() {
        for (;;) {
            try {

                this.queue = true;
                this.biblioteka.requestRead();
                this.queue = false;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.work = true;
            int dane = this.biblioteka.getDane();
            // do sth with "dane"
            try {

                Thread.sleep(1000);
                this.work = false;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                this.biblioteka.finishRead();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            Random random = new Random();
            try {
                this.rest = true;
                Thread.sleep(Math.abs(random.nextInt() % 5000));
                this.rest = false;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
