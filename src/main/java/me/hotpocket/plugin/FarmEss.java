package me.hotpocket.plugin;

import me.hotpocket.plugin.events.TrampleEvent;
import me.hotpocket.plugin.util.MessageUtil;
import me.hotpocket.plugin.util.PermissionUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class FarmEss extends JavaPlugin {

    public static FarmEss instance;

    @Override
    public void onEnable() {
        instance = this;

        this.getServer().getPluginManager().registerEvents(new TrampleEvent(), this);

        File file = new File(getDataFolder() + File.separator + "config.yml");
        if (!file.exists()){
            getConfig().options().copyDefaults(true);
            saveDefaultConfig();
        } else {
            reloadConfig();
            this.saveDefaultConfig();
        }
        MessageUtil.consoleMessage("[FarmEss] has been enabled!");
    }
    @Override
    public void onDisable() {
        MessageUtil.consoleMessage("[FarmEss] has been disabled!");
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("farmess-reload")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (PermissionUtil.canReload(player)) {
                    this.reloadConfig();
                    this.saveDefaultConfig();
                    MessageUtil.playerMessage(player, "&a[FarmEss] &7Reloaded the config successfully.");
                } else {
                    MessageUtil.playerMessage(player, "&4[FarmEss] &cYou do not have access to that command!");
                }
            }
        }
        return false;
    }
}
