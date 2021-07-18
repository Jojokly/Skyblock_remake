package me.Jojokly.items.abilities;

import me.Jojokly.mobs.BuildMob;
import me.Jojokly.skyblockmain.Main;
import me.Jojokly.stats.intelligence.Intelligence;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class AbilityDamage {

    public static void damage(Player p, Location loc, int basedamage, double scaling, double radius, String ability) {
        final int abilitydamage = (int) (basedamage * (1+(Intelligence.getmaxintelligence(p) / 100) * scaling));
        int i = 0;
        World w = p.getWorld();
        for (Entity entity : w.getNearbyEntities(loc, radius, radius, radius)) {
            if (BuildMob.mobname.containsKey(entity) && BuildMob.moblvl.containsKey(entity) && BuildMob.mobhealth.containsKey(entity) && BuildMob.mobmaxhealth.containsKey(entity)) {
                if (entity instanceof Mob) {
                    if (BuildMob.mobname.containsKey(entity) && BuildMob.moblvl.containsKey(entity) && BuildMob.mobhealth.containsKey(entity) && BuildMob.mobmaxhealth.containsKey(entity)) {
                        int lvl = BuildMob.moblvl.get(entity);
                        String name = BuildMob.mobname.get(entity);
                        int health = BuildMob.mobhealth.get(entity) - abilitydamage;
                        if (health < abilitydamage) {
                            ((Mob) entity).setHealth(0);
                            entity.setCustomName("§7[Lvl " + lvl + "]§c " + name + " §a0/" + BuildMob.mobmaxhealth.get(entity) + "§c❤");
                            BuildMob.mobhealth.remove(entity);
                            BuildMob.moblvl.remove(entity);
                            BuildMob.mobname.remove(entity);
                            p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                        }
                        entity.setCustomName("§7[Lvl " + lvl + "]§c " + name + " §a" + health + "/" + BuildMob.mobmaxhealth.get(entity) + "§c❤");
                        entity.setCustomNameVisible(true);
                        ((Mob) entity).damage(0);
                        BuildMob.mobhealth.put(entity, health);
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
            }
        }
        if (i==0) return;
        p.sendMessage("§7Your §c" + ability + " §7Hit §c" + i + " §7Enemies for §c" + i* abilitydamage + " §7damage!");
    }
}
