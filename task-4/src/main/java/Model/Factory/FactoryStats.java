package Model.Factory;

import Model.Events.Event;
import Model.Events.Observable;

public class FactoryStats extends Observable {

    public enum DETAIL {
        ACCESSORY,
        BODY,
        ENGINE,
        CAR
    }

    private int accessoryStoredCount = 0;
    private int bodyStoredCount = 0;
    private int engineStoredCount = 0;
    private int carStoredCount = 0;

    private int accessoryProducedCount = 0;
    private int bodyProducedCount = 0;
    private int engineProducedCount = 0;
    private int carProducedCount = 0;

    public synchronized void setStoredCount(DETAIL detail, int value) {
        switch (detail) {
            case ACCESSORY:
                accessoryStoredCount = value;
                notifyObservers(new Event(Event.EVENT_TYPE.UPD_ACCESSORY_STORED_COUNT));
                break;
            case BODY:
                bodyStoredCount = value;
                notifyObservers(new Event(Event.EVENT_TYPE.UPD_BODY_STORED_COUNT));
                break;
            case ENGINE:
                engineStoredCount = value;
                notifyObservers(new Event(Event.EVENT_TYPE.UPD_ENGINE_STORED_COUNT));
                break;
            case CAR:
                carStoredCount = value;
                notifyObservers(new Event(Event.EVENT_TYPE.UPD_CAR_STORED_COUNT));
                break;
        }

    }

    public synchronized void increaseStoredCount(DETAIL detail) {
        switch (detail) {
            case ACCESSORY:
                accessoryStoredCount++;
                notifyObservers(new Event(Event.EVENT_TYPE.UPD_ACCESSORY_STORED_COUNT));
                break;
            case BODY:
                bodyStoredCount++;
                notifyObservers(new Event(Event.EVENT_TYPE.UPD_BODY_STORED_COUNT));
                break;
            case ENGINE:
                engineStoredCount++;
                notifyObservers(new Event(Event.EVENT_TYPE.UPD_ENGINE_STORED_COUNT));
                break;
            case CAR:
                carStoredCount++;
                notifyObservers(new Event(Event.EVENT_TYPE.UPD_CAR_STORED_COUNT));
                break;
        }
    }

    public synchronized void decreaseStoredCount(DETAIL detail) {
        switch (detail) {
            case ACCESSORY:
                accessoryStoredCount--;
                notifyObservers(new Event(Event.EVENT_TYPE.UPD_ACCESSORY_STORED_COUNT));
                break;
            case BODY:
                bodyStoredCount--;
                notifyObservers(new Event(Event.EVENT_TYPE.UPD_BODY_STORED_COUNT));
                break;
            case ENGINE:
                engineStoredCount--;
                notifyObservers(new Event(Event.EVENT_TYPE.UPD_ENGINE_STORED_COUNT));
                break;
            case CAR:
                carStoredCount--;
                notifyObservers(new Event(Event.EVENT_TYPE.UPD_CAR_STORED_COUNT));
                break;
        }
    }

    public synchronized void setProducedCount(DETAIL detail, int value) {
        switch (detail) {
            case ACCESSORY:
                accessoryProducedCount = value;
                notifyObservers(new Event(Event.EVENT_TYPE.UPD_ACCESSORY_PROD_COUNT));
                break;
            case BODY:
                bodyProducedCount = value;
                notifyObservers(new Event(Event.EVENT_TYPE.UPD_BODY_PROD_COUNT));
                break;
            case ENGINE:
                engineProducedCount = value;
                notifyObservers(new Event(Event.EVENT_TYPE.UPD_ENGINE_PROD_COUNT));
                break;
            case CAR:
                carProducedCount = value;
                notifyObservers(new Event(Event.EVENT_TYPE.UPD_CAR_PROD_COUNT));
                break;
        }
    }

    public synchronized void increaseProducedCount(DETAIL detail) {
        switch (detail) {
            case ACCESSORY:
                accessoryProducedCount++;
                notifyObservers(new Event(Event.EVENT_TYPE.UPD_ACCESSORY_PROD_COUNT));
                break;
            case BODY:
                bodyProducedCount++;
                notifyObservers(new Event(Event.EVENT_TYPE.UPD_BODY_PROD_COUNT));
                break;
            case ENGINE:
                engineProducedCount++;
                notifyObservers(new Event(Event.EVENT_TYPE.UPD_ENGINE_PROD_COUNT));
                break;
            case CAR:
                carProducedCount++;
                notifyObservers(new Event(Event.EVENT_TYPE.UPD_CAR_PROD_COUNT));
                break;
        }
    }

    public synchronized int getAccessoryStoredCount() {
        return accessoryStoredCount;
    }

    public synchronized int getBodyStoredCount() {
        return bodyStoredCount;
    }

    public synchronized int getEngineStoredCount() {
        return engineStoredCount;
    }

    public synchronized int getCarStoredCount() {
        return carStoredCount;
    }

    public synchronized int getAccessoryProducedCount() {
        return accessoryProducedCount;
    }

    public synchronized int getBodyProducedCount() {
        return bodyProducedCount;
    }

    public synchronized int getEngineProducedCount() {
        return engineProducedCount;
    }

    public synchronized int getCarProducedCount() {
        return carProducedCount;
    }
}