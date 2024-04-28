package com.byzh.picgen.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class OutputTool extends Item {
    public OutputTool(Settings settings) {
        super(settings);
    }

    private static ArrayList<Integer> size = new ArrayList<>();
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient()){
            user.sendMessage(Text.literal("awa"),false);
            if (isSelected()){
                size.clear();
                getSize();
//                output();
                user.sendMessage(Text.literal(size.toString()),false);
            }
        }
        return TypedActionResult.success(user.getStackInHand(hand));
    }

    private static boolean isSelected(){
        if (SelectTool.blockPos1 != SelectTool.blockPos0 & SelectTool.blockPos2 != SelectTool.blockPos0){
            return true;
        }
        return false;
    }
    private static void getSize(){
        size.add(Math.min(SelectTool.blockPos1.getX(), SelectTool.blockPos2.getX()));
        size.add(Math.max(SelectTool.blockPos1.getX(), SelectTool.blockPos2.getX()));
        size.add(Math.min(SelectTool.blockPos1.getY(), SelectTool.blockPos2.getY()));
        size.add(Math.max(SelectTool.blockPos1.getY(), SelectTool.blockPos2.getY()));
        size.add(Math.min(SelectTool.blockPos1.getZ(), SelectTool.blockPos2.getZ()));
        size.add(Math.max(SelectTool.blockPos1.getZ(), SelectTool.blockPos2.getZ()));
    }

}
