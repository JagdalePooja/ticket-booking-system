// Ticket.java
package com.example.ticketbookingsystem.model;

public class Ticket {
    private String id;
    private String startStation;
    private String endStation;
    private boolean usedForEntry;
    private boolean usedForExit;
    private long expirationTime;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getStartStation() {
        return startStation;
    }
    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    public String getEndStation() {
        return endStation;
    }

    public void setEndStation(String endStation) {
        this.endStation = endStation;
    }

    public boolean isUsedForEntry() {
        return usedForEntry;
    }

    public void setUsedForEntry(boolean usedForEntry) {
        this.usedForEntry = usedForEntry;
    }

    public boolean isUsedForExit() {
        return usedForExit;
    }

    public void setUsedForExit(boolean usedForExit) {
        this.usedForExit = usedForExit;
    }

    public long getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(long expirationTime) {
        this.expirationTime = expirationTime;
    }

}