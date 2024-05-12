package com.byzh.picgen.util;


import java.util.HashMap;

public class mycolor {
    public static HashMap<String,Integer> NAME_COLOR = new HashMap<>();
    public static HashMap<String,Integer> DEFAULT_NAME_COLOR = new HashMap<>();

    static {
        NAME_COLOR.put("byzh_empty",(0 << 24) | 0xEFEFEF);

        NAME_COLOR.put("byzh_red",(255 << 24) | 0xEB3324);
        NAME_COLOR.put("byzh_orange",(255 << 24) | 0xF08650);
        NAME_COLOR.put("byzh_yellow",(255 << 24) | 0xFFFD55);
        NAME_COLOR.put("byzh_green",(255 << 24) | 0x75F94D);
        NAME_COLOR.put("byzh_cyan",(255 << 24) | 0x00FFFF);
        NAME_COLOR.put("byzh_blue",(255 << 24) | 0x3282F6);
        NAME_COLOR.put("byzh_purple",(255 << 24) | 0xEA3FF7);

        NAME_COLOR.put("byzh_black",(255 << 24) | 0x000000);
        NAME_COLOR.put("byzh_white",(255 << 24) | 0xFFFFFF);

        NAME_COLOR.put("bili_1",(255 << 24) | 0xFE0302);
        NAME_COLOR.put("bili_2",(255 << 24) | 0xFF7204);
        NAME_COLOR.put("bili_3",(255 << 24) | 0xFFAA02);
        NAME_COLOR.put("bili_4",(255 << 24) | 0xFFD302);
        NAME_COLOR.put("bili_5",(255 << 24) | 0xFFFF00);
        NAME_COLOR.put("bili_6",(255 << 24) | 0xA0EE00);
        NAME_COLOR.put("bili_7",(255 << 24) | 0x00CD00);
        NAME_COLOR.put("bili_8",(255 << 24) | 0x019899);
        NAME_COLOR.put("bili_9",(255 << 24) | 0x4266BE);
        NAME_COLOR.put("bili_10",(255 << 24) | 0x89D5FF);
        NAME_COLOR.put("bili_11",(255 << 24) | 0xCC0273);
        NAME_COLOR.put("bili_12",(255 << 24) | 0x222222);
        NAME_COLOR.put("bili_13",(255 << 24) | 0x9B9B9B);
        NAME_COLOR.put("bili_14",(255 << 24) | 0xFFFFFF);

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

                    int pixel = (255 << 24) | (now_i << 16) | (now_j << 8) | now_k;

                    DEFAULT_NAME_COLOR.put(block_name,pixel);
                }
            }
        }


    }


}
