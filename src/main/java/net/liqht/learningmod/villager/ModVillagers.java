package net.liqht.learningmod.villager;

import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.object.builder.v1.villager.VillagerProfessionBuilder;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.liqht.learningmod.LearningMod;
import net.liqht.learningmod.block.ModBlocks;
import net.liqht.learningmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class ModVillagers {
    public static final PointOfInterestType TANZANITE_FURNACE_POI = registerPOI("tanzanite_furnace_poi", ModBlocks.TANZANITE_FURNACE);
    public static final VillagerProfession JUMP_MASTER = registerProfession("jumpmaster",
            RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, new Identifier(LearningMod.MOD_ID, "tanzanite_furnace_poi")));

    public static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registry.VILLAGER_PROFESSION, new Identifier(LearningMod.MOD_ID, name),
                VillagerProfessionBuilder.create().id(new Identifier(LearningMod.MOD_ID, name)).workstation(type)
                        .workSound(SoundEvents.ENTITY_VILLAGER_WORK_ARMORER).build());
    }

    public static PointOfInterestType registerPOI(String name, Block block) {
        return PointOfInterestHelper.register(new Identifier(LearningMod.MOD_ID, name),
                1, 1, ImmutableSet.copyOf(block.getStateManager().getStates()));
    }

    public static void registerVillagers() {
        LearningMod.LOGGER.debug("Registering Villagers for " + LearningMod.MOD_ID);
    }

    public static void registerTrades() {
        // 1 Emerald - 1 Jumpy Block
        TradeOfferHelper.registerVillagerOffers(JUMP_MASTER, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD , 1),
                            new ItemStack(ModBlocks.JUMPY_BLOCK, 1),
                            6, 2, 0.02f
                    ));
                });

        // 1 Emerald - 3 Tanzanite
        TradeOfferHelper.registerVillagerOffers(JUMP_MASTER, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD , 1),
                            new ItemStack(ModItems.TANZANITE, 3),
                            6, 2, 0.02f
                    ));
                });
    }
}
