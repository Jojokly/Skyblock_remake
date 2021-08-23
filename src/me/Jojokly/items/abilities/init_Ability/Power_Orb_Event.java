package me.Jojokly.items.abilities.init_Ability;

import me.Jojokly.items.abilities.right_click.Deploy;
import me.Jojokly.items.items.Power_Orb;
import me.Jojokly.skyblockmain.Main;
import me.Jojokly.stats.intelligence.Intelligence;
import net.md_5.bungee.api.chat.TextComponent;
import net.minecraft.server.v1_16_R3.NBTTagCompound;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class Power_Orb_Event implements Listener {

    static List<String> powerorb = new ArrayList<String>();

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        ItemStack item = p.getInventory().getItemInMainHand();
        if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (item.getType() == Material.AIR || !(item.hasItemMeta())) {
                return;
            }
            net.minecraft.server.v1_16_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(item);
            NBTTagCompound compound = (nmsItem.hasTag()) ? nmsItem.getTag() : new NBTTagCompound();
            String s1 = compound.getString("SbName");
            try {
                Power_Orb orb = Power_Orb.valueOf(s1);
                int intelligence = Intelligence.getmaxintelligence(p);
                int cost = intelligence / 2;
                if (Intelligence.getintelligence(p) < cost) {
                    e.setCancelled(true);
                    p.sendMessage("§cYou don't have enough Mana!");
                    return;
                }
                if (item.getItemMeta().getDisplayName().equalsIgnoreCase(orb.getRarity().getColor() + orb.getName() + "Power Orb")) {
                    if (!powerorb.contains(p.getName())) {
                        Intelligence.setIntelligence(p, Intelligence.getintelligence(p) - cost);
                        Deploy.deploy(orb, p);
                        p.spigot().sendMessage(TextComponent.fromLegacyText("§b-1/2 of your Mana (§6Deploy§b)"));
                        powerorb.add(p.getName());
                        new BukkitRunnable() {
                            int time = 20 * orb.getTime();

                            @Override
                            public void run() {
                                if (time == 0) {
                                    powerorb.remove(p.getName());
                                    cancel();
                                }
                                time--;
                            }
                        }.runTaskTimer(Main.getMain(), 0, 1);
                    } else {
                        p.sendMessage("§eYou already have an orb placed!");
                    }
                }
            }catch(IllegalArgumentException ignored) {
                }
            }
        }
    }