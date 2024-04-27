package com.byzh.picgen.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class picgen {
    public static void main(String[] args) throws IOException {
        String path = "src/main/resources/assets/byzh-picgen/textures/block/";
        mytry("byzh_red",0xFF0000,path);
    }
    private static void mytry(String name,int pic,String path) throws IOException {

        int width = 16; // 画布宽度
        int height = 16; // 画布高度

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y,pic); // 设置像素颜色
            }
        }

        File output = new File(path + name +".png");
        ImageIO.write(image, "png", output); // 保存为PNG格式的图片
    }
}
