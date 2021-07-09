package me.Jojokly.stats.intelligence;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerGameModeChangeEvent;

public class EndlessMana implements Listener {

    @EventHandler
    public void onChange(PlayerGameModeChangeEvent e) {
        Player p = e.getPlayer();
        GameMode gm = e.getNewGameMode();
        if (gm.equals(GameMode.CREATIVE)) {
            Intelligence.setmaxIntelligence(p, 1000000);
            Intelligence.setIntelligence(p, 10000000);
        } else {
            Intelligence.setmaxIntelligence(p, 100);
            Intelligence.setIntelligence(p, 100);
        }
    }
}
