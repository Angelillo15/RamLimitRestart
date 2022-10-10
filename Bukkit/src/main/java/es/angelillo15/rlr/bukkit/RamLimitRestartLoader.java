package es.angelillo15.rlr.bukkit;

import es.angelillo15.rlr.bukkit.config.ConfigLoader;

public class RamLimitRestartLoader extends RamLimitRestart {
    @Override
    public void onEnable() {
        super.onEnable();
        new ConfigLoader(getInstance()).loadConfig();
        setupLogger();
        setupScheduler();
    }

    @Override
    public void onDisable() {

    }
}
