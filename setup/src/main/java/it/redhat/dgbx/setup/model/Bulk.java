package it.redhat.dgbx.setup.model;

import org.apache.kafka.common.protocol.types.Field;

public class Bulk {
    private String benchmarkId;
    private String description;
    private long day;
    private int entries;
    private int days;
    private int dayOfSequence;

    public String getBenchmarkId() {
        return benchmarkId;
    }

    public Bulk setBenchmarkId(String benchmarkId) {
        this.benchmarkId = benchmarkId;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Bulk setDescription(String description) {
        this.description = description;
        return this;
    }

    public long getDay() {
        return day;
    }

    public Bulk setDay(long day) {
        this.day = day;
        return this;
    }

    public int getEntries() {
        return entries;
    }

    public Bulk setEntries(int entries) {
        this.entries = entries;
        return this;
    }

    public int getDays() {
        return days;
    }

    public Bulk setDays(int days) {
        this.days = days;
        return this;
    }

    public int getDayOfSequence() {
        return dayOfSequence;
    }

    public Bulk setDayOfSequence(int dayOfSequence) {
        this.dayOfSequence = dayOfSequence;
        return this;
    }
}
