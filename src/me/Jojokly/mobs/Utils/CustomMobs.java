package me.Jojokly.mobs.Utils;

import me.Jojokly.items.armor.Armor;
import me.Jojokly.items.armor.ArmorBuilder;
import me.Jojokly.items.items.ItemBuilder;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

public enum CustomMobs {

    //Skyblock hub
    HIGH_LEVEL_SKELETON(EntityType.SKELETON, "Skeleton", "HIGH_LEVEL_SKELETON", 2, 100, 100, 0, 50, null, null, null, null, new ItemStack(Material.BONE), new ItemStack(Material.BONE, 5), 100),
    RUINS_WOLF(EntityType.WOLF, "Wolf", "RUINS_WOLF", 15, 250, 250, 0, 90,  null, null, null, null, null, new ItemStack(Material.BONE), 100),
    RUINS_OLD_WOLF(EntityType.WOLF, "Old Wolf", "OLD_WOLF", 55, 15000, 15000, 0, 800,null, null, null, null, null, new ItemStack(Material.BONE, 4), 100),
    //Deep caverns
    LAPIS_ZOMBIE(EntityType.ZOMBIE, "Lapis Zombie", "LAPIS_ZOMBIE", 7, 200, 200, 0, 50, new ItemStack(Material.BLUE_STAINED_GLASS), ItemBuilder.colorArmor(Material.LEATHER_CHESTPLATE, Color.BLUE), ItemBuilder.colorArmor(Material.LEATHER_LEGGINGS, Color.BLUE), ItemBuilder.colorArmor(Material.LEATHER_BOOTS, Color.BLUE), null, ArmorBuilder.build(Armor.LAPIS_ARMOR_HELMET), 1, ArmorBuilder.build(Armor.LAPIS_ARMOR_CHESTPLATE), 1, ArmorBuilder.build(Armor.LAPIS_ARMOR_LEGGINGS), 1, ArmorBuilder.build(Armor.LAPIS_ARMOR_BOOTS), 1),
    //End
    ZEALOT(EntityType.ENDERMAN, "Zealot", "ZEALOT", 55, 13000, 13000, 0, 1250, null, null, null, null, null),
    OBSIDIAN_DEFENDER(EntityType.WITHER_SKELETON, "Obsidian Defender", "OBSIDIAN_DEFENDER", 55, 10000, 10000, 0, 200, new ItemStack(Material.OBSIDIAN),new ItemStack(ItemBuilder.colorArmor(Material.LEATHER_CHESTPLATE, Color.BLACK)), null, null, null, new ItemStack(Material.OBSIDIAN, 4), 100, new ItemStack(ArmorBuilder.build(Armor.OBSIDIAN_CHESTPLATE)), 20),
    ;

    private EntityType type;
    private String name;
    private String rawname;
    private int level;
    private int health;
    private int maxhealth;
    private int defense;
    private int damage;
    private ItemStack helmet;
    private ItemStack chestplate;
    private ItemStack leggings;
    private ItemStack boots;
    private ItemStack weapon;
    private Object[] lootTable;

    CustomMobs(EntityType type, String name, String rawname, int level, int health, int maxhealth, int defense, int damage, ItemStack helmet, ItemStack chestplate, ItemStack leggings, ItemStack boots, ItemStack weapon, Object... lootTable) {
        this.type = type;
        this.name = name;
        this.rawname = rawname;
        this.level = level;
        this.health = health;
        this.maxhealth = maxhealth;
        this.defense = defense;
        this.damage = damage;
        this.helmet = helmet;
        this.chestplate = chestplate;
        this.leggings = leggings;
        this.boots = boots;
        this.weapon = weapon;
        this.lootTable = lootTable;
    }

    public EntityType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getRawname() { return rawname; }

    public int getHealth() {
        return health;
    }

    public int getMaxhealth() {
        return maxhealth;
    }

    public int getLevel() {
        return level;
    }

    public int getDamage() {
        return damage;
    }

    public ItemStack getHelmet() {
        return helmet;
    }

    public ItemStack getChestplate() {
        return chestplate;
    }

    public ItemStack getLeggings() {
        return leggings;
    }

    public ItemStack getBoots() {
        return boots;
    }

    public ItemStack getWeapon() {
        return weapon;
    }

    public Object[] getLootTable() {
        return lootTable;
    }
}
