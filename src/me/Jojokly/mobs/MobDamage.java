package me.Jojokly.mobs;

import me.Jojokly.items.items.SkyblockItems;
import me.Jojokly.skyblockmain.Main;
import net.minecraft.server.v1_16_R3.NBTTagCompound;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class MobDamage implements Listener {

    private double getRandomOffset() {
        double random = Math.random();
        if (Math.random() > 0.5D) {
            random *= -1.0D;
        }
        return random;
    }


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
            SkyblockItems items = SkyblockItems.valueOf(s1);
            int damage = (5 + items.getDamage()) * (1+ items.getStrength() / 100);
            if (!(entity instanceof Player)) {
                if (entity instanceof Mob) {
                    if (BuildMob.mobname.containsKey(entity) && BuildMob.moblvl.containsKey(entity) && BuildMob.mobhealth.containsKey(entity) && BuildMob.mobmaxhealth.containsKey(entity)) {
                        int lvl = BuildMob.moblvl.get(entity);
                        String name = BuildMob.mobname.get(entity);
                        int health = BuildMob.mobhealth.get(entity) - damage;
                        if (health < damage) {
                            health = 0;
                            ((Mob) entity).setHealth(0);
                            entity.setCustomName("§7[Lvl " + lvl + "]§c " + name + " §a0/" + BuildMob.mobmaxhealth.get(entity) + "§c❤");
                            BuildMob.mobhealth.remove(entity);
                            BuildMob.moblvl.remove(entity);
                            BuildMob.mobname.remove(entity);
                            p.playSound(loc, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                        }
                        entity.setCustomName("§7[Lvl " + lvl + "]§c " + name + " §a" + health + "/" + BuildMob.mobmaxhealth.get(entity) + "§c❤");
                        entity.setCustomNameVisible(true);
                        BuildMob.mobhealth.put(entity, health);
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
}
