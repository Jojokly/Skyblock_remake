package me.Jojokly.general;

import me.Jojokly.items.items.SkyblockItems;
import me.Jojokly.stats.intelligence.Intelligence;
import net.minecraft.server.v1_16_R3.NBTTagCompound;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Formulas {

    public static int Weapondamage(Player p) {
        ItemStack item = p.getItemInHand();
        net.minecraft.server.v1_16_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(item);
        NBTTagCompound compound = (nmsItem.hasTag()) ? nmsItem.getTag() : new NBTTagCompound();
        String s1 = compound.getString("SbName");
        SkyblockItems items = SkyblockItems.valueOf(s1);
        final int damage = (5 + items.getDamage()) * (1+ items.getStrength() / 100);
        return damage;
    }

    public static int Abilitydamage(Player p, int basedamage, int scaling) {
        ItemStack item = p.getItemInHand();
        net.minecraft.server.v1_16_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(item);
        NBTTagCompound compound = (nmsItem.hasTag()) ? nmsItem.getTag() : new NBTTagCompound();
        String s1 = compound.getString("SbName");
        SkyblockItems items = SkyblockItems.valueOf(s1);
        final int abilitydamage = (int) (basedamage * (1+(Intelligence.getmaxintelligence(p) / 100) * scaling));
        return abilitydamage;
    }
}
