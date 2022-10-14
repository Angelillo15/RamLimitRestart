package es.angelillo15.rlr.bukkit.commands;

import es.angelillo15.rlr.bukkit.RamLimitRestart;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage("§aRamLimitRestart v1.0 by Angelillo15");
            sender.sendMessage("§a/rlr reload - Reloads the config");
            sender.sendMessage("§a/rlr help - Shows this message");
            return true;
        } else if (args.length == 1) {
            if (args[0].equalsIgnoreCase("reload")) {
                if (sender.hasPermission("rlr.reload") | (sender instanceof Player)) {
                    sender.sendMessage("§aReloading config...");
                    RamLimitRestart.getInstance().reload();
                    sender.sendMessage("§aConfig reloaded!");
                } else {
                    sender.sendMessage("§cYou don't have permission to do that!");
                }
                return true;
            } else if (args[0].equalsIgnoreCase("help")) {
                sender.sendMessage("§aRamLimitRestart v1.0 by Angelillo15");
                sender.sendMessage("§a/rlr reload - Reloads the config");
                sender.sendMessage("§a/rlr help - Shows this message");
                return true;
            }

        } else {
            return false;
        }
        return false;
    }
}
