package me.Jojokly.mobs.damage;

import me.Jojokly.skyblockmain.Main;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;

public class ArrowDamage implements Listener {

    private double getRandomOffset() {
        double random = Math.random();
        if (Math.random() > 0.5D) {
            random *= -1.0D;
        }
        return random;
    }

    @EventHandler
    public void onHit(ProjectileHitEvent e) {
        Entity entity = e.getHitEntity();
        Entity projectile = e.getEntity();
        if (entity == null)
            return;
        World w = entity.getWorld();
        Location loc = entity.getLocation().clone().add(getRandomOffset(), 1.0D, getRandomOffset());
        if (projectile instanceof Arrow) {
            Arrow arrow = (Arrow) e.getEntity();
            PersistentDataContainer arrowPersistentData = arrow.getPersistentDataContainer();
            PersistentDataContainer MobPersistentdata = entity.getPersistentDataContainer();
            try {
                int damage = arrowPersistentData.get(new NamespacedKey(Main.getMain(), "Damage"), PersistentDataType.INTEGER);
                int health = MobPersistentdata.get(new NamespacedKey(Main.getMain(), "Health"), PersistentDataType.INTEGER) - damage;
                int lvl = MobPersistentdata.get(new NamespacedKey(Main.getMain(), "Level"), PersistentDataType.INTEGER);
                int maxhealth = MobPersistentdata.get(new NamespacedKey(Main.getMain(), "MaxHealth"), PersistentDataType.INTEGER);
                String name = MobPersistentdata.get(new NamespacedKey(Main.getMain(), "Name"), PersistentDataType.STRING);
                if (damage == 0 || health == 0 || lvl == 0 || maxhealth == 0 || name == null)
                    return;
                if (health <= damage) {
                    ((Mob) entity).setHealth(0);
                    entity.setCustomName("§7[Lvl " + lvl + "]§c " + name + " §e0/" + maxhealth + "§c❤");
                } else {
                    if (!(health <= (maxhealth / 2))) {
                        entity.setCustomName("§7[Lvl " + lvl + "]§c " + name + " §a" + health + "/" + maxhealth + "§c❤");
                    } else {
                        entity.setCustomName("§7[Lvl " + lvl + "]§c " + name + " §e" + health + "/" + maxhealth + "§c❤");
                    }
                    entity.setCustomNameVisible(true);
                    MobPersistentdata.set(new NamespacedKey(Main.getMain(), "Health"), PersistentDataType.INTEGER, health - damage);
                    w.spawn(loc, ArmorStand.class, (armorStand) -> {
                        armorStand.setMarker(true);
                        armorStand.setVisible(false);
                        armorStand.setGravity(false);
                        armorStand.setSmall(true);
                        armorStand.setCustomNameVisible(true);
                        armorStand.setCustomName(String.valueOf(damage));
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                armorStand.remove();
                            }
                        }.runTaskLater(Main.getMain(), 20);
                        });
                    }
                } catch (NullPointerException exception) {
            }
        }
    }
}

