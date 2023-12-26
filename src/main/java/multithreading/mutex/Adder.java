package multithreading.mutex;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable {

    Counter counter;
    Lock lock;

    Adder(Counter counter, Lock lock) {
        this.counter = counter;
        this.lock = lock;
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i < 10000; i++) {


            counter.count += i;

        }
    }
}
