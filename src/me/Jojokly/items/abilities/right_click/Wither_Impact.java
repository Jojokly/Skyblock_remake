package me.Jojokly.items.abilities.right_click;

import me.Jojokly.items.abilities.utils.AbilityDamage;
import me.Jojokly.items.abilities.utils.Particletest;
import me.Jojokly.skyblockmain.Main;
import net.md_5.bungee.api.chat.TextComponent;
import net.minecraft.server.v1_16_R3.PacketPlayOutWorldParticles;
import net.minecraft.server.v1_16_R3.ParticleParam;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_16_R3.CraftParticle;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashSet;

public class Wither_Impact {

    public  static void wither_impact(Player p) {
        Location loc = p.getLocation();
        HashSet hashSet = new HashSet();
        hashSet.add(Material.AIR);
        Block block = p.getTargetBlock(hashSet, 8);
        Location playerLocation = p.getLocation();
        Location teleportLocation = new Location(block.getWorld(), block.getX(), block.getY(), block.getZ(), playerLocation.getYaw(), playerLocation.getPitch());
        if (teleportLocation.getBlock().getType() != Material.AIR) {
            teleportLocation.setY(teleportLocation.getY() + 1.0D);
        }

        if ((new Location(teleportLocation.getWorld(), teleportLocation.getX(), teleportLocation.getY() + 1.0D, teleportLocation.getZ())).getBlock().getType() == Material.AIR && p.getLocation().add(p.getLocation().getDirection()).getBlock().getType() == Material.AIR) {
            teleportLocation.setX(teleportLocation.getX() - 0.5D);
            teleportLocation.setZ(teleportLocation.getZ() - 0.5D);
        } else {
            teleportLocation.setX(teleportLocation.getX() + 0.5D);
            teleportLocation.setZ(teleportLocation.getZ() + 0.5D);
        }
        p.teleport(teleportLocation);
        p.spigot().sendMessage(TextComponent.fromLegacyText("§b-250 Mana (§6Implosion§b)"));
        p.getWorld().playSound(loc, Sound.ENTITY_GENERIC_EXPLODE, 1, 1);
        ParticleParam particleParam = CraftParticle.toNMS(org.bukkit.Particle.valueOf("EXPLOSION_LARGE"));
        PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(particleParam, true, (float) teleportLocation.getX(), (float) teleportLocation.getY(), (float) teleportLocation.getZ(), 0, 0, 0, 20, 20);
        for (Player all : Bukkit.getOnlinePlayers())
            ((CraftPlayer) all).getHandle().playerConnection.sendPacket(packet);
        Particletest.playcircle(p);
        AbilityDamage.damage(p, teleportLocation, 10000, 0.3, 5, "Implosion");
        p.setAbsorptionAmount(10);
        new BukkitRunnable() {
            @Override
            public void run() {
                p.setAbsorptionAmount(0);
            }
        }.runTaskLater(Main.getMain(), 100);
    }
}
