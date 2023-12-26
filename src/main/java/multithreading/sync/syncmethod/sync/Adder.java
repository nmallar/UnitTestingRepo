package multithreading.sync.syncmethod.sync;

public class Adder implements Runnable {

    final Counter counter;

    Adder(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            counter.incrementCount(i);

        }
    }
}
