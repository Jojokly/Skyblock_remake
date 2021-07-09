package me.Jojokly.stats.intelligence;

import me.Jojokly.skyblockmain.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class regenmana {

    public static void regenmana(Player p) {

        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.getMain(), new Runnable() {

            @Override
            public void run() {
                int manaregen = Intelligence.getmaxintelligence(p) / 25;
                int maxintel = Intelligence.getmaxintelligence(p);
                int baseintel = Intelligence.getintelligence(p);
                if (baseintel + manaregen > maxintel) {
                    Intelligence.setIntelligence(p, Intelligence.getmaxintelligence(p));
                } else {
                    Intelligence.setIntelligence(p, manaregen + Intelligence.getintelligence(p));
                }
            }
        }, 1, 20);
    }

}
