package pl.edu.agh.kis.pz1;

import java.util.Random;

public class Writer extends ReaderWriter{

    Library biblioteka;
    int ID;
    static int instanceCounter = 0;
    public Writer(Library bib){
        this.ID = instanceCounter;
        this.biblioteka = bib;
        instanceCounter++;
    }
    @Override
    public void run() {
        for (;;) {

            try {
                this.queue = true;
                this.biblioteka.requestWrite();
                this.queue = false;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Random random = new Random();
            int daneDoZapisu = random.nextInt();
            this.work = true;
            this.biblioteka.setDane(daneDoZapisu);

            try {

                Thread.sleep(2000);
                this.work = false;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.biblioteka.finishWrite();

            try {
                this.rest = true;
                Thread.sleep(Math.abs(random.nextInt() % 10000));
                this.rest = false;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
