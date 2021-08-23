package me.Jojokly.items.abilities.right_click;

import me.Jojokly.skyblockmain.Main;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashSet;

public class Instant_Transmission {

    public static void teleport(Player p) {
        p.sendMessage("§b-50 Mana (§6Instant Transmission§b)");
        p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
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
        p.setWalkSpeed((float) (p.getWalkSpeed() + 0.05));
        new BukkitRunnable() {
            @Override
            public void run() {
                p.setWalkSpeed((float) (p.getWalkSpeed() - 0.05));
            }

        }.runTaskLater(Main.getMain(), 100);
    }
}