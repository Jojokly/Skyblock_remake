package me.Jojokly.items.abilities;

import me.Jojokly.skyblockmain.Main;
import me.Jojokly.stats.intelligence.Intelligence;
import org.bukkit.*;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;

public class Iron_punch {

    static Map<String, Long> cooldown = new HashMap<String, Long>();

    public static void IronPunch(Player p) {
        if (cooldown.containsKey(p.getName()) && (Long) cooldown.get(p.getName()) > System.currentTimeMillis()) {
            long timeleft = ((Long) cooldown.get(p.getName()) - System.currentTimeMillis()) / 1000L;
            p.sendMessage("§cAbility is on cooldown for " + timeleft + " §cmore seconds");
            return;
        }
        cooldown.put(p.getName(), System.currentTimeMillis() + 3000L);
        p.sendMessage("§b-70 Mana (§6Iron Punch§b)");
        Location loc = p.getLocation();
        Location teleportloc = new Location(p.getWorld(), 0, 0, 0);
        Location Block1loc = new Location(loc.getWorld(), loc.getX() + 4, loc.getY() + 5, loc.getZ());
        Location Block2loc = new Location(loc.getWorld(), loc.getX() + 4, loc.getY() + 5, loc.getZ() - 1);
        Location Block3loc = new Location(loc.getWorld(), loc.getX() + 4, loc.getY() + 5, loc.getZ() + 1);
        Location Block4loc = new Location(loc.getWorld(), loc.getX() + 2, loc.getY() + 5, loc.getZ() + 3);
        Location Block5loc = new Location(loc.getWorld(), loc.getX(), loc.getY() + 5, loc.getZ() + 4);
        Location Block6loc = new Location(loc.getWorld(), loc.getX() - 2, loc.getY() + 5, loc.getZ() + 3);
        Location Block7loc = new Location(loc.getWorld(), loc.getX() - 4, loc.getY() + 5, loc.getZ() + 1);
        Location Block8loc = new Location(loc.getWorld(), loc.getX() - 4, loc.getY() + 5, loc.getZ());
        Location Block9loc = new Location(loc.getWorld(), loc.getX() - 4, loc.getY() + 5, loc.getZ() - 1);
        Location Block10loc = new Location(loc.getWorld(), loc.getX() - 2, loc.getY() + 5, loc.getZ() - 3);
        Location Block11loc = new Location(loc.getWorld(), loc.getX(), loc.getY() + 5, loc.getZ() - 4);
        Location Block12loc = new Location(loc.getWorld(), loc.getX() + 2, loc.getY() + 5, loc.getZ() - 3);


        ArmorStand Block1 = p.getWorld().spawn(Block1loc, ArmorStand.class);
        Block1.setVisible(false);
        Block1.getEquipment().setHelmet(new ItemStack(Material.IRON_BLOCK));
        ArmorStand Block2 = p.getWorld().spawn(Block2loc, ArmorStand.class);
        Block2.setVisible(false);
        Block2.getEquipment().setHelmet(new ItemStack(Material.IRON_BLOCK));
        ArmorStand Block3 = p.getWorld().spawn(Block3loc, ArmorStand.class);
        Block3.setVisible(false);
        Block3.getEquipment().setHelmet(new ItemStack(Material.IRON_BLOCK));
        ArmorStand Block4 = p.getWorld().spawn(Block4loc, ArmorStand.class);
        Block4.setVisible(false);
        Block4.getEquipment().setHelmet(new ItemStack(Material.IRON_BLOCK));
        ArmorStand Block5 = p.getWorld().spawn(Block5loc, ArmorStand.class);
        Block5.setVisible(false);
        Block5.getEquipment().setHelmet(new ItemStack(Material.IRON_BLOCK));
        ArmorStand Block6 = p.getWorld().spawn(Block6loc, ArmorStand.class);
        Block6.setVisible(false);
        Block6.getEquipment().setHelmet(new ItemStack(Material.IRON_BLOCK));
        ArmorStand Block7 = p.getWorld().spawn(Block7loc, ArmorStand.class);
        Block7.setVisible(false);
        Block7.getEquipment().setHelmet(new ItemStack(Material.IRON_BLOCK));
        ArmorStand Block8 = p.getWorld().spawn(Block8loc, ArmorStand.class);
        Block8.setVisible(false);
        Block8.getEquipment().setHelmet(new ItemStack(Material.IRON_BLOCK));
        ArmorStand Block9 = p.getWorld().spawn(Block9loc, ArmorStand.class);
        Block9.setVisible(false);
        Block9.getEquipment().setHelmet(new ItemStack(Material.IRON_BLOCK));
        ArmorStand Block10 = p.getWorld().spawn(Block10loc, ArmorStand.class);
        Block10.setVisible(false);
        Block10.getEquipment().setHelmet(new ItemStack(Material.IRON_BLOCK));
        ArmorStand Block11 = p.getWorld().spawn(Block11loc, ArmorStand.class);
        Block11.setVisible(false);
        Block11.getEquipment().setHelmet(new ItemStack(Material.IRON_BLOCK));
        ArmorStand Block12 = p.getWorld().spawn(Block12loc, ArmorStand.class);
        Block12.setVisible(false);
        Block12.getEquipment().setHelmet(new ItemStack(Material.IRON_BLOCK));
        new BukkitRunnable() {
            @Override
            public void run() {
                Block1loc.setY(Block1loc.getY() - 4.5);
                Block2loc.setY(Block2loc.getY() - 4.5);
                Block3loc.setY(Block3loc.getY() - 4.5);
                Block4loc.setY(Block4loc.getY() - 4.5);
                Block5loc.setY(Block5loc.getY() - 4.5);
                Block6loc.setY(Block6loc.getY() - 4.5);
                Block7loc.setY(Block7loc.getY() - 4.5);
                Block8loc.setY(Block8loc.getY() - 4.5);
                Block9loc.setY(Block9loc.getY() - 4.5);
                Block10loc.setY(Block10loc.getY() - 4.5);
                Block11loc.setY(Block11loc.getY() - 4.5);
                Block12loc.setY(Block12loc.getY() - 4.5);
                ParticleUtils.drawLine(p, Block1loc, Block8loc, 0.5);
                ParticleUtils.drawLine(p, Block4loc, Block10loc, 0.5);
                ParticleUtils.drawLine(p, Block6loc, Block12loc, 0.5);
                ParticleUtils.drawLine(p, Block6loc, Block8loc, 0.5);
                ParticleUtils.drawLine(p, Block8loc, Block10loc, 0.5);
                ParticleUtils.drawLine(p, Block10loc, Block12loc, 0.5);
                ParticleUtils.drawLine(p, Block1loc, Block4loc, 0.5);
                ParticleUtils.drawLine(p, Block4loc, Block6loc, 0.5);
                ParticleUtils.drawLine(p, Block1loc, Block12loc, 0.5);

            }
        }.runTaskLater(me.Jojokly.skyblockmain.Main.getMain(), 25);

        new BukkitRunnable() {
            @Override
            public void run() {
                Block1.teleport(teleportloc);
                Block3.teleport(teleportloc);
                Block2.teleport(teleportloc);
                Block4.teleport(teleportloc);
                Block5.teleport(teleportloc);
                Block6.teleport(teleportloc);
                Block7.teleport(teleportloc);
                Block8.teleport(teleportloc);
                Block9.teleport(teleportloc);
                Block10.teleport(teleportloc);
                Block11.teleport(teleportloc);
                Block12.teleport(teleportloc);
                p.getWorld().spawnParticle(Particle.EXPLOSION_HUGE, loc, 1);
                p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_PLACE, 1, 1);
                AbilityDamage.damage(p, p.getLocation(), 255, 1, 4, "Iron Punch");
            }
        }.runTaskLater(Main.getMain(), 20);
    }
}
