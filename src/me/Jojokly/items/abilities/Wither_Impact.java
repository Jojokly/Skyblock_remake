package me.Jojokly.items.abilities;

import me.Jojokly.skyblockmain.Main;
import me.Jojokly.stats.intelligence.Intelligence;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class Wither_Impact {

    public  static void wither_impact(Player p, int manacost) {
        if (Intelligence.getintelligence(p) >= manacost) {
            Intelligence.setIntelligence(p, Intelligence.getintelligence(p) - manacost);
            Location loc = p.getLocation();
            Vector v = loc.getDirection();
            v.normalize();
            v.multiply(8);
            loc.add(v);
            p.teleport(loc);
            p.spigot().sendMessage(TextComponent.fromLegacyText("§b-250 Mana (§6Implosion§b)"));
            p.getWorld().playSound(loc, Sound.ENTITY_GENERIC_EXPLODE, 1, 1);
            p.spawnParticle(Particle.EXPLOSION_LARGE, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 10, 0, 0, 0);
            AbilityDamage.damage(p, loc ,10000, 0.3, 5, "Implosion");
            p.setAbsorptionAmount(10);
            new BukkitRunnable() {
                @Override
                public void run() {
                    p.setAbsorptionAmount(0);
                }
            }.runTaskLater(Main.getMain(), 100);
        } else {
            p.sendMessage("§cYou don't have enough Mana!");
        }
    }
}
