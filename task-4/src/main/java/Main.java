import Model.Factory.Factory;
import Model.Factory.FactoryStats;
import Util.Settings;
import Util.Config;
import View.FactoryView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Config config = new Config();
        Settings settings = new Settings(1000, 1000, 1000, 1000);

        FactoryStats stats = new FactoryStats();
        Factory factory = new Factory(config, settings, stats);

        if (config.getLog()) {
            logger.info("The Factory successfully created with settings: " +
                            "accessorySupplyTime = {} ms, " +
                            "bodySupplyTime = {}, " +
                            "engineSupplyTime = {}, " +
                            "dealerSaleTime = {}",
                    settings.getAccessorySupplyTime(), settings.getBodySupplyTime(),
                    settings.getEngineSupplyTime(), settings.getDealerSaleTime());
        }

        FactoryView frame = new FactoryView(factory, stats);

        factory.run();
    }
}