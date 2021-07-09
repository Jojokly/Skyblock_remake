package me.Jojokly.items.abilities;

import me.Jojokly.skyblockmain.Main;
import me.Jojokly.stats.intelligence.Intelligence;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class Instant_Transmission {

    public static void teleport(Player p) {
        if (Intelligence.getintelligence(p) >= 50) {
            Intelligence.setIntelligence(p, Intelligence.getintelligence(p) - 50);
            p.sendMessage("§b-50 Mana (§6Instant Transmission§b)");
            p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
            Location loc = p.getLocation();
            Vector v = loc.getDirection();
            v.normalize();
            v.multiply(8);
            loc.add(v);
            p.teleport(loc);
            p.setWalkSpeed((float) (p.getWalkSpeed() + 0.05));
            new BukkitRunnable() {
                @Override
                public void run() {
                    p.setWalkSpeed((float) (p.getWalkSpeed() - 0.05));
                }

            }.runTaskLater(Main.getMain(), 100);
        } else {
            p.sendMessage("§cYou don't have enough mana!");
        }
    }
}