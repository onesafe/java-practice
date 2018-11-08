package com._onesafe.jjcommander;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

/**
 * Created by onesafe on 08/11/2018.
 * http://jcommander.org/
 */
@Parameters(separators = "=")
public class jjcommand2 {

    @Parameter(names = {"--length", "-l"}, validateWith = PositiveInteger.class)
    int lenght;

    @Parameter(names = {"--pattern", "-p"})
    int pattern;

    public static void main(String[] args) {
        jjcommand2 jj = new jjcommand2();
        JCommander.newBuilder().addObject(jj).build().parse(args);
        System.out.printf("%d %d", jj.lenght, jj.pattern);
    }
}

/*
$ java jjcommand2 -l=33 --pattern=88
33 88
*/
