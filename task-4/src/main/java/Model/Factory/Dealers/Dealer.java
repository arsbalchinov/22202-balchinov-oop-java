package Model.Factory.Dealers;

import Model.Factory.FactoryController;
import Model.Factory.FactoryStats;
import Model.Factory.Details.Car;
import Util.IDgenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Dealer extends Thread {
    private static final Logger logger = LoggerFactory.getLogger(Dealer.class);
    private final boolean log;

    private final int id;

    private final FactoryController factoryController;
    private int timeToSale;
    private final FactoryStats stats;

    public Dealer(FactoryController factoryController, int timeToSale, FactoryStats stats, boolean log) {
        this.factoryController = factoryController;
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
        synchronized (factoryController) {
            factoryController.notify();
        }
        Car car = (Car) factoryController.getCarStorage().get();
        stats.decreaseStoredCount(FactoryStats.DETAIL.CAR);
        return car;
    }
}