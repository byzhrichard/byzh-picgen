package com.byzh.picgen.block;

import com.byzh.picgen.ByzhPicgen;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks extends Block {
    public ModBlocks(Settings settings) {
        super(settings);
    }

    public static final Block BYZH_RED = registerBlocks(
            "byzh_red",
            new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL)));

    //==注册方法=====================================================================
    private static Item registerBlockItems(String name, Block block){
        return Registry.register(
                Registries.ITEM,
                new Identifier(ByzhPicgen.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));//区别于item注册的一点。这里是BlockItem类
    }
    public static Block registerBlocks(String name,Block block){
        registerBlockItems(name, block);//注册 方块 的时候也注册 方块物品
        return Registry.register(
                Registries.BLOCK,
                new Identifier(ByzhPicgen.MOD_ID, name),
                block);
    }
    public static void registerModBlocks(){};
}
