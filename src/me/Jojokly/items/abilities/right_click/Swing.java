package me.Jojokly.items.abilities.right_click;

import me.Jojokly.items.abilities.utils.AbilityDamage;
import me.Jojokly.items.items.ItemBuilder;
import me.Jojokly.items.items.Weapons;
import me.Jojokly.skyblockmain.Main;
import net.minecraft.server.v1_16_R3.NBTTagCompound;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;
import org.bukkit.util.Vector;

public class Swing {

    public static void Swing(Player p) {
        if (p.getItemInHand().getType().equals(Material.BONE)) {
            ItemStack bone = p.getItemInHand();
            ItemMeta bonemeta = bone.getItemMeta();
            ItemStack thrownBonemerang = new ItemStack(Material.GHAST_TEAR);
            ItemMeta bonem = thrownBonemerang.getItemMeta();
            bonem.setDisplayName("§6Bonemerang");
            bonem.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            bonem.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
            thrownBonemerang.setItemMeta(bonemeta);
            net.minecraft.server.v1_16_R3.ItemStack nmsbone = CraftItemStack.asNMSCopy(thrownBonemerang);
            int random = (int)(Math.random() * 1000000 + 1);
            NBTTagCompound combound = (nmsbone.hasTag()) ? nmsbone.getTag() : new NBTTagCompound();
            combound.setInt("Random", random);
            nmsbone.setTag(combound);
            ItemStack finalItem = CraftItemStack.asBukkitCopy(nmsbone);
            Location loc = p.getLocation();
            World w = p.getWorld();
            ArmorStand as = (ArmorStand) w.spawnEntity(loc, EntityType.ARMOR_STAND);
            Location destination = loc.add(loc.getDirection().multiply(10));

            as.setArms(true);
            as.setGravity(false);
            as.setInvulnerable(true);
            as.setVisible(false);
            as.setItemInHand(new ItemStack(Material.BONE));
            as.setRightArmPose(new EulerAngle(Math.toRadians(0), Math.toRadians(120), Math.toRadians(0)));

            p.getInventory().removeItem(p.getItemInHand());
            p.getInventory().addItem(finalItem);
            Vector v = destination.subtract(p.getLocation()).toVector();
            new BukkitRunnable() {
                int distance = 20;
                int i = 0;
                @Override
                public void run() {
                    EulerAngle rot = as.getRightArmPose();
                    EulerAngle rotnew = rot.add(0, 20, 0);
                    as.setRightArmPose(rotnew);

                    if (i >= distance) {
                        as.teleport(as.getLocation().subtract(v.normalize()));
                        if (i >= distance * 2) {
                            as.remove();
                            p.getInventory().removeItem(finalItem);
                            p.getInventory().addItem(new ItemStack(ItemBuilder.createItem(Weapons.BONEMERANG)));
                            cancel();
                        }
                    }else {
                        as.teleport(as.getLocation().add(v.normalize()));
                    }
                    i++;
                    AbilityDamage.damage(p, as.getLocation(), 1000,1 ,1, "Swing");
                }
            }.runTaskTimer(Main.getMain(), 1, 1);
        }
    }
}
