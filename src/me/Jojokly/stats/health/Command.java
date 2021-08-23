//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package me.Jojokly.stats.health;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command implements CommandExecutor {

    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if (sender instanceof Player) {
            String targetstring = args[0];
            Player target = Bukkit.getPlayer(targetstring);
            int health = Integer.parseInt(args[1]);
            if (label.equalsIgnoreCase("setcustomhealth") && args.length == 2) {
                MaxHealth.setMaxhealth(target, health);
                HealthMain.setCustomHealth(target, health);
                HealthMain.setBaseHealth(target, health);
            }
        }

        return false;
    }
}

