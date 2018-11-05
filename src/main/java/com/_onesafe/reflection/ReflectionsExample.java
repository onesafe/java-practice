package com._onesafe.reflection;

import lombok.Data;

/**
 * Created by onesafe on 05/11/2018.
 */
@Data
public class ReflectionsExample {

    public String name;

    public int age;

    public String toJson() {
        return "{test : 1}";
    }
}
