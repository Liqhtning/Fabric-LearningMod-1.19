package net.liqht.learningmod.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.liqht.learningmod.LearningMod;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup TANZANITE = FabricItemGroupBuilder.build(
            new Identifier(LearningMod.MOD_ID, "tanzanite"), () -> new ItemStack(ModItems.TANZANITE));
}
