package com._onesafe.readonlylist;

import lombok.Data;

import java.util.ArrayList;

/**
 * Created by onesafe on 25/10/2018.
 */
@Data
public class Student {

    private String name;
    private ArrayList<String> courses;

    public Student(String name, ArrayList<String> courses) {
        this.name = name;
        this.courses = courses;
    }
}
