package com._onesafe.builder;

/**
 * Created by onesafe on 05/11/2018.
 */
public class BuilderExampleTest {

    public static void main(String[] args) {
        BuilderExample builderExample = new BuilderExample.BuilderExampleBuilder()
                .name("onesafe")
                .age(19)
                .occupation("111")
                .occupation("222")
                .build();

        builderExample.setAge(18);

        System.out.println(builderExample.toString());
    }
}

/*
BuilderExample(created=1541398217888, name=onesafe, age=18, occupations=[111, 222])
 */
