package com.byzh.picgen.item.custom;

import com.byzh.picgen.block.ModBlocks;
import com.byzh.picgen.util.mycolor;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.passive.TropicalFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class OutputTool extends Item {
    public OutputTool(Settings settings) {
        super(settings);
    }

    private static HashMap<String,Integer> NAME_COLOR = mycolor.NAME_COLOR;
    private static ArrayList<Integer> SIZE = new ArrayList<>();
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient()){
            if (isSelected()){
                SIZE.clear();
                getSize();
                try {
                    output(world);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                user.sendMessage(Text.literal(SIZE.toString()),false);

//                String awa = world.getBlockState(SelectTool.blockPos2).getBlock().toString();
//                awa = awa.substring(18,awa.length()-1);
//                user.sendMessage(Text.literal(awa),false);
            }else {
                user.sendMessage(Text.literal("select wrong"),false);
            }
        }
        return TypedActionResult.success(user.getStackInHand(hand));
    }

    public static void output(World world) throws IOException {
        int x = SIZE.get(1) - SIZE.get(0) + 1;
        int y = SIZE.get(3) - SIZE.get(2) + 1;
        int z = SIZE.get(5) - SIZE.get(4) + 1;
        int width = 0;
        int height = 0;

        FabricLoader loader = FabricLoader.getInstance();
        java.nio.file.Path mcDir = loader.getGameDir();
        String path = mcDir.toString()+"\\config\\byzh";
        File dir = new File(path);
        dir.mkdir();

        if (z == 1){
            width = x;
            height = y;
        }
        if (y == 1){
            width = x;
            height = z;
        }
        if (x == 1){
            width = y;
            height = z;
        }
        if (z == 1){
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    Block block = world.getBlockState(new BlockPos(i + SIZE.get(0), j + SIZE.get(2), SIZE.get(4))).getBlock();
                    String block_name = block.toString();
                    block_name = block_name.substring(18,block_name.length()-1);
                    int colorID = getColorID(block_name);
                    image.setRGB(i, j, colorID); // 设置像素颜色
                }
            }
            File output = new File(path+"\\output"+ dir.list().length +".png");
            ImageIO.write(image, "png", output); // 保存为PNG格式的图片
        }
//        File output = new File(path+"\\output"+ FileCnt +".png");
//        ImageIO.write(image, "png", output); // 保存为PNG格式的图片


    }

    private static int getColorID(String name) {
        return NAME_COLOR.get(name);
    }

    private static boolean isSelected(){
        boolean flag1 = SelectTool.blockPos1 != SelectTool.blockPos0 &
                SelectTool.blockPos2 != SelectTool.blockPos0;
        boolean flag2 = SelectTool.blockPos1.getX() == SelectTool.blockPos2.getX() |
                SelectTool.blockPos1.getY() == SelectTool.blockPos2.getY() |
                SelectTool.blockPos1.getZ() == SelectTool.blockPos2.getZ();
        if (flag1 & flag2){
            return true;
        }
        return false;
    }
    private static void getSize(){
        SIZE.add(Math.min(SelectTool.blockPos1.getX(), SelectTool.blockPos2.getX()));
        SIZE.add(Math.max(SelectTool.blockPos1.getX(), SelectTool.blockPos2.getX()));
        SIZE.add(Math.min(SelectTool.blockPos1.getY(), SelectTool.blockPos2.getY()));
        SIZE.add(Math.max(SelectTool.blockPos1.getY(), SelectTool.blockPos2.getY()));
        SIZE.add(Math.min(SelectTool.blockPos1.getZ(), SelectTool.blockPos2.getZ()));
        SIZE.add(Math.max(SelectTool.blockPos1.getZ(), SelectTool.blockPos2.getZ()));
    }

}
