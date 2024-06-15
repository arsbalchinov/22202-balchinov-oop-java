package Model.Factory.Storages;

import Model.Factory.FactoryStats;
import Model.Factory.Details.Detail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccessoryStorage extends Storage<Detail> {
    private static final Logger logger = LoggerFactory.getLogger(AccessoryStorage.class);
    private final boolean log;

    public AccessoryStorage(int capacity, FactoryStats stats, boolean log) {
        super(capacity, stats);
        this.log = log;
    }

    @Override
    public synchronized void put(Detail detail) {
        super.put(detail);
        stats.increaseStoredCount(FactoryStats.DETAIL.ACCESSORY);
        if (log) {
            logger.info("New Accessory put into Accessory Storage. ID = {}", detail.getID());
        }
    }

    @Override
    public synchronized Detail get() {
        return super.get();
    }
}