package com.byzh.picgen.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.StackReference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ClickType;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SelectTool extends Item {
    public SelectTool(Settings settings) {
        super(settings);
    }

    public static BlockPos blockPos0 = new BlockPos(0,0,0);
    public static BlockPos blockPos1 = blockPos0;
    public static BlockPos blockPos2 = blockPos0;
    private static boolean selectBP1 = true;

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        if (!world.isClient()){
            BlockPos blockPos = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            if (selectBP1){
                blockPos1 = blockPos;
                selectBP1 = false;
                player.sendMessage(Text.translatable("item.byzh-picgen.select1",blockPos1.getX(),blockPos1.getY(),blockPos1.getZ()),false);
            } else {
                blockPos2 = blockPos;
                selectBP1 = true;
                player.sendMessage(Text.translatable("item.byzh-picgen.select2",blockPos2.getX(),blockPos2.getY(),blockPos2.getZ()),false);
            }
        }
        return ActionResult.SUCCESS;
    }



}
