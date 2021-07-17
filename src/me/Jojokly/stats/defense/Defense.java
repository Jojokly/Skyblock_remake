package me.Jojokly.stats.defense;

import org.bukkit.entity.Player;

import java.util.HashMap;

public class Defense {

    public static HashMap<String, Integer> defense = new HashMap<String, Integer>();

    public static int getdefense(Player p) {
        int integer;
        if (defense.containsKey(p.getName())) {
            integer = defense.get(p.getName());
        } else {
            integer = 0;
        }
        return integer;
    }

    public static void setdefense(Player p, int def) {
        if (defense.containsKey(p.getName())) {
            defense.remove(p.getName());
            defense.put(p.getName(), def);
        } else {
            defense.put(p.getName(), def);
        }
    }
}
