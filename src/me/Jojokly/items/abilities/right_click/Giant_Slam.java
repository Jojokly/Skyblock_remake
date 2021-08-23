package me.Jojokly.items.abilities.right_click;

import me.Jojokly.items.abilities.utils.AbilityDamage;
import me.Jojokly.skyblockmain.Main;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;

public class Giant_Slam {

    static Map<String, Long> cooldown = new HashMap<String, Long>();


    public static void GiantSlam(Player p) {
        Location loc = p.getLocation();
        if (p.getInventory().getItemInHand().hasItemMeta() && p.getInventory().getItemInHand().getItemMeta().getDisplayName().equals("§6Giant's Sword")) {
            if (cooldown.containsKey(p.getName()) && (Long) cooldown.get(p.getName()) > System.currentTimeMillis()) {
                long timeleft = ((Long) cooldown.get(p.getName()) - System.currentTimeMillis()) / 1000L;
                p.sendMessage("§cAbility is on cooldown for " + timeleft + " §cmore seconds");
                return;
            }
            cooldown.put(p.getName(), System.currentTimeMillis() + 15000L);
            p.sendMessage("§b-500 Mana (§6Giant's Slam§b)");
            AbilityDamage.damage(p, loc, 100000, 0.05, 5, "Giant's Slam");
            ItemStack sword = new ItemStack(Material.IRON_SWORD);
            sword.addEnchantment(Enchantment.DAMAGE_ALL, 1);
            loc.setY(loc.getY() - 2);
            Giant giant = loc.getWorld().spawn(loc, Giant.class);
            giant.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 2147483647, 999));
            giant.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 2147483647, 999));
            giant.setCustomName("Dinnerbone");
            giant.setCustomNameVisible(false);
            giant.getEquipment().setItemInMainHand(sword);
            giant.setInvulnerable(true);
            ArmorStand holder = loc.getWorld().spawn(loc, ArmorStand.class);
            holder.setGravity(true);
            holder.setVisible(false);
            holder.setCustomName(" ");
            holder.setCustomNameVisible(false);
            holder.setPassenger(giant);
            holder.setInvulnerable(true);
            p.spawnParticle(Particle.EXPLOSION_HUGE, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 1, 0, 0, 0);
            p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_PLACE, 1, 1);
            p.playSound(p.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_THUNDER, 3, 1);
            AbilityDamage.damage(p, loc, 100000, 0.05, 5, "Giant's Slam");
            new BukkitRunnable() {
                @Override
                public void run() {
                    Location killloc = loc;
                    killloc.setY(0);
                    holder.teleport(loc);
                    giant.teleport(loc);
                    holder.remove();
                    giant.remove();
                }

            }.runTaskLater(Main.getMain(), 80);
        }
    }
}
