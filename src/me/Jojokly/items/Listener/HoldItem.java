package me.Jojokly.items.Listener;

import me.Jojokly.items.items.SkyblockItems;
import me.Jojokly.stats.intelligence.Intelligence;
import net.minecraft.server.v1_16_R3.NBTTagCompound;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class HoldItem implements Listener {


    @EventHandler
    public void onHold(PlayerItemHeldEvent e) {
        Player p = e.getPlayer();
        int newslot = e.getNewSlot();
        int oldslot = e.getPreviousSlot();
        ItemStack newitem = p.getInventory().getItem(newslot);
        ItemStack olditem = p.getInventory().getItem(oldslot);
        net.minecraft.server.v1_16_R3.ItemStack newnmsItem = CraftItemStack.asNMSCopy(newitem);
        net.minecraft.server.v1_16_R3.ItemStack oldnmsItem = CraftItemStack.asNMSCopy(olditem);
        NBTTagCompound newcompound = (newnmsItem.hasTag()) ? newnmsItem.getTag() : new NBTTagCompound();
        NBTTagCompound oldcompound = (oldnmsItem.hasTag()) ? oldnmsItem.getTag() : new NBTTagCompound();
        Integer newintel = newcompound.getInt("Intelligence");
        Integer oldintel = oldcompound.getInt("Intelligence");
        if (newitem == null) {
            Intelligence.setmaxIntelligence(p, Intelligence.getmaxintelligence(p) - oldintel);
            return;
        }
        if (newitem == null && olditem == null)
            return;
        if (!newitem.hasItemMeta())
            return;
        if (olditem != null && newitem != null) {
            if (olditem == newitem)
                return;
            if (newitem.hasItemMeta()) {
                Intelligence.setmaxIntelligence(p, Intelligence.getmaxintelligence(p) - oldintel);
                Intelligence.setmaxIntelligence(p, Intelligence.getmaxintelligence(p) + newintel);
            } else {
                Intelligence.setmaxIntelligence(p, Intelligence.getmaxintelligence(p) - oldintel);
            }
        } else if (olditem != null && newitem == null) {
            Intelligence.setmaxIntelligence(p, Intelligence.getmaxintelligence(p) - oldintel);
        } else if (olditem == null && newitem != null) {
            if (olditem == newitem)
                return;
            if (newitem.hasItemMeta()) {
                Intelligence.setmaxIntelligence(p, Intelligence.getmaxintelligence(p) - oldintel);
                Intelligence.setmaxIntelligence(p, Intelligence.getmaxintelligence(p) + newintel);
            }
        }
    }
}