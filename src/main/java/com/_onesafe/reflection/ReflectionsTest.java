package com._onesafe.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Set;

import static org.reflections.ReflectionUtils.*;

/**
 * Created by onesafe on 05/11/2018.
 */
@SuppressWarnings("unchecked")
public class ReflectionsTest {

    public static void main(String[] args) {
        Set<Method> methods = getMethods(ReflectionsExample.class,
                withModifier(Modifier.PUBLIC),
                withReturnType(String.class),
                withParametersCount(0),
                withPrefix("to"));

        System.out.println(methods);
    }
}

/*  1
* [
*   public java.lang.String com._onesafe.reflection.ReflectionsExample.toJson(),
*   public java.lang.String com._onesafe.reflection.ReflectionsExample.toString()
* ]
*/
