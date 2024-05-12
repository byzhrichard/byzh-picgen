package com.byzh.picgen.util;

import com.byzh.picgen.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;

public class test {


    public static void main(String[] args) {
//        int num = (8+1);
//        for (int i = 0; i < num; i++) {
//            for (int j = 0; j < num; j++) {
//                for (int k = 0; k < num; k++) {
//                    int now_i = i*32;
//                    int now_j = j*32;
//                    int now_k = k*32;
//
//                    StringBuilder sb = new StringBuilder();
//                    sb.append("default_").append(now_i).append(" ").append(now_j).append(" ").append(now_k);
//                    String block_name = sb.toString();
//                    System.out.println(block_name);
//                    int pixel = (now_i << 16) | (now_j << 8) | now_k;
//                    String hex = Integer.toHexString(pixel);
//                    System.out.println(hex);
//                }
//            }
//        }
        Integer awa = mycolor.NAME_COLOR.get("awa");
        System.out.println(awa == null);

    }
}
