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
    public static ArrayList<Block> BYZH_BLOCK = new ArrayList<>();
    public static ArrayList<Block> BILI_BLOCK = new ArrayList<>();

    public static final Block BYZH_EMPTY = registerToByzhBlock("byzh_empty", new Block(FabricBlockSettings.copyOf(Blocks.GLASS).nonOpaque()));
    public static final Block BYZH_RED = registerToByzhBlock("byzh_red", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL)));
    public static final Block BYZH_ORANGE = registerToByzhBlock("byzh_orange", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL)));
    public static final Block BYZH_YELLOW = registerToByzhBlock("byzh_yellow", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL)));
    public static final Block BYZH_GREEN = registerToByzhBlock("byzh_green", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL)));
    public static final Block BYZH_CYAN = registerToByzhBlock("byzh_cyan", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL)));
    public static final Block BYZH_BLUE = registerToByzhBlock("byzh_blue", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL)));
    public static final Block BYZH_PURPLE = registerToByzhBlock("byzh_purple", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL)));
    public static final Block BYZH_BLACK = registerToByzhBlock("byzh_black", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL)));
    public static final Block BYZH_WHITE = registerToByzhBlock("byzh_white", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL)));
    public static final Block BILI_1 = registerToBiliBlock("bili_1", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL)));
    public static final Block BILI_2 = registerToBiliBlock("bili_2", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL)));
    public static final Block BILI_3 = registerToBiliBlock("bili_3", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL)));
    public static final Block BILI_4 = registerToBiliBlock("bili_4", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL)));
    public static final Block BILI_5 = registerToBiliBlock("bili_5", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL)));
    public static final Block BILI_6 = registerToBiliBlock("bili_6", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL)));
    public static final Block BILI_7 = registerToBiliBlock("bili_7", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL)));
    public static final Block BILI_8 = registerToBiliBlock("bili_8", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL)));
    public static final Block BILI_9 = registerToBiliBlock("bili_9", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL)));
    public static final Block BILI_10 = registerToBiliBlock("bili_10", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL)));
    public static final Block BILI_11 = registerToBiliBlock("bili_11", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL)));
    public static final Block BILI_12 = registerToBiliBlock("bili_12", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL)));
    public static final Block BILI_13 = registerToBiliBlock("bili_13", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL)));
    public static final Block BILI_14 = registerToBiliBlock("bili_14", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL)));

    //==注册方法=====================================================================
    private static Item registerBlockItems(String name, Block block){
        return Registry.register(
                Registries.ITEM,
                new Identifier(ByzhPicgen.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));//区别于item注册的一点。这里是BlockItem类
    }
    private static Block registerBlocks(String name,Block block){
        registerBlockItems(name, block);//注册 方块 的时候也注册 方块物品
        return Registry.register(
                Registries.BLOCK,
                new Identifier(ByzhPicgen.MOD_ID, name),
                block);
    }
    private static Block registerToByzhBlock(String name,Block block){
        Block result = registerBlocks(name, block);
        BYZH_BLOCK.add(result);
        return result;
    }
    private static Block registerToBiliBlock(String name,Block block){
        Block result = registerBlocks(name, block);
        BILI_BLOCK.add(result);
        return result;
    }
    public static void registerModBlocks(){};
}
