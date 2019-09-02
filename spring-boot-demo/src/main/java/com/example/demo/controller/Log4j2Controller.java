package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by onesafe on 02/09/2019 11:45 AM.
 */
@RestController
public class Log4j2Controller {

    private static final Logger LOG = LogManager.getLogger(Log4j2Controller.class);

    @GetMapping("/testlog4j2")
    public String test() {
        LOG.debug("debug 级别日志 ...");
        LOG.info("info 级别日志 ...");
        LOG.warn("warn 级别日志 ...");
        LOG.error("error 级别日志 ...");
        LOG.fatal("fatal 级别日志 ...");
        return "Hello Log4j2 !";
    }
}
