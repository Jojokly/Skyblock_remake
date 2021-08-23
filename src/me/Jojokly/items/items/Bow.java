package me.Jojokly.items.items;

import org.bukkit.Material;

public enum Bow {

    MACHINE_GUN_BOW("Machine Gun Bow", "MACHINE_GUN_BOW", Material.BOW, Rarity.RARE, 75, 50, 12, 0, false, "§6Ability: Rapid Fire: §e§lLEFT CLICK", "§7Shoots §a5 §7Arrows per second", "§7for §a8 §7seconds! Arrows deal", "§a70.0% §7of what they would normally deal.", "§8Cooldown: §a100s"),
    RUNAANS_BOW("Runaan's Bow", "RUNAANS_BOW", Material.BOW, Rarity.LEGENDARY, 160, 50, 0, 0, false, "§6Ability: Triple Shot", "§7Shoots 3 arrows at a time! §7The 2", "§7extra arrows deal §a40%", "§7of the damage and home", "§7to targets!"),
    ;

    private String name;
    private String rawname;
    private Material material;
    private Rarity rarity;
    private int damage;
    private int strength;
    private int critdamage;
    private int critchance;
    private boolean isShortBow;
    private String[] lore;

    Bow(String name, String rawname, Material material, Rarity rarity, int damage, int strength, int critdamage, int critchance, boolean isShortBow, String... lore) {
        this.name = name;
        this.rawname = rawname;
        this.material = material;
        this.rarity = rarity;
        this.damage = damage;
        this.strength = strength;
        this.critdamage = critdamage;
        this.critchance = critchance;
        this.isShortBow = isShortBow;
        this.lore = lore;

    }

    public String getName() {
        return name;
    }

    public String getRawname() {
        return rawname;
    }

    public Material getMaterial() {
        return material;
    }

    public int getDamage() {
        return damage;
    }

    public int getStrength() {
        return strength;
    }

    public int getCritdamage() {
        return critdamage;
    }

    public int getCritchance() {
        return critchance;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public String[] getLore() {
        return lore;
    }

    public boolean isShortBow() {
        return isShortBow;
    }
}
