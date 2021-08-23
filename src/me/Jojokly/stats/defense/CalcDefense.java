package me.Jojokly.stats.defense;

import net.minecraft.server.v1_16_R3.NBTTagCompound;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CalcDefense {

    public static int gethelmetDefense(Player p) {
        if (p.getInventory().getHelmet() == null)
            return 0;
        ItemStack helmet = p.getInventory().getHelmet();
        net.minecraft.server.v1_16_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(helmet);
        NBTTagCompound combound = (nmsItem.hasTag()) ? nmsItem.getTag() : new NBTTagCompound();
        int health = combound.getInt("Defense");
        return health;
    }

    public static int getChestplateDefense(Player p) {
        if (p.getInventory().getChestplate() == null)
            return 0;
        ItemStack chestplate = p.getInventory().getChestplate();
        net.minecraft.server.v1_16_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(chestplate);
        NBTTagCompound combound = (nmsItem.hasTag()) ? nmsItem.getTag() : new NBTTagCompound();
        int health = combound.getInt("Defense");
        return health;
    }

    public static int getLeggingsDefense(Player p) {
        if (p.getInventory().getLeggings() == null)
            return 0;
        ItemStack leggings = p.getInventory().getLeggings();
        net.minecraft.server.v1_16_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(leggings);
        NBTTagCompound combound = (nmsItem.hasTag()) ? nmsItem.getTag() : new NBTTagCompound();
        int health = combound.getInt("Defense");
        return health;
    }

    public static int getBootsDefense(Player p) {
        if (p.getInventory().getBoots() == null)
            return 0;
        ItemStack boots = p.getInventory().getBoots();
        net.minecraft.server.v1_16_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(boots);
        NBTTagCompound combound = (nmsItem.hasTag()) ? nmsItem.getTag() : new NBTTagCompound();
        int health = combound.getInt("Defense");
        return health;
    }

}
