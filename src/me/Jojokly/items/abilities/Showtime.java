package me.Jojokly.items.abilities;

import me.Jojokly.items.items.ItemBuilder;
import me.Jojokly.skyblockmain.Main;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftEntity;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Showtime {

    public static void showtime(Player p) {
        p.spigot().sendMessage(TextComponent.fromLegacyText("§b-250 Mana (§6Showtime§b)"));
        List<Color> color = new ArrayList<Color>();
        color.add(Color.AQUA);
        color.add(Color.BLACK);
        color.add(Color.BLUE);
        color.add(Color.LIME);
        color.add(Color.OLIVE);
        color.add(Color.ORANGE);
        color.add(Color.PURPLE);
        color.add(Color.WHITE);
        color.add(Color.FUCHSIA);
        color.add(Color.GRAY);
        color.add(Color.MAROON);
        color.add(Color.SILVER);
        color.add(Color.NAVY);
        color.add(Color.TEAL);
        color.add(Color.YELLOW);
        color.add(Color.RED);
        color.add(Color.GREEN);
        Random c1r = new Random();
        Color color1 = color.get(c1r.nextInt(color.size()));
        color.remove(color1);
        Random c2r = new Random();
        Color color2 = color.get(c2r.nextInt(color.size()));
        Random ashead = new Random();
        int asheadresult = ashead.nextInt(10);
        Location loc = p.getLocation();
        loc.setY(loc.getY() + 1);
        Vector v = p.getLocation().getDirection().normalize();
        v.multiply(0.3);
        loc.add(v);
        v.normalize();
        ArmorStand as = p.getWorld().spawn(loc, ArmorStand.class);
        as.setRotation(0, 0);
        as.setCustomName("Bonzo_Balloon");
        as.setCustomNameVisible(false);
        as.setCollidable(false);
        ((CraftEntity) as).getHandle().noclip = true;
        ((CraftEntity) as).getHandle().setInvisible(true);
        p.playSound(loc, Sound.ENTITY_GHAST_WARN, 1, 10);
        switch (asheadresult) {
            case 1:
                as.getEquipment().setHelmet(ItemBuilder.createHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTJkZDExZGEwNDI1MmY3NmI2OTM0YmMyNjYxMmY1NGYyNjRmMzBlZWQ3NGRmODk5NDEyMDllMTkxYmViYzBhMiJ9fX0="));
                break;
            case 2:
                as.getEquipment().setHelmet(ItemBuilder.createHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2IxYWU3YTQ3MTcyOTY1MWI1NjY3YjgxNjk0ZTQ5MjgwOGM1MDkwYzJiMTY4ZjBhOTE5MGZkMDAyZWU1MGEyNiJ9fX0="));
                break;
            case 3:
                as.getEquipment().setHelmet(ItemBuilder.createHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjA1MmJlMWMwNmE0YTMyNTEyOWQ2ZjQxYmI4NGYwZWExY2E2ZjlmNjllYmRmZmY0MzE2ZTc0MjQ1MWM3OWMyMSJ9fX0="));
                break;
            case 4:
                as.getEquipment().setHelmet(ItemBuilder.createHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjg2OGU2YTVjNGE0NDVkNjBhMzA1MGI1YmVjMWQzN2FmMWIyNTk0Mzc0NWQyZDQ3OTgwMGM4NDM2NDg4MDY1YSJ9fX0="));
                break;
            case 5:
                as.getEquipment().setHelmet(ItemBuilder.createHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2EyZGYzMTViNDM1ODNiMTg5NjIzMWI3N2JhZTFhNTA3ZGJkN2U0M2FkODZjMWNmYmUzYjJiOGVmMzQzMGU5ZSJ9fX0="));
                break;
            case 6:
                as.getEquipment().setHelmet(ItemBuilder.createHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTI2ZWM3Y2QzYjZhZTI0OTk5NzEzN2MxYjk0ODY3YzY2ZTk3NDk5ZGEwNzFiZjUwYWRmZDM3MDM0MTMyZmEwMyJ9fX0="));
                break;
            case 7:
                as.getEquipment().setHelmet(ItemBuilder.createHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWVmMTYyZGVmODQ1YWEzZGM3ZDQ2Y2QwOGE3YmY5NWJiZGZkMzJkMzgxMjE1YWE0MWJmZmFkNTIyNDI5ODcyOCJ9fX0="));
                break;
            case 8:
                as.getEquipment().setHelmet(ItemBuilder.createHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGY4NTUyMmVlODE1ZDExMDU4N2ZmZmM3NDExM2Y0MTlkOTI5NTk4ZTI0NjNiOGNlOWQzOWNhYTlmYjZmZjVhYiJ9fX0="));
                break;
            case 9:
                as.getEquipment().setHelmet(ItemBuilder.createHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzYzODdmYzI0Njg5M2Q5MmE2ZGQ5ZWExYjUyZGNkNTgxZTk5MWVlZWUyZTI2M2IyN2ZmZjFiY2YxYjE1NGViNyJ9fX0="));
                break;
            default:
                as.getEquipment().setHelmet(ItemBuilder.createHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzYzODdmYzI0Njg5M2Q5MmE2ZGQ5ZWExYjUyZGNkNTgxZTk5MWVlZWUyZTI2M2IyN2ZmZjFiY2YxYjE1NGViNyJ9fX0="));
                break;
        }
        new BukkitRunnable() {
            int x = 0;

            @Override
            public void run() {
                if (!(p.getLocation().distance(as.getLocation()) > 80 || as.getLocation().add(0.5, 0, 0).getBlock().getType() != Material.AIR || as.getLocation().add(0, 1, 0).getBlock().getType() != Material.AIR || as.getLocation().add(0, 0, 0.5).getBlock().getType() != Material.AIR || as.getLocation().subtract(0.5, 0, 0).getBlock().getType() != Material.AIR || as.getLocation().subtract(0, 0, 0.5).getBlock().getType() != Material.AIR)) {
                    as.setVelocity(v);
                    as.setRotation(x, x);
                } else {
                    for (Entity entities : p.getWorld().getNearbyEntities(as.getLocation(), 2, 2, 2)) {
                        if (entities == p) {
                            Vector v = p.getLocation().getDirection().normalize().multiply(-2);
                            p.setVelocity(v);
                        }
                        as.remove();
                        AbilityDamage.damage(p, as.getLocation(), 1000, 0.2, 3, "Showtime");
                        as.getLocation().setY(as.getLocation().getY() + 5);
                        Firework f = p.getWorld().spawn(as.getLocation(), Firework.class);
                        FireworkMeta fm = f.getFireworkMeta();
                        fm.addEffect(FireworkEffect.builder().flicker(false).trail(false).withColor(color1, color2).build());
                        f.setFireworkMeta(fm);
                        f.detonate();
                        cancel();
                    }
                }
                x += 25;
            }
        }.runTaskTimer(Main.getMain(), 0, 1);
    }
}
