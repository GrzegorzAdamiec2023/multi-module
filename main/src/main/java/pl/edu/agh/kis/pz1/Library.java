package pl.edu.agh.kis.pz1;

import java.util.concurrent.Semaphore;

public class Library {
    private int data = 42;

    private int readcount = 0;
    private final Semaphore resource = new Semaphore(1);
    private final Semaphore rmutex = new Semaphore(1);
    private final Semaphore serviceQueue = new Semaphore(1);

    private final Semaphore readersLimit = new Semaphore(5);

    public int getDane() {
        return data;
    }

    public void setDane(int noweDane){
        this.data = noweDane;
    }

    public void requestRead() throws InterruptedException {
        readersLimit.acquire();    // control amount of readers
        serviceQueue.acquire();    // wait in line to be serviced
        rmutex.acquire();          // request exclusive access to readcount
        readcount++;               // update count of active readers
        if (readcount == 1)        // if I am the first reader
            resource.acquire();    // request resource access for readers (writers blocked)
        serviceQueue.release();    // let next in line be serviced
        rmutex.release();          // release access to readcount
    }
    public void finishRead() throws InterruptedException {
        readersLimit.release();
        rmutex.acquire();          // request exclusive access to readcount
        readcount--;               // update count of active readers
        if (readcount == 0)        // if there are no readers left
            resource.release();    // release resource access for all
        rmutex.release();          // release access to readcount
        }

    public void requestWrite() throws InterruptedException {
        serviceQueue.acquire();    // wait in line to be serviced
        resource.acquire();        // request exclusive access to resource
        serviceQueue.release();    // let next in line be serviced
    }
    public void finishWrite(){
        resource.release();        // release resource access for next reader/writer
    }
}
