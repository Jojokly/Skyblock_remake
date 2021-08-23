package me.Jojokly.general;

import me.Jojokly.skyblockmain.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class Push implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("push")) {
            if (args.length == 2) {
                if (sender instanceof Player) {
                    Player p = (Player) sender;
                    String targetstring = args[0];
                    try {
                        int strength = Integer.parseInt(args[1]);
                        if (Bukkit.getPlayer(targetstring) != null) {
                            Player target = Bukkit.getPlayer(targetstring);
                            Vector vec = target.getLocation().getDirection().normalize().multiply(strength).setY(1.5);
                            target.setVelocity(vec);
                            p.sendMessage("§4§lYEEEEET!");
                        }
                    } catch (Exception e) {
                        p.sendMessage("§cWRONG ARG PEKW");
                    }

                }
            } else if(args.length == 1) {
                if(sender instanceof Player) {
                    Integer strength = Main.getDefaultPush();
                    Player p = (Player) sender;
                    String targetstring = args[0];
                    if(Bukkit.getPlayerExact(targetstring) != null) {
                        Player target = Bukkit.getPlayer(targetstring);
                        Vector vec = target.getLocation().getDirection().normalize().multiply(strength).setY(1.5);
                    }
                }
            }
        }
        return false;
    }
}
