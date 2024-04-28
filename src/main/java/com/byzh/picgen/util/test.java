package com.byzh.picgen.util;

import com.byzh.picgen.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;

public class test {


    public static void main(String[] args) {
        ArrayList<Integer> x = new ArrayList<>();
        x.add(1);
        x.add(1);
        x.add(1);
        ArrayList<Integer> y = new ArrayList<>();
        y.add(1);
        ArrayList<Integer> z = new ArrayList<>();
        z.add(1);
        z.add(1);
        z.add(1);
        BufferedImage image = new BufferedImage(x.size(), z.size(), BufferedImage.TYPE_INT_RGB);
        int width = 0;
        for (int i : x) {
            for (int j : y) {
                int height = 0;
                for (int k : z) {
//                    System.out.println(width+" "+height);
                    image.setRGB(width, height, 0xFF0000); // 设置像素颜色

                    height++;
                }
            }
            width++;
        }
//        System.out.println("awa");
    }
}
