package me.rafaelpiloto10.custommessages.listeners;

import me.rafaelpiloto10.custommessages.CustomMessages;
import me.rafaelpiloto10.custommessages.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.List;

public class NewMessageListener implements Listener {

    private CustomMessages plugin;

    public NewMessageListener(CustomMessages plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onNewMessage(AsyncPlayerChatEvent e) {
        String message = e.getMessage();
        Player p = e.getPlayer();
        if (p.hasPermission("custommessages.customformat.use")) {
            List<String> formats = plugin.getConfig().getStringList("chat-formats");
            for (int i = 0; i < plugin.getConfig().getInt("chat-format-amount"); i++) {
                if (p.hasPermission("custommessages.ranks.rank_" + (i + 1))) {
                    e.setFormat(Utils.chat(formats.get(i).replace("<name>", p.getDisplayName()).replace("<msg>", message)));
                    return;
                }
            }
        }
    }


}
