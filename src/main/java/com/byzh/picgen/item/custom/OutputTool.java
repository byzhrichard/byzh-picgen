package com.byzh.picgen.item.custom;

import com.byzh.picgen.util.mycolor;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.apache.commons.lang3.ObjectUtils;
import org.jetbrains.annotations.Nullable;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OutputTool extends Item {
    public OutputTool(Settings settings) {
        super(settings);
    }

    private static ArrayList<Integer> SIZE = new ArrayList<>();
    private static final String PATH = FabricLoader.getInstance().getGameDir().toString()+"\\config\\byzh";
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient()){
            if (isRightSelected()){
                sizeInit();
                try {
                    output(world);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                user.sendMessage(Text.translatable("item.byzh-picgen.complete"),false);
            }else {
                user.sendMessage(Text.translatable("item.byzh-picgen.selectwrong"),false);
            }
        }
        return TypedActionResult.success(user.getStackInHand(hand));
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.byzh-picgen.outputtoolusage1"));
        tooltip.add(Text.translatable("item.byzh-picgen.outputtoolusage2"));
        super.appendTooltip(stack, world, tooltip, context);
    }

    public static void output(World world) throws IOException {
        ArrayList<Integer> x = new ArrayList<>();
        if (SIZE.get(1) < SIZE.get(2)){
            for (int i = 0; i < SIZE.get(2) - SIZE.get(1) + 1; i++) {
                x.add(SIZE.get(1)+i);
            }
        } else {
            for (int i = 0; i < SIZE.get(1) - SIZE.get(2) + 1; i++) {
                x.add(SIZE.get(1)-i);
            }
        }
        ArrayList<Integer> y = new ArrayList<>();
        if (SIZE.get(3) < SIZE.get(4)){
            for (int i = 0; i < SIZE.get(4) - SIZE.get(3) + 1; i++) {
                y.add(SIZE.get(3)+i);
            }
        } else {
            for (int i = 0; i < SIZE.get(3) - SIZE.get(4) + 1; i++) {
                y.add(SIZE.get(3)-i);
            }
        }
        ArrayList<Integer> z = new ArrayList<>();
        if (SIZE.get(5) < SIZE.get(6)){
            for (int i = 0; i < SIZE.get(6) - SIZE.get(5) + 1; i++) {
                z.add(SIZE.get(5)+i);
            }
        } else {
            for (int i = 0; i < SIZE.get(5) - SIZE.get(6) + 1; i++) {
                z.add(SIZE.get(5)-i);
            }
        }

        File dir = new File(PATH);
        dir.mkdir();
        int dircnt = dir.list().length;

        BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        if (z.size() == 1){
            image = xyGetImage(world, x, y, z);
        }
        if (y.size() == 1){
            image = xzGetImage(world, x, y, z);
        }
        if (x.size() == 1){
            image = yzGetImage(world, x, y, z);
        }

        imageSave(image, dircnt);
    }

    private static void imageSave(BufferedImage image,int dircnt) throws IOException {
        File output = new File(PATH+"\\output"+ dircnt +".png");
        ImageIO.write(image, "png", output); // 保存为PNG格式的图片
    }

    private static BufferedImage yzGetImage(World world, ArrayList<Integer> x, ArrayList<Integer> y, ArrayList<Integer> z){
        BufferedImage image = new BufferedImage(z.size(), y.size(), BufferedImage.TYPE_INT_ARGB);
        for (Integer i : x) {
            int height = 0;
            for (Integer j : y) {
                int width = 0;
                for (Integer k : z) {
                    int colorID = getColorID(world,i,j,k);
                    image.setRGB(width, height, colorID);
                    width++;
                }
                height++;
            }
        }
        return image;
    }
    private static BufferedImage xzGetImage(World world, ArrayList<Integer> x, ArrayList<Integer> y, ArrayList<Integer> z) {
        BufferedImage image = new BufferedImage(x.size(), z.size(), BufferedImage.TYPE_INT_ARGB);
        int width = 0;
        for (Integer i : x) {
            for (Integer j : y) {
                int height = 0;
                for (Integer k : z) {
                    int colorID = getColorID(world,i,j,k);
                    image.setRGB(width, height, colorID);
                    height++;
                }
            }
            width++;
        }
        return image;
    }
    private static BufferedImage xyGetImage(World world, ArrayList<Integer> x, ArrayList<Integer> y, ArrayList<Integer> z) {
        BufferedImage image = new BufferedImage(x.size(), y.size(), BufferedImage.TYPE_INT_ARGB);
        int width = 0;
        for (Integer i : x) {
            int height = 0;
            for (Integer j : y) {
                for (Integer k : z) {
                    int colorID = getColorID(world,i,j,k);
                    image.setRGB(width, height, colorID);
                }
                height++;
            }
            width++;
        }
        return image;
    }

    private static int getColorID(World world, int i, int j, int k) {
        Block block = world.getBlockState(new BlockPos(i, j, k)).getBlock();
        String block_name = block.toString();
        boolean flag = block_name.startsWith("Block{byzh-picgen:");
        if (flag){
            block_name = block_name.substring(18,block_name.length()-1);
            Integer result = mycolor.NAME_COLOR.get(block_name);
            return result != null ? result : mycolor.DEFAULT_NAME_COLOR.get(block_name);
        }else {
            return mycolor.NAME_COLOR.get("byzh_empty");
        }
    }

    private static boolean isRightSelected(){
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
    private static void sizeInit(){
        SIZE.clear();
        SIZE.add(0);
        SIZE.add(SelectTool.blockPos1.getX());
        SIZE.add(SelectTool.blockPos2.getX());
        SIZE.add(SelectTool.blockPos1.getY());
        SIZE.add(SelectTool.blockPos2.getY());
        SIZE.add(SelectTool.blockPos1.getZ());
        SIZE.add(SelectTool.blockPos2.getZ());
    }
}
