package me.Jojokly.general;

import me.Jojokly.skyblockmain.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class countdown implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("per.countdown")) {
                if (label.equalsIgnoreCase("countdown")) {
                    if (args.length >= 2) {
                        final int[] time = {Integer.parseInt(args[0])};
                        String msg = "";
                        for(int i = 1; i < args.length; ++i) {
                            msg = msg + args[i] + " ";
                        }
                        for (Player all : Bukkit.getOnlinePlayers()) {
                            String finalMsg = msg;
                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    if (args[0].equalsIgnoreCase("cancel")) {
                                        cancel();
                                    }
                                    if (time[0] > 0) {
                                        all.sendTitle("§c" + finalMsg, "§c" + time[0] + " seconds left");
                                        time[0] -=1;
                                    } else if(time[0] == 0){
                                        all.sendTitle("§c" + finalMsg, "§c0 seconds left");
                                        cancel();
                                    }
                                }
                            }.runTaskTimer(Main.getMain(), 0, 20);
                        }
                    }
                }
            }
        }

        return false;
    }
}
