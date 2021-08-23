package me.Jojokly.items.items;

import me.Jojokly.items.items.Rarity;

public enum Transmission_Items {

    ETHERWARP_CONDUIT("Etherwarp Conduit", "e3RleHR1cmVzOntTS0lOOnt1cmw6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2E3MGUwMjA2ZjYxNjYwNDg0NDFkZmUwOGUwNTNhNjAxN2Q5MTRmMzVjNmIxZmIwZjU1OGM1MDU3NGY5NzBkMCJ9fX0=", Rarity.EPIC, 180, 57, "§6Ability: Ether Transmission §e§lRIGHT CLICK", "§7Teleport to your targetted block", "§7up to §a57 blocks §7away.", "§8Manacots: §3180"),
    ;

    private final String name;
    private final String headID;
    private final Rarity rarity;
    private final int manacost;
    private final int teleportrange;
    private final String[] lore;


    Transmission_Items(String s, String s1, Rarity rarity, int i, int i1, String... lore) {
        this.name = s;
        this.headID = s1;
        this.rarity = rarity;
        this.manacost = i;
        this.teleportrange = i1;
        this.lore = lore;
    }

    public String getName() {
        return name;
    }

    public String getHeadID() {
        return headID;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public int getManacost() {
        return manacost;
    }

    public int getTeleportrange() {
        return teleportrange;
    }

    public String[] getLore() {
        return lore;
    }
}
