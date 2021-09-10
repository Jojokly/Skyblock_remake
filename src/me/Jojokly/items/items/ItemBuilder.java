package me.Jojokly.items.items;

import net.minecraft.server.v1_16_R3.NBTTagCompound;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ItemBuilder {

    public static ItemStack createItem(Weapons sbitem) {
        ArrayList<String> lore = new ArrayList<String>();
        Rarity rarity = sbitem.getRarity();
        int damage = sbitem.getDamage();
        int intel = sbitem.getIntelligence();
        int strength = sbitem.getStrength();
        boolean isEnchanted = sbitem.isEnchanted();
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
        itemmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemmeta.setUnbreakable(true);
        if (isEnchanted) {
            itemmeta.addEnchant(Enchantment.DURABILITY, 1, true);
        }
        finalItem.setItemMeta(itemmeta);
        return finalItem;
    }

    public static ItemStack createPowerOrb(Power_Orb orb) {
        List<String> lore = new ArrayList<String>();
        ChatColor color = orb.getRarity().getColor();
        ItemStack item = new ItemStack(getHead(orb.getHeadId()));
        net.minecraft.server.v1_16_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(item);
        NBTTagCompound combound = (nmsItem.hasTag()) ? nmsItem.getTag() : new NBTTagCompound();
        combound.setString("SbName", orb.getRawname());
        ItemStack orbItem = CraftItemStack.asBukkitCopy(nmsItem);
        SkullMeta meta = (SkullMeta) orbItem.getItemMeta();
        meta.setDisplayName(color + orb.getName() + "Power Orb");
        lore.add("§6Item Ability: Deploy");
        lore.add("§7Place an Orb for §a " + orb.getTime() + "s §7buffing");
        lore.add("§7up to §b5 §7players within §a18");
        lore.add("§7blocks.");
        lore.add("§8Costs 50% of max mana.");
        lore.add("§8Only one orb applies per player.");
        lore.add(" ");
        for (String lines : orb.getLore()) lore.add(lines);
        lore.add(" ");
        lore.add(orb.getRarity().getColor() + "" + ChatColor.BOLD + orb.getRarity().getName().toUpperCase());
        meta.setLore(lore);
        orbItem.setItemMeta(meta);
        return orbItem;
    }

    public static ItemStack colorArmor(Material material, Color color) {
        ItemStack item = new ItemStack(material);
        LeatherArmorMeta itemMeta = (LeatherArmorMeta) item.getItemMeta();
        itemMeta.setColor(color);
        item.setItemMeta(itemMeta);
        return item;
    }

    public static ItemStack createHead(String value) {
            ItemStack item = new ItemStack(getHead(value));
            SkullMeta meta = (SkullMeta) item.getItemMeta();
            item.setItemMeta(meta);
        return item;
    }

    @SuppressWarnings("deprecation")
    public static ItemStack getHead(String value) {
        ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
        UUID hashAsId = new UUID(value.hashCode(), value.hashCode());
        return Bukkit.getUnsafe().modifyItemStack(skull,
                "{SkullOwner:{Id:\"" + hashAsId + "\",Properties:{textures:[{Value:\"" + value + "\"}]}}}"
        );
    }

    public static ItemStack createBow(Bow bows) {
        List<String> lore = new ArrayList<String>();
        ChatColor color = bows.getRarity().getColor();
        ItemStack item = new ItemStack(bows.getMaterial());
        net.minecraft.server.v1_16_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(item);
        NBTTagCompound combound = (nmsItem.hasTag()) ? nmsItem.getTag() : new NBTTagCompound();
        combound.setString("Sbname", bows.getRawname());
        combound.setInt("Damage", bows.getDamage());
        combound.setBoolean("isShortBow", bows.isShortBow());
        nmsItem.setTag(combound);
        ItemStack finalItem = CraftItemStack.asBukkitCopy(nmsItem);
        ItemMeta meta = finalItem.getItemMeta();
        meta.setDisplayName(bows.getRarity().getColor() + bows.getName());
        lore.add("§7Damage: §c+" + bows.getDamage());
        if (bows.getStrength() != 0) {
            lore.add("§7Strength: §c" + bows.getStrength());
        }
        if (bows.getCritdamage() != 0) {
            lore.add("§7Crit damage: §c+" + bows.getCritdamage());
        }
        if (bows.getCritchance() != 0) {
            lore.add("§7Crit Chance: §c+" + bows.getCritchance());
        }
        if (bows.isShortBow()) {
            lore.add("");
            lore.add(color + "Shortbow: Instantly Shoots!");
            lore.add("§7Hits §c3 mobs on impact. Can damage");
            lore.add("§7endermen. ");
        }
        lore.add(" ");
        for (String lines : bows.getLore()) lore.add(lines);
        lore.add(" ");
        lore.add("§8This item can be reforged!");
        lore.add(bows.getRarity().getColor() + "" + ChatColor.BOLD + bows.getRarity().getName().toUpperCase());
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.setUnbreakable(true);
        meta.setLore(lore);
        finalItem.setItemMeta(meta);
        return finalItem;
    }
}
