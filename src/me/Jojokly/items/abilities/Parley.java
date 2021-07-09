package me.Jojokly.items.abilities;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class Parley {

    public static void playParley(Player p) {
        p.getWorld().playSound(p.getLocation(), Sound.ENTITY_VILLAGER_YES, 1, 1);
    }

}
