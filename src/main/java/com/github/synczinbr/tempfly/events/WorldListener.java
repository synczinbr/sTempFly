package com.github.synczinbr.tempfly.events;

import com.github.synczinbr.tempfly.TemporaryFly;
import com.github.synczinbr.tempfly.managers.FlyManager;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.plugin.Plugin;

import java.util.List;

public class WorldListener implements Listener {

    private static FileConfiguration cfg = TemporaryFly.instance.getConfig();

    public WorldListener(Plugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onChange(PlayerChangedWorldEvent event) {
        List<String> worldsList = cfg.getStringList("worlds");
        String thisWorld = event.getPlayer().getWorld().getName();
        for (String world : worldsList) {
            if (world.equalsIgnoreCase(thisWorld)) {
                if (FlyManager.getActivePlayers().contains(event.getPlayer().getName())) {
                    event.getPlayer().setAllowFlight(true);
                }
            } else {
                if (FlyManager.getActivePlayers().contains(event.getPlayer().getName())) {
                    event.getPlayer().setAllowFlight(false);
                }
            }
        }
    }
}
