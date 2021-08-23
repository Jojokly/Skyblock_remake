package me.Jojokly.items.armor;

import net.minecraft.server.v1_16_R3.NBTTagCompound;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArmorBuilder {

    public static ItemStack build(Armor armor) {
        List<String> lore = new ArrayList<>();
        ItemStack itemStack = armor.getMaterial();
        net.minecraft.server.v1_16_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(itemStack);
        NBTTagCompound combound = (nmsItem.hasTag()) ? nmsItem.getTag() : new NBTTagCompound();
        combound.setInt("Health", armor.getHealth());
        combound.setInt("Defense", armor.getDefense());
        combound.setString("Full_Set_Bonus", armor.getFull_set_bonus());
        Random r = new Random();
        int random = r.nextInt(20000000);
        combound.setInt("Random", random);
        if (armor.isHelmet()) {
            combound.setBoolean("Helmet", true);
        }
        nmsItem.setTag(combound);
        ItemStack item = CraftItemStack.asBukkitCopy(nmsItem);
        ItemMeta meta = item.getItemMeta();
        ChatColor color = armor.getRarity().getColor();
        meta.setDisplayName(color + armor.getName());
        if (armor.getHealth() != 0) {
            lore.add("§7Health: §c+" + armor.getHealth());
        }
        if (armor.getDefense() != 0) {
            lore.add("§7Defense: §a+" + armor.getDefense());
        }
        lore.add(" ");
        for (String lines : armor.getLore()) {
            lore.add(lines);
        }
        lore.add(" ");
        if (armor.isReforgeable()) {
            lore.add("§8This item can be reforged!");
        }
        lore.add(color + "" + ChatColor.BOLD + armor.getRarity().getName().toUpperCase());
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_DYE);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }
}
