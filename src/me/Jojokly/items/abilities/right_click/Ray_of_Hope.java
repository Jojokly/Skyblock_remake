package me.Jojokly.items.abilities.right_click;

import me.Jojokly.items.abilities.utils.AbilityDamage;
import me.Jojokly.items.items.ItemBuilder;
import me.Jojokly.skyblockmain.Main;
import me.Jojokly.stats.intelligence.Intelligence;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftEntity;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class Ray_of_Hope {

    public static void Ray_of_Hope(Player p) {
        int intelligence = Intelligence.getintelligence(p);
        int maxintelligence = Intelligence.getmaxintelligence(p);
        int manacost = maxintelligence / 10;
        if (!(intelligence >= manacost))
            return;
        Intelligence.setIntelligence(p, intelligence - manacost);
        p.spigot().sendMessage(TextComponent.fromLegacyText("§b-" + manacost + " Mana (§6Ray of Hope§b)"));
        World w = p.getWorld();
        Location loc = p.getLocation();
        Vector v = loc.getDirection();
        v.normalize().multiply(1);
        loc.add(v);
        loc.setY(loc.getY() + 1.5);
        ArmorStand as = p.getWorld().spawn(loc, ArmorStand.class);
        as.getEquipment().setHelmet(new ItemStack(ItemBuilder.createHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDUyZGNhNjhjOGY4YWY1MzNmYjczN2ZhZWVhY2JlNzE3Yjk2ODc2N2ZjMTg4MjRkYzJkMzdhYzc4OWZjNzcifX19")));
        as.setCollidable(false);
        ((CraftEntity) as).getHandle().noclip = true;
        ((CraftEntity) as).getHandle().setInvisible(true);
        new BukkitRunnable() {
            @Override
            public void run() {
                if (as.isDead() || p.getLocation().distance(as.getLocation()) > 80 || as.getLocation().add(0.2, 0, 0).getBlock().getType() != Material.AIR || as.getLocation().add(0, 0.1, 0).getBlock().getType() != Material.AIR || as.getLocation().add(0, 0, 0.2).getBlock().getType() != Material.AIR || as.getLocation().subtract(0, 0.1, 0).getBlock().getType() != Material.AIR || as.getLocation().subtract(0, 0, 0.2).getBlock().getType() != Material.AIR) {
                    Location asloc = as.getLocation();
                    w.spawnParticle(Particle.EXPLOSION_HUGE, asloc, 1, 0, 0, 0);
                    as.remove();
                    try {
                        AbilityDamage.damage(p, asloc, 750, 0.2, 4, "Ray of Hope");
                    } catch (NullPointerException e) {
                    }
                    cancel();
                    return;
                }
                Vector v = p.getLocation().getDirection().normalize();
                as.setVelocity(v);
            }
        }.runTaskTimer(Main.getMain(), 0, 1);
    }
}
