package me.Jojokly.items.abilities;

import me.Jojokly.items.items.Power_Orb;
import me.Jojokly.items.items.SkyblockItems;
import me.Jojokly.stats.intelligence.Intelligence;
import net.minecraft.server.v1_16_R3.NBTTagCompound;
import org.bukkit.Material;
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
        if (p.getItemInHand().hasItemMeta()) {
            ItemStack item = p.getItemInHand();
            if (item.getType() == Material.AIR || !(item.hasItemMeta()))
                return;
            net.minecraft.server.v1_16_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(item);
            NBTTagCompound compound = (nmsItem.hasTag()) ? nmsItem.getTag() : new NBTTagCompound();
            try {
                String s1 = compound.getString("SbName");
                SkyblockItems items = SkyblockItems.valueOf(s1);
                int intelligence = me.Jojokly.stats.intelligence.Intelligence.getintelligence(p);
                int manacost = items.getManacost();
                if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                    if (manacost < intelligence) {
                        Intelligence.setIntelligence(p, intelligence - manacost);
                        if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§6Hyperion")) {
                            Wither_Impact.wither_impact(p);
                        } else if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§6Giant's Sword")) {
                            Giant_Slam.GiantSlam(p);
                        } else if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§9Aspect of the End")) {
                            Instant_Transmission.teleport(p);
                        } else if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§fAspect of the Jerry")) {
                            Parley.playParley(p);
                        } else if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§9Golem Sword")) {
                            Iron_punch.IronPunch(p);
                        } else if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§5Ember Rod")) {
                            Fire_blast.FireBlast(p);
                        } else if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§6Spirit Sceptre")) {
                            Guided_Bat.guidedBat(p);
                        } else if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§fRogue Sword")) {
                            Speed_Boost.boostSpeed(p, 0.2f);
                        } else if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§6Bonemerang")) {
                            e.setCancelled(true);
                            Swing.Swing(p);
                        } else if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§9Bonzo's Staff")) {
                            Showtime.showtime(p);
                        }
                    } else {
                        p.sendMessage("§cYou don't have enogh Mana!");
                    }
                }
            } catch (IllegalArgumentException exception) {
                exception.printStackTrace();
            }
        }
    }
}
