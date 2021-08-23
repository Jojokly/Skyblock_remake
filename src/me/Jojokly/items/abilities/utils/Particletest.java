package me.Jojokly.items.abilities.utils;

import me.Jojokly.skyblockmain.Main;
import org.bukkit.*;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class Particletest implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        Action a = e.getAction();
        if (p.getItemInHand().getType().equals(Material.END_ROD)) {
            if (a == Action.RIGHT_CLICK_AIR) {
                sphere(p);
            }
        }
    }

    private void particlebeam(Player p, Location loc, Vector v) {
        Location particleloc = loc.clone();
        World w = particleloc.getWorld();
        Vector voffset = v.clone().multiply(0.5);
        new BukkitRunnable() {
            int maxbeamlength = 100;
            int beamlength = 0;
            @Override
            public void run() {
                for (Entity entity : w.getNearbyEntities(particleloc,5, 5, 5)) {
                    if (entity instanceof LivingEntity) {
                        if (entity == p) {
                            continue;
                        }
                        Vector minvec = new Vector(
                                particleloc.getX() - 0.25,
                                particleloc.getY() - 0.25,
                                particleloc.getZ() - 0.25);
                        Vector maxvec = new Vector(
                                particleloc.getX() + 0.25,
                                particleloc.getY() + 0.25,
                                particleloc.getZ() + 0.25);
                        if (entity.getBoundingBox().overlaps(minvec, maxvec)) {
                            w.spawnParticle(Particle.FLASH, particleloc, 0);
                            w.playSound(particleloc, Sound.ENTITY_GENERIC_EXPLODE, 2, 1);
                            ((Damageable) entity).damage(5, p);
                            entity.setVelocity(entity.getVelocity().add(particleloc.getDirection().normalize().multiply(1.5)));
                            cancel();
                            return;
                        }
                    }
                }
                Vector vecOffset = null;
                if (beamlength >=6) {

                }
                beamlength ++;
                if (beamlength >=maxbeamlength) {
                    w.spawnParticle(Particle.FLASH, particleloc, 0);
                    cancel();
                    return;
                }
                particleloc.add(voffset);
                w.spawnParticle(Particle.COMPOSTER, particleloc, 0);
            }
        }.runTaskTimer(Main.getMain(), 0, 1);
    }

    public static void particleTutorial(Player player){
        new BukkitRunnable() {
            // Number of points on each circle to show a particle
            int circlePoints = 12;
            // Maximum radius before shrinking again.
            double maxRadius = 1.5;
            Location playerLoc = player.getEyeLocation();
            World world = playerLoc.getWorld();
            // Get the player's looking direction and multiply it by 0.5
            // 0.5 is the number of blocks each new ring will be away from the previous ring
            final Vector dir = player.getLocation().getDirection().normalize().multiply(0.5);
            final double pitch = (playerLoc.getPitch() + 90.0F) * 0.017453292F; // Need these in radians, not degrees or the circle flattens out sometimes
            final double yaw = -playerLoc.getYaw() * 0.017453292F; // Need these in radians, not degrees or the circle flattens out sometimes
            double increment = (2 * Math.PI) / circlePoints;
            // This will be the maximum number of circles in one oscillation before repeating
            int maxCircles = 12;
            // This is used to calculate the radius for each loop
            double t = 0;
            double circlePointOffset = 5; // This is used to rotate the circle as the beam progresses
            // Max beam length
            int beamLength = 20;
            @Override
            public void run() {
                beamLength--;
                if(beamLength < 1){
                    this.cancel();
                    return;
                }
                // This calculates the radius for the current circle/ring in the pattern
                double radius = Math.sin(t) * maxRadius;
                for (int i = 0; i < circlePoints; i++) {
                    double angle = i * increment + circlePointOffset; // Angle on the circle
                    double x = radius * Math.cos(angle);
                    double z = radius * Math.sin(angle);
                    Vector vec = new Vector(x, 0, z);
                    ParticleUtils.rotateAroundAxisX(vec, pitch);
                    ParticleUtils.rotateAroundAxisY(vec, yaw);
                    playerLoc.add(vec);
                    world.spawnParticle(Particle.FLAME, playerLoc, 0); // Reminder to self - the "data" option for a (particle, location, data) is speed, not count!!
                    playerLoc.subtract(vec);
                }
                circlePointOffset += increment / 5; // Rotate the circle points each iteration, like rifling in a barrel
                if (circlePointOffset >= increment) {
                    circlePointOffset = 0;
                }
                t += Math.PI / maxCircles; // Oscillation effect
                if (t > Math.PI * 2) {
                    t = 0;
                }
                playerLoc.add(dir);
            }
        }.runTaskTimer(Main.getMain(), 0, 1);
    }

    public static void playcircle(Player p) {
        Location loc = p.getLocation();
        Location startloc = p.getLocation();
        for (int i = 0; i < 360; i++) {
            p.getWorld().spawnParticle(Particle.PORTAL, startloc, 0);
            double radians = Math.toRadians(i);
            double y = Math.sin(radians);
            double x = Math.cos(radians);
            y = y*0.5;
            x = x*0.5;
            loc.add(x, y, 0);
            loc.getWorld().spawnParticle(Particle.PORTAL, loc, 0);
            loc.subtract(x, y, 0);
        }
    }
    public void particleline(Player p){
        new BukkitRunnable() {
            // Number of points to display, evenly spaced around the circle's radius
            int circlePoints = 3;
            // How fast should the particles rotate around the center beam
            int rotationSpeed = 20;
            double radius = 2.5;
            Location startLoc = p.getEyeLocation();
            World world = startLoc.getWorld();
            final Vector dir = p.getLocation().getDirection().normalize().multiply(1);
            final double pitch = (startLoc.getPitch() +90.0F) * 0.017453292F;
            final double yaw = -startLoc.getYaw() * 0.017453292F;
            // Particle offset increment for each loop
            double increment = (2 * Math.PI) / rotationSpeed;
            double circlePointOffset = 0; // This is used to rotate the circle as the beam progresses
            int beamLength = 60;
            double radiusShrinkage = radius / (double) ((beamLength + 2) / 2);
            @Override
            public void run() {
                beamLength--;
                if(beamLength < 1){
                    this.cancel();
                }
                for (int i = 0; i < circlePoints; i++) {
                    double x =  radius * Math.cos(2 * Math.PI * i / circlePoints + circlePointOffset);
                    double z =  radius * Math.sin(2 * Math.PI * i / circlePoints + circlePointOffset);

                    Vector vec = new Vector(x, 0, z);
                    ParticleUtils.rotateAroundAxisX(vec, pitch);
                    ParticleUtils.rotateAroundAxisY(vec, yaw);

                    startLoc.add(vec);
                    world.spawnParticle(Particle.FLAME, startLoc, 0);
                    startLoc.subtract(vec);
                }
                // Always spawn a center particle in the same direction the player was facing.
                startLoc.add(dir);
                world.spawnParticle(Particle.FIREWORKS_SPARK, startLoc, 0);
                startLoc.subtract(dir);

                // Shrink each circle radius until it's just a point at the end of a long swirling cone
                radius -= radiusShrinkage;
                if (radius < 0) {
                    this.cancel();
                }

                // Rotate the circle points each iteration, like rifling in a barrel
                circlePointOffset += increment;
                if (circlePointOffset >= (2 * Math.PI)) {
                    circlePointOffset = 0;
                }
                startLoc.add(dir);
            }
        }.runTaskTimer(Main.getMain(), 0, 1);
    }

    public void sphere(Player player) {
        new BukkitRunnable() {
            @Override
            public void run() {
                Location loc = player.getLocation();
                for (double i = 0; i <= Math.PI; i += Math.PI / 25) {
                    double radius = Math.sin(i);
                    double y = Math.cos(i);
                    y = y*2;
                    for (double a = 0; a < Math.PI * 2; a+= Math.PI / 25) {
                        double x = Math.cos(a) * radius;
                        double z = Math.sin(a) * radius;
                        x = x*2;
                        z = z*2;
                        loc.add(x, y, z);
                        player.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, loc, 0);
                        loc.subtract(x, y, z);
                    }
                }
            }
        }.runTaskTimer(Main.getMain(), 0, 1);

    }
}
