package me.rafaelpiloto10.custommessages;

import me.rafaelpiloto10.custommessages.commands.AnnounceCommand;
import me.rafaelpiloto10.custommessages.listeners.NewMessageListener;
import me.rafaelpiloto10.custommessages.listeners.NewPlayerListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustomMessages extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        registerCommands();
        registerListeners();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void registerCommands(){
        new AnnounceCommand(this);
    }

    public void registerListeners(){
        getServer().getPluginManager().registerEvents(new NewPlayerListener(this), this);
        getServer().getPluginManager().registerEvents(new NewMessageListener(this), this);
    }


}
