package Model.Events;

public class Event {
    public enum EVENT_TYPE {
        UPD_ACCESSORY_STORED_COUNT,
        UPD_BODY_STORED_COUNT,
        UPD_ENGINE_STORED_COUNT,
        UPD_CAR_STORED_COUNT,
        UPD_ACCESSORY_PROD_COUNT,
        UPD_BODY_PROD_COUNT,
        UPD_ENGINE_PROD_COUNT,
        UPD_CAR_PROD_COUNT,
    }

    private final EVENT_TYPE eventType;

    public Event(EVENT_TYPE eventType) {
        this.eventType = eventType;
    }

    public EVENT_TYPE getEventType() {
        return eventType;
    }
}