package ThreadPool;

import Model.Factory.Workers.Worker;
import java.util.LinkedList;

public class ThreadPool extends Thread {
    private final LinkedList<Worker> workers;

    public ThreadPool(int threadsCount, BlockingQueue<Runnable> tasks) {
        workers = new LinkedList<>();
        for (int i = 0; i < threadsCount; i++) {
            workers.add(new Worker(tasks));
        }
    }

    @Override
    public void run() {
        for (Worker worker : workers) {
            worker.start();
        }
    }
}