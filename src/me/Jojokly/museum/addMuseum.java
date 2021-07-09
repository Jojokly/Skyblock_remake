package me.Jojokly.museum;

import me.Jojokly.skyblockmain.Main;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;

public class addMuseum {

    public static void remove(Block b) {
        BlockState state =  b.getState();
        PersistentDataContainer container = state.getChunk().getPersistentDataContainer();
        NamespacedKey key = new  NamespacedKey(Main.getMain(), "Hyperion");
        NamespacedKey key1 = new NamespacedKey(Main.getMain(), "Giant_sword");
        NamespacedKey key2 = new NamespacedKey(Main.getMain(), "Aspect_of_the_end");
        container.remove(key);
        container.remove(key1);
        container.remove(key2);
        state.update();
    }

    public static void addMuseum(Player p, Block b, Material material, String name) {
        b = p.getTargetBlock(null,5);
        Location loc = b.getLocation();
        Location nameloc = b.getLocation();
        loc.setX(loc.getX() + 0.5);
        loc.setY(loc.getY() - 1.5);
        loc.setZ(loc.getZ() + 1);
        nameloc.setX(nameloc.getX() + 0.5);
        nameloc.setY(nameloc.getY() -1);
        nameloc.setZ(nameloc.getZ() + 0.4);
        ArmorStand holder = loc.getWorld().spawn(loc, ArmorStand.class);
        ArmorStand stand = nameloc.getWorld().spawn(nameloc, ArmorStand.class);
        stand.setCustomName(name);
        stand.setInvulnerable(true);
        stand.setVisible(false);
        stand.setCustomNameVisible(true);
        stand.setGravity(false);
        holder.setInvulnerable(true);
        holder.setCustomName(" ");
        holder.setCustomNameVisible(false);
        holder.setVisible(false);
        holder.getEquipment().setHelmet(new ItemStack(material));
        p.sendMessage("Block is now an" + name + " block!");
    }
}
