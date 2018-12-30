package me.iblitzkriegi.dexecon.events;

import me.iblitzkriegi.dexecon.util.managers.EconManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class EvtJoin implements Listener {

    @EventHandler
    public void playerJoin(PlayerJoinEvent playerJoinEvent) {
        EconManager.setupPlayer(playerJoinEvent.getPlayer());
    }

}
