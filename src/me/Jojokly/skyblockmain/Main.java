package me.Jojokly.skyblockmain;

import me.Jojokly.general.Listener;
import me.Jojokly.general.Push;
import me.Jojokly.items.abilities.init_Ability.Left_Click;
import me.Jojokly.items.abilities.init_Ability.Power_Orb_Event;
import me.Jojokly.items.abilities.init_Ability.Right_click;
import me.Jojokly.items.abilities.init_Ability.ShootArrow;
import me.Jojokly.items.abilities.right_click.Fire_blast;
import me.Jojokly.items.abilities.right_click.GrapplingHook;
import me.Jojokly.items.abilities.right_click.Iron_punch;
import me.Jojokly.items.abilities.right_click.Molten_Wave;
import me.Jojokly.items.abilities.utils.Particletest;
import me.Jojokly.items.armor.EquipHelmet;
import me.Jojokly.items.armor.FullSetBonus;
import me.Jojokly.mobs.Loot.RareDropListener;
import me.Jojokly.mobs.damage.ArrowDamage;
import me.Jojokly.mobs.damage.MobDamage;
import me.Jojokly.general.countdown;
import me.Jojokly.general.loop;
import me.Jojokly.items.Listener.HoldItem;
import me.Jojokly.items.items.ClickItems;
import me.Jojokly.items.items.getItems;
import me.Jojokly.mobs.Loot.MobLoot;
import me.Jojokly.mobs.Utils.SpawnCommand;
import me.Jojokly.stats.health.Command;
import me.Jojokly.museum.ClickEvent;
import me.Jojokly.museum.MuseumCommand;
import me.Jojokly.stats.health.Damage;
import me.Jojokly.stats.intelligence.EndlessMana;
import me.Jojokly.stats.main.StatsMain;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    static Main instance;
    private static int push_default;

    @Override
    public void onEnable() {
        getCommand("museum").setExecutor(new MuseumCommand());
        getCommand("setcustomhealth").setExecutor(new Command());
        getCommand("setIntelligence").setExecutor(new me.Jojokly.stats.intelligence.Command());
        getCommand("items").setExecutor(new getItems());
        getCommand("loop").setExecutor(new loop());
        getCommand("countdown").setExecutor(new countdown());
        getCommand("spawncustommob").setExecutor(new SpawnCommand());
        getCommand("push").setExecutor(new Push());
        getServer().getPluginManager().registerEvents(new Listener(), this);
        getServer().getPluginManager().registerEvents(new ClickEvent(), this);
        getServer().getPluginManager().registerEvents(new StatsMain(), this);
        getServer().getPluginManager().registerEvents(new Right_click(), this);
        getServer().getPluginManager().registerEvents(new HoldItem(), this);
        getServer().getPluginManager().registerEvents(new ClickItems(), this);
        getServer().getPluginManager().registerEvents(new Particletest(), this);
        getServer().getPluginManager().registerEvents(new GrapplingHook(),this);
        getServer().getPluginManager().registerEvents(new Fire_blast(), this);
        getServer().getPluginManager().registerEvents(new MobDamage(), this);
        getServer().getPluginManager().registerEvents(new EndlessMana(), this);
        getServer().getPluginManager().registerEvents(new Damage(), this);
        getServer().getPluginManager().registerEvents(new Power_Orb_Event(), this);
        getServer().getPluginManager().registerEvents(new Molten_Wave(), this);
        getServer().getPluginManager().registerEvents(new Iron_punch(), this);
        getServer().getPluginManager().registerEvents(new Left_Click(), this);
        getServer().getPluginManager().registerEvents(new ShootArrow(), this);
        getServer().getPluginManager().registerEvents(new ArrowDamage(), this);
        getServer().getPluginManager().registerEvents(new me.Jojokly.mobs.damage.ShootArrow(), this);
        getServer().getPluginManager().registerEvents(new MobLoot(), this);
        getServer().getPluginManager().registerEvents(new RareDropListener(), this);
        getServer().getPluginManager().registerEvents(new EquipHelmet(), this);
        getServer().getPluginManager().registerEvents(new FullSetBonus(), this);
        instance = this;
        for (Player p : Bukkit.getOnlinePlayers()) {
            StatsMain.Actionbar(p);
        }
        YamlConfiguration config = this.getServer().spigot().getConfig();
        push_default = config.getInt("commands.push.default-push");
    }

    @Override
    public void onDisable() {
        this.saveConfig();
        this.reloadConfig();
        this.saveConfig();
    }

    public static Main getMain() {
        return instance;
    }

    public static Integer getDefaultPush() {
        return push_default;
    }
}
