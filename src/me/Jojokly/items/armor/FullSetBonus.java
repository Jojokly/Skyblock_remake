package me.Jojokly.items.armor;

import me.Jojokly.items.armor.Setbonus.LapisHealth;
import me.Jojokly.skyblockmain.Main;
import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_16_R3.NBTTagCompound;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;

public class FullSetBonus implements Listener {

    Map<Player, String> isActive = new HashMap<>();

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        new BukkitRunnable() {
            @Override
            public void run() {
                ItemStack helmet = p.getInventory().getHelmet();
                if (helmet == null)
                    return;
                ItemStack chestplate = p.getInventory().getChestplate();
                if (chestplate == null)
                    return;
                ItemStack leggings = p.getInventory().getLeggings();
                if (leggings == null)
                    return;
                ItemStack boots = p.getInventory().getBoots();
                if (boots == null)
                    return;
                net.minecraft.server.v1_16_R3.ItemStack nmsHelmet = CraftItemStack.asNMSCopy(helmet);
                NBTTagCompound combound = (nmsHelmet.hasTag()) ? nmsHelmet.getTag() : new NBTTagCompound();
                String helmetbonus = combound.getString("Full_Set_Bonus");
                net.minecraft.server.v1_16_R3.ItemStack nmsChestplate = CraftItemStack.asNMSCopy(chestplate);
                NBTTagCompound combound1 = (nmsChestplate.hasTag()) ? nmsChestplate.getTag() : new NBTTagCompound();
                String chestplatebonus = combound1.getString("Full_Set_Bonus");
                net.minecraft.server.v1_16_R3.ItemStack nmsLeggings = CraftItemStack.asNMSCopy(leggings);
                NBTTagCompound combound2 = (nmsLeggings.hasTag()) ? nmsLeggings.getTag() : new NBTTagCompound();
                String leggingsbonus = combound2.getString("Full_Set_Bonus");
                net.minecraft.server.v1_16_R3.ItemStack nmsBoots = CraftItemStack.asNMSCopy(boots);
                NBTTagCompound combound3 = (nmsBoots.hasTag()) ? nmsBoots.getTag() : new NBTTagCompound();
                String bootsbonus = combound3.getString("Full_Set_Bonus");
                if (helmetbonus.equals(chestplatebonus) && helmetbonus.equals(leggingsbonus) && helmetbonus.equals(bootsbonus)) {
                    if (helmet.getItemMeta().getDisplayName().equals("§aLapis Armor Helmet")) {
                        if (isActive.containsKey(p))
                            return;
                        LapisHealth.Health(p);
                        isActive.put(p, "Health");
                    }
                }
            }
        }.runTaskTimer(Main.getMain(), 0, 1);
    }
}