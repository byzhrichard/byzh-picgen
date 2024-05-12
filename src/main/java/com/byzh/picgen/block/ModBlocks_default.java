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

public class ModBlocks_default {
    public static ArrayList<Block> DEFAULT_BLOCK = new ArrayList<>();

    static{
        int num = (8+1);
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                for (int k = 0; k < num; k++) {
                    int now_i = i*32;
                    int now_j = j*32;
                    int now_k = k*32;

                    StringBuilder sb = new StringBuilder();
                    sb.append("default_").append(now_i).append("_").append(now_j).append("_").append(now_k);
                    String block_name = sb.toString();
                    registerToDefaultBlock(block_name, new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL)));
//                    int pixel = (now_i << 16) | (now_j << 8) | now_k;
//                    String hex = Integer.toHexString(pixel);
//                    System.out.println(hex);
                }
            }
        }
    }

    //==注册方法=====================================================================
    private static void registerBlockItems(String name, Block block){
        Registry.register(
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
    private static void registerToDefaultBlock(String name,Block block){
        Block result = registerBlocks(name, block);
        DEFAULT_BLOCK.add(result);
    }
    public static void registerModBlocks(){};
}
