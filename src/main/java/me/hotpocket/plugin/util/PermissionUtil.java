package me.hotpocket.plugin.util;

import org.bukkit.entity.Player;

public class PermissionUtil {

    public static boolean canReload(Player player) {
        if(player.hasPermission("farmess.reload")) {
            return true;
        } else if(player.hasPermission("farmess.*")) {
            return true;
        }
        return false;
    }
}
