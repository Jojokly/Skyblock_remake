package me.Jojokly.items.abilities;

import me.Jojokly.skyblockmain.Main;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftEntity;
import org.bukkit.entity.Entity;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.Map;

public class Molten_Wave implements Listener {

    static Map<String, Long> cooldown = new HashMap<String, Long>();

    public static void Moltenwave(Player p) {
        Location loc = p.getLocation();
        World w = p.getWorld();
        if (cooldown.containsKey(p.getName()) && (Long) cooldown.get(p.getName()) > System.currentTimeMillis()) {
            long timeleft = ((Long) cooldown.get(p.getName()) - System.currentTimeMillis()) / 1000L;
            p.sendMessage("§cAbility is on cooldown for " + timeleft + " §cmore seconds");
            return;
        }
        cooldown.put(p.getName(), System.currentTimeMillis() + 1000L);
        p.playSound(loc, Sound.ENTITY_ARMOR_STAND_HIT, 1, 1);
        p.spigot().sendMessage(TextComponent.fromLegacyText("§b-500 Mana (§6Molten Wave§b)"));
        loc.setY(loc.getY() + 3);
        new BukkitRunnable() {
            int i = 9;
            @Override
            public void run() {
                if (i > 0) {
                    Vector v = p.getLocation().getDirection().normalize();
                    double x = v.getX();
                    double z = v.getZ();
                    x = x * -1;
                    Vector newvec = new Vector(z, 0, x);
                    newvec.normalize().multiply(1);
                    v.normalize().multiply(1);
                    loc.add(v);
                    w.spawnParticle(Particle.FLAME, loc.getX(), loc.getY() + 3, loc.getZ(), 2, 0, 0, 0);
                    FallingBlock block = w.spawnFallingBlock(loc, Material.GOLD_BLOCK, (byte) 0);
                    ((CraftEntity) block).getHandle().noclip = true;
                    loc.add(newvec);
                    w.spawnParticle(Particle.FLAME, loc.getX(), loc.getY() + 3, loc.getZ(), 2, 0, 0, 0);                    FallingBlock block2 = w.spawnFallingBlock(loc, Material.GOLD_BLOCK, (byte) 0);
                    ((CraftEntity) block2).getHandle().noclip = true;
                    loc.add(newvec.multiply(-2));
                    w.spawnParticle(Particle.FLAME, loc.getX(), loc.getY() + 3, loc.getZ(), 1, 0, 0, 0);                   FallingBlock block3 = w.spawnFallingBlock(loc, Material.GOLD_BLOCK, (byte) 0);
                    ((CraftEntity) block3).getHandle().noclip = true;
                    loc.add(newvec.multiply(-0.5));
                    AbilityDamage.damage(p, loc, 16000, 0.3, 1.5, "Molten Wave");
                } else {
                    cancel();
                }
                i-=1;
            }
        }.runTaskTimer(Main.getMain(), 0, 2);
    }
}
