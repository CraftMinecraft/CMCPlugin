package net.craftminecraft.bukkit.cmcplugin;

import net.craftminecraft.bukkit.cmcplugin.config.MainConfig;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class CMCPlugin extends JavaPlugin implements Listener {
	private MainConfig mainConfig;
	
	@Override
	public void onEnable() {
		mainConfig = new MainConfig(this);
		mainConfig.load();
		this.getServer().getPluginManager().registerEvents(this, this);
	}
	
	@Override
	public void onDisable() {
		
	}
	
	@EventHandler
	public void onPlayerConnect(PlayerLoginEvent ev) {
		String address = ev.getAddress().toString().split("/")[1];
		if (!(address.equals("199.101.51.252") || address.equals("50.49.250.100"))) {
			this.getLogger().info(address);
			ev.setResult(PlayerLoginEvent.Result.KICK_OTHER);
			ev.setKickMessage("Please connect to playcmc.com or " + mainConfig.ServerAddress);
		}
	}
}
