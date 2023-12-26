package multithreading.mutex;

import java.util.concurrent.locks.Lock;

public class Subtractor implements Runnable {

    Counter counter;
    Lock lock;

    Subtractor(Counter counter, Lock lock) {
        this.counter = counter;
        this.lock = lock;
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i < 10000; i++) {
            lock.lock();

            counter.count = counter.count - i;
            lock.unlock();
        }
    }
}
