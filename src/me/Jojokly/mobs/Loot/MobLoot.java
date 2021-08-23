package me.Jojokly.mobs.Loot;

import com.google.common.collect.Lists;

import me.Jojokly.mobs.Utils.CustomMobs;
import me.Jojokly.mobs.damage.MobDamage;
import me.Jojokly.skyblockmain.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.*;

public class MobLoot implements Listener {


    @EventHandler
    public void onDeath(EntityDeathEvent e) {
        Entity entity = e.getEntity();
        Location loc = entity.getLocation();
        e.setDroppedExp(0);
        e.getDrops().clear();
        Player p = e.getEntity().getKiller();
        PersistentDataContainer persistentData = entity.getPersistentDataContainer();
        String rawname = persistentData.get(new NamespacedKey(Main.getMain(), "RawName"), PersistentDataType.STRING);
        CustomMobs mob = CustomMobs.valueOf(rawname);
        List<Object> loot = Arrays.asList(mob.getLootTable());
        List<List<Object>> finallist = Lists.partition(loot, 2);
        for (List<Object> sublist : finallist) {
            ItemStack item = (ItemStack) sublist.get(0);
            int chance = (Integer) sublist.get(1);
            Random r = new Random();
            int i = r.nextInt(100) + 1;
            if (i < chance) {
                if (chance <= 2) {
                    p.sendMessage("§6§lRare Drop! " + item.getItemMeta().getDisplayName());
                    RareDropEvent event = new RareDropEvent(p, item);
                    Bukkit.getPluginManager().callEvent(event);
                }
                entity.getWorld().dropItemNaturally(loc, item);
            }
        }
    }
}
