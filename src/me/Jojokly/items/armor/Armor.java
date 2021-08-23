package me.Jojokly.items.armor;

import me.Jojokly.items.items.ItemBuilder;
import me.Jojokly.items.items.Rarity;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public enum Armor {

    LAPIS_ARMOR_HELMET("Lapis Armor Helmet", "LAPIS_ARMOR_HELMET", new ItemStack(Material.SEA_LANTERN), Rarity.UNCOMMON, 0, 25, true, true, "Health", "§7Each piece of this armour grants", "§a50% §7 bonus experience when", "§7mining ores.", " ", "§6Full Set Bonus: Health", "§7Increases the wearer's maximum", "§cHealth §7by §a60§7."),
    LAPIS_ARMOR_CHESTPLATE("Lapis Armor Chestplate", "LAPIS_ARMOR_CHESTPLATE", new ItemStack(ItemBuilder.colorArmor(Material.LEATHER_CHESTPLATE, Color.BLUE)), Rarity.UNCOMMON, 0, 40, true, false,"Health", "§7Each piece of this armour grants", "§a50% §7 bonus experience when", "§7mining ores.", " ", "§6Full Set Bonus: Health", "§7Increases the wearer's maximum", "§cHealth §7by §a60§7."),
    LAPIS_ARMOR_LEGGINGS("Lapis Armor Leggings", "LAPIS_ARMOR_LEGGINGS", new ItemStack(ItemBuilder.colorArmor(Material.LEATHER_LEGGINGS, Color.BLUE)), Rarity.UNCOMMON, 0, 35, true, false,"Health", "§7Each piece of this armour grants", "§a50% §7 bonus experience when", "§7mining ores.", " ", "§6Full Set Bonus: Health", "§7Increases the wearer's maximum", "§cHealth §7by §a60§7."),
    LAPIS_ARMOR_BOOTS("Lapis Armor Boots", "LAPIS_ARMOR_BOOTS", new ItemStack(ItemBuilder.colorArmor(Material.LEATHER_BOOTS, Color.BLUE)), Rarity.UNCOMMON, 0, 15, true, false, "Health","§7Each piece of this armour grants", "§a50% §7 bonus experience when", "§7mining ores.", " ", "§6Full Set Bonus: Health", "§7Increases the wearer's maximum", "§cHealth §7by §a60§7."),
    OBSIDIAN_CHESTPLATE("Obsidian Chestplate", "OBSIDIAN_CHESTPLATE", new ItemStack(ItemBuilder.colorArmor(Material.LEATHER_CHESTPLATE, Color.BLACK)), Rarity.EPIC, 0, 250, true, false, "null", "§7While worn gain §a+1", "§fSpeed §7for every §a20 §7pieces", "§7of Obsidian in your Inventory.", " ", "§7Bonus Speed: §a0", " ", "§7Immune to Wither effect"),
    ;

    private final String name;
    private final String rawname;
    private final ItemStack material;
    private final Rarity rarity;
    private final int health;
    private final int defense;
    private final boolean isReforgeable;
    private final boolean isHelmet;
    private final String full_set_bonus;
    private final String[] lore;

    Armor(String name, String rawname, ItemStack material, Rarity rarity, int health, int defense, boolean isReforgeable, boolean isHelmet, String full_set_bonus, String... lore) {
        this.name = name;
        this.rawname = rawname;
        this.material = material;
        this.rarity = rarity;
        this.health = health;
        this.defense = defense;
        this.isReforgeable = isReforgeable;
        this.isHelmet = isHelmet;
        this.full_set_bonus = full_set_bonus;
        this.lore = lore;
    }

    public String getName() {
        return name;
    }

    public String getRawname() {
        return rawname;
    }

    public ItemStack getMaterial() {
        return material;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public int getHealth() {
        return health;
    }

    public int getDefense() {
        return defense;
    }

    public boolean isReforgeable() {
        return isReforgeable;
    }

    public boolean isHelmet() {
        return isHelmet;
    }

    public String getFull_set_bonus() {
        return full_set_bonus;
    }

    public String[] getLore() {
        return lore;
    }
}
