package me.Jojokly.stats.health;

import me.Jojokly.skyblockmain.Main;
import net.minecraft.server.v1_16_R3.NBTTagCompound;
import org.bukkit.NamespacedKey;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class CalcHealth {

    public static int gethelmetHealth(Player p) {
        if (p.getInventory().getHelmet() == null)
            return 0;
        ItemStack helmet = p.getInventory().getHelmet();
        net.minecraft.server.v1_16_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(helmet);
        NBTTagCompound combound = (nmsItem.hasTag()) ? nmsItem.getTag() : new NBTTagCompound();
        int health = combound.getInt("Health");
        return health;
    }

    public static int getChestplateHealth(Player p) {
        if (p.getInventory().getChestplate() == null)
            return 0;
        ItemStack chestplate = p.getInventory().getChestplate();
        net.minecraft.server.v1_16_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(chestplate);
        NBTTagCompound combound = (nmsItem.hasTag()) ? nmsItem.getTag() : new NBTTagCompound();
        int health = combound.getInt("Health");
        return health;
    }

    public static int getLeggingsHealth(Player p) {
        if (p.getInventory().getLeggings() == null)
            return 0;
        ItemStack leggings = p.getInventory().getLeggings();
        net.minecraft.server.v1_16_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(leggings);
        NBTTagCompound combound = (nmsItem.hasTag()) ? nmsItem.getTag() : new NBTTagCompound();
        int health = combound.getInt("Health");
        return health;
    }

    public static int getBootsHealth(Player p) {
        if (p.getInventory().getBoots() == null)
            return 0;
        ItemStack boots = p.getInventory().getBoots();
        net.minecraft.server.v1_16_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(boots);
        NBTTagCompound combound = (nmsItem.hasTag()) ? nmsItem.getTag() : new NBTTagCompound();
        int health = combound.getInt("Health");
        return health;
    }
}
