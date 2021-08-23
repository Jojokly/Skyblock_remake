package me.Jojokly.items.armor.Setbonus;

import me.Jojokly.stats.health.HealthMain;
import org.bukkit.entity.Player;

public class LapisHealth {

    public static void Health(Player p) {
        HealthMain.setCustomHealth(p, HealthMain.getCustomHealth(p) + 60);
    }
}
