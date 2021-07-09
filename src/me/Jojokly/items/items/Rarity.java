package me.Jojokly.items.items;

import org.bukkit.ChatColor;

public enum Rarity {

    COMMON(ChatColor.WHITE,"common" ,250, 1.2),
    UNCOMMON(ChatColor.GREEN,"uncommon" ,1000, 1.4),
    RARE(ChatColor.DARK_BLUE,"rare" ,2500, 1.6),
    EPIC(ChatColor.DARK_PURPLE, "epic", 5000, 1.8),
    LEGENDARY(ChatColor.GOLD,"legendary" ,10000, 2),
    MYTHIC(ChatColor.LIGHT_PURPLE,"mythic" ,10000, 2.2),
    SPECIAL(ChatColor.RED, "special", 10000, 2);
    ;

    private ChatColor color;
    private String name;
    private int reforgecost;
    private double reforgemuliplyer;

     Rarity(ChatColor color,String name ,int reforgecost, double reforgemultiplyer) {
        this.color = color;
        this.name = name;
        this.reforgecost = reforgecost;
        this.reforgemuliplyer = reforgemultiplyer;
    }

    public ChatColor getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public int getReforgecost() {
        return reforgecost;
    }

    public double getReforgemuliplyer() {
        return reforgemuliplyer;
    }

}
