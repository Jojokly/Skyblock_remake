package me.Jojokly.items.items;

public enum Power_Orb {

    RADIANT_POWER_ORB("Radiant ", Rarity.UNCOMMON, "RADIANT_POWER_ORB", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2FiNGM0ZDZlZTY5YmMyNGJiYTJiOGZhZjY3YjlmNzA0YTA2YjAxYWE5M2YzZWZhNmFlZjdhOTY5NmM0ZmVlZiJ9fX0=", 30, 1, 0, 0, "§aOrb Buff: Radiant", "§7Heals §c1% §aof max §c❤ §7per second."),
    MANAFLUX_POWER_ORB("Manaflux ", Rarity.RARE, "MANAFLUX_POWER_ORB", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODJhZGExYzdmY2M4Y2YzNWRlZmViOTQ0YTRmOGZmYTlhOWQyNjA1NjBmYzdmNWY1ODI2ZGU4MDg1NDM1OTY3YyJ9fX0=", 30, 2, 2, 10, "§9Orb Buff: Manaflux", "§7Grants §e+50% §7base Mana regen.", "§7Heals §c2% §7of max §c❤§7 per second.", "§7Grants §c+10 Strngth§7."),
    OVERFLUX_POWER_ORB("Overflux ", Rarity.EPIC, "OVERFLUX_POWER_ORB", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjU2MTU5NWQ5Yzc0NTc3OTZjNzE5ZmFlNDYzYTIyMjcxY2JjMDFjZjEwODA5ZjVhNjRjY2IzZDZhZTdmOGY2In19fQ=", 60, 3, 3, 20, "§5Orb Buf: Overflux", "§7Grants §3100% §7base Mana regen.", "§7Heals §c2.5% §7of max §c❤§7 per second.", "§7Increases all helas by §a+5%.", "§7Grants §c+25 Strength§7."),
    PLASMAFLUX_POWER_ORB("Plasmaflux ", Rarity.LEGENDARY, "PLASMAFLUX_POWER_ORB", "ewogICJ0aW1lc3RhbXAiIDogMTYwMzE3NjQyODEzNSwKICAicHJvZmlsZUlkIiA6ICI0MWQzYWJjMmQ3NDk0MDBjOTA5MGQ1NDM0ZDAzODMxYiIsCiAgInByb2ZpbGVOYW1lIiA6ICJNZWdha2xvb24iLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODNlZDRjZTIzOTMzZTY2ZTA0ZGYxNjA3MDY0NGY3NTk5ZWViNTUzMDdmN2VhZmU4ZDkyZjQwZmIzNTIwODYzYyIKICAgIH0KICB9Cn0=", 60, 1, 1, 1 ,"§6Orb Buff: Plasmaflux", "§7Grants §e+125% §7base Mana regen.", "§7Heals §c3% §7of max §c❤§7 per second.", "§7Increases all heals by §a+7.5%§7.", "§7Grants §c+35 Strength§7."),
    ;

    private String name;
    private Rarity rarity;
    private String rawname;
    private String headId;
    private int time;
    private int regenhealth;
    private int regenMana;
    private int Strength;
    private String[] lore;

    Power_Orb(String name, Rarity rarity, String rawname, String headID, int time, int regenHealth, int regenMana, int Strength, String... lore) {
        this.name = name;
        this.rarity = rarity;
        this.rawname = rawname;
        this.headId = headID;
        this.time = time;
        this.regenhealth = regenHealth;
        this.regenMana = regenMana;
        this.Strength = Strength;
        this.lore = lore;
    }

    public String getName() {
        return name;
    }

    public String getRawname() {
        return rawname;
    }

    public int getStrength() {
        return Strength;
    }

    public String[] getLore() {
        return lore;
    }

    public int getRegenhealth() {
        return regenhealth;
    }

    public int getRegenMana() {
        return regenMana;
    }

    public int getTime() {
        return time;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public String getHeadId() {
        return headId;
    }
}
