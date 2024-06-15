package Model.Factory.Suppliers;

import Model.Factory.FactoryStats;
import Model.Factory.Storages.Storage;

public abstract class Supplier<T> extends Thread {
    protected final Storage<T> storage;
    protected int timeToProduce;
    protected final FactoryStats stats;

    public Supplier(Storage<T> storage, int timeToProduce, FactoryStats stats) {
        this.storage = storage;
        this.timeToProduce = timeToProduce;
        this.stats = stats;
    }

    public int getTimeToProduce() {
        return timeToProduce;
    }

    public void setTimeToProduce(int timeToProduce) {
        if (timeToProduce <= 0) {
            throw new RuntimeException("Time to produce a detail must be greater than 0");
        }
        this.timeToProduce = timeToProduce;
    }

    @Override
    public void run() {
        while (true) {
            try {
                produceDetail();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public abstract void produceDetail() throws InterruptedException;
}