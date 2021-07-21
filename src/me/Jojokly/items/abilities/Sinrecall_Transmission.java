package me.Jojokly.items.abilities;

import me.Jojokly.items.items.SkyblockItems;
import me.Jojokly.skyblockmain.Main;
import net.minecraft.server.v1_16_R3.NBTTagCompound;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.libs.org.apache.commons.lang3.Validate;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Sinrecall_Transmission {

   static List<Location> teleport = new ArrayList<Location>();

    public static void Sinrecall_Transmission(Player p) {
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
        if (teleport.isEmpty()) {
            teleport.add(loc);
            teleport.add(teleportLocation);
        } else {
            teleport.add(teleportLocation);
        }
        p.teleport(teleportLocation);
        p.playSound(teleportLocation, Sound.BLOCK_SAND_PLACE, 1, 1);
        new BukkitRunnable() {
            int count = 0;
            @Override
            public void run() {
                if (!teleport.isEmpty()) {
                    Location loc = teleport.get(0);
                    int manacost = 260;
                    for (int i = 1; i < teleport.size(); i++) {
                        Location startloc = teleport.get(i);
                        Location endloc = teleport.get(i -1 );
                        World world = startloc.getWorld();
                        Validate.isTrue(endloc.getWorld().equals(world), "");
                        double distance = startloc.distance(endloc);
                        Vector p1 = startloc.toVector();
                        Vector p2 = endloc.toVector();
                        Vector vector = p2.clone().subtract(p1).normalize().multiply(0.5);
                        double length = 0;
                        for (; length < distance; p1.add(vector)) {
                            Particle.DustOptions dustOptions = new Particle.DustOptions(Color.RED, 2);
                            world.spawnParticle(Particle.REDSTONE, p1.getX(), p1.getY(), p1.getZ(), 2, 0, 0, 0, dustOptions);
                            Location particleloc = new Location(p.getWorld(), p1.getX(), p1.getY(), p1.getZ());
                            ItemStack item = p.getItemInHand();
                            net.minecraft.server.v1_16_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(item);
                            NBTTagCompound compound = (nmsItem.hasTag()) ? nmsItem.getTag() : new NBTTagCompound();
                                try {
                                    String s1 = compound.getString("SbName");
                                    SkyblockItems items = SkyblockItems.valueOf(s1);
                                    AbilityDamage.damage(p, particleloc, items.getDamage(), 1, 0.5, "Sinrecall Transmission");
                            } catch (IllegalArgumentException e) {
                                    e.printStackTrace();
                            }
                            length += 0.5;
                        }
                        count++;
                    }
                    p.teleport(loc);
                    p.sendMessage("§b-" + (int) Math.pow(1.5, count) * manacost + " Mana (§6Sinrecall Transmission§b)");
                    p.playSound(loc, Sound.BLOCK_SAND_PLACE, 1, 1);
                    teleport.clear();
                }
            }
        }.runTaskLater(Main.getMain(), 20);
    }

}
