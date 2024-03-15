package com.example.ticketbookingsystem.model;

public class Station {
    private String code;
    private String name;
    private boolean startStation;
    private int price;
    private boolean lastStation;

    public Station(String code, String name, boolean startStation, boolean lastStation, int price) {
        this.code = code;
        this.name = name;
        this.startStation = startStation;
        this.price = price;
        this.lastStation = lastStation;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStartStation() {
        return startStation;
    }

    public void setStartStation(boolean startStation) {
        this.startStation = startStation;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isLastStation() {
        return lastStation;
    }

    public void setLastStation(boolean lastStation) {
        this.lastStation = lastStation;
    }

    @Override
    public String toString() {
        return "Station{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", startStation=" + startStation +
                ", price=" + price +
                ", lastStation=" + lastStation +
                '}';
    }
}
