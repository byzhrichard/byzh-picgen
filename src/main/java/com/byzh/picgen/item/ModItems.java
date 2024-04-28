package com.byzh.picgen.item;

import com.byzh.picgen.ByzhPicgen;
import com.byzh.picgen.item.custom.OutputTool;
import com.byzh.picgen.item.custom.SelectTool;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item OUTPUT_TOOL = registerItems("output_tool",new OutputTool(new FabricItemSettings()));
    public static final Item SELECT_TOOL = registerItems("select_tool",new SelectTool(new FabricItemSettings()));
    //物品注册的方法
    private static Item registerItems(String name, Item item){
        return Registry.register(
                Registries.ITEM,
                new Identifier(ByzhPicgen.MOD_ID, name),
                item);
    }
    public static void registerModItems(){
    }
}
