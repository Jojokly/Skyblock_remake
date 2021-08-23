package me.Jojokly.items.armor;

import net.minecraft.server.v1_16_R3.NBTTagCompound;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class EquipHelmet implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        Inventory inv = e.getClickedInventory();
        if (e.getCurrentItem() != null) {
            ItemStack item = p.getItemOnCursor();
            ItemStack clickedItem = e.getCurrentItem();
            net.minecraft.server.v1_16_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(item);
            NBTTagCompound combound = (nmsItem.hasTag()) ? nmsItem.getTag() : new NBTTagCompound();
            net.minecraft.server.v1_16_R3.ItemStack nmsclickedItem = CraftItemStack.asNMSCopy(clickedItem);
            NBTTagCompound clickedcombound = (nmsclickedItem.hasTag()) ? nmsclickedItem.getTag() : new NBTTagCompound();
            if (inv.equals(p.getInventory())) {
                if (e.getClick().isLeftClick() && e.getClick() != ClickType.SHIFT_LEFT) {
                    if (e.getSlotType() == InventoryType.SlotType.ARMOR) {
                        if (e.getRawSlot() == 5) {
                            if (combound.getBoolean("Helmet") == true) {
                                e.setCancelled(true);
                                p.getInventory().setHelmet(item);
                                p.setItemOnCursor(null);
                            }
                        }
                    }
                } else if (e.getClick() == ClickType.SHIFT_LEFT) {
                    if (e.getRawSlot() > 8) {
                        if (clickedcombound.hasKey("Helmet")) {
                            p.getInventory().removeItem(clickedItem);
                            p.getInventory().setHelmet(clickedItem);
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (p.getInventory().getItemInMainHand() != null) {
            ItemStack item = p.getInventory().getItemInMainHand();
            net.minecraft.server.v1_16_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(item);
            NBTTagCompound combound = (nmsItem.hasTag()) ? nmsItem.getTag() : new NBTTagCompound();
            if (e.getItem() != null) {
                if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                    assert combound != null;
                    if (combound.hasKey("Helmet")) {
                        p.getInventory().setHelmet(item);
                        p.getInventory().removeItem(e.getItem());
                    }
                }
            }
        }
    }
}
