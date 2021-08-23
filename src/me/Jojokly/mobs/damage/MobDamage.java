package me.Jojokly.mobs.damage;

import me.Jojokly.items.items.Weapons;
import me.Jojokly.skyblockmain.Main;
import net.minecraft.server.v1_16_R3.NBTTagCompound;
import org.bukkit.*;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;

public class MobDamage implements Listener {

    private double getRandomOffset() {
        double random = Math.random();
        if (Math.random() > 0.5D) {
            random *= -1.0D;
        }
        return random;
    }

    public static Map<Entity, Player> killer = new HashMap<>();

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        e.setDamage(0);
        Entity entity = e.getEntity();
        Entity damager = e.getDamager();
        if (damager instanceof Player) {
            Player p = (Player) e.getDamager();
            World world = entity.getWorld();
            Location loc = entity.getLocation().clone().add(getRandomOffset(), 1.0D, getRandomOffset());
            ItemStack item = p.getItemInHand();
            if (item.getType() == Material.AIR || !(item.hasItemMeta()))
                return;
            net.minecraft.server.v1_16_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(item);
            NBTTagCompound compound = (nmsItem.hasTag()) ? nmsItem.getTag() : new NBTTagCompound();
            String s1 = compound.getString("SbName");
            Weapons items = Weapons.valueOf(s1);
            int damage = (5 + items.getDamage()) * (1 + items.getStrength() / 100);
            if (!(entity instanceof Player)) {
                if (entity instanceof Mob) {
                    PersistentDataContainer persistentData = entity.getPersistentDataContainer();
                    int lvl = persistentData.get(new NamespacedKey(Main.getMain(), "Level"), PersistentDataType.INTEGER);
                    String name = persistentData.get(new NamespacedKey(Main.getMain(), "Name"), PersistentDataType.STRING);
                    int health = persistentData.get(new NamespacedKey(Main.getMain(), "Health"), PersistentDataType.INTEGER);
                    int maxhealth = persistentData.get(new NamespacedKey(Main.getMain(), "MaxHealth"), PersistentDataType.INTEGER);
                    if (health < damage) {
                        ((Mob) entity).setHealth(0);
                        killer.put(entity, p);
                        entity.setCustomName("§7[Lvl " + lvl + "]§c " + name + " §e0§f/§a" + maxhealth + "§c❤");
                        p.playSound(loc, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                    } else {
                        if (!(health <= (maxhealth / 2))) {
                            entity.setCustomName("§7[Lvl " + lvl + "]§c " + name + " §a" + health + "§f/§a" + maxhealth + "§c❤");
                        } else {
                            entity.setCustomName("§7[Lvl " + lvl + "]§c " + name + " §e" + health + "§f/§a" + maxhealth + "§c❤");
                        }
                        entity.setCustomNameVisible(true);
                        persistentData.set(new NamespacedKey(Main.getMain(), "Health"), PersistentDataType.INTEGER, health - damage);
                    }
                    world.spawn(loc, ArmorStand.class, (armorStand) -> {
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
            }
        }
    }
}
