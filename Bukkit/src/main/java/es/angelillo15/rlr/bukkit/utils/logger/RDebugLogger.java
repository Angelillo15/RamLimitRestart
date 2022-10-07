package es.angelillo15.rlr.bukkit.utils.logger;

import es.angelillo15.rlr.api.ILogger;

import java.util.logging.Logger;

public class RDebugLogger implements ILogger {
    private Logger logger;

    public RDebugLogger(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void info(String message) {
        logger.info(message);
    }

    @Override
    public void warn(String message) {
        logger.warning(message);
    }

    @Override
    public void error(String message) {
        logger.severe(message);
    }

    @Override
    public void debug(String message) {
        logger.info("[DEBUG] " + message);
    }
}
