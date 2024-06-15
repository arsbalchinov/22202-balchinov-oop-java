package Util;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    private final Properties properties;

    public Config() {
        properties = new Properties();
        loadConfig();
    }

    public int getBodyStorageCapacity() {
        return Integer.parseInt(properties.getProperty("BodyStorageCapacity"));
    }

    public int getEngineStorageCapacity() {
        return Integer.parseInt(properties.getProperty("EngineStorageCapacity"));
    }

    public int getAccessoryStorageCapacity() {
        return Integer.parseInt(properties.getProperty("AccessoryStorageCapacity"));
    }

    public int getCarStorageCapacity() {
        return Integer.parseInt(properties.getProperty("CarStorageCapacity"));
    }

    public int getWorkers() {
        return Integer.parseInt(properties.getProperty("Workers"));
    }

    public int getDealers() {
        return Integer.parseInt(properties.getProperty("Dealers"));
    }

    public int getAccessorySuppliers() {
        return Integer.parseInt(properties.getProperty("Suppliers"));
    }

    public boolean getLog() {
        return Boolean.parseBoolean(properties.getProperty("Log"));
    }

    private void loadConfig() {
        InputStream input = Config.class.getResourceAsStream("/factory.cfg");
        try {
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}