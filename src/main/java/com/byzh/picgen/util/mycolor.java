package com.byzh.picgen.util;


import java.util.HashMap;

public class mycolor {
    public static HashMap<String,Integer> NAME_COLOR = new HashMap<>();

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

    }


}
