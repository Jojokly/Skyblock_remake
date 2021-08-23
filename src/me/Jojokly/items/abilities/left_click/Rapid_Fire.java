package me.Jojokly.items.abilities.left_click;

import me.Jojokly.skyblockmain.Main;
import net.minecraft.server.v1_16_R3.NBTTagCompound;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;

public class Rapid_Fire {

    static Map<String, Long> cooldown = new HashMap<String, Long>();

    public static void Rapid_Fire(Player p) {
        if (cooldown.containsKey(p.getName()) && cooldown.get(p.getName()) > System.currentTimeMillis()) {
            long timeleft = (cooldown.get(p.getName()) - System.currentTimeMillis()) / 1000L;
            p.sendMessage("§cAbility is on cooldown for " + timeleft + " §cmore seconds");
            return;
        }
        cooldown.put(p.getName(), System.currentTimeMillis() + 20000L);
        new BukkitRunnable() {
            int i = 40;
            final ItemStack item = p.getInventory().getItemInMainHand();
            @Override
            public void run() {
                if (i == 0) {
                    cancel();
                    return;
                }
                if (!(p.getInventory().getItemInMainHand().equals(item))) {
                    cancel();
                    return;
                }
                Location eye = p.getEyeLocation();
                Location loc = eye.add(eye.getDirection().multiply(1.2));
                Arrow arrow = loc.getWorld().spawn(loc, Arrow.class);
                ItemStack item = p.getInventory().getItemInMainHand();
                net.minecraft.server.v1_16_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(item);
                NBTTagCompound itemcombound = nmsItem.getTag();
                Integer damage = itemcombound.getInt("Damage");
                PersistentDataContainer persistentData = arrow.getPersistentDataContainer();
                persistentData.set(new NamespacedKey(Main.getMain(), "Damage"), PersistentDataType.INTEGER, damage);
                arrow.setVelocity(loc.getDirection().normalize().multiply(2));
                arrow.setShooter(p);
                i--;
            }
        }.runTaskTimer(Main.getMain(), 0, 4);
    }
}
