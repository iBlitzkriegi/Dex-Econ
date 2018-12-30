package me.iblitzkriegi.dexecon;

import me.iblitzkriegi.dexecon.commands.CommandBal;
import me.iblitzkriegi.dexecon.events.EvtJoin;
import me.iblitzkriegi.dexecon.events.EvtLeave;
import me.iblitzkriegi.dexecon.util.managers.ConfigManager;
import org.bukkit.plugin.java.JavaPlugin;

public class DexEcon extends JavaPlugin {

    @Override
    public void onEnable() {
        ConfigManager.getInstance().setup(this);
        getServer().getPluginManager().registerEvents(new EvtLeave(), this);
        getServer().getPluginManager().registerEvents(new EvtJoin(), this);
        getCommand("bal").setExecutor(new CommandBal());
    }

    @Override
    public void onDisable() {

    }

}
