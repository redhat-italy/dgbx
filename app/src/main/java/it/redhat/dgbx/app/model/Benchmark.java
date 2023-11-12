package it.redhat.dgbx.app.model;

import java.io.Serializable;

import static java.util.UUID.randomUUID;

public class Benchmark implements Serializable {
    private String description;

    private String benchmarkId;
    private long startDate;
    private int days;
    private int entries;
    private String referral;

    public Benchmark(String description, String id, long startDate, int days, int entries){
        if(id == null){
            this.benchmarkId = randomUUID().toString();
        }
        this.description = description;
        this.startDate = startDate;
        this.days = days;
        this.entries = entries;
        this.referral = benchmarkId;
    }

    public String getDescription() {
        return description;
    }

    public String getBenchmarkId() {
        return benchmarkId;
    }

    public long getStartDate() {
        return startDate;
    }

    public int getDays() {
        return days;
    }

    public int getEntries() {
        return entries;
    }
    public String getReferral() {
        return referral;
    }
}
