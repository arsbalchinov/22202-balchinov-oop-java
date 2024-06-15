package Model.Factory.Suppliers;

import Model.Factory.FactoryStats;
import Model.Factory.Details.Detail;
import Model.Factory.Details.Engine;
import Model.Factory.Storages.Storage;
import Util.IDgenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EnginesSupplier extends Supplier<Detail> {
    private static final Logger logger = LoggerFactory.getLogger(EnginesSupplier.class);
    private final boolean log;

    public EnginesSupplier(Storage<Detail> storage, int timeToProduce, FactoryStats stats, boolean log) {
        super(storage, timeToProduce, stats);
        this.log = log;
    }

    @Override
    public void produceDetail() throws InterruptedException {
        sleep(timeToProduce);
        Engine engine = new Engine(IDgenerator.get());
        if (log) {
            logger.info("Produced new engine. ID = {}", engine.getID());
        }
        storage.put(engine);
        stats.increaseProducedCount(FactoryStats.DETAIL.ENGINE);
    }
}