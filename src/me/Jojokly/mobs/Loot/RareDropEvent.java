package me.Jojokly.mobs.Loot;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

public class RareDropEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    private Player killer;
    private ItemStack drop;
    private boolean cancelled;

    public RareDropEvent(Player killer, ItemStack drop) {
        this.killer = killer;
        this.drop = drop;
        this.cancelled = false;
    }

    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public Player getPlayer() {
        return killer;
    }

    public ItemStack getDrop() {
        return drop;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
