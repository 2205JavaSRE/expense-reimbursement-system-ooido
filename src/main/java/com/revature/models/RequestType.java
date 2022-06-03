package com.revature.models;

public enum RequestType {
    LODGING(0), TRAVEL (1), FOOD (2), OTHER (3); //lodging, travel, food, other

    private int requestType;
    RequestType(int requestType) { this.requestType = requestType; }

    public int getStatus() { return requestType; }

    public void setRequestType(int requestType) {
        this.requestType = requestType;
    }

    public static RequestType fromOrdinal(int n){
        switch(n){
            case 0:
                return LODGING;
            case 1:
                return TRAVEL;
            case 2:
                return FOOD;
            case 3:
                return OTHER;
            default:
                return null;
        }
    }
}
