package me.Jojokly.items.abilities;

import net.minecraft.server.v1_16_R3.NBTTagCompound;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class Right_click implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (p.getItemInHand().hasItemMeta()) {
                if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§6Hyperion")) {
                    Wither_Impact.wither_impact(p, 250);
                } else if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§6Giant's Sword")) {
                    Giant_Slam.GiantSlam(p, 500);
                } else if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§9Aspect of the End")) {
                    Instant_Transmission.teleport(p);
                }else if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§fAspect of the Jerry")) {
                    Parley.playParley(p);
                }else if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§9Golem Sword")) {
                    Iron_punch.IronPunch(p, 70);
                }else if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§5Ember Rod")) {
                    Fire_blast.FireBlast(p, 150);
                }else if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§6Spirit Sceptre")) {
                    Guided_Bat.guidedBat(p);
                } else if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§fRogue Sword")) {
                    Speed_Boost.boostSpeed(p, 0.2f);
                } else if(p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§6Bonemerang")) {
                    e.setCancelled(true);
                    Swing.Swing(p);
                }
            }
        }
    }
}
