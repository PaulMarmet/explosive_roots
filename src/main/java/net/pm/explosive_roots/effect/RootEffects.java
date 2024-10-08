package net.pm.explosive_roots.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.pm.explosive_roots.ExplosiveRoots;

public class RootEffects {
    public static final RegistryEntry<StatusEffect> SPORES = registerEffect("spores", new SporeStatusEffect());

    public static RegistryEntry<StatusEffect> registerEffect(String name, StatusEffect effect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(ExplosiveRoots.MOD_ID, name), effect);
    }

    public static void registerEffects() {

    }
}
