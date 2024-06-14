package Model.Factory.Storages;

import Model.Factory.Details.Detail;
import java.util.HashMap;

public class StorageMap {
    private final HashMap<Type, Storage<Detail>> map;

    public enum Type {
        accessory,
        body,
        engine,
        car
    }

    public StorageMap() {
        map = new HashMap<>();
    }

    public void put(Type type, Storage<Detail> storage) {
        map.put(type, storage);
    }

    public Storage<Detail> get(Type type) {
        return map.get(type);
    }
}