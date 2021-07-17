package me.Jojokly.items.abilities;

import me.Jojokly.skyblockmain.Main;
import me.Jojokly.stats.intelligence.Intelligence;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.*;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.HashMap;

public class Guided_Bat {

    static HashMap<Player, Entity> shooter = new HashMap<Player, Entity>();

    public static void guidedBat(Player p) {
        p.spigot().sendMessage(TextComponent.fromLegacyText("§b-250 Mana (§6Guided Bat§b)"));
        World w = p.getWorld();
        Location loc = p.getLocation();
        Vector v = loc.getDirection();
        v.normalize().multiply(1);
        loc.add(v);
        loc.setY(loc.getY() + 1.5);
        Bat bat = w.spawn(loc, Bat.class);
        bat.setAwake(true);
        bat.setCollidable(false);
        new BukkitRunnable() {
            @Override
            public void run() {
                if (bat.isDead() || p.getLocation().distance(bat.getLocation()) > 80 || bat.getLocation().add(0.5, 0, 0).getBlock().getType() != Material.AIR || bat.getLocation().add(0, 0.5, 0).getBlock().getType() != Material.AIR || bat.getLocation().add(0, 0, 0.5).getBlock().getType() != Material.AIR || bat.getLocation().subtract(0.5, 0, 0).getBlock().getType() != Material.AIR || bat.getLocation().subtract(0, 0.5, 0).getBlock().getType() != Material.AIR || bat.getLocation().subtract(0, 0, 0.5).getBlock().getType() != Material.AIR) {
                    cancel();
                    Location batloc = bat.getLocation();
                    w.spawnParticle(Particle.EXPLOSION_HUGE, batloc, 1, 0, 0, 0);
                    AbilityDamage.damage(p, batloc, 2000, 0.2, 4, "Guided Bat");
                    bat.remove();
                    return;
                }
                Vector v = p.getLocation().getDirection().normalize();
                bat.setVelocity(v);
            }
        }.runTaskTimer(Main.getMain(), 0, 1);
    }
}