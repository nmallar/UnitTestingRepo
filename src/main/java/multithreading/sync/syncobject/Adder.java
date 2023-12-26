package multithreading.sync.syncobject;

public class Adder implements Runnable {

    final Counter counter;

    Adder(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {

            synchronized (counter) {
                counter.count += i;
            }

        }
    }
}
