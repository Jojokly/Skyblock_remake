package me.Jojokly.museum;


import me.Jojokly.skyblockmain.Main;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class ClickEvent implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        Location Hyperionloc = new Location(p.getWorld(), -23, 56, 14);
        Location giantloc = new Location(p.getWorld(), -32, 56, 19);
        Location aoteloc = new Location(p.getWorld(), -28, 54, 31);
        Location grappleloc = new Location(p.getWorld(), -17, 53, 115);
        Location golemswordloc = new Location(p.getWorld(), -31, 54, 32);
        Location EmberRodloc = new Location(p.getWorld(), -13, 54, 41);
        if (!(e.hasBlock()))
            return;
        if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (e.getClickedBlock().getType() == Material.GLASS) {
                if (e.getClickedBlock().getState() instanceof BlockState) {
                    BlockState state = e.getClickedBlock().getState();
                    PersistentDataContainer container = state.getChunk().getPersistentDataContainer();
                    NamespacedKey key = new NamespacedKey(Main.getMain(), "Hyperion");
                    PersistentDataContainer container1 = state.getChunk().getPersistentDataContainer();
                    NamespacedKey key1 = new NamespacedKey(Main.getMain(), "Giant_sword");
                    if (container.has(key, PersistentDataType.STRING)) {
                        if (e.getClickedBlock().getLocation().equals(Hyperionloc)) {
                        }
                    } else if (container1.has(key1, PersistentDataType.STRING)) {
                    }
                }
                } else if(e.getClickedBlock().getLocation().equals(golemswordloc)) {
                } else if(e.getClickedBlock().getLocation().equals(EmberRodloc)) {
                }
            }
        }
    }