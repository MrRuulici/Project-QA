package util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum CustomLogger {
    INSTANCE;

    String consoleLogLevel = System.getProperty("consoleLogLevel");
    String fileLogLevel = System.getProperty("fileLogLevel");
    private Logger log;

    public Logger getLogger(Class<?> clazz) {
        // if -DconsoleLogLevel AND/OR -DfileLogLevel are not set => DEFAULT
        // values should be INFO/DEBUG
        if (null == consoleLogLevel) {
            System.setProperty("consoleLogLevel", "INFO");
        }

        if (null == fileLogLevel) {
            System.setProperty("fileLogLevel", "DEBUG");
        }
        log = LoggerFactory.getLogger(clazz);
        return log;
    }
}
