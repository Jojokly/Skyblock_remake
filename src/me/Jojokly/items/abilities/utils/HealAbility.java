package me.Jojokly.items.abilities.utils;

import me.Jojokly.items.abilities.utils.AbilityBase;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class HealAbility extends AbilityBase {

    public HealAbility(Entity caster, Entity target, double damage) {
        super(caster, target, damage);
    }

    @Override
    public void cast() {
        if(getCaster() instanceof Player caster)  {
            double heal = getDamage() * 2;
            Entity healedEntity = getTarget();
            if(caster.getHealth() > getDamage()) {
                if(healedEntity instanceof LivingEntity entity) {
                    if(entity.getHealth() + heal <= entity.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()) {
                        caster.setHealth(caster.getHealth() - this.getDamage());
                        entity.setHealth(entity.getHealth() + heal);
                    } else if(entity.getHealth() + heal > entity.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()) {
                        entity.setHealth(entity.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
                    }
                }
            }
        }
    }

}
