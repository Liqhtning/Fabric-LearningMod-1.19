package net.liqht.learningmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.liqht.learningmod.LearningMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item RAW_TANZANITE = registerItems("raw_tanzanite",
            new Item(new FabricItemSettings().group(ModItemGroup.TANZANITE)));

    public static final Item TANZANITE = registerItems("tanzanite",
            new Item(new FabricItemSettings().group(ModItemGroup.TANZANITE)));


    private static Item registerItems(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(LearningMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        LearningMod.LOGGER.debug("Registering Mod Items for " + LearningMod.MOD_ID);
    }

}
