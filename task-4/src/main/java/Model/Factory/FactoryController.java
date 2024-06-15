package Model.Factory;

import Model.Factory.Storages.CarStorage;
import Model.Factory.Storages.StorageMap;
import Model.Factory.Workers.Order;
import ThreadPool.BlockingQueue;
import ThreadPool.ThreadPool;
import Util.Config;

import static Model.Factory.Storages.StorageMap.Type.car;

public class FactoryController extends Thread {
    private final boolean log;
    private final StorageMap storageMap;
    private final FactoryStats stats;
    private final int orderSize;
    private final BlockingQueue<Runnable> orders;

    public FactoryController(StorageMap storageMap, Config config, int orderSize, FactoryStats stats, boolean log) {
        this.storageMap = storageMap;
        this.orderSize = orderSize;
        this.stats = stats;
        this.log = log;

        orders = new BlockingQueue<Runnable>();
        ThreadPool workers = new ThreadPool(config.getWorkers(), orders);
        workers.start();
    }

    public CarStorage getCarStorage() {
        return (CarStorage) storageMap.get(car);
    }

    public BlockingQueue<Runnable> getOrders() {
        return orders;
    }

    @Override
    public synchronized void run() {
        while (true) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (storageMap.get(car)) {
                if (storageMap.get(car).isEmpty()) {
                    addTasks(orderSize);
                }
            }
        }
    }

    private void addTasks(int count) {
        for (int i = 0; i < count; i++) {
            orders.put(new Order(storageMap, stats, log));
        }
    }
}
