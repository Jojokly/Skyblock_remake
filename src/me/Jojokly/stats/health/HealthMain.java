//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package me.Jojokly.stats.health;

import java.util.HashMap;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class HealthMain implements Listener {

    public static HashMap<Player, Integer> healthmap = new HashMap();
    public static HashMap<Player, Integer> basehealthmap = new HashMap();

    //health
    public static int getCustomHealth(Player p) {
        int integer;
        if (healthmap.containsKey(p)) {
            integer = healthmap.get(p);
        } else {
            integer = 0;
        }
        return integer;
    }

    public static void setCustomHealth(Player p, int health) {
        if (healthmap.containsKey(p)) {
            healthmap.remove(p);
            healthmap.put(p, health);
        } else {
            healthmap.put(p, health);
        }

    }
    //base health
    public static int getBaseHealth(Player p) {
        int integer;
        if (basehealthmap.containsKey(p)) {
            integer = basehealthmap.get(p);
        } else {
            integer = 0;
        }
        return integer;
    }

    public static void setBaseHealth(Player p, int health) {
        if (basehealthmap.containsKey(p)) {
            basehealthmap.remove(p);
            basehealthmap.put(p, health);
        } else {
            basehealthmap.put(p, health);
        }

    }

}

