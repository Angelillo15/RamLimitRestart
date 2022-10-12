package es.angelillo15.rlr.api;

import org.bukkit.Bukkit;

public interface RLRPlugin {
    /**
     * @return if the plugin is in debug mode
     */
    boolean isDebug();

    /**
     * @return the plugin's logger
     */
    boolean isLimitReached();

    /**
     * <p>Set the limit as reached</p>
     * @param limitReached true if the limit is reached
     *                     false will ignore
     */
    void setLimitReached(boolean limitReached);

    /**
     * @param debug enable/disable debug mode
     */
    void setDebug(boolean debug);

    /**
     * <p>Reloads the plugin</p>
     */
    void reload();

    /**
     * @return the plugin instance
     *
     */
    public static RLRPlugin getInstance(){
        RLRPlugin plugin = (RLRPlugin) Bukkit.getPluginManager().getPlugin("RamLimitRestart");
        if(plugin == null){
            throw new IllegalStateException("RamLimitRestart plugin is not loaded");
        } else {
            return plugin;
        }
    }
}
