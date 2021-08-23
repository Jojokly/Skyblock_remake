package me.Jojokly.items.items;

import me.Jojokly.items.armor.Armor;
import me.Jojokly.items.armor.ArmorBuilder;
import net.minecraft.server.v1_16_R3.NBTTagCompound;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class ClickItems implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        ItemStack item = e.getCurrentItem();
        net.minecraft.server.v1_16_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(item);
        NBTTagCompound combound = (nmsItem.hasTag()) ? nmsItem.getTag() : new NBTTagCompound();
        boolean secret = combound.getBoolean("Secret");
        if (secret) {
            Bukkit.dispatchCommand(p, "items custom");
        }
        if (e.getView().getTitle().equalsIgnoreCase("§fSkyblock Items")) {
            if (e.getCurrentItem() != null && e.getCurrentItem().hasItemMeta()) {
                if(e.getCurrentItem().getItemMeta().hasDisplayName())
                e.setCancelled(true);
                switch (e.getCurrentItem().getItemMeta().getDisplayName()) {
                    case "§fAspect of the Jerry":
                        e.setCancelled(true);
                        p.getInventory().addItem(ItemBuilder.createItem(Weapons.ASPECT_OF_THE_JERRY));
                        break;
                    case "§fRogue Sword":
                        e.setCancelled(true);
                        p.getInventory().addItem(ItemBuilder.createItem(Weapons.ROGUE_SWORD));
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
                        p.getInventory().addItem(ItemBuilder.createItem(Weapons.GRAPPLINGHOOK));
                        break;
                    case "§aRadiant Power Orb":
                        e.setCancelled(true);
                        p.getInventory().addItem(ItemBuilder.createPowerOrb(Power_Orb.RADIANT_POWER_ORB));
                        break;
                    case "§aLapis Armor Helmet":
                        e.setCancelled(true);
                        p.getInventory().addItem(ArmorBuilder.build(Armor.LAPIS_ARMOR_HELMET));
                        p.getInventory().addItem(ArmorBuilder.build(Armor.LAPIS_ARMOR_CHESTPLATE));
                        p.getInventory().addItem(ArmorBuilder.build(Armor.LAPIS_ARMOR_LEGGINGS));
                        p.getInventory().addItem(ArmorBuilder.build(Armor.LAPIS_ARMOR_BOOTS));
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
                        p.getInventory().addItem(ItemBuilder.createItem(Weapons.ASPECT_OF_THE_END));
                        break;
                    case "§9Golem Sword":
                        e.setCancelled(true);
                        p.getInventory().addItem(new ItemStack(ItemBuilder.createItem(Weapons.GOLEM_SWORD)));
                        break;
                    case "§9Bonzo's Staff" :
                        e.setCancelled(true);
                        p.getInventory().addItem(new ItemStack(ItemBuilder.createItem(Weapons.BONZO_STAFF)));
                        break;
                    case "§9Manaflux Power Orb":
                        e.setCancelled(true);
                        p.getInventory().addItem(new ItemStack(ItemBuilder.createPowerOrb(Power_Orb.MANAFLUX_POWER_ORB)));
                        break;
                    case "§9Machine Gun Bow":
                        e.setCancelled(true);
                        p.getInventory().addItem(new ItemStack(ItemBuilder.createBow(Bow.MACHINE_GUN_BOW)));
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
                        p.getInventory().addItem(new ItemStack(ItemBuilder.createItem(Weapons.EMBER_ROD)));
                        break;
                    case "§5Overflux Power Orb":
                        e.setCancelled(true);
                        p.getInventory().addItem(new ItemStack(ItemBuilder.createPowerOrb(Power_Orb.OVERFLUX_POWER_ORB)));
                        break;
                    case "§4Sin§5seeker Scythe":
                        e.setCancelled(true);
                        p.getInventory().addItem(new ItemStack(ItemBuilder.createItem(Weapons.SINSEEKER_SCYTHE)));
                        break;
                    case "§5Staff of the Rising Sun":
                        e.setCancelled(true);
                        p.getInventory().addItem(new ItemStack(ItemBuilder.createItem(Weapons.STAFF_OF_THE_RISING_SUN)));
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
                        p.getInventory().addItem(new ItemStack(ItemBuilder.createItem(Weapons.HYPERION)));
                        break;
                    case "§6Giant's Sword":
                        e.setCancelled(true);
                        p.getInventory().addItem(new ItemStack(ItemBuilder.createItem(Weapons.GIANT_SWORD)));
                        break;
                    case "§6Spirit Sceptre":
                        e.setCancelled(true);
                        p.getInventory().addItem(new ItemStack(ItemBuilder.createItem(Weapons.SPIRIT_SCEPTRE)));
                        break;
                    case "§6Bonemerang":
                        e.setCancelled(true);
                        p.getInventory().addItem(new ItemStack(ItemBuilder.createItem(Weapons.BONEMERANG)));
                        break;
                    case "§6Plasmaflux Power Orb":
                        e.setCancelled(true);
                        p.getInventory().addItem(new ItemStack(ItemBuilder.createPowerOrb(Power_Orb.PLASMAFLUX_POWER_ORB)));
                        break;
                    case "§4§lS§cw§6o§er§2d §bo§3f §1t§dh§1e §3U§bn§2i§ev§6e§cr§4s§ce":
                        e.setCancelled(true);
                        p.getInventory().addItem(new ItemStack(ItemBuilder.createItem(Weapons.SWORD_OF_THE_UNIVERSE)));
                        break;
                    case "§6Midas Staff":
                        e.setCancelled(true);
                        p.getInventory().addItem(new ItemStack(ItemBuilder.createItem(Weapons.MIDAS_STAFF)));
                        break;
                    case "§6Runaan's Bow":
                        e.setCancelled(true);
                        p.getInventory().addItem(new ItemStack(ItemBuilder.createBow(Bow.RUNAANS_BOW)));
                        break;
                    case "§6Aspect of the Dragons":
                        e.setCancelled(true);
                        p.getInventory().addItem(new ItemStack(ItemBuilder.createItem(Weapons.ASPECT_OF_THE_DRAGONS)));
                    default:
                        e.setCancelled(true);
                }
            }
        } else if (e.getView().getTitle().equalsIgnoreCase("§bChoose your Rarity!")) {
            if (e.getCurrentItem() != null && e.getCurrentItem().hasItemMeta()) {
                Material material = e.getCurrentItem().getType();
                switch (material) {
                    case WHITE_STAINED_GLASS_PANE:
                        Bukkit.dispatchCommand(p, "items common");
                        break;
                    case GREEN_STAINED_GLASS_PANE:
                        Bukkit.dispatchCommand(p, "items uncommon");
                        break;
                    case BLUE_STAINED_GLASS_PANE:
                        Bukkit.dispatchCommand(p, "items rare");
                        break;
                    case PURPLE_STAINED_GLASS_PANE:
                        Bukkit.dispatchCommand(p, "items epic");
                        break;
                    case YELLOW_STAINED_GLASS_PANE:
                        Bukkit.dispatchCommand(p, "items legendary");
                        break;
                    default:
                        e.setCancelled(true);
                }
            }
        }
    }
}