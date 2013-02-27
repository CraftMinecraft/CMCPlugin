package com.craftminecraft.bukkit.cmcplugin;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class CMCPlugin extends JavaPlugin implements Listener {
	@Override
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(this, this);
	}
	
	@Override
	public void onDisable() {
		
	}
	
	@EventHandler
	public void onPlayerConnect(PlayerLoginEvent ev) {
		String address = ev.getAddress().getHostAddress();
		if (address != "50.49.250.100") {
			ev.setResult(PlayerLoginEvent.Result.KICK_OTHER);
			ev.setKickMessage("Please connect to playcmc.com or this server's domain !");
		}
	}
}