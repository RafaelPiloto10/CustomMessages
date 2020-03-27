package me.rafaelpiloto10.custommessages.listeners;

import me.rafaelpiloto10.custommessages.CustomMessages;
import me.rafaelpiloto10.custommessages.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;

public class NewPlayerListener implements Listener {

    private CustomMessages plugin;

    public NewPlayerListener(CustomMessages plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onNewPlayerJoinEvent(PlayerJoinEvent e) {
        if (plugin.getConfig().getBoolean("new-player-join") && !e.getPlayer().hasPlayedBefore()) {
            String message = "Test-CustomMessage";
            for (String line : plugin.getConfig().getStringList("new-player-join-message")) {
                message += Utils.chat(line);
            }
            Bukkit.broadcastMessage(message.replace("<name>", e.getPlayer().getDisplayName()));

        } else if (plugin.getConfig().getBoolean("custom-join")) {
            e.setJoinMessage(Utils.chat(plugin.getConfig().getString("custom-join-message").replace("<name>", e.getPlayer().getDisplayName())));
        }
    }


}
