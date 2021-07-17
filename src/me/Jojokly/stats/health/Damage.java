package me.Jojokly.stats.health;

import me.Jojokly.mobs.BuildMob;
import me.Jojokly.mobs.CustomMobs;
import me.Jojokly.stats.defense.Defense;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class Damage implements Listener {

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        Entity entity = e.getDamager();
        Entity entity1 = e.getEntity();
        Location respawn = new Location(entity1.getWorld(), -2, 70, -86);
        if (entity1 instanceof Player) {
            e.setDamage(0);
            Player p = (Player) e.getEntity();
            if (BuildMob.rawmobname.containsKey(entity)) {
                String name = BuildMob.rawmobname.get(entity);
                CustomMobs mob = CustomMobs.valueOf(name);
                double defense = Defense.getdefense(p);
                double damage = mob.getDamage();
                double finaldamage = (defense / (100 + defense)) * damage;
                if (HealthMain.getCustomHealth(p) <= finaldamage) {
                    p.teleport(respawn);
                    p.playSound(entity1.getLocation(), Sound.BLOCK_ANVIL_STEP, 10, 1);
                    p.sendMessage("§cYou died an lost 0 coins!");
                    HealthMain.setCustomHealth(p, MaxHealth.getMaxHealth(p));
                } else {
                    HealthMain.setCustomHealth(p, HealthMain.getCustomHealth(p) - (int) finaldamage);
                }
            }
        }
    }

}
