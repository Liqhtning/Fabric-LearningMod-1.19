package net.liqht.learningmod;

import net.fabricmc.api.ModInitializer;
import net.liqht.learningmod.block.ModBlocks;
import net.liqht.learningmod.item.ModItems;
import net.liqht.learningmod.villager.ModVillagers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LearningMod implements ModInitializer {
	public static final String MOD_ID = "learningmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModVillagers.registerVillagers();
		ModVillagers.registerTrades();

	}
}
