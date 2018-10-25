package com._onesafe.readonlylist;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by onesafe on 25/10/2018.
 */
public class TestReadonlyList {

    public static void main(String[] args)
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("001");
        list.add("002");
        StudentReadonlyList s = new StudentReadonlyList("Tom", list);

        List<String> anotherList = s.getCourses();

        /**
         * throws java.lang.UnsupportedOperationException
         * should replace with s.addCourse(String course)
         */
        anotherList.add("999");

        // never reached
        System.out.println("Tom's course.length = " + s.getCourses().size());
    }
}
