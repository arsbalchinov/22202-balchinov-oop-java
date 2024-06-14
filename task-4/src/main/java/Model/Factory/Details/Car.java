package Model.Factory.Details;

import Util.IDgenerator;

public class Car extends Detail {
    private final Body body;
    private final Engine engine;
    private final Accessory accessory;

    public Car(Accessory accessory, Body body, Engine engine) {
        super(IDgenerator.get());
        this.accessory = accessory;
        this.body = body;
        this.engine = engine;
    }

    public int getAccessoryID() {
        return accessory.getID();
    }

    public int getBodyID() {
        return body.getID();
    }

    public int getEngineID() {
        return engine.getID();
    }
}
