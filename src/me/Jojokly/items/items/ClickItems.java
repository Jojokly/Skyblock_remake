package me.Jojokly.items.items;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class ClickItems implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase("§fSkyblock Items")) {
            if (e.getCurrentItem() != null && e.getCurrentItem().hasItemMeta()) {
                if(e.getCurrentItem().getItemMeta().hasDisplayName())
                e.setCancelled(true);
                switch (e.getCurrentItem().getItemMeta().getDisplayName()) {
                    case "§fAspect of the Jerry":
                        e.setCancelled(true);
                        p.getInventory().addItem(ItemBuilder.createItem(SkyblockItems.ASPECT_OF_THE_JERRY));
                        break;
                    case "§fRogue Sword":
                        e.setCancelled(true);
                        p.getInventory().addItem(ItemBuilder.createItem(SkyblockItems.ROGUE_SWORD));
                        break;
                    case "§6Go to: §a§lUNCOMMON":
                        Bukkit.dispatchCommand(p, "items uncommon");
                    default:
                        e.setCancelled(true);
                }
            }
        } else if (e.getView().getTitle().equalsIgnoreCase("§aSkyblock Items")) {
            if (e.getCurrentItem() != null && e.getCurrentItem().hasItemMeta()) {
                if(e.getCurrentItem().getItemMeta().hasDisplayName())
                e.setCancelled(true);
                switch (e.getCurrentItem().getItemMeta().getDisplayName()) {
                    case "§aGrappling Hook":
                        e.setCancelled(true);
                        p.getInventory().addItem(ItemBuilder.createItem(SkyblockItems.GRAPPLINGHOOK));
                        break;
                    case "§aRadiant Power Orb":
                        e.setCancelled(true);
                        p.getInventory().addItem(ItemBuilder.createPowerOrb(Power_Orb.RADIANT_POWER_ORB));
                        break;
                    case "§6Go to: §f§lCOMMON":
                        Bukkit.dispatchCommand(p, "items common");
                        break;
                    case "§6Go to: §9§lRARE":
                        Bukkit.dispatchCommand(p, "items rare");
                    default:
                        e.setCancelled(true);
                }
            }
        } else if (e.getView().getTitle().equalsIgnoreCase("§9Skyblock Items")) {
            if (e.getCurrentItem() != null && e.getCurrentItem().hasItemMeta()) {
                if(e.getCurrentItem().getItemMeta().hasDisplayName())
                e.setCancelled(true);
                switch (e.getCurrentItem().getItemMeta().getDisplayName()) {
                    case "§9Aspect of the End":
                        e.setCancelled(true);
                        p.getInventory().addItem(ItemBuilder.createItem(SkyblockItems.ASPECT_OF_THE_END));
                        break;
                    case "§9Golem Sword":
                        e.setCancelled(true);
                        p.getInventory().addItem(new ItemStack(ItemBuilder.createItem(SkyblockItems.GOLEM_SWORD)));
                        break;
                    case "§9Bonzo's Staff" :
                        e.setCancelled(true);
                        p.getInventory().addItem(new ItemStack(ItemBuilder.createItem(SkyblockItems.BONZO_STAFF)));
                        break;
                    case "§9Manaflux Power Orb":
                        e.setCancelled(true);
                        p.getInventory().addItem(new ItemStack(ItemBuilder.createPowerOrb(Power_Orb.MANAFLUX_POWER_ORB)));
                        break;
                    case "§6Go to: §a§lUNCOMMON":
                        Bukkit.dispatchCommand(p, "items uncommon");
                        break;
                    case "§6Go to: §5§lEPIC":
                        Bukkit.dispatchCommand(p,"items epic");
                    default:
                        e.setCancelled(true);
                }
            }
        }else if (e.getView().getTitle().equalsIgnoreCase("§5Skyblock Items")) {
            if (e.getCurrentItem() != null && e.getCurrentItem().hasItemMeta()) {
                if(e.getCurrentItem().getItemMeta().hasDisplayName())
                e.setCancelled(true);
                switch (e.getCurrentItem().getItemMeta().getDisplayName()) {
                    case "§6Go to: §9§lRARE":
                        Bukkit.dispatchCommand(p, "items rare");
                        break;
                    case "§5Ember Rod":
                        e.setCancelled(true);
                        p.getInventory().addItem(new ItemStack(ItemBuilder.createItem(SkyblockItems.EMBER_ROD)));
                        break;
                    case "§5Overflux Power Orb":
                        e.setCancelled(true);
                        p.getInventory().addItem(new ItemStack(ItemBuilder.createPowerOrb(Power_Orb.OVERFLUX_POWER_ORB)));
                        break;
                    case "§6Go to: §6§lLEGENDARY":
                        Bukkit.dispatchCommand(p,"items legendary");
                        break;
                    default:
                        e.setCancelled(true);
                }
            }
        }else if (e.getView().getTitle().equalsIgnoreCase("§6Skyblock Items")) {
            if (e.getCurrentItem() != null && e.getCurrentItem().hasItemMeta()) {
                if(e.getCurrentItem().getItemMeta().hasDisplayName())
                e.setCancelled(true);
                switch (e.getCurrentItem().getItemMeta().getDisplayName()) {
                    case "§6Go to: §5§lEPIC":
                        Bukkit.dispatchCommand(p, "items epic");
                        break;
                    case "§6Hyperion":
                        e.setCancelled(true);
                        p.getInventory().addItem(new ItemStack(ItemBuilder.createItem(SkyblockItems.HYPERION)));
                        break;
                    case "§6Giant's Sword":
                        e.setCancelled(true);
                        p.getInventory().addItem(new ItemStack(ItemBuilder.createItem(SkyblockItems.GIANT_SWORD)));
                        break;
                    case "§6Spirit Sceptre":
                        e.setCancelled(true);
                        p.getInventory().addItem(new ItemStack(ItemBuilder.createItem(SkyblockItems.SPIRIT_SCEPTRE)));
                        break;
                    case "§6Bonemerang":
                        e.setCancelled(true);
                        p.getInventory().addItem(new ItemStack(ItemBuilder.createItem(SkyblockItems.BONEMERANG)));
                        break;
                    case "§6Plasmaflux Power Orb":
                        e.setCancelled(true);
                        p.getInventory().addItem(new ItemStack(ItemBuilder.createPowerOrb(Power_Orb.PLASMAFLUX_POWER_ORB)));
                        break;
                    case "§4§lS§cw§6o§er§2d §bo§3f §1t§dh§1e §3U§bn§2i§ev§6e§cr§4s§ce":
                        e.setCancelled(true);
                        p.getInventory().addItem(new ItemStack(ItemBuilder.createItem(SkyblockItems.SWORD_OF_THE_UNIVERSE)));
                        p.getInventory().addItem(ItemBuilder.createHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTJkZDExZGEwNDI1MmY3NmI2OTM0YmMyNjYxMmY1NGYyNjRmMzBlZWQ3NGRmODk5NDEyMDllMTkxYmViYzBhMiJ9fX0="));
                        break;
                    case "§6Midas Staff":
                        e.setCancelled(true);
                        p.getInventory().addItem(new ItemStack(ItemBuilder.createItem(SkyblockItems.MIDAS_STAFF)));
                        break;
                    default:
                        e.setCancelled(true);
                }
            }
        }
    }

}