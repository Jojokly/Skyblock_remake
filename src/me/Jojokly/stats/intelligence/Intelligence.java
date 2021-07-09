package me.Jojokly.stats.intelligence;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class Intelligence {

    public static HashMap<String, Integer> intelligence = new HashMap<String, Integer>();
    public static Map<String, Integer> maxintelligence = new HashMap<String, Integer>();
    public static HashMap<String, Integer> baseintelligence = new HashMap<String, Integer>();

    public static int getintelligence(Player p) {
        int integer;
        if (intelligence.containsKey(p.getName())) {
            integer = intelligence.get(p.getName());
        } else {
            integer = 0;
        }
        return integer;
    }

    public static void setIntelligence(Player p, int intel) {
        if (intelligence.containsKey(p.getName())) {
            intelligence.remove(p.getName());
            intelligence.put(p.getName(), intel);
        } else {
            intelligence.put(p.getName(), intel);
        }
    }


    public static int getmaxintelligence(Player p) {
        int integer;
        if (maxintelligence.containsKey(p.getName())) {
            integer = maxintelligence.get(p.getName());
        } else {
            integer = 0;
        }
        return integer;
    }

    public static void setmaxIntelligence(Player p, int intel) {
        if (maxintelligence.containsKey(p.getName())) {
            maxintelligence.remove(p.getName());
            maxintelligence.put(p.getName(), intel);
        } else {
            maxintelligence.put(p.getName(), intel);
        }
    }
}
