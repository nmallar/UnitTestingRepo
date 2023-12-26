package multithreading.sync.syncmethod.sync;

public class Subtractor implements Runnable {

    final Counter counter;

    Subtractor(Counter counter) {
        this.counter = counter;
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i < 10000; i++) {
            counter.decrementCount(i);
        }
    }
}
