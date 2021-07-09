package me.Jojokly.mobs;

import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class MobLoot implements Listener {

    @EventHandler
    public void onDeath(EntityDeathEvent e) {
        Entity entity = e.getEntity();
        if (BuildMob.mobname.containsKey(entity)) {

        }
    }
}
