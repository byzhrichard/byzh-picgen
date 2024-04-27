package com.byzh.picgen.test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class picgen {
    public static void main(String[] args) throws IOException {
        mytry();
    }
    private static void mytry() throws IOException {

        int width = 16; // 画布宽度
        int height = 16; // 画布高度
        int[][] pixels = new int[width][height]; // 初始化画布


        int byzh_red = 0xFF;
        int byzh_green = 0x00;
        int byzh_blue = 0x00;
        int pixel = (byzh_red << 16) | (byzh_green << 8) | byzh_blue; // 合并RGB值
        System.out.println(pixel);
        System.out.println("awa");

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, pixel); // 设置像素颜色
            }
        }

        File output = new File("out.png");
        ImageIO.write(image, "png", output); // 保存为PNG格式的图片
    }
}
