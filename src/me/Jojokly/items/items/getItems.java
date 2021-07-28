package me.Jojokly.items.items;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class getItems implements CommandExecutor {

    public ItemStack ItemBuilder(Material material, String displayname) {
        ItemStack fill = new ItemStack(material);
        ItemMeta fillmeta = fill.getItemMeta();
        fillmeta.setDisplayName(displayname);
        fill.setItemMeta(fillmeta);
        return fill;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            Inventory commoninv = Bukkit.createInventory(null, 9 * 5, "§fSkyblock Items");
            Inventory uncommoninv = Bukkit.createInventory(null, 9 * 5, "§aSkyblock Items");
            Inventory rareinv = Bukkit.createInventory(null, 9 * 5, "§9Skyblock Items");
            Inventory epicinv = Bukkit.createInventory(null, 9 * 5, "§5Skyblock Items");
            Inventory legendaryinv = Bukkit.createInventory(null, 9 * 5, "§6Skyblock Items");
            //Other Items
            ItemStack toCommon = new ItemStack(ItemBuilder(Material.ARROW, "§6Go to: §f§lCOMMON"));
            ItemStack toUncommon = new ItemStack(ItemBuilder(Material.ARROW, "§6Go to: §a§lUNCOMMON"));
            ItemStack toRare = new ItemStack(ItemBuilder(Material.ARROW, "§6Go to: §9§lRARE"));
            ItemStack toEpic = new ItemStack(ItemBuilder(Material.ARROW, "§6Go to: §5§lEPIC"));
            ItemStack toLegendary = new ItemStack(ItemBuilder(Material.ARROW, "§6Go to: §6§lLEGENDARY"));
            for (int i = 0; i < commoninv.getSize(); i++) {
                if (commoninv.getItem(i) == null) {
                    commoninv.setItem(i, ItemBuilder(Material.GRAY_STAINED_GLASS_PANE, " "));
                }
            }
                ItemStack white_fill = new ItemStack(ItemBuilder(Material.WHITE_STAINED_GLASS_PANE, " "));
                commoninv.setItem(0, white_fill);
                commoninv.setItem(1, new ItemStack(ItemBuilder.createItem(SkyblockItems.ASPECT_OF_THE_JERRY)));
                commoninv.setItem(2, new ItemStack(ItemBuilder.createItem(SkyblockItems.ROGUE_SWORD)));
                commoninv.setItem(8, white_fill);
                commoninv.setItem(9, white_fill);
                commoninv.setItem(17, white_fill);
                commoninv.setItem(18, white_fill);
                commoninv.setItem(26, toUncommon);
                commoninv.setItem(27, white_fill);
                commoninv.setItem(35, white_fill);
                commoninv.setItem(36, white_fill);
                commoninv.setItem(44, white_fill);

                for (int j = 0; j < uncommoninv.getSize(); j++) {
                    if (uncommoninv.getItem(j) == null) {
                        uncommoninv.setItem(j, ItemBuilder(Material.GRAY_STAINED_GLASS_PANE, " "));
                    }
                }
                    ItemStack green_fill = new ItemStack(ItemBuilder(Material.GREEN_STAINED_GLASS_PANE, " "));
                    uncommoninv.setItem(0, green_fill);
                    uncommoninv.setItem(1, new ItemStack(ItemBuilder.createItem(SkyblockItems.GRAPPLINGHOOK)));
                    uncommoninv.setItem(2, new ItemStack(ItemBuilder.createPowerOrb(Power_Orb.RADIANT_POWER_ORB)));
                    uncommoninv.setItem(8, green_fill);
                    uncommoninv.setItem(9, green_fill);
                    uncommoninv.setItem(17, green_fill);
                    uncommoninv.setItem(18, toCommon);
                    uncommoninv.setItem(26, toRare);
                    uncommoninv.setItem(27, green_fill);
                    uncommoninv.setItem(35, green_fill);
                    uncommoninv.setItem(36, green_fill);
                    uncommoninv.setItem(44, green_fill);

            for (int i = 0; i < rareinv.getSize(); i++) {
                if (rareinv.getItem(i) == null) {
                    rareinv.setItem(i, ItemBuilder(Material.GRAY_STAINED_GLASS_PANE, " "));
                }
            }
            ItemStack bluefill = new ItemStack(ItemBuilder(Material.BLUE_STAINED_GLASS_PANE, " "));
            rareinv.setItem(0, bluefill);
            rareinv.setItem(1, new ItemStack(ItemBuilder.createItem(SkyblockItems.ASPECT_OF_THE_END)));
            rareinv.setItem(2, new ItemStack(ItemBuilder.createItem(SkyblockItems.GOLEM_SWORD)));
            rareinv.setItem(3, new ItemStack(ItemBuilder.createItem(SkyblockItems.BONZO_STAFF)));
            rareinv.setItem(4, new ItemStack(ItemBuilder.createPowerOrb(Power_Orb.MANAFLUX_POWER_ORB)));
            rareinv.setItem(8, bluefill);
            rareinv.setItem(9, bluefill);
            rareinv.setItem(17, bluefill);
            rareinv.setItem(18, toUncommon);
            rareinv.setItem(26, toEpic);
            rareinv.setItem(27, bluefill);
            rareinv.setItem(35, bluefill);
            rareinv.setItem(36, bluefill);
            rareinv.setItem(44, bluefill);
            for (int i = 0; i < epicinv.getSize(); i++) {
                if (epicinv.getItem(i) == null) {
                    epicinv.setItem(i, ItemBuilder(Material.GRAY_STAINED_GLASS_PANE, " "));
                }
            }
            ItemStack purplefill = new ItemStack(ItemBuilder(Material.PURPLE_STAINED_GLASS_PANE, " "));
            epicinv.setItem(0, purplefill);
            epicinv.setItem(1, new ItemStack(ItemBuilder.createItem(SkyblockItems.EMBER_ROD)));
            epicinv.setItem(2, new ItemStack(ItemBuilder.createItem(SkyblockItems.SINSEEKER_SCYTHE)));
            epicinv.setItem(3, new ItemStack(ItemBuilder.createPowerOrb(Power_Orb.OVERFLUX_POWER_ORB)));
            epicinv.setItem(8, purplefill);
            epicinv.setItem(9, purplefill);
            epicinv.setItem(17, purplefill);
            epicinv.setItem(18, toRare);
            epicinv.setItem(26, toLegendary);
            epicinv.setItem(27, purplefill);
            epicinv.setItem(35, purplefill);
            epicinv.setItem(36, purplefill);
            epicinv.setItem(44, purplefill);
            for (int i = 0; i < legendaryinv.getSize(); i++) {
                if (legendaryinv.getItem(i) == null) {
                    legendaryinv.setItem(i, ItemBuilder(Material.GRAY_STAINED_GLASS_PANE, " "));
                }
            }
            ItemStack goldfill = new ItemStack(ItemBuilder(Material.YELLOW_STAINED_GLASS_PANE, " "));
            legendaryinv.setItem(0, goldfill);
            legendaryinv.setItem(1, new ItemStack(ItemBuilder.createItem(SkyblockItems.HYPERION)));
            legendaryinv.setItem(2, new ItemStack(ItemBuilder.createItem(SkyblockItems.GIANT_SWORD)));
            legendaryinv.setItem(3, new ItemStack(ItemBuilder.createItem(SkyblockItems.SPIRIT_SCEPTRE)));
            legendaryinv.setItem(4, new ItemStack(ItemBuilder.createItem(SkyblockItems.BONEMERANG)));
            legendaryinv.setItem(5, new ItemStack(ItemBuilder.createPowerOrb(Power_Orb.PLASMAFLUX_POWER_ORB)));
            legendaryinv.setItem(6, new ItemStack(ItemBuilder.createItem(SkyblockItems.MIDAS_STAFF)));
            legendaryinv.setItem(8, new ItemStack(ItemBuilder.createItem(SkyblockItems.SWORD_OF_THE_UNIVERSE)));
            legendaryinv.setItem(8, goldfill);
            legendaryinv.setItem(9, goldfill);
            legendaryinv.setItem(17, goldfill);
            legendaryinv.setItem(18, toEpic);
            legendaryinv.setItem(26, goldfill);
            legendaryinv.setItem(27, goldfill);
            legendaryinv.setItem(35, goldfill);
            legendaryinv.setItem(36, goldfill);
            legendaryinv.setItem(44, goldfill);
                    if (label.equalsIgnoreCase("items")) {
                        if (args.length == 1) {
                            switch (args[0]) {
                                case "common":
                                    p.openInventory(commoninv);
                                    break;
                                case "uncommon":
                                    p.openInventory(uncommoninv);
                                    break;
                                case "rare":
                                    p.openInventory(rareinv);
                                    break;
                                case "epic":
                                    p.openInventory(epicinv);
                                    break;
                                case "legendary":
                                    p.openInventory(legendaryinv);
                                    break;
                            }
                        }
                    }
                }
        return false;
    }
}