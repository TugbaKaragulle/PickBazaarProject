package utilities;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StepLogger {

    private static final Logger logger = LogManager.getLogger(StepLogger.class);

    @Step("{message}")
    public static void log(String message) {
        logger.info("[STEP] " + message);
    }
}