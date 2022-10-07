package es.angelillo15.rlr.bukkit;

import es.angelillo15.rlr.api.ILogger;
import es.angelillo15.rlr.api.RLRPlugin;
import es.angelillo15.rlr.bukkit.config.ConfigLoader;
import es.angelillo15.rlr.bukkit.utils.logger.RDebugLogger;
import es.angelillo15.rlr.bukkit.utils.logger.RLogger;
import org.bukkit.plugin.java.JavaPlugin;

public class RamLimitRestart extends JavaPlugin implements RLRPlugin  {
    private boolean debug = false;
    private boolean limitReached = false;
    private static RamLimitRestart instance;
    private static ILogger logger;

    public void setupLogger(){
        debug = getConfig().getBoolean("debug");
        if(debug) {
            logger = new RDebugLogger(getLogger());
        } else {
            logger = new RLogger(getLogger());
        }
    }

    @Override
    public void onEnable() {
        instance = this;
    }

    public static RamLimitRestart getInstance() {
        return instance;
    }

    @Override
    public void reload(){
        ConfigLoader.reload();
        setupLogger();
    }

    @Override
    public boolean isDebug() {
        return debug;
    }

    @Override
    public boolean isLimitReached() {
        return limitReached;
    }

    @Override
    public void setLimitReached(boolean limitReached) {
        this.limitReached = limitReached;
    }

    @Override
    public void setDebug(boolean debug) {
        this.debug = debug;
    }
    public static ILogger getPluginLogger() {
        return logger;
    }

}
