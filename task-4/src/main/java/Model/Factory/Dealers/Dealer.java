package Model.Factory.Dealers;

import Model.Factory.FactoryStats;
import Model.Factory.Details.Car;
import Model.Factory.Storages.CarStorage;
import Util.IDgenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Dealer extends Thread {
    private static final Logger logger = LoggerFactory.getLogger(Dealer.class);
    private final boolean log;

    private final int id;
    private final CarStorage carStorage;
    private int timeToSale;
    private final FactoryStats stats;

    public Dealer(CarStorage carStorage, int timeToSale, FactoryStats stats, boolean log) {
        this.carStorage = carStorage;
        this.timeToSale = timeToSale;
        this.stats = stats;
        this.id = IDgenerator.get();
        this.log = log;
    }

    public void setTimeToSale(int timeToSale) {
        this.timeToSale = timeToSale;
    }
    public int getTimeToSale() {
        return timeToSale;
    }

    @Override
    public void run() {
        while (true) {
            Car carForSale;
            try {
                carForSale = orderCar();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (log) {
                logger.info("Dealer #{} ordered new Car (ID = {}) [Accessory ID = {}, Body ID = {}, Engine ID = {}]",
                        id, carForSale.getID(), carForSale.getAccessoryID(), carForSale.getBodyID(), carForSale.getEngineID());
            }
        }
    }

    private Car orderCar() throws InterruptedException {
        sleep(timeToSale);
        Car car = (Car) carStorage.get();
        stats.decreaseStoredCount(FactoryStats.DETAIL.CAR);
        return car;
    }
}
