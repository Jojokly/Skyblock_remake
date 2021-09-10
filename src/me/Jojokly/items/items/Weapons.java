package me.Jojokly.items.items;

import org.bukkit.Material;

public enum Weapons {

    HYPERION("§6Hyperion", "HYPERION", Rarity.LEGENDARY, Material.IRON_SWORD, false, 260, 350, 150,  "Wither Impact", 250, 0, "§7Ferocity: §a+30", "§7Deals +§a50% §7damage to", "§7Withers. Grants + §c 1 Damage", "§7and §a+2 §bIntelligence", "§7per §cCatacombs §7level.", " ", "§7Your Catacombs level: §c0", " ", "§6Item Ability: Wither Impact §eRIGHT CLICK ", "§7Teleports §a10 blocks §7ahead of you.", "§7Then implode dealing §c10000 §7damage to nearby enemies.", "§7Also applies the wither shield scroll ability", "§7reducing damage taken and granting", "§7an §6Absorption §7shield for 5 seconds.", "§8Mana cost: §3250", ""),
    GIANT_SWORD("§6Giant's Sword", "GIANT_SWORD",Rarity.LEGENDARY, Material.IRON_SWORD, true, 500, 0, 0, "Giant's Slam", 500, 15,"§6Item Ability: Giant's Slam  §eRIGHT CLICK", "§7Slam your sword into the ground", "§7dealing §c100,000 §7damage to", "§7nearby enemies", "§8Mana cost: §3500", "§8Cooldown: §a15s", " ", "§8This item can be reforged!"),
    SPIRIT_SCEPTRE("§6Spirit Sceptre", "SPIRIT_SCEPTRE", Rarity.LEGENDARY, Material.ALLIUM, true, 180, 300, 0, "Guided Bat", 250, 0, "§6Item Ability: Guided Bat §e§lRIGHT CLICK", "§7Shoots a guided spirit bat,", "§7following your aim end exploding", "§c2.000 §7damage", "§8Mana cost: §3250", " "),
    BONEMERANG("§6Bonemerang", "BONEMERANG", Rarity.LEGENDARY, Material.BONE, false, 270, 0, 130, "Swing", 0, 0, "§6Item Ability: Swing §e§lRIGHT CLICK", "§7Throw the bone a short distance,", "§7dealing the damage an arrow", "§7would.", " ", "§7Deals §cdouble damage §7when", "§7coming back. Pierces up to §e10", "§7foes.", " ", "§8This item can be reforged!" ),
    MIDAS_STAFF("§6Midas Staff", "MIDAS_STAFF", Rarity.LEGENDARY, Material.GOLDEN_SHOVEL, true,130, 50, 150, "Molten Wave", 500, 1, "§6Item Ability: Molten Wave §e§lRIGHT CLICK", "§7Cast a wave of molten gold in", "§7the direction you are facing!", "§7Deals up to §c16.000 §7damage.", "§8Mana Cost: §3500", "§7Cooldown: §a1s"," ", "§6Item Ability: Greed", "§7The §3ability damage bonus §7of", "§7the item is dependent on the", "§7price paid for it at the §5Dark", "§5Auction§7!", "§7The maximum bonus of this item", "§7is §316000 §7if the bid was", "§6100.000.000 Coins §7or higher!", " "),
    ASPECT_OF_THE_DRAGONS("§6Aspect of the Dragons", "ASPECT_OF_THE_DRAGONS", Rarity.LEGENDARY, Material.DIAMOND_SWORD, false, 225, 0, 100, "Dragon Rage", 100, 0, "§6Item Ability: Dragon Rage §e§lRIGHT CLICK", "§7All monsters in front of you", "§7take §a12.000 §7damage. Hit", "§7Monsters take large knockback.", "§8Mana Cost: §b100", " ", "§8This item can be reforged!"),
    //Epic
    EMBER_ROD("§5Ember Rod", "EMBER_ROD", Rarity.EPIC, Material.BLAZE_ROD, true, 80, 50, 35, "Fire blast", 150, 15, "§6Item Ability: Fire Blase  §e§lRIGHT CLICK","§7Shoot 3 Fireballs which deal", "§c30 §7damage in rapid", "§7succession in front of you!", "§7Mana cost: §3150", "§7cooldown: §a15s"),
    SINSEEKER_SCYTHE("§4Sin§5seeker Scythe", "SINSEEKER_SCYTHE", Rarity.EPIC, Material.GOLDEN_HOE, false, 100, 0, 100, "Sinrecall Transmission", 260, 0, "§6Item Ability: Sinrecall Transmission §e§lRIGHT CLICK", "§7Zap a line §54 §7blocks forward.", " ", "§7Recast within 1s (§b1.5x Mana§7)", "§7or warp back to starting point.", " ", "§7Mobs crossing zhe line(s)", "§7receive a §cmelee hit §7from what", "§7you are holding.", "§8Mana Cost: §3260", " ", "§8This item can be reforged!"),
    STAFF_OF_THE_RISING_SUN("§5Staff of the Rising Sun", "STAFF_OF_THE_RISING_SUN", Rarity.EPIC, Material.SUNFLOWER, false, 0, 0, 0, "Ray of Hope", 0, 0, "§6Ability: Ray of Hope §e§lRIGHT CLICK", "§7Channels your energy towards", "§7the targets location, exploding on", "§7impact for §c750 §7damage.", "§7Costs §b10% §7 of your total mana", "§7to use. This is the only item", "§7that can deal damage to Dante."),
    ICE_SPRAY_WAND("§5Ice Spray Wand", "ICE_SPRAY_WAND", Rarity.EPIC, Material.STICK, true, 120, 293, 0, "Ice Spray", 50, 5, "§6Ability: Ice Spray §e§lRIGHT CLICK", "§7Produces a cone of ice in front", "§7of the caster that deals", "§c17.000 §7damage to mobs and", "§7freezes them in place for §e5", "§7seconds! Frozen mobs take", "§c10% §7increased damage!", "§8Mana Cost: §b50", "§8Cooldown: §a5s", "", "§8This item can be reforged!"),
    //Rare
    BONZO_STAFF("§9Bonzo's Staff", "BONZO_STAFF", Rarity.RARE, Material.BLAZE_ROD, true, 160, 250, 0, "Showtime", 100, 0, "§6Item Ability: Showtime §e§lRIGHT CLICK", "§7Shoots balloons that create a", "§7large explosion on impact", "§7dealing up to §c1.000 §7damage.", "§8Mana cost: §3100", " ", "§8This item can be reforged!"),
    ASPECT_OF_THE_END("§9Aspect of the End", "ASPECT_OF_THE_END", Rarity.RARE, Material.DIAMOND_SWORD, false, 100, 0, 100, "Instant transmission", 50, 0, "§6Item Ability: Instant Transmission  §e§lRIGHT CLICK", "§7Teleport §a8 blocks §7 ahead of", "§7you and gain +50 §fSpeed", "§7for §a3 seconds§7.", "§7Mana cost: §30", " ", "§7This item can be reforged!"),
    GOLEM_SWORD("§9Golem Sword", "GOLEM_SWORD", Rarity.RARE, Material.IRON_SWORD, false, 80, 0, 125, "Iron Punch", 70, 3, "§6Item Ability: Iron Punch §e§lRIGHT CLICK", "§7Punch the ground, damaging", "§7enemies in a hexagon around you", "§7for §a255 §7base magic Damage", "§8Mana cost: §370", "§8Cooldown: §a3s", " "),
    //Uncommon
    GRAPPLINGHOOK("§aGrappling Hook", "GRAPPLINGHOOK", Rarity.UNCOMMON, Material.FISHING_ROD, false, 0, 0, 0, "diesdas", 0, 2, "§7Travel around in style using", "§7this Grappling Hook", "§80 Seconds cooldown", " "),
    //Common
    ROGUE_SWORD("§fRogue Sword", "ROGUE_SWORD", Rarity.COMMON, Material.GOLDEN_SWORD, false, 20, 0, 0, "Speed Boost", 50, 0, "Sword of the legendary speedster \"Schneider_\""),
    ASPECT_OF_THE_JERRY("§fAspect of the Jerry", "ASPECT_OF_THE_JERRY", Rarity.COMMON,Material.WOODEN_SWORD, false, 1, 00, 0, "Parley", 10, 5,"§6Item Ability: Parley §e§lRIGHT CLICK", "§7Channel your inner Jerry.","§8Cooldown: §a5s", " ", "§7This item can be reforged!"),
    //Special
    SWORD_OF_THE_UNIVERSE("§4§lS§cw§6o§er§2d §bo§3f §1t§dh§1e §3U§bn§2i§ev§6e§cr§4s§ce","SWORD_OF_THE_UNIVERSE", Rarity.SPECIAL, Material.GOLDEN_SWORD, false,214748364, 0, 0, null, 0, 0, "§7Damage: §d+∞", "§7Skill: §d-∞", "§7Clout: §d+100", "§ePog, this sword is overkill!", " "),
    ;

    private String name;
    private Rarity rarity;
    private String tag;
    private Material material;
    private boolean isEnchanted;
    private int damage;
    private int intelligence;
    private String ItemAbility;
    private int manacost;
    private int cooldown;
    private String[] lore;
    private int strength;

    Weapons(String name, String tag, Rarity rarity, Material material, boolean isEnchanted, int damage, int intelligence, int strength, String ItemAbility, int manacost, int cooldown, String... lore) {
        this.name = name;
        this.tag = tag;
        this.rarity = rarity;
        this.material = material;
        this.isEnchanted = isEnchanted;
        this.damage = damage;
        this.intelligence = intelligence;
        this.strength = strength;
        this.ItemAbility = ItemAbility;
        this.manacost = manacost;
        this.cooldown = cooldown;
        this.lore = lore;
    }

    public String getName() {
        return name;
    }

    public String getTag() {
        return tag;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public Material getMaterial() {
        return material;
    }

    public boolean isEnchanted() {
        return isEnchanted;
    }

    public int getDamage() {
        return damage;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public String getItemAbility() {
        return ItemAbility;
    }

    public int getManacost() {
        return manacost;
    }

    public String[] getLore() {
        return lore;
    }

    public int getStrength() {
        return strength;
    }
}