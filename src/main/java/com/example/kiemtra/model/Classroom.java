package com.example.kiemtra.model;

public class Classroom {
    private int idClass;
    private String nameClass;

    public Classroom() {
    }

    public Classroom(int idClass, String nameClass) {
        this.idClass = idClass;
        this.nameClass = nameClass;
    }

    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }
}
