package me.iblitzkriegi.dexecon;

import me.iblitzkriegi.dexecon.util.managers.ConfigManager;
import org.bukkit.plugin.java.JavaPlugin;

public class DexEcon extends JavaPlugin {

    @Override
    public void onEnable() {
        ConfigManager.getInstance().setup(this);
    }

    @Override
    public void onDisable() {

    }

}
