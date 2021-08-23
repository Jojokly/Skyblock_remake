package me.Jojokly.mobs.Loot;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class RareDropListener implements Listener {

    @EventHandler
    public void onRareDrop(RareDropEvent e) {
        Player p = e.getPlayer();
        ItemStack item = e.getDrop();
        p.sendMessage("HEPPPP!");
        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
    }
}
