package me.Jojokly.stats.main;

import me.Jojokly.skyblockmain.Main;
import me.Jojokly.stats.defense.CalcDefense;
import me.Jojokly.stats.defense.Defense;
import me.Jojokly.stats.health.CalcHealth;
import me.Jojokly.stats.health.HealthMain;
import me.Jojokly.stats.health.MaxHealth;
import me.Jojokly.stats.health.Regen_Health;
import me.Jojokly.stats.intelligence.Intelligence;
import me.Jojokly.stats.intelligence.regenmana;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import net.minecraft.server.v1_16_R3.NBTTagCompound;
import org.bukkit.GameMode;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import static me.Jojokly.stats.health.MaxHealth.maxhealth;


public class StatsMain implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        p.setFoodLevel(20);
        Actionbar(p);
    }

    public static void Actionbar(Player p) {
        ItemStack item = p.getItemInHand();
        net.minecraft.server.v1_16_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(item);
        NBTTagCompound combound = (nmsItem.hasTag()) ? nmsItem.getTag() : new NBTTagCompound();
        int intel = combound.getInt("Intelligence");
        MaxHealth.setMaxhealth(p, 100);
        HealthMain.setBaseHealth(p, 100);
        Intelligence.setIntelligence(p, 100);
        Intelligence.setmaxIntelligence(p, 100 + intel);
        Defense.setBaseDefense(p, 100);
        regenmana.regenmana(p);
        Regen_Health.regenHealth(p);
        p.setMaxHealth(20);
        new BukkitRunnable() {
            @Override
            public void run() {
                if (!p.getGameMode().equals(GameMode.CREATIVE)) {
                    int health = HealthMain.getBaseHealth(p) + CalcHealth.gethelmetHealth(p) + CalcHealth.getChestplateHealth(p) + CalcHealth.getLeggingsHealth(p) + CalcHealth.getBootsHealth(p);
                    int defense = Defense.getBaseDefense(p) + CalcDefense.gethelmetDefense(p) + CalcDefense.getChestplateDefense(p) + CalcDefense.getLeggingsDefense(p) + CalcDefense.getBootsDefense(p);
                    MaxHealth.setMaxhealth(p, health);
                    Defense.setdefense(p, defense);
                    p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§c" + HealthMain.getCustomHealth(p) + "/" + MaxHealth.getMaxHealth(p) + " ❤" + "       " +  "§a" + defense + " ❈" + "       " + "§b" + Intelligence.getintelligence(p) + "/" + Intelligence.getmaxintelligence(p) + " ⌘"));
                } else {
                    HealthMain.setCustomHealth(p, 100);
                    Intelligence.setIntelligence(p, 10000000);
                    Intelligence.setmaxIntelligence(p, 10000000);
                    p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§c" + HealthMain.getCustomHealth(p) + "/" + MaxHealth.getMaxHealth(p) + " ❤" + "             " + "§b ∞/∞ ⌘"));
                }
            }
        }.runTaskTimer(Main.getMain(), 1, 1);
    }
}
