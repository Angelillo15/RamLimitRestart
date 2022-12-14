package es.angelillo15.rlr.bukkit;

import es.angelillo15.rlr.api.ILogger;
import es.angelillo15.rlr.api.RLRPlugin;
import es.angelillo15.rlr.api.bukkit.events.LimitReachedEvent;
import es.angelillo15.rlr.bukkit.commands.MainCommand;
import es.angelillo15.rlr.bukkit.config.ConfigLoader;
import es.angelillo15.rlr.bukkit.listener.LimitListener;
import es.angelillo15.rlr.bukkit.utils.AutoUpdater;
import es.angelillo15.rlr.bukkit.utils.Queries;
import es.angelillo15.rlr.bukkit.utils.logger.RDebugLogger;
import es.angelillo15.rlr.bukkit.utils.logger.RLogger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public class RamLimitRestart extends JavaPlugin implements RLRPlugin  {
    private boolean debug = false;
    private boolean limitReached = false;
    private static RamLimitRestart instance;
    private static ILogger logger;
    private BukkitTask task;

    public void setupLogger(){
        debug = getConfig().getBoolean("Config.debug");

        if (debug) logger = new RDebugLogger(getLogger());
        else logger = new RLogger(getLogger());
    }

    @SuppressWarnings("deprecation")
    public void setupScheduler(){
            Bukkit.getScheduler().scheduleAsyncRepeatingTask(this, () -> {
            double memoryInUsage = Queries.getUsageMemory();
            int maxMemory = Queries.getMaxMemory();
            int limit = getConfig().getInt("Config.limit");

            if(memoryInUsage >= maxMemory - limit){
                if(!limitReached){
                    limitReached = true;
                    Bukkit.getScheduler().scheduleSyncDelayedTask(this, () -> {
                        Bukkit.getPluginManager().callEvent(new LimitReachedEvent());
                    }, 0L);
                }
            }

            RamLimitRestart.getPluginLogger().debug(ChatColor.translateAlternateColorCodes('&', ConfigLoader.getConfig().getString("Messages.debug-message"))
                    .replace("%memory_usage%", String.valueOf(memoryInUsage))
                    .replace("%memory_free%", String.valueOf(maxMemory - memoryInUsage))
                    .replace("%memory_max%", String.valueOf(maxMemory))
            );
        }, 0L, getConfig().getLong("Config.check-interval") * 20L);
    }

    public void autoUpdater(){
        AutoUpdater updater = new AutoUpdater(98166);
        updater.checkForUpdates();
        if(updater.hasUpdate()){
            RamLimitRestart.getPluginLogger().info(ChatColor.translateAlternateColorCodes('&',
                    "&cThere is a new version of RamLimitRestart available!")
            );
            RamLimitRestart.getPluginLogger().info(ChatColor.translateAlternateColorCodes('&',
                    "&6Download it: https://www.spigotmc.org/resources/ramlimitrestart.98166/")
            );

        }
    }

    public void registerCommands(){
        this.getCommand("rlr").setExecutor(new MainCommand());
    }

    public void registerListners(){
        Bukkit.getPluginManager().registerEvents(new LimitListener(), this);
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
