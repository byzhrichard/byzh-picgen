package com.byzh.picgen.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class OutputTool extends Item {
    public OutputTool(Settings settings) {
        super(settings);
    }

    BlockPos blockPos1 = new BlockPos(0,0,0);
    BlockPos blockPos2 = new BlockPos(0,0,0);
    boolean selectBP1 = true;

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        if (!world.isClient()){
            BlockPos blockPos = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            if (selectBP1){
                blockPos1 = blockPos;
                selectBP1 = false;
                player.sendMessage(Text.literal("你选中的第一个方块在("+blockPos1.getX()+", "+blockPos1.getY()+", "+blockPos1.getZ()+")"),false);
            } else {
                blockPos2 = blockPos;
                selectBP1 = true;
                player.sendMessage(Text.literal("你选中的第二个方块在("+blockPos2.getX()+", "+blockPos2.getY()+", "+blockPos2.getZ()+")"),false);

            }


        }
        return ActionResult.SUCCESS;
    }
}
