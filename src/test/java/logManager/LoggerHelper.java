package logManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerHelper {

    private static final Logger LOGGER = LogManager.getLogger(LoggerHelper.class);

    private LoggerHelper() {

    }

    public static void logInfo(String message) {
        LOGGER.info(message);
    }

    public static void logError(String message) {
        LOGGER.error(message);
    }

    public static void logDebug(String message) {
        LOGGER.debug(message);
    }

    public static void logException(String message, Throwable throwable) {
        LOGGER.error(message, throwable);
    }


    public static void logElementNotFoundException(String locator) {
        String errorMessage = "Element not found with locator: " + locator;
        LOGGER.error(errorMessage);
    }

    public static void logTimeoutException(String operation) {
        String errorMessage = "Timeout while performing operation: " + operation;
        LOGGER.error(errorMessage);
    }

    public static void logAssertionError(String message, AssertionError assertionError) {
        LOGGER.error(message, assertionError);
    }



}
