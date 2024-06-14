package Model.Factory.Storages;
import Model.Factory.FactoryStats;
import ThreadPool.BlockingQueue;

public class Storage<T> extends BlockingQueue<T> {
    protected int capacity;
    protected FactoryStats stats;

    public Storage(int capacity, FactoryStats stats) {
        this.capacity = capacity;
        this.stats = stats;
    }

    @Override
    public synchronized void put(T element) {
        while (isFull()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        super.put(element);
    }

    @Override
    public synchronized T get() {
        notify();
        return super.get();
    }

    public synchronized boolean isFull() {
        return getSize() == capacity;
    }

    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    public synchronized int getSize() {
        return tasks.size();
    }
}
