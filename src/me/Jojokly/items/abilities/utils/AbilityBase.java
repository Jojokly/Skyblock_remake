package me.Jojokly.items.abilities.utils;

import org.bukkit.entity.Entity;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class AbilityBase {

    private double damage;
    private double heal;
    private Entity caster;
    private Entity target;
    private PotionEffectType potionEffectType;

    public AbilityBase(Entity caster, Entity target, double damage, double heal, PotionEffectType effect) {
        this.caster = caster;
        this.target = target;
        this.damage = damage;
        this.heal = heal;
        this.potionEffectType = effect;
    }
    public AbilityBase(Entity caster, Entity target, double damage) {
        this.caster = caster;
        this.target = target;
        this.damage = damage;
    }

    public void cast() {

    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public Entity getCaster() {
        return caster;
    }

    public void setCaster(Entity caster) {
        this.caster = caster;
    }

    public Entity getTarget() {
        return target;
    }

    public void setTarget(Entity target) {
        this.target = target;
    }

    public PotionEffectType getPotionEffectType() {
        return potionEffectType;
    }

    public void setPotionEffectType(PotionEffectType potionEffectType) {
        this.potionEffectType = potionEffectType;
    }

}
