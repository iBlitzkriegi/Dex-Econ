package me.iblitzkriegi.dexecon.util;

import me.iblitzkriegi.dexecon.util.managers.ConfigManager;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Util {

    public static String getUniqueId(Player player) {
        return player.getUniqueId().toString();
    }

    public static void sendMessage(CommandSender commandSender, String message) {
        commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigManager.getPrefix() + message));
    }

    public static boolean hasPermission(Player player, String permission) {
        if (player.hasPermission(permission)) {
            return true;
        }
        sendMessage(player, "You must have the " + permission + " permission in order to run this command!");
        return false;
    }

}
