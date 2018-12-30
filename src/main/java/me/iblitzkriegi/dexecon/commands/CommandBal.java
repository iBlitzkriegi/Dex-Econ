package me.iblitzkriegi.dexecon.commands;

import me.iblitzkriegi.dexecon.util.Util;
import me.iblitzkriegi.dexecon.util.managers.ConfigManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

public class CommandBal implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (!(commandSender instanceof Player)) {
            if (args.length == 0) {
                Util.sendMessage(commandSender, "You must specify a player to get the balance of!");
                return true;
            }
            if (args.length != 1) {
                Util.sendMessage(commandSender, "Invalid usage! Console must specify a single player to get the balance of.");
                return true;
            }
            String uuid = Util.getUUIDfromName(args[0]);
            if (uuid == null) {
                Util.sendMessage(commandSender, "Could not find a user by the provided name");
                return true;
            }
            ConfigurationSection configurationSection = ConfigManager.getConfig().getConfigurationSection("Balances." + uuid);
            if (configurationSection == null) {
                Util.sendMessage(commandSender, "Could not find a user by the provided name");
                return true;
            }
            Util.sendMessage(commandSender, args[0] + "'s current balance is: " + configurationSection.getInt("balance"));
            return true;
        }
        return true;
    }
}
