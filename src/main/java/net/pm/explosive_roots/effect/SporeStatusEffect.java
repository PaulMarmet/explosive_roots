package net.pm.explosive_roots.effect;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.util.math.Vec3d;
import net.pm.explosive_roots.damage.RootDamageTypes;

import java.util.Objects;
import java.util.Random;


public class SporeStatusEffect extends StatusEffect {
    protected SporeStatusEffect() {
        super(StatusEffectCategory.HARMFUL, 0x2A8533);
    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return (duration % 40 == 0 || duration == 1);
    }

    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        Random r = new Random();
        if (r.nextInt(4) == 0) {
            entity.damage(entity.getDamageSources().create(RootDamageTypes.SPORED), 1.0F);
        }
        if (entity.getStatusEffect(RootEffects.SPORES) != null && Objects.requireNonNull(entity.getStatusEffect(RootEffects.SPORES)).isDurationBelow(20)) {
            entity.damage(entity.getDamageSources().create(RootDamageTypes.SPORED), 2.0F);
            spawnCreeperling(entity);
        }
        return true;
    }

//    public void onApplied(AttributeContainer attributeContainer, int amplifier) {
//        this.super(attributeContainer, amplifier);
//        ExplosiveRoots.LOGGER.info("applied!");
//    }

    public void spawnCreeperling(LivingEntity entity) {
        if (!entity.getWorld().isClient) {
            CreeperEntity creeperling = EntityType.CREEPER.create(entity.getWorld());
            if (creeperling != null) {
                creeperling.setPos(entity.getPos().x, entity.getPos().y, entity.getPos().z);
                creeperling.refreshPositionAndAngles(entity.getX(), entity.getY(), entity.getZ(), entity.getYaw(), 0.0F);
                Vec3d newVel = entity.getVelocity();
                creeperling.setVelocity(newVel);
                entity.getWorld().spawnEntity(creeperling);
            }
        }
    }
}
