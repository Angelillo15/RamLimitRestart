package es.angelillo15.rlr.api;

public interface RLRPlugin {
    boolean isDebug();

    boolean isLimitReached();

    void setLimitReached(boolean limitReached);

    void setDebug(boolean debug);

    void reload();
}
