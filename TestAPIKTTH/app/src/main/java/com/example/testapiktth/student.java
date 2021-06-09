package com.example.testapiktth;

import java.io.Serializable;

public class student implements Serializable {
    private int mssv;
    private String name;
    private String clazz;
    private double point;

    public student(int mssv, String name, String clazz, double point) {
        this.mssv = mssv;
        this.name = name;
        this.clazz = clazz;
        this.point = point;
    }

    public student() {
    }

    @Override
    public String toString() {
        return "student{" +
                "mssv='" + mssv + '\'' +
                ", name='" + name + '\'' +
                ", clazz='" + clazz + '\'' +
                ", point=" + point +
                '}';
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public int getMssv() {
        return mssv;
    }

    public void setMssv(int mssv) {
        this.mssv = mssv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

