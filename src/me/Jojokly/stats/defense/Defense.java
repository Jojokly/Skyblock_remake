package me.Jojokly.stats.defense;

import org.bukkit.entity.Player;

import java.util.HashMap;

public class Defense {

    public static HashMap<String, Integer> defense = new HashMap<String, Integer>();
    public static HashMap<String, Integer> basedefense = new HashMap<String, Integer>();

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

    public static int getBaseDefense(Player p) {
        int integer;
        if (defense.containsKey(p.getName())) {
            integer = basedefense.get(p.getName());
        } else {
            integer = 0;
        }
        return integer;
    }

    public static void setBaseDefense(Player p, int def) {
        if (basedefense.containsKey(p.getName())) {
            basedefense.remove(p.getName());
            basedefense.put(p.getName(), def);
        } else {
            basedefense.put(p.getName(), def);
        }
    }

}
