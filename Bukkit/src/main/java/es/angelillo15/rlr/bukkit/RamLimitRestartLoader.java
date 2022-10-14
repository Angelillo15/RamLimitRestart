package es.angelillo15.rlr.bukkit;

import es.angelillo15.rlr.bukkit.config.ConfigLoader;
import es.angelillo15.rlr.bukkit.metrics.Metrics;

public class RamLimitRestartLoader extends RamLimitRestart {
    @Override
    public void onEnable() {
        super.onEnable();
        new ConfigLoader(getInstance()).loadConfig();
        setupLogger();
        setupScheduler();
        registerCommands();
        registerListners();
        new Metrics(this, 16665);
        autoUpdater();
    }
}
