package me.rafaelpiloto10.custommessages.commands;

import me.rafaelpiloto10.custommessages.CustomMessages;
import me.rafaelpiloto10.custommessages.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnnounceCommand implements CommandExecutor {

    private CustomMessages plugin;

    public AnnounceCommand(CustomMessages plugin) {
        this.plugin = plugin;
        this.plugin.getCommand("announce").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(Utils.chat(plugin.getConfig().getString("announce-error-no-message")));
        } else if (!sender.hasPermission("custommessages.announce.use")) {
            sender.sendMessage(Utils.chat(plugin.getConfig().getString("no-permission")));
        } else {
            List<String> _message = Arrays.asList(args);
            String message = String.join(" ", _message);
            Bukkit.broadcastMessage(Utils.chat(plugin.getConfig().getString("announce-message-tag")) + message);
            return true;
        }

        return false;
    }
}
