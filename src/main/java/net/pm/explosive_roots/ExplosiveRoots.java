package net.pm.explosive_roots;

import net.fabricmc.api.ModInitializer;

import net.pm.explosive_roots.effect.RootEffects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExplosiveRoots implements ModInitializer {
	public static final String MOD_ID = "explosive_roots";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		RootEffects.registerEffects();
	}
}