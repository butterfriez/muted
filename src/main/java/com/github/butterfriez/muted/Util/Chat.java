// https://github.com/appable0/AmbientAddons/blob/master/src/main/kotlin/com/ambientaddons/utils/Chat.kt

package com.github.butterfriez.muted.Util;

import net.minecraft.client.Minecraft;

public class Chat {
    public static String GetChatBreak() {
        StringBuilder str = new StringBuilder("§9§m");
        System.out.println(Minecraft.getMinecraft().fontRendererObj.getStringWidth("-"));
        for (int i = 0; i < Minecraft.getMinecraft().fontRendererObj.getStringWidth("-"); i++) {
            str.append("-");
        }

        return str + "\n";
    }
}
