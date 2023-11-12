package it.redhat.dgbx.setup.model;

import io.quarkus.logging.Log;

import java.io.Serializable;

import static java.util.UUID.randomUUID;

public class Benchmark implements Serializable {
    private String description;

    private String benchmarkId;
    private long startDate;
    private int days;
    private int entries;

    private String referral;


    public Benchmark(String description, String benchmarkId, long startDate, int days, int entries, String referral){
        if(benchmarkId == null){
            this.benchmarkId = randomUUID().toString();
        }
        this.description = description;
        this.startDate = startDate;
        this.days = days;
        this.entries = entries;
        this.referral = referral;
    }

    public String getDescription() {
        return description;
    }

    public String getBenchmarkId() {
        return benchmarkId;
    }

    public String getReferral() {
        return referral;
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

    @Override
    public String toString() {
        return new String("{\"" + this.referral + "\":\"" + this.description + "\"}");
    }
}
