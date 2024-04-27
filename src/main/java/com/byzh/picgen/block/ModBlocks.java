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

import java.util.ArrayList;

public class ModBlocks{
    public static ArrayList<Block> BLOCK_LIST = new ArrayList<>();

    public static final Block BYZH_RED = registerBlocks("byzh_red", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL)));
    public static final Block BYZH_ORANGE = registerBlocks("byzh_orange", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL)));
    public static final Block BYZH_YELLOW = registerBlocks("byzh_yellow", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL)));
    public static final Block BYZH_GREEN = registerBlocks("byzh_green", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL)));
    public static final Block BYZH_CYAN = registerBlocks("byzh_cyan", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL)));
    public static final Block BYZH_BLUE = registerBlocks("byzh_blue", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL)));
    public static final Block BYZH_PURPLE = registerBlocks("byzh_purple", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL)));

    //==注册方法=====================================================================
    private static Item registerBlockItems(String name, Block block){
        return Registry.register(
                Registries.ITEM,
                new Identifier(ByzhPicgen.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));//区别于item注册的一点。这里是BlockItem类
    }
    private static Block registerBlocks(String name,Block block){
        registerBlockItems(name, block);//注册 方块 的时候也注册 方块物品
        Block result = Registry.register(
                Registries.BLOCK,
                new Identifier(ByzhPicgen.MOD_ID, name),
                block);
        BLOCK_LIST.add(result);
        return result;
    }
    public static void registerModBlocks(){};
}
