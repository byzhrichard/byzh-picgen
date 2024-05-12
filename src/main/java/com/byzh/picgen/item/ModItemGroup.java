package com.byzh.picgen.item;

import com.byzh.picgen.ByzhPicgen;
import com.byzh.picgen.block.ModBlocks;
import com.byzh.picgen.block.ModBlocks_default;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Block;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup DEFAULT_GROUP_Bulider = FabricItemGroup.builder()
            .displayName(Text.translatable("itemGroup.default_group"))
            .icon(()->new ItemStack(ModItems.ICON))
            .entries( (displayContext, entries) -> {
                for (Block block : ModBlocks_default.DEFAULT_BLOCK) {
                    entries.add(block);
                }
            }).build();
    public static final ItemGroup BILI_GROUP_Bulider = FabricItemGroup.builder()
            .displayName(Text.translatable("itemGroup.bili_group"))
            .icon(()->new ItemStack(ModItems.ICON))
            .entries( (displayContext, entries) -> {
                for (Block block : ModBlocks.BILI_BLOCK) {
                    entries.add(block);
                }
            }).build();
    public static final ItemGroup PICGEN_GROUP_Bulider = FabricItemGroup.builder()
            .displayName(Text.translatable("itemGroup.picgen_group"))
            .icon(()->new ItemStack(ModItems.ICON))
            .entries( (displayContext, entries) -> {
                entries.add(ModItems.OUTPUT_TOOL);
                entries.add(ModItems.SELECT_TOOL);
                for (Block block : ModBlocks.BYZH_BLOCK) {
                    entries.add(block);
                }
            }).build();
    public static final ItemGroup BILI_GROUP = registerItemGroups("bili_group", BILI_GROUP_Bulider);
    public static final ItemGroup PICGEN_GROUP = registerItemGroups("picgen_group", PICGEN_GROUP_Bulider);
    public static final ItemGroup DEFAULT_GROUP = registerItemGroups("default_group", DEFAULT_GROUP_Bulider);


    //===========物品栏注册的方法==============
    private static ItemGroup registerItemGroups(String name, ItemGroup itemGroup){
        return Registry.register(
                Registries.ITEM_GROUP,
                new Identifier(ByzhPicgen.MOD_ID, name),
                itemGroup);
    }
    public static void registerModItemGroup(){

    }
}
