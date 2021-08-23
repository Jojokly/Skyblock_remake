package me.Jojokly.items.abilities.right_click;

import me.Jojokly.items.abilities.utils.ParticleUtils;
import me.Jojokly.items.items.ItemBuilder;
import me.Jojokly.items.items.Power_Orb;
import me.Jojokly.skyblockmain.Main;
import me.Jojokly.stats.health.HealthMain;
import me.Jojokly.stats.health.MaxHealth;
import org.bukkit.*;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.EulerAngle;
import org.bukkit.util.Vector;

public class Deploy {

    public static void deploy(Power_Orb orb, Player p) {
        ChatColor color = orb.getRarity().getColor();
        Location loc = p.getLocation();
        loc.setY(loc.getY() - 1);
        ArmorStand as = p.getWorld().spawn(loc, ArmorStand.class);
        as.setInvisible(true);
        as.setCustomName(color + orb.getName() + "§e" + orb.getTime() + "s");
        as.setCustomNameVisible(true);
        as.getEquipment().setHelmet(ItemBuilder.createHead(orb.getHeadId()));
        as.setRotation(0, 0);
        as.setArms(true);
        as.setGravity(false);
        Location uploc = loc;
        uploc.setY(uploc.getY() + 1.5);
        Location asloc = loc;
        new BukkitRunnable() {
            int i = 20 * orb.getTime();
            long startTime = System.currentTimeMillis();
            @Override
            public void run() {
                if (i == 0) {
                    Particle.DustOptions dust = new Particle.DustOptions(Color.fromRGB(255,255,255), 1);
                    loc.getWorld().spawnParticle(Particle.REDSTONE, loc.getX(), loc.getY() + 2, loc.getZ(), 20, 0.5, 0, 0.5, dust);
                    as.remove();
                    cancel();
                    return;
                }
                Location asl = as.getLocation();
                EulerAngle ea = as.getRightArmPose();
                Vector armDir = ParticleUtils.getDirection(ea.getY(), ea.getX(), -ea.getZ());
                armDir = ParticleUtils.rotateAroundAxisY(armDir, Math.toRadians(asl.getYaw() + 90f));
                asl.setX(asl.getX() + 30 / 16f * armDir.getX());
                asl.setY(asl.getY() + 10f / 16f * armDir.getY());
                asl.setZ(asl.getZ() + 30f / 16f * armDir.getZ());

                if (orb.equals(Power_Orb.RADIANT_POWER_ORB)) {
                    asl.getWorld().spawnParticle(Particle.VILLAGER_HAPPY, asl.getX(), asl.getY() + 2, asl.getZ(), 1);
                } else if (orb.equals(Power_Orb.MANAFLUX_POWER_ORB)) {
                    Particle.DustOptions dust = new Particle.DustOptions(Color.fromRGB(135,206,250), 1);
                    asl.getWorld().spawnParticle(Particle.REDSTONE, asl.getX(), asl.getY() + 2, asl.getZ(), 1, 0, 0, 0, dust);
                } else if (orb.equals(Power_Orb.OVERFLUX_POWER_ORB)) {
                    Particle.DustOptions dustred = new Particle.DustOptions(Color.fromRGB(139,0,0), 1);
                    Particle.DustOptions dustblack = new Particle.DustOptions(Color.fromRGB(0,0,0), 1);
                    asl.getWorld().spawnParticle(Particle.REDSTONE, asl.getX(), asl.getY() + 2, asl.getZ(), 1, 0, 0, 0, dustred);
                    asl.getWorld().spawnParticle(Particle.REDSTONE, asl.getX(), asl.getY() + 2, asl.getZ(), 1, 0, 0, 0, dustblack);
                } else if (orb.equals(Power_Orb.PLASMAFLUX_POWER_ORB)) {
                    Particle.DustOptions dustblack = new Particle.DustOptions(Color.fromRGB(0,0,0), 1);
                    Particle.DustOptions dustpurple = new Particle.DustOptions(Color.fromRGB(75,0,130), 1);
                    asl.getWorld().spawnParticle(Particle.REDSTONE, asl.getX(), asl.getY() + 2, asl.getZ(), 1, 0, 0, 0, dustblack);
                    asl.getWorld().spawnParticle(Particle.REDSTONE, asl.getX(), asl.getY() + 2, asl.getZ(), 1, 0, 0, 0, dustpurple);
                }
                double timeSeconds =(((double) System.currentTimeMillis() - (double) startTime) / 1000D);
                as.teleport(asloc.clone().add(0, Math.cos(timeSeconds), 0));
                as.setRotation(i*15, i*15);
                as.setCustomName(color + orb.getName() + "§e" + i / 20 + "s");
                i -=1;
            }
        }.runTaskTimer(Main.getMain(), 0, 1);

        new BukkitRunnable() {
            @Override
            public void run() {
                for (Entity players : p.getWorld().getNearbyEntities(loc, 18, 18, 18)) {
                    if (players instanceof Player) {
                        int regenhealth = 0;
                        if (orb == Power_Orb.RADIANT_POWER_ORB) {
                            regenhealth = HealthMain.getCustomHealth(p) / 100;
                        } else if (orb == Power_Orb.MANAFLUX_POWER_ORB) {
                            regenhealth = HealthMain.getCustomHealth(p) / 50;
                        } else if (orb == Power_Orb.OVERFLUX_POWER_ORB) {
                            regenhealth = HealthMain.getCustomHealth(p) / 40;
                        } else if (orb == Power_Orb.PLASMAFLUX_POWER_ORB) {
                            regenhealth = HealthMain.getCustomHealth(p) / 33;
                        }

                        if (HealthMain.getCustomHealth(p) + regenhealth > MaxHealth.getMaxHealth(p)) {
                            MaxHealth.setMaxhealth(p, MaxHealth.getMaxHealth(p));
                        } else {
                            HealthMain.setCustomHealth(p, HealthMain.getCustomHealth(p) + regenhealth);
                        }

                    }
                }
            }
        }.runTaskTimer(Main.getMain(), 0, 20);

    }
}
