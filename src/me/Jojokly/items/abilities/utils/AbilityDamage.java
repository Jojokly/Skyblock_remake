package me.Jojokly.items.abilities.utils;

import me.Jojokly.mobs.damage.MobDamage;
import me.Jojokly.skyblockmain.Main;
import me.Jojokly.stats.intelligence.Intelligence;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftEntity;
import org.bukkit.entity.*;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;

public class AbilityDamage {

    public static void damage(Player p, Location loc, int basedamage, double scaling, double radius, String ability) {
        final int abilitydamage = (int) (basedamage * (1+(Intelligence.getmaxintelligence(p) / 100) * scaling));
        int i = 0;
        World w = p.getWorld();
        for (Entity entity : w.getNearbyEntities(loc, radius, radius, radius)) {
            if (entity instanceof Mob) {
                PersistentDataContainer persistentData = entity.getPersistentDataContainer();
                Integer lvl = persistentData.get(new NamespacedKey(Main.getMain(), "Level"), PersistentDataType.INTEGER);
                String name = persistentData.get(new NamespacedKey(Main.getMain(), "Name"), PersistentDataType.STRING);
                Integer health = persistentData.get(new NamespacedKey(Main.getMain(), "Health"), PersistentDataType.INTEGER) - abilitydamage;
                Integer maxhealth = persistentData.get(new NamespacedKey(Main.getMain(), "MaxHealth"), PersistentDataType.INTEGER);
                if (abilitydamage > health) {
                    ((Mob) entity).setHealth(0);
                    entity.setCustomName("§7[Lvl " + lvl + "]§c " + name + " §e0§f/§a" + maxhealth + "§c❤");
                    p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                        } else if (!(health <= (maxhealth / 2))) {
                        entity.setCustomName("§7[Lvl " + lvl + "]§c " + name + " §a" + health + "§f/§a" + maxhealth + "§c❤");
                    } else {
                        entity.setCustomName("§7[Lvl " + lvl + "]§c " + name + " §e" + health + "§f/§a" + maxhealth + "§c❤");
                    }
                        persistentData.set(new NamespacedKey(Main.getMain(), "Health"), PersistentDataType.INTEGER, health - abilitydamage);
                        entity.setCustomNameVisible(true);
                        ((Mob) entity).damage(0);
                        MobDamage.killer.put(entity, p);
                        i+= 1;
                        p.getWorld().spawn(entity.getLocation(), ArmorStand.class, (armorStand) -> {
                            armorStand.setMarker(true);
                            armorStand.setVisible(false);
                            armorStand.setGravity(false);
                            armorStand.setSmall(true);
                            armorStand.setCustomNameVisible(true);
                            armorStand.setCustomName(String.valueOf(abilitydamage));
                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    armorStand.remove();
                                }
                            }.runTaskLater(Main.getMain(), 20);
                        });
                    }
                }
        if (i==0) return;
        if (i == 1) {
            p.sendMessage("§7Your " + ability + " §7Hit §c" + i + " §7Enemy for §c" + i* abilitydamage + " §7damage!");
        } else {
            p.sendMessage("§7Your " + ability + " §7Hit §c" + i + " §7Enemies for §c" + i * abilitydamage + " §7damage!");
        }
    }
}
