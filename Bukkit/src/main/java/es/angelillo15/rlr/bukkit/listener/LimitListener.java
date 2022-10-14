package es.angelillo15.rlr.bukkit.listener;

import es.angelillo15.rlr.api.events.CommandOnLimitReachedEvent;
import es.angelillo15.rlr.api.events.LimitReachedEvent;
import es.angelillo15.rlr.bukkit.RamLimitRestart;
import es.angelillo15.rlr.bukkit.config.ConfigLoader;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import java.util.List;

public class LimitListener implements Listener {
    @EventHandler
    public void onLimitReached(LimitReachedEvent event) {
        int delay = ConfigLoader.getConfig().getInt("Config.delay");
        List<String> commands = ConfigLoader.getConfig().getStringList("Config.commands");
        Bukkit.getScheduler().scheduleSyncDelayedTask(RamLimitRestart.getInstance(), () -> {
            commands.forEach(command -> {
                Bukkit.getPluginManager().callEvent(new CommandOnLimitReachedEvent(command));
            });
        }, delay * 20L);
    }
    
    @EventHandler(priority = EventPriority.MONITOR)
    public void onCommandOnLimitReached(CommandOnLimitReachedEvent event) {
        if (!event.isCancelled()) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), event.getCommand());
            RamLimitRestart.getPluginLogger().debug("Command executed: " + event.getCommand());
        }
    }
}
