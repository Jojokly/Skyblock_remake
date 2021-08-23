package me.Jojokly.mobs.Utils;

import me.Jojokly.skyblockmain.Main;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftZombie;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class BuildMob {

    public static Entity createMob(CustomMobs mob, Player p) { ;
        Location loc = p.getLocation();
        LivingEntity entity = (LivingEntity) loc.getWorld().spawnEntity(loc, mob.getType());
        if (mob.getType() == EntityType.ZOMBIE) {
            ((CraftZombie) entity).getHandle().setBaby(false);
        }
        entity.setCustomName("§7[Lvl " + mob.getLevel() + "]§c " + mob.getName() + " §a" + mob.getHealth() + "§f/§a" + mob.getMaxhealth() + "§c❤");
        entity.setCustomNameVisible(true);
        entity.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(100);
        entity.setHealth(100);
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
        PersistentDataContainer persistentData = entity.getPersistentDataContainer();
        persistentData.set(new NamespacedKey(Main.getMain(), "Name"), PersistentDataType.STRING, mob.getName());
        persistentData.set(new NamespacedKey(Main.getMain(), "RawName"), PersistentDataType.STRING, mob.getRawname());
        persistentData.set(new NamespacedKey(Main.getMain(), "Level"), PersistentDataType.INTEGER, mob.getLevel());
        persistentData.set(new NamespacedKey(Main.getMain(), "Health"), PersistentDataType.INTEGER, mob.getHealth());
        persistentData.set(new NamespacedKey(Main.getMain(), "MaxHealth"), PersistentDataType.INTEGER, mob.getMaxhealth());
        return entity;
    }
}
