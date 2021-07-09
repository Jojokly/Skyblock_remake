package me.Jojokly.items.items;

import net.minecraft.server.v1_16_R3.NBTTagCompound;
import net.minecraft.server.v1_16_R3.NBTTagString;
import net.minecraft.server.v1_16_R3.NBTTagTypes;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;

public class ItemBuilder {

    public static ItemStack createItem(SkyblockItems sbitem) {
        ArrayList<String> lore = new ArrayList<String>();
        Rarity rarity = sbitem.getRarity();
        int damage = sbitem.getDamage();
        int intel = sbitem.getIntelligence();
        int strength = sbitem.getStrength();
        ItemStack item = new ItemStack(sbitem.getMaterial());
        net.minecraft.server.v1_16_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(item);
        NBTTagCompound combound = (nmsItem.hasTag()) ? nmsItem.getTag() : new NBTTagCompound();
        combound.setString("SbName", sbitem.getTag());
        combound.setInt("Intelligence", sbitem.getIntelligence());
        int random = (int)(Math.random() * 1000000 + 1);
        combound.setInt("Random", random);
        nmsItem.setTag(combound);
        ItemStack finalItem = CraftItemStack.asBukkitCopy(nmsItem);
        ItemMeta itemmeta = finalItem.getItemMeta();
        itemmeta.setDisplayName(sbitem.getName());
        if (damage != 0) {
            lore.add("§7Damage: §c" + damage);
        }
        if (strength != 0) {
            lore.add("§7Strength: §c" + strength);
        }
        if (intel != 0) {
            lore.add(" ");
            lore.add("§7Intelligence: §a" + intel);
        }
        lore.add(" ");
        for (String lines : sbitem.getLore()) lore.add(lines);
        lore.add(rarity.getColor() + "" + ChatColor.BOLD +rarity.getName().toUpperCase());
        itemmeta.setLore(lore);
        itemmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemmeta.setUnbreakable(true);
        finalItem.setItemMeta(itemmeta);
        return finalItem;
    }

    public static ItemStack colorArmor(Material material, Color color) {
        ItemStack item = new ItemStack(material);
        LeatherArmorMeta itemMeta = (LeatherArmorMeta) item.getItemMeta();
        itemMeta.setColor(color);
        item.setItemMeta(itemMeta);
        return item;
    }
}
