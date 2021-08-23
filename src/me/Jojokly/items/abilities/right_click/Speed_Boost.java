package me.Jojokly.items.abilities.right_click;

import me.Jojokly.skyblockmain.Main;
import me.Jojokly.stats.intelligence.Intelligence;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Speed_Boost {

    private static float speedBoost;

    public static void boostSpeed(Player player, float amount) {
        speedBoost = amount;
        if(Intelligence.getintelligence(player) >= 50) {
            Intelligence.setIntelligence(player, Intelligence.getintelligence(player) - 50);
            if(player.getWalkSpeed() <= 1.0 - amount) {
                player.setWalkSpeed(player.getWalkSpeed() + speedBoost);
                Main.getMain().getLogger().info("set " + player.getDisplayName() + "'s speed to " + player.getWalkSpeed() + " (amount: " + speedBoost + ")");
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.setWalkSpeed(player.getWalkSpeed() - speedBoost);
                        Main.getMain().getLogger().info("removed " + player.getDisplayName() + "'s speed");
                    }
                }.runTaskLater(Main.getMain(), 5*20);
            }
        }
    }
}
