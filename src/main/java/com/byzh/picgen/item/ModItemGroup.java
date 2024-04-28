package com.byzh.picgen.item;

import com.byzh.picgen.ByzhPicgen;
import com.byzh.picgen.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup PICGEN_GROUP_Bulider = FabricItemGroup.builder()
            .displayName(Text.translatable("itemGroup.picgen_group"))
            .icon(()->new ItemStack(ModBlocks.BYZH_RED))
            .entries( (displayContext, entries) -> {
                entries.add(ModItems.OUTPUT_TOOL);
                entries.add(ModItems.SELECT_TOOL);
                for (Block block : ModBlocks.BLOCK_LIST) {
                    entries.add(block);
                }

            }).build();
    public static final ItemGroup PICGEN_GROUP = registerItemGroups("picgen_group", PICGEN_GROUP_Bulider);
    //物品栏注册的方法
    private static ItemGroup registerItemGroups(String name, ItemGroup itemGroup){
        return Registry.register(
                Registries.ITEM_GROUP,
                new Identifier(ByzhPicgen.MOD_ID, name),
                itemGroup);
    }
    public static void registerModItemGroup(){

    }
}
