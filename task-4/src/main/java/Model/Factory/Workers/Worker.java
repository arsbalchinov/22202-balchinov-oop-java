package Model.Factory.Workers;

import ThreadPool.BlockingQueue;

public class Worker extends Thread {
    private final BlockingQueue<Runnable> tasks;

    public Worker(BlockingQueue<Runnable> tasks) {
        this.tasks = tasks;
    }

    @Override
    public void run() {
        while (true) {
            Order task = (Order) tasks.get();
            task.run();
        }
    }
}