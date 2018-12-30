package me.iblitzkriegi.dexecon.util.managers;

import me.iblitzkriegi.dexecon.util.Util;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class EconManager {
    public static HashMap<String, Integer> balanceMap = new HashMap<>();

    public static ConfigurationSection setupPlayer(Player player) {
        FileConfiguration config = ConfigManager.getConfig();
        String uuid = Util.getUniqueId(player);
        ConfigurationSection configurationSection = config.getConfigurationSection("Balances." + uuid);
        if (configurationSection == null) {
            ConfigurationSection userSection = config.createSection("Balances." + uuid);
            userSection.set("balance", ConfigManager.defaultBalance);
            balanceMap.put(uuid, ConfigManager.defaultBalance);
            ConfigManager.getInstance().saveConfig();
            return userSection;
        }
        balanceMap.put(uuid, configurationSection.getInt("balance"));

        return null;
    }


    public static HashMap<String, Integer> getBalanceMap() {
        return balanceMap;
    }

    public void setBalance(Player player, int balance) {
        FileConfiguration config = ConfigManager.getConfig();
        String uuid = Util.getUniqueId(player);
        ConfigurationSection configurationSection = config.getConfigurationSection("Balances." + uuid);
        if (configurationSection == null) {
            setupPlayer(player)
                    .set("balance", balance);
            ConfigManager.getInstance().saveConfig();
            return;
        }
        configurationSection.set("balance", balance);
        ConfigManager.getInstance().saveConfig();
    }

    public int getBalance(Player player, String balance) {
        FileConfiguration config = ConfigManager.getConfig();
        String uuid = Util.getUniqueId(player);
        ConfigurationSection configurationSection = config.getConfigurationSection("Balances." + uuid);
        if (configurationSection == null) {
            return 0;
        }
        return configurationSection.getInt("balance");
    }

}
