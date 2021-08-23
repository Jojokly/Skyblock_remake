package me.Jojokly.stats.health;

import me.Jojokly.mobs.Utils.CustomMobs;
import me.Jojokly.skyblockmain.Main;
import me.Jojokly.stats.defense.Defense;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class Damage implements Listener {

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        Entity entity = e.getDamager();
        Entity entity1 = e.getEntity();
        Location respawn = new Location(entity1.getWorld(), -2, 70, -86);
        if (entity1 instanceof Player) {
            e.setDamage(0);
            Player p = (Player) e.getEntity();
            PersistentDataContainer persistentData = entity.getPersistentDataContainer();
            String name = persistentData.get(new NamespacedKey(Main.getMain(), "RawName"), PersistentDataType.STRING);
            if (name == null)
                return;
            CustomMobs mob = CustomMobs.valueOf(name);
            double defense = Defense.getdefense(p);
            double damage = mob.getDamage();
            double dmgreduction = (defense / (defense + 100)) * 100;
            double finaldamage = damage / 100 * dmgreduction;
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

