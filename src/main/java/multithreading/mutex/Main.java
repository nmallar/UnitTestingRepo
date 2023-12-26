package multithreading.mutex;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Lock lock1 = new ReentrantLock();


        Counter counter = new Counter();
        Adder adder = new Adder(counter, lock1);
        Subtractor subtractor = new Subtractor(counter, lock1);

        Thread t1 = new Thread(adder);
        Thread t2 = new Thread(subtractor);


        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Count is " + counter.count);
    }

}
