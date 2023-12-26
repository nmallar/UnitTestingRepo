package multithreading.sync.syncobject;

public class Subtractor implements Runnable {

    final Counter counter;

    Subtractor(Counter counter) {
        this.counter = counter;
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (counter) {
                counter.count = counter.count - i;
            }

        }
    }
}
