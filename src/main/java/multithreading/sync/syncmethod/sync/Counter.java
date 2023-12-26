package multithreading.sync.syncmethod.sync;

public class Counter {

    int count = 0;

    synchronized public void incrementCount(int i) {
        this.count = this.count + i;
    }

    synchronized public void decrementCount(int i) {
        this.count = this.count - i;
    }

    public int getCount() {
        return this.count;
    }
}
