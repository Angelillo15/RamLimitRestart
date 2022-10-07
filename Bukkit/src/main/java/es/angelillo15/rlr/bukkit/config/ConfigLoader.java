package es.angelillo15.rlr.bukkit.config;

import es.angelillo15.configmanager.ConfigManager;
import es.angelillo15.rlr.bukkit.RamLimitRestart;

public class ConfigLoader {
    private static RamLimitRestart plugin;
    private static ConfigManager config;

    public ConfigLoader(RamLimitRestart plugin) {
        this.plugin = plugin;
    }

    public void load() {
        loadConfig();
    }

    public void loadConfig(){
        config = new ConfigManager(plugin.getDataFolder().toPath(), "config.yml", "config.yml");
        config.registerConfig();
    }

    public static void reload(){
        config.registerConfig();
    }
}