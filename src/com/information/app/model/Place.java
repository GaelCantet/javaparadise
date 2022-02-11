package com.information.app.model;

public class Place {
    private long id;
    private String name;

    public Place(String name) {
        this.name = name;
    }

    public Place(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
