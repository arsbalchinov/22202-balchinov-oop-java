package Model.Factory.Storages;

import Model.Factory.FactoryStats;
import Model.Factory.Details.Detail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CarStorage extends Storage<Detail> {
    private static final Logger logger = LoggerFactory.getLogger(CarStorage.class);
    private final boolean log;

    public CarStorage(int capacity, FactoryStats stats, boolean log) {
        super(capacity, stats);
        this.log = log;
    }

    @Override
    public synchronized void put(Detail detail) {
        super.put(detail);
        stats.increaseStoredCount(FactoryStats.DETAIL.CAR);
        if (log) {
            logger.info("New Car put into Car Storage. ID = {}", detail.getID());
        }
    }

    @Override
    public synchronized Detail get() {
        return super.get();
    }
}