package com.byzh.picgen.dategen;

import com.byzh.picgen.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        for (Block block : ModBlocks.BLOCK_LIST) {
            addDrop(block);
        }
//        addDrop(ModBlocks.BYZH_RED);
//        addDrop(ModBlocks.BYZH_RED);
//        addDrop(ModBlocks.BYZH_RED);
//        addDrop(ModBlocks.BYZH_RED);
//        addDrop(ModBlocks.BYZH_RED);
//        addDrop(ModBlocks.BYZH_RED);
//        addDrop(ModBlocks.BYZH_RED);
    }
}
