package me.Jojokly.mobs;

import me.Jojokly.stats.intelligence.Intelligence;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftMob;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftTurtle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;

public class BuildMob {

    public static Map<Entity, String> mobname = new HashMap<Entity, String>();
    public static Map<Entity, String> rawmobname = new HashMap<Entity, String>();
    public static Map<Entity, Integer> moblvl = new HashMap<Entity, Integer>();
    public static Map<Entity, Integer> mobhealth = new HashMap<Entity, Integer>();
    public static Map<Entity, Integer> mobmaxhealth = new HashMap<Entity, Integer>();

    public static Entity createMob(CustomMobs mob, Player p) { ;
        Location loc = p.getLocation();
        LivingEntity entity = (LivingEntity) loc.getWorld().spawnEntity(loc,mob.getType());
        entity.setCustomName("§7[Lvl " + mob.getLevel() + "]§c " + mob.getName() + " §a" + mob.getHealth() + "/" + mob.getMaxhealth() + "§c❤");
        entity.setCustomNameVisible(true);
        entity.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(1);
        entity.setHealth(1);
        EntityEquipment inv = entity.getEquipment();
        inv.setHelmet(mob.getHelmet());
        inv.setChestplate(mob.getChestplate());
        inv.setLeggings(mob.getLeggings());
        inv.setBoots(mob.getBoots());
        inv.setHelmetDropChance(0.0F);
        inv.setChestplateDropChance(0.0F);
        inv.setLeggingsDropChance(0.0F);
        inv.setBootsDropChance(0.0F);

        inv.setItemInMainHand(mob.getWeapon());
        mobname.put(entity, mob.getName());
        rawmobname.put(entity, mob.getRawname());
        moblvl.put(entity, mob.getLevel());
        mobhealth.put(entity, mob.getHealth());
        mobmaxhealth.put(entity, mob.getMaxhealth());
        return entity;
    }
}
