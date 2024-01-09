package pl.edu.agh.kis.pz1;


public class Main {
    public static void main( String[] args ) {
        Library biblioteka  = new Library();

        int liczbaCzytelnikow = 10;
        int liczbaPisarzy = 3;

        Reader[] readers  = new Reader[liczbaCzytelnikow];
        Writer[] writers  = new Writer[liczbaPisarzy];
        Displayer dis = new Displayer(writers, readers);

        for(int i = 0;  i < liczbaCzytelnikow; i++){
            readers[i] = new Reader(biblioteka);
        }

        for(int i = 0;  i < liczbaPisarzy; i++){
            writers[i] = new Writer(biblioteka);
        }

        for(Reader r: readers){
            r.start();
        }
        for(Writer w: writers){
            w.start();
        }
        dis.start();
    }
}
