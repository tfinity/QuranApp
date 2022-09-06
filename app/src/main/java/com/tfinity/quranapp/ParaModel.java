package com.tfinity.quranapp;

public class ParaModel {
    String name;
    int number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public ParaModel(String name, int number) {
        this.name = name;
        this.number = number;
    }
}
