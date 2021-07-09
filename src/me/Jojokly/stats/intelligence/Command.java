package me.Jojokly.stats.intelligence;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            String targetstring = args[0];
            Player target = Bukkit.getPlayer(targetstring);
            int intel = Integer.parseInt(args[1]);
            if (label.equalsIgnoreCase("setIntelligence")) {
                if (args.length == 2) {
                    p.sendMessage("§cSet intelligence of player " + target.getName()+ " to " + intel + "!");
                    Intelligence.setIntelligence(target, intel);
                    Intelligence.setmaxIntelligence(target, intel);
                 }
            }
        }
        return false;
    }
}
