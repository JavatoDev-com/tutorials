package com.javatodev.api.Util;

import lombok.extern.slf4j.Slf4j;

public interface RandomWork {

    @Slf4j
    final class LoggerForRandomWork {}

    default void doTheRandomLog () {
        LoggerForRandomWork.log.info("Doing the random Log using Lombok Slf4J");
    }

}
