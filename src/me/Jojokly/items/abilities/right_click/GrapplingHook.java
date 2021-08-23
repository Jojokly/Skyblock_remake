package me.Jojokly.items.abilities.right_click;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.util.Vector;

public class GrapplingHook implements Listener {

    @EventHandler
    public void onInteract(PlayerFishEvent e) {
        Player p = e.getPlayer();
        Vector v = p.getLocation().getDirection().multiply(4D).setY(1.5D);
        if (e.getState().equals(PlayerFishEvent.State.REEL_IN) || e.getState().equals(PlayerFishEvent.State.IN_GROUND)) {
            if (p.getItemInHand().hasItemMeta()) {
                if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§aGrappling Hook"))
                p.setVelocity(v);
            }
        }
    }
}
