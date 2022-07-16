package net.liqht.learningmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class JumpyBlock extends Block {
    public JumpyBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(!world.isClient()) {
            player.sendMessage(Text.literal("Right Clicked This!"));
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        if(Screen.hasShiftDown()) {
            tooltip.add(Text.literal("Jump on this block to jump higher than ever before!").formatted(Formatting.AQUA));
        } else {
            tooltip.add(Text.literal("Press shift for more info!").formatted(Formatting.YELLOW));
        }


        super.appendTooltip(stack, world, tooltip, options);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if(entity instanceof LivingEntity livingEntity) {
            livingEntity.addVelocity(0, 0.7, 0);
        }



        super.onSteppedOn(world, pos, state, entity);
    }
}
