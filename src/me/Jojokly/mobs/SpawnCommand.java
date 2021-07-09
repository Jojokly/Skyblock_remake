package me.Jojokly.mobs;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (label.equalsIgnoreCase("spawncustommob")) {
                if (args.length == 1) {
                    String mob = args[0];
                    try {
                        CustomMobs cmob = CustomMobs.valueOf(mob);
                        BuildMob.createMob(cmob, p);
                    } catch (Exception e) {
                        p.sendMessage("§cNo Mob found!");
                        e.printStackTrace();
                    }

                }
            }
        }
        return false;
    }
}
