package com._onesafe.jjcommander;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

/**
 * Created by onesafe on 08/11/2018.
 */
public class PositiveInteger implements IParameterValidator {

    public void validate(String name, String value) throws ParameterException {
        int n = Integer.parseInt(value);
        if (n < 0) {
            throw new ParameterException("Parameter " + name + "should be positive (found " + value + ")");
        }
    }
}
