package me.hotpocket.plugin.events;

import me.hotpocket.plugin.util.ConfigUtil;
import me.hotpocket.plugin.util.MessageUtil;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class TrampleEvent implements Listener {

    @EventHandler
    private void onTrample(PlayerInteractEvent event) {
        if (event.getClickedBlock().getType().equals(Material.SOIL) && event.getAction().equals(Action.PHYSICAL)) {
            event.setCancelled(true);
            if (ConfigUtil.getBoolean("message-when-trampled")) {
                MessageUtil.playerMessage(event.getPlayer(), ConfigUtil.getString("trample-message"));
            }
            if (ConfigUtil.getBoolean("title-when-trampled")) {
                MessageUtil.playerTitle(event.getPlayer(), ConfigUtil.getString("trample-title"), ConfigUtil.getString("trample-subtitle"), 0, 30, 5);
            }
            if (ConfigUtil.getBoolean("action-bar-when-trampled")) {
                MessageUtil.playerActionBar(event.getPlayer(), ConfigUtil.getString("trample-action-bar"));
            }
        }
    }

    @EventHandler
    private void onMobTrample(EntityInteractEvent event) {
        if (event.getBlock().getType().equals(Material.SOIL)) {
            event.setCancelled(true);
        }
    }
}
