package net.pm.explosive_roots.damage;

import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.pm.explosive_roots.ExplosiveRoots;

public class RootDamageTypes {
    public static final RegistryKey<DamageType> SPORED = register("spored");

    private static RegistryKey<DamageType> register(String name)
    {
        return RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(ExplosiveRoots.MOD_ID, name));
    }

}
