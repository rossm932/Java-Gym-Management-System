package com.funfit.model;

public class Batch {
    private int id;
    private String batchName;
    private String timetable;

    // Constructors
    public Batch() {}

    public Batch(int id, String batchName, String timetable) {
        this.id = id;
        this.batchName = batchName;
        this.timetable = timetable;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getBatchName() { return batchName; }
    public void setBatchName(String batchName) { this.batchName = batchName; }

    public String getTimetable() { return timetable; }
    public void setTimetable(String timetable) { this.timetable = timetable; }
}
