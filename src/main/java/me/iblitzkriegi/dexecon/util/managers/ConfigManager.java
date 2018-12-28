package me.iblitzkriegi.dexecon.util.managers;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class ConfigManager {

    static ConfigManager instance = new ConfigManager();
    Plugin plugin;
    FileConfiguration config;
    File file;
    public static String prefix;

    public static ConfigManager getInstance() {
        return instance;
    }

    public void setup(Plugin plugin) {
        this.plugin = plugin;
        config = plugin.getConfig();
        file = new File(plugin.getDataFolder(), "config.yml");
        getConfig().options().copyDefaults(true);
        plugin.saveDefaultConfig();
        prefix = config.getString("plugin-prefix");

    }

    public void saveConfig() {
        try {
            config.save(file);
        } catch (IOException e) {

        }
    }

    public void reloadConfig() {
        config = YamlConfiguration.loadConfiguration(file);
        prefix = config.getString("plugin-prefix");
    }

    public static String getPrefix() {
        return prefix;
    }

    public FileConfiguration getConfig() {
        return plugin.getConfig();
    }

}
