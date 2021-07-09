package me.Jojokly.stats.main;

import org.bukkit.entity.Player;

import java.util.HashMap;

public class ActionBar {

    static HashMap<Player, String> actionbar = new HashMap<Player, String>();

    public static String getActionBar(Player p) {
        String ab;
        if (actionbar.containsKey(p)) {
            ab = actionbar.get(p);
        } else {
            ab = null;
        }
        return ab;
    }
    public static void setActionBar(Player p, String ab) {
        if (actionbar.containsKey(p.getName())) {
            actionbar.remove(p.getName());
            actionbar.put(p, ab);
        } else {
            actionbar.put(p, ab);
        }
    }
}
