package utils;

public class LoggerUtils {
    private static Logger logger = LogManager.getLogger(LoggerUtils.class);

    public static void configureLogger() {
        Configurator.initialize(null, "resources/log4j2.xml");
    }

    public static void info(String message) {
        logger.info(message);
    }

    public static void error(String message) {
        logger.error(message);
    }

    public static void debug(String message) {
        logger.debug(message);
    }
}

