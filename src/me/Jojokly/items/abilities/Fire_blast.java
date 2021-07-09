package me.Jojokly.items.abilities;

import me.Jojokly.skyblockmain.Main;
import me.Jojokly.stats.intelligence.Intelligence;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.Map;

public class Fire_blast implements Listener {
    static int i = 3;
    static Map<String, Long> cooldown = new HashMap<String, Long>();

    public static void FireBlast(Player p, int manacost) {
        if (Intelligence.getintelligence(p) >= 150) {
            if (cooldown.containsKey(p.getName()) && (Long) cooldown.get(p.getName()) > System.currentTimeMillis()) {
                long timeleft = ((Long) cooldown.get(p.getName()) - System.currentTimeMillis()) / 1000L;
                p.sendMessage("§cAbility is on cooldown for " + timeleft + " §cmore seconds");
                return;
            }
            cooldown.put(p.getName(), System.currentTimeMillis() + 30000L);
            Intelligence.setIntelligence(p, Intelligence.getintelligence(p) - 150);
            p.sendMessage("§b-150 Mana (§6Fire Blast§b)");
            new BukkitRunnable() {
                @Override
                public void run() {
                    if (i > 0) {
                        Location loc = p.getLocation();
                        loc.setY(loc.getY() + 1);
                        Vector v = loc.getDirection();
                        Fireball fireball = loc.getWorld().spawn(loc, Fireball.class);
                        fireball.setVelocity(v);
                        fireball.setCustomName("EmberRodBall");
                        fireball.setCustomNameVisible(false);
                        fireball.setBounce(false);
                        i -= 1;
                    } else {
                        cancel();
                    }
                }
            }.runTaskTimer(Main.getMain(), 0, 7);
            i = 3;
        } else {
            p.sendMessage("§cYou don't have enough Mana!");
        }
    }

    @EventHandler
    public void onLand(EntityExplodeEvent event) {
        Entity projectile = event.getEntity();
        Location loc = projectile.getLocation();
        projectile.getWorld().spawnParticle(Particle.EXPLOSION_HUGE, loc, 1);
        if (projectile instanceof Fireball) {
            projectile.remove();
            for (Entity entity : projectile.getNearbyEntities(3, 3, 3)) {
                if (entity instanceof Mob) {
                    if (((Mob) entity).getHealth() <= 30) {
                        ((Mob) entity).setHealth(0);
                    } else {
                        ((Mob) entity).setHealth(((Mob) entity).getHealth() - 30);
                    }
                }
            }
            event.setCancelled(true);
        }
    }
}