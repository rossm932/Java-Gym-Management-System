package com.funfit.model;

public class Participant {
    private int id;
    private String name;
    private String email; // Added email field
    private String phone;
    private int batchId;

    // Constructors
    public Participant() {}

    public Participant(int id, String name, String email, String phone, int batchId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.batchId = batchId;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() { // Getter for email
        return email;
    }

    public void setEmail(String email) { // Setter for email
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }
}
