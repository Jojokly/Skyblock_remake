//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package me.Jojokly.general;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class loop implements CommandExecutor {
    public loop() {
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player && label.equalsIgnoreCase("loop")) {
            Player p = (Player)sender;
            int loops = Integer.parseInt(args[0]);
            if (args.length >= 3) {
                String cmd = "";
                for(int i = 1; i < args.length; ++i) {
                    cmd = cmd + args[i] + " ";
                }
                for(int i = 0; i < loops; ++i) {
                    Bukkit.dispatchCommand(p, cmd);
                }
            }
        }

        return false;
    }
}
