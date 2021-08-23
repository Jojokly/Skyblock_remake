//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package me.Jojokly.general;

import me.Jojokly.skyblockmain.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class loop implements CommandExecutor {
    public loop() {
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player && label.equalsIgnoreCase("loop")) {
            Player p = (Player)sender;
            if (args.length >= 3) {
                int loops = Integer.parseInt(args[0]);
                int delay = Integer.parseInt(args[1]);
                String cmd = "";
                for(int i = 2; i < args.length; ++i) {
                    cmd = cmd + args[i] + " ";
                }
                String finalCmd = cmd;
                new BukkitRunnable() {
                    int i = loops;
                    @Override
                    public void run() {
                        if (i == 0) {
                            cancel();
                            return;
                        }
                        Bukkit.dispatchCommand(p, finalCmd);
                        i--;
                    }
                }.runTaskTimer(Main.getMain(), 0, delay);
            }
        }
        return false;
    }
}
