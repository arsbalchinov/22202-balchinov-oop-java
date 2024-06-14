package Model.Factory.Suppliers;

import Model.Factory.FactoryStats;
import Model.Factory.Details.Detail;
import Model.Factory.Details.Body;
import Model.Factory.Storages.Storage;
import Util.IDgenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BodiesSupplier extends Supplier<Detail> {
    private static final Logger logger = LoggerFactory.getLogger(BodiesSupplier.class);
    private final boolean log;

    public BodiesSupplier(Storage<Detail> storage, int timeToProduce, FactoryStats stats, boolean log) {
        super(storage, timeToProduce, stats);
        this.log = log;
    }

    @Override
    public void produceDetail() throws InterruptedException {
        sleep(timeToProduce);
        Body body = new Body(IDgenerator.get());
        if (log) {
            logger.info("Produced new car body. ID = {}", body.getID());
        }
        storage.put(body);
        stats.increaseProducedCount(FactoryStats.DETAIL.BODY);
    }
}