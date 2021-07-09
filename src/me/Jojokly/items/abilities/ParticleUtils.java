package me.Jojokly.items.abilities;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.craftbukkit.libs.org.apache.commons.lang3.Validate;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class ParticleUtils {

    public static final Vector rotateAroundAxisX(Vector v, double angle) {
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);
        double y = v.getY() * cos - v.getZ() * sin;
        double z = v.getY() * sin + v.getZ() * cos;
        return v.setY(y).setZ(z);
    }

    public static final Vector rotateAroundAxisY(Vector v, double angle) {
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);
        double x = v.getX() * cos + v.getZ() * sin;
        double z = v.getX() * -sin + v.getZ() * cos;
        return v.setX(x).setZ(z);
    }

    public static void drawLine(Player p, Location point1, Location point2, double space) {
        World world = point1.getWorld();
        Validate.isTrue(point2.getWorld().equals(world), "");
        double distance = point1.distance(point2);
        Vector p1 = point1.toVector();
        Vector p2 = point2.toVector();
        Vector vector = p2.clone().subtract(p1).normalize().multiply(space);
        double length = 0;
        for (; length < distance; p1.add(vector)) {
            world.spawnParticle(Particle.FLAME, p1.getX(), p1.getY(), p1.getZ(), 0);
            length += space;
        }
    }
}
