package com._onesafe.readonlylist;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by onesafe on 25/10/2018.
 */
public class StudentReadonlyList {

    @Getter
    @Setter
    private String name;

    private ArrayList<String> courses;

    public StudentReadonlyList(String name, ArrayList<String> courses)
    {
        this.name = name;
        this.courses = courses;
    }

    public void addCourse(String course)
    {
        courses.add(course);
    }

    public String removeCourse(String course)
    {
        boolean removed = courses.remove(courses);

        if (removed)
        {
            return course;
        }
        else
        {
            return null;
        }
    }

    public List<String> getCourses()
    {
        return Collections.unmodifiableList(courses);
    }

}
