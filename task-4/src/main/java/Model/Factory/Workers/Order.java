package Model.Factory.Workers;

import Model.Factory.FactoryStats;
import Model.Factory.Details.*;
import Model.Factory.Storages.StorageMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.Thread.sleep;
import static Model.Factory.Storages.StorageMap.Type.*;

public class Order implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(Order.class);
    private final boolean log;

    private final StorageMap storageMap;
    private final FactoryStats stats;

    public Order(StorageMap storageMap, FactoryStats stats, boolean log) {
        this.storageMap = storageMap;
        this.stats = stats;
        this.log = log;
    }

    @Override
    public void run() {
        try {
            sleep(1500);    //Time to create a new car
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Accessory accessoryDetail = (Accessory) storageMap.get(accessory).get();
        stats.decreaseStoredCount(FactoryStats.DETAIL.ACCESSORY);
        if (log) {
            logger.info("Accessory received from Accessory Storage. ID = {}", accessoryDetail.getID());
        }

        Body bodyDetail = (Body) storageMap.get(body).get();
        stats.decreaseStoredCount(FactoryStats.DETAIL.BODY);
        if (log) {
            logger.info("Car Body received from Body Storage. ID = {}", bodyDetail.getID());
        }

        Engine engineDetail = (Engine) storageMap.get(engine).get();
        stats.decreaseStoredCount(FactoryStats.DETAIL.ENGINE);
        if (log) {
            logger.info("Engine received from Engine Storage. ID = {}", engineDetail.getID());
        }

        Car carDetail = new Car(accessoryDetail, bodyDetail, engineDetail);
        storageMap.get(car).put(carDetail);
        stats.increaseProducedCount(FactoryStats.DETAIL.CAR);
    }
}