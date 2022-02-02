package me.hotpocket.plugin.util;

import me.hotpocket.plugin.FarmEss;

public class ConfigUtil {

    public static boolean getBoolean(String path) {
        return FarmEss.instance.getConfig().getBoolean(path);
    }

    public static String getString(String path) {
        return FarmEss.instance.getConfig().getString(path);
    }
}
