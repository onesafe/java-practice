package com._onesafe.jjcommander;

import com.beust.jcommander.JCommander;

/**
 * Created by onesafe on 08/11/2018.
 */
public class jjcommand1 {

    public static void main(String[] args) {
        Args args1 = new Args();
        JCommander.newBuilder().addObject(args1).build().parse(args);
        System.out.println(args1.getGroups() + args1.getParameters() + args1.getVerbose() + args1.isDebug());
    }
}
