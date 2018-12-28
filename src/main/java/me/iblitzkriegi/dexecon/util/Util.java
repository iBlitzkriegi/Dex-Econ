package me.iblitzkriegi.dexecon.util;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Util {

    public static String getUniqueId(Player player) {
        return player.getUniqueId().toString();
    }

    public static void sendMessage(CommandSender commandSender, String message) {
        //TODO Add plugin chat format here
        commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

}
