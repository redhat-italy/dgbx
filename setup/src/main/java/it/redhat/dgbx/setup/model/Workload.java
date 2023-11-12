package it.redhat.dgbx.setup.model;

public class Workload {
    private String benchmarkId;
    private long day;
    private int entries;

    public String getBenchmarkId() {
        return benchmarkId;
    }

    public Workload setBenchmarkId(String benchmarkId) {
        this.benchmarkId = benchmarkId;
        return this;
    }

    public long getDay() {
        return day;
    }

    public Workload setDay(long day) {
        this.day = day;
        return this;
    }

    public int getEntries() {
        return entries;
    }

    public Workload setEntries(int entries) {
        this.entries = entries;
        return this;
    }

}
