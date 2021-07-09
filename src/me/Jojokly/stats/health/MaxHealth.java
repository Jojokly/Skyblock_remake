//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package me.Jojokly.stats.health;

import java.util.HashMap;
import org.bukkit.entity.Player;

public class MaxHealth {
    public static HashMap<Player, Integer> maxhealth = new HashMap();

    public static int getMaxHealth(Player p) {
        int integer;
        if (maxhealth.containsKey(p)) {
            integer = (Integer)maxhealth.get(p);
        } else {
            integer = 0;
        }

        return integer;
    }

    public static void setMaxhealth(Player p, int health) {
        if (maxhealth.containsKey(p)) {
            maxhealth.remove(p);
            maxhealth.put(p, health);
        } else {
            maxhealth.put(p, health);
        }

    }
}

