package com.javatodev.api.Util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoggerTestUtil implements RandomWork{

    public static void writeLogs () {
        log.info("INFO log using Lombok Slf4j ");
        log.error("ERROR log using Lombok Slf4j ");
        log.warn("WARN log using Lombok Slf4j ");

    }


}
