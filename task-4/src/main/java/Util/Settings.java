package Util;

public class Settings {
    private int bodySupplyTime;
    private int engineSupplyTime;
    private int accessorySupplyTime;
    private int dealerSaleTime;

    public Settings(int accessorySupplyTime, int bodySupplyTime, int enginesSupplyTime, int dealerPeriod) {
        this.accessorySupplyTime = accessorySupplyTime;
        this.bodySupplyTime = bodySupplyTime;
        this.dealerSaleTime = dealerPeriod;
        this.engineSupplyTime = enginesSupplyTime;
    }

    public int getBodySupplyTime() {
        return bodySupplyTime;
    }

    public int getEngineSupplyTime() {
        return engineSupplyTime;
    }

    public int getAccessorySupplyTime() {
        return accessorySupplyTime;
    }

    public int getDealerSaleTime() {
        return dealerSaleTime;
    }

    public void setAccessorySupplyTime(int accessorySupplyTime) {
        this.accessorySupplyTime = accessorySupplyTime;
    }

    public void setBodySupplyTime(int bodySupplyTime) {
        this.bodySupplyTime = bodySupplyTime;
    }

    public void setEngineSupplyTime(int engineSupplyTime) {
        this.engineSupplyTime = engineSupplyTime;
    }

    public void setDealerSaleTime(int dealerSaleTime) {
        this.dealerSaleTime = dealerSaleTime;
    }
}