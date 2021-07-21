package me.Jojokly.items.abilities;

import org.bukkit.*;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftEntity;
import org.bukkit.entity.*;
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
        Location Block1loc = new Location(loc.getWorld(), loc.getX() + 4, loc.getY() + 10, loc.getZ());
        Location Block2loc = new Location(loc.getWorld(), loc.getX() + 4, loc.getY() + 10, loc.getZ() - 1);
        Location Block3loc = new Location(loc.getWorld(), loc.getX() + 4, loc.getY() + 10, loc.getZ() + 1);
        Location Block4loc = new Location(loc.getWorld(), loc.getX() + 2, loc.getY() + 10, loc.getZ() + 3);
        Location Block5loc = new Location(loc.getWorld(), loc.getX(), loc.getY() + 10, loc.getZ() + 4);
        Location Block6loc = new Location(loc.getWorld(), loc.getX() - 2, loc.getY() + 10, loc.getZ() + 3);
        Location Block7loc = new Location(loc.getWorld(), loc.getX() - 4, loc.getY() + 10, loc.getZ() + 1);
        Location Block8loc = new Location(loc.getWorld(), loc.getX() - 4, loc.getY() + 10, loc.getZ());
        Location Block9loc = new Location(loc.getWorld(), loc.getX() - 4, loc.getY() + 10, loc.getZ() - 1);
        Location Block10loc = new Location(loc.getWorld(), loc.getX() - 2, loc.getY() + 10, loc.getZ() - 3);
        Location Block11loc = new Location(loc.getWorld(), loc.getX(), loc.getY() + 10, loc.getZ() - 4);
        Location Block12loc = new Location(loc.getWorld(), loc.getX() + 2, loc.getY() + 10, loc.getZ() - 3);


        FallingBlock Block1 = p.getWorld().spawnFallingBlock(Block1loc, Material.IRON_BLOCK, (byte) 0);
        FallingBlock Block2 = p.getWorld().spawnFallingBlock(Block2loc, Material.IRON_BLOCK, (byte) 0);
        FallingBlock Block3 = p.getWorld().spawnFallingBlock(Block3loc, Material.IRON_BLOCK, (byte) 0);
        FallingBlock Block4 = p.getWorld().spawnFallingBlock(Block4loc, Material.IRON_BLOCK, (byte) 0);
        FallingBlock Block5 = p.getWorld().spawnFallingBlock(Block5loc, Material.IRON_BLOCK, (byte) 0);
        FallingBlock Block6 = p.getWorld().spawnFallingBlock(Block6loc, Material.IRON_BLOCK, (byte) 0);
        FallingBlock Block7 = p.getWorld().spawnFallingBlock(Block7loc, Material.IRON_BLOCK, (byte) 0);
        FallingBlock Block8 = p.getWorld().spawnFallingBlock(Block8loc, Material.IRON_BLOCK, (byte) 0);
        FallingBlock Block9 = p.getWorld().spawnFallingBlock(Block9loc, Material.IRON_BLOCK, (byte) 0);
        FallingBlock Block10 = p.getWorld().spawnFallingBlock(Block10loc, Material.IRON_BLOCK, (byte) 0);
        FallingBlock Block11 = p.getWorld().spawnFallingBlock(Block11loc, Material.IRON_BLOCK, (byte) 0);
        FallingBlock Block12 = p.getWorld().spawnFallingBlock(Block12loc, Material.IRON_BLOCK, (byte) 0);
        ((CraftEntity)Block1).getHandle().noclip = true;
        ((CraftEntity)Block2).getHandle().noclip = true;
        ((CraftEntity)Block3).getHandle().noclip = true;
        ((CraftEntity)Block4).getHandle().noclip = true;
        ((CraftEntity)Block5).getHandle().noclip = true;
        ((CraftEntity)Block6).getHandle().noclip = true;
        ((CraftEntity)Block7).getHandle().noclip = true;
        ((CraftEntity)Block8).getHandle().noclip = true;
        ((CraftEntity)Block9).getHandle().noclip = true;
        ((CraftEntity)Block10).getHandle().noclip = true;
        ((CraftEntity)Block11).getHandle().noclip = true;
        ((CraftEntity)Block12).getHandle().noclip = true;

        new BukkitRunnable() {
            @Override
            public void run() {
                Block1.remove();
                Block2.remove();
                Block3.remove();
                Block4.remove();
                Block5.remove();
                Block6.remove();
                Block7.remove();
                Block8.remove();
                Block9.remove();
                Block10.remove();
                Block11.remove();
                Block12.remove();
                Block1loc.setY(Block1loc.getY() - 9.5);
                Block2loc.setY(Block2loc.getY() - 9.5);
                Block3loc.setY(Block3loc.getY() - 9.5);
                Block4loc.setY(Block4loc.getY() - 9.5);
                Block5loc.setY(Block5loc.getY() - 9.5);
                Block6loc.setY(Block6loc.getY() - 9.5);
                Block7loc.setY(Block7loc.getY() - 9.5);
                Block8loc.setY(Block8loc.getY() - 9.5);
                Block9loc.setY(Block9loc.getY() - 9.5);
                Block10loc.setY(Block10loc.getY() - 9.5);
                Block11loc.setY(Block11loc.getY() - 9.5);
                Block12loc.setY(Block12loc.getY() - 9.5);

                ParticleUtils.drawLine(p, Block1loc, Block8loc, 0.5);
                ParticleUtils.drawLine(p, Block4loc, Block10loc, 0.5);
                ParticleUtils.drawLine(p, Block6loc, Block12loc, 0.5);
                ParticleUtils.drawLine(p, Block6loc, Block8loc, 0.5);
                ParticleUtils.drawLine(p, Block8loc, Block10loc, 0.5);
                ParticleUtils.drawLine(p, Block10loc, Block12loc, 0.5);
                ParticleUtils.drawLine(p, Block1loc, Block4loc, 0.5);
                ParticleUtils.drawLine(p, Block4loc, Block6loc, 0.5);
                ParticleUtils.drawLine(p, Block1loc, Block12loc, 0.5);
                p.getWorld().spawnParticle(Particle.EXPLOSION_HUGE, loc, 1);
                p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_PLACE, 1, 1);
                AbilityDamage.damage(p, p.getLocation(), 255, 1, 4, "Iron Punch");
            }
        }.runTaskLater(me.Jojokly.skyblockmain.Main.getMain(), 25);
    }
}
