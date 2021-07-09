package me.Jojokly.skyblockmain;

import me.Jojokly.general.Listener;
import me.Jojokly.mobs.MobDamage;
import me.Jojokly.general.countdown;
import me.Jojokly.general.loop;
import me.Jojokly.items.Listener.HoldItem;
import me.Jojokly.items.abilities.Fire_blast;
import me.Jojokly.items.abilities.GrapplingHook;
import me.Jojokly.items.abilities.Particletest;
import me.Jojokly.items.abilities.Right_click;
import me.Jojokly.items.items.ClickItems;
import me.Jojokly.items.items.getItems;
import me.Jojokly.mobs.SpawnCommand;
import me.Jojokly.stats.health.Command;
import me.Jojokly.museum.ClickEvent;
import me.Jojokly.museum.MuseumCommand;
import me.Jojokly.stats.health.Damage;
import me.Jojokly.stats.intelligence.EndlessMana;
import me.Jojokly.stats.main.StatsMain;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    static Main instance;

    @Override
    public void onEnable() {
        getCommand("museum").setExecutor(new MuseumCommand());
        getCommand("setcustomhealth").setExecutor(new Command());
        getCommand("setIntelligence").setExecutor(new me.Jojokly.stats.intelligence.Command());
        getCommand("items").setExecutor(new getItems());
        getCommand("loop").setExecutor(new loop());
        getCommand("countdown").setExecutor(new countdown());
        getCommand("spawncustommob").setExecutor(new SpawnCommand());
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
        instance = this;
    }

    public static Main getMain() {
        return instance;
    }
}
