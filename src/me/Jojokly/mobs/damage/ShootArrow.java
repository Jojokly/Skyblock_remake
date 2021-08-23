package me.Jojokly.mobs.damage;

import me.Jojokly.skyblockmain.Main;
import net.minecraft.server.v1_16_R3.NBTTagCompound;
import org.bukkit.NamespacedKey;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class ShootArrow implements Listener {

    @EventHandler
    public void onShoot(EntityShootBowEvent e) {
        Entity entity = e.getEntity();
        Entity projectile = e.getProjectile();
        if (entity instanceof Player) {
            if (projectile instanceof Arrow) {
                Player p = (Player) e.getEntity();
                Arrow arrow = (Arrow) e.getProjectile();
                ItemStack item = p.getInventory().getItemInMainHand();
                net.minecraft.server.v1_16_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(item);
                NBTTagCompound itemcombound = nmsItem.getTag();
                Integer damage = itemcombound.getInt("Damage");
                PersistentDataContainer persistentData = arrow.getPersistentDataContainer();
                persistentData.set(new NamespacedKey(Main.getMain(), "Damage"), PersistentDataType.INTEGER, damage);
            }
        }
    }
}
