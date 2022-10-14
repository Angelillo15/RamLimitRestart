package es.angelillo15.rlr.api;

public interface ILogger {
    /**
     * <p>Logs a message to the console</p>
     * @param message the message to log
     */
    void info(String message);

    /**
     * <p>Logs a message as a warning to the console</p>
     * @param message the message to log with warning color
     */
    void warn(String message);

    /**
     * <p>Logs a message as an error to the console</p>
     * @param message the message to log with error color
     */
    void error(String message);

    /**
     * <p>Logs a message only if debug mode is enable to the console</p>
     * @param message the message to log with debug color
     */
    void debug(String message);
}
