package com._onesafe.readonlylist;

import java.util.ArrayList;

/**
 * Created by onesafe on 25/10/2018.
 */
public class Test {

    public static void main(String[] args)
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("001");
        list.add("002");
        Student s = new Student("Tom", list);

        ArrayList<String> anotherList = s.getCourses();

        anotherList.add("999");

        System.out.println("Tom's course.length = " + s.getCourses().size());
    }
}
