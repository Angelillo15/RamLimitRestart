package es.angelillo15.rlr.bukkit;

import es.angelillo15.rlr.api.RLRPlugin;
import org.bukkit.plugin.java.JavaPlugin;

public class RamLimitRestart extends JavaPlugin implements RLRPlugin  {
    private boolean debug = false;
    private boolean limitReached = false;
    private static RamLimitRestart instance;

    @Override
    public void onEnable() {
        instance = this;
    }

    public static RamLimitRestart getInstance() {
        return instance;
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
}
