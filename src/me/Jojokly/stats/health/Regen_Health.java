package me.Jojokly.stats.health;

import me.Jojokly.skyblockmain.Main;
import me.Jojokly.stats.intelligence.Intelligence;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Regen_Health {

    public static void regenHealth(Player p) {

        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.getMain(), new Runnable() {

            @Override
            public void run() {
                int maxhealth = MaxHealth.getMaxHealth(p);
                int basehealth = HealthMain.getCustomHealth(p);
                int healthregen = 2 + (maxhealth / 100);
                if (basehealth + healthregen > maxhealth) {
                    HealthMain.setCustomHealth(p, maxhealth);
                } else {
                    HealthMain.setCustomHealth(p, healthregen + basehealth);
                }
            }
        }, 1, 20);
    }

}
