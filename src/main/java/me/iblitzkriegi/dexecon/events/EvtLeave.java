package me.iblitzkriegi.dexecon.events;

import me.iblitzkriegi.dexecon.util.Util;
import me.iblitzkriegi.dexecon.util.managers.EconManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class EvtLeave implements Listener {

    @EventHandler
    public void playerLeave(PlayerQuitEvent playerQuitEvent) {
        EconManager.balanceMap.put(Util.getUniqueId(playerQuitEvent.getPlayer()), null);
    }

}
