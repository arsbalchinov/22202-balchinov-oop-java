package Model.Factory;

import Model.Factory.Dealers.Dealer;
import Model.Factory.Storages.*;
import Model.Factory.Suppliers.*;
import Util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;

import static Model.Factory.Storages.StorageMap.Type.*;

public class Factory implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(Factory.class);
    private final IDgenerator IDgenerator = new IDgenerator();

    private final boolean log;
    private final Config config;
    private final Settings settings;

    private final BodiesSupplier bodiesSupplier;
    private final EnginesSupplier enginesSupplier;
    private final LinkedList<AccessoriesSupplier> accessoriesSuppliers;

    private final FactoryController factoryController;

    private final LinkedList<Dealer> dealers;

    public Factory(Config config, Settings settings, FactoryStats stats) {
        this.config = config;
        this.settings = settings;
        this.log = config.getLog();

        StorageMap storageMap = new StorageMap();

        AccessoryStorage accessoryStorage = new AccessoryStorage(config.getAccessoryStorageCapacity(), stats, log);
        storageMap.put(accessory, accessoryStorage);
        BodyStorage bodyStorage = new BodyStorage(config.getBodyStorageCapacity(), stats, log);
        storageMap.put(body, bodyStorage);
        EngineStorage engineStorage = new EngineStorage(config.getEngineStorageCapacity(), stats, log);
        storageMap.put(engine, engineStorage);
        CarStorage carStorage = new CarStorage(config.getCarStorageCapacity(), stats, log);
        storageMap.put(car, carStorage);

        bodiesSupplier = new BodiesSupplier(bodyStorage, settings.getBodySupplyTime(), stats, log);
        enginesSupplier = new EnginesSupplier(engineStorage, settings.getEngineSupplyTime(), stats, log);
        accessoriesSuppliers = new LinkedList<>();
        for (int i = 0; i < config.getAccessorySuppliers(); i++) {
            accessoriesSuppliers.add(new AccessoriesSupplier(accessoryStorage, settings.getAccessorySupplyTime(), stats, log));
        }

        factoryController = new FactoryController(storageMap, config, 5, stats, log);

        dealers = new LinkedList<>();
        for (int i = 0; i < config.getDealers(); i++) {
            dealers.add(new Dealer(factoryController, settings.getDealerSaleTime(), stats, log));
        }
    }

    @Override
    public void run() {
        int i = 0;
        for (AccessoriesSupplier accessorySupplier : accessoriesSuppliers) {
            i++;
            accessorySupplier.start();
            if (log) {
                logger.info("Accessory Supplier #{} successfully executed", i);
            }
        }
        bodiesSupplier.start();
        if (log) {
            logger.info("Body Supplier successfully executed");
        }

        enginesSupplier.start();
        if (log) {
            logger.info("Engine Supplier successfully executed");
        }

        i = 0;
        for (Dealer dealer : dealers) {
            i++;
            dealer.start();
            if (log) {
                logger.info("Dealer #{} successfully executed", i);
            }
        }

        factoryController.start();
        if (log) {
            logger.info("Factory Controller successfully executed");
        }
    }

    public Config getConfig() {
        return config;
    }

    public void setAccessoriesTimeToSupply(int newValue) {
        for (AccessoriesSupplier acsSupplier : accessoriesSuppliers) {
            acsSupplier.setTimeToProduce(newValue);
        }
        settings.setAccessorySupplyTime(newValue);
        if (log) {
            logger.info("Accessory Supply Time set to {} ms", newValue);
        }
    }

    public void setBodyTimeToSupply(int newValue) {
        bodiesSupplier.setTimeToProduce(newValue);
        settings.setBodySupplyTime(newValue);
        if (log) {
            logger.info("Body Supply Time set to {} ms", newValue);
        }
    }

    public void setEngineTimeToSupply(int newValue) {
        enginesSupplier.setTimeToProduce(newValue);
        settings.setEngineSupplyTime(newValue);
        if (log) {
            logger.info("Engine Supply Time set to {} ms", newValue);
        }
    }

    public void setDealersTimeToSale(int newValue) {
        for (Dealer dealer : dealers) {
            dealer.setTimeToSale(newValue);
        }
        settings.setDealerSaleTime(newValue);
        if (log) {
            logger.info("Dealer Sale Time set to {} ms", newValue);
        }
    }
}
