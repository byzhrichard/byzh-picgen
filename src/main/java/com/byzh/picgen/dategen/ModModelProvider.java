package com.byzh.picgen.dategen;

import com.byzh.picgen.block.ModBlocks;
import com.byzh.picgen.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        for (Block block : ModBlocks.BLOCK_LIST) {
            blockStateModelGenerator.registerSimpleCubeAll(block);
        }
//        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BYZH_RED);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.OUTPUT_TOOL, Models.GENERATED);
    }
}
