package me.iblitzkriegi.dexecon.util;

import me.iblitzkriegi.dexecon.util.managers.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

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

    public static String getNameFromUUID(String input) {
        UUID uuid = UUID.fromString(input);
        OfflinePlayer player = Bukkit.getOfflinePlayer(uuid);
        if(player == null) return null;
        return player.getName();
    }

    public static String getUUIDfromName(String input) {
        OfflinePlayer player = Bukkit.getOfflinePlayer(input);
        if (player == null) return null;
        return player.getUniqueId().toString();
    }

}
