package me.Jojokly.items.abilities.right_click;

import me.Jojokly.items.abilities.utils.AbilityDamage;
import me.Jojokly.items.abilities.utils.ParticleUtils;
import me.Jojokly.skyblockmain.Main;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class Dragon_Rage {

    public static void Dragon_Rage(Player p) {
        Location loc = p.getLocation();
        loc.setY(loc.getY() + 1.6);
        p.sendMessage("§b-100 Mana (§6Dragon Rage§b)");
        p.getWorld().playSound(loc, Sound.ENTITY_ENDER_DRAGON_GROWL, 1, 1);
        new BukkitRunnable() {
            double i = 0;
            float radius = 0;
            @Override
            public void run() {
                if (i >= 40) {
                    cancel();
                    return;
                }
                for (int j = 0; j <4 ; j++) {
                    double angle = 2 * Math.PI * i / 7;
                    double x = radius * (float) Math.cos(angle);
                    double z = radius * (float) Math.sin(angle);
                    Vector locvec = loc.getDirection().normalize().multiply(0.05);

                    Vector v0 = new Vector(x, 0, z);
                    ParticleUtils.rotateAroundAxisX1(v0, -90);
                    Vector v01 = new Vector(v0.getX(), v0.getY(), v0.getZ());
                    ParticleUtils.rotateAroundAxisX(v01, 90);

                    Vector v = new Vector(v01.getX(), v01.getY(), v01.getZ());
                    ParticleUtils.rotateAroundAxisX(v, loc.getPitch() + 90);
                    Vector v2 = new Vector(v.getX(), v.getY(), v.getZ());
                    ParticleUtils.rotateAroundAxisY(v2, loc.getYaw());
                    v2.add(locvec);
                    Location loc1 = loc.add(v2.getX(), v2.getY(), v2.getZ());
                    if (i >= 5) {
                        p.getWorld().spawnParticle(Particle.FLAME, loc1, 10, 0, 0, 0, 0);
                        for (Entity entity : loc1.getWorld().getNearbyEntities(loc1, 0.1, 0.1, 0.1)) {
                            if (entity != p) {
                                Vector velocity = loc.getDirection().normalize().multiply(7);
                                entity.setVelocity(velocity);
                            }
                        }
                        AbilityDamage.damage(p, loc1, 12000, 0.4, 0.1, "Dragon Rage");
                    }
                    i += 0.5;
                    radius += 0.0065;
                }
            }
        }.runTaskTimer(Main.getMain(), 0, 1);
    }
}
