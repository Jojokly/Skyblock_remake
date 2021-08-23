package me.Jojokly.items.abilities.init_Ability;

import me.Jojokly.items.abilities.left_click.Triple_Shot;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;

public class ShootArrow implements Listener {

    @EventHandler
    public void onShoot(EntityShootBowEvent e) {
        if (!(e.getProjectile() instanceof Arrow))
            return;
        if (!(e.getEntity() instanceof Player))
            return;
        Player p = (Player) e.getEntity();
        ItemStack item = e.getBow();
        if (!(item.hasItemMeta()))
            return;
        if (item.getItemMeta().getDisplayName().equals("§6Runaan's Bow")) {
            Triple_Shot.tripleShot(p, (Arrow) e.getProjectile());

        }
    }
}
