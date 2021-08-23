package me.Jojokly.items.abilities.init_Ability;

import me.Jojokly.items.abilities.left_click.Rapid_Fire;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class Left_Click implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (!(e.getAction() == Action.LEFT_CLICK_BLOCK || e.getAction() == Action.LEFT_CLICK_AIR))
            return;
        ItemStack item = p.getInventory().getItemInMainHand();
        if (item.getType() == Material.AIR || !(item.hasItemMeta()))
            return;
        if (item.getItemMeta().getDisplayName().equals("§9Machine Gun Bow")) {
            Rapid_Fire.Rapid_Fire(p);
        }
    }

}
