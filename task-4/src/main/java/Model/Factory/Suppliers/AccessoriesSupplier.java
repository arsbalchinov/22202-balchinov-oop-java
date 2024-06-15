package Model.Factory.Suppliers;

import Model.Factory.FactoryStats;
import Model.Factory.Details.Detail;
import Model.Factory.Details.Accessory;
import Model.Factory.Storages.Storage;
import Util.IDgenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccessoriesSupplier extends Supplier<Detail> {
    private static final Logger logger = LoggerFactory.getLogger(AccessoriesSupplier.class);
    private final boolean log;

    public AccessoriesSupplier(Storage<Detail> storage, int timeToProduce, FactoryStats stats, boolean log) {
        super(storage, timeToProduce, stats);
        this.log = log;
    }

    @Override
    public void produceDetail() throws InterruptedException {
        sleep(timeToProduce);
        Accessory accessory = new Accessory(IDgenerator.get());
        if (log) {
            logger.info("Produced new accessory. ID = {}", accessory.getID());
        }
        storage.put(accessory);
        stats.increaseProducedCount(FactoryStats.DETAIL.ACCESSORY);
    }
}