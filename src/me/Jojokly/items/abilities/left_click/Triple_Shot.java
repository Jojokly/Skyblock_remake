package me.Jojokly.items.abilities.left_click;

import me.Jojokly.skyblockmain.Main;
import net.minecraft.server.v1_16_R3.NBTTagCompound;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

public class Triple_Shot {

    public static void tripleShot(Player p, Arrow arrow) {
        ItemStack item = p.getInventory().getItemInMainHand();
        net.minecraft.server.v1_16_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(item);
        NBTTagCompound itemcombound = nmsItem.getTag();
        Integer damage = itemcombound.getInt("Damage");
        Arrow leftarrow = p.getWorld().spawn(p.getEyeLocation(), Arrow.class);
        leftarrow.setShooter(p);
        leftarrow.setVelocity(arrow.getVelocity().rotateAroundY(Math.toRadians(15)));
        PersistentDataContainer leftpersistentData = arrow.getPersistentDataContainer();
        leftpersistentData.set(new NamespacedKey(Main.getMain(), "Damage"), PersistentDataType.INTEGER, damage);

        Arrow rightarrow = p.getWorld().spawn(p.getEyeLocation(), Arrow.class);
        rightarrow.setShooter(p);
        rightarrow.setVelocity(arrow.getVelocity().rotateAroundY(Math.toRadians(-15)));
        PersistentDataContainer rightpersistentData = arrow.getPersistentDataContainer();
        rightpersistentData.set(new NamespacedKey(Main.getMain(), "Damage"), PersistentDataType.INTEGER, damage);
        new BukkitRunnable() {
            @Override
            public void run() {
                if (leftarrow.isOnGround() || leftarrow.isDead() || rightarrow.isOnGround() || rightarrow.isDead()) {
                    cancel();
                    return;
                }
                List<Entity> leftnearby = leftarrow.getNearbyEntities(5,5, 5);
                List<Entity> rightnearby = rightarrow.getNearbyEntities(5,5, 5);
                for (Entity lefttarget : leftnearby) {
                    if (p.hasLineOfSight(lefttarget) && lefttarget instanceof LivingEntity && !lefttarget.isDead() && lefttarget != p) {
                        leftarrow.setVelocity(lefttarget.getLocation().toVector().subtract(leftarrow.getLocation().toVector()).normalize());
                    }
                }
                for (Entity righttarget : rightnearby) {
                    if (p.hasLineOfSight(righttarget) && righttarget instanceof LivingEntity && !righttarget.isDead() && righttarget != p) {
                        righttarget.setVelocity(righttarget.getLocation().toVector().subtract(rightarrow.getLocation().toVector()).normalize());
                    }
                }
            }
        }.runTaskTimer(Main.getMain(), 0, 1);
    }

}
