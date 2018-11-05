package com._onesafe.builder;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.Set;

/**
 * Created by onesafe on 05/11/2018.
 */
@Builder
@Data
public class BuilderExample {

    @Builder.Default private long created = System.currentTimeMillis();

    private String name;

    private int age;

    @Singular private Set<String> occupations;
}
