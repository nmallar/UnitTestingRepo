package multithreading.nosync;

public class Subtractor implements Runnable {

    Counter counter;

    Subtractor(Counter counter) {
        this.counter = counter;
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i < 10000; i++) {

            counter.count = counter.count - i;

        }
    }
}
