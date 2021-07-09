package me.Jojokly.museum;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MuseumCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String args[]) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            Block b = p.getTargetBlock(null,5);
            Location loc = b.getLocation();
            if (p.hasPermission("per.museum")) {
                if (label.equalsIgnoreCase("museum")) {
                    if (args[0].equalsIgnoreCase("hyperion")) {
                        if (b.getType() == Material.GLASS) {
                            addMuseum.addMuseum(p, b, Material.IRON_SWORD, "§6Hyperion");
                        }
                    } else if (args[0].equalsIgnoreCase("Giantsword")) {
                            addMuseum.addMuseum(p, b, Material.IRON_SWORD, "§6Giant's sword");
                        } else if (args[0].equalsIgnoreCase("Aote")) {
                            addMuseum.addMuseum(p, b, Material.DIAMOND_SWORD, "§9Aspect of the End");
                    } else if (args[0].equalsIgnoreCase("GrapplingHook")) {
                        addMuseum.addMuseum(p, b, Material.FISHING_ROD, "§aGrappling Hook");
                    } else if(args[0].equalsIgnoreCase("Golemsword")) {
                        addMuseum.addMuseum(p,b, Material.IRON_SWORD, "§9Golem Sword");
                    } else if(args[0].equalsIgnoreCase("EmberRod")) {
                            addMuseum.addMuseum(p, b, Material.BLAZE_ROD, "§5Ember Rod");
                    } else if(args[0].equalsIgnoreCase("remove")) {
                        if (b.getState() instanceof  BlockState) {
                            addMuseum.remove(b);
                            }
                        }
                }
            }
        }
        return false;
    }
}
