package net.craftminecraft.bukkit.cmcplugin;

import net.craftminecraft.bukkit.cmcplugin.log.Logger;
import net.craftminecraft.bukkit.cmcplugin.log.LogLevels;
import net.craftminecraft.bukkit.cmcplugin.config.MainConfig;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class CMCPlugin extends JavaPlugin implements Listener {
	private MainConfig mainConfig;
	public Logger logger = new Logger(this);
	
	@Override
	public void onEnable() {
    	try {
    		mainConfig = new MainConfig(this);
    		mainConfig.init();
    	} catch (Exception ex) {
    		logger.log(LogLevels.FATAL, "Failed to load config");
    		logger.log(LogLevels.FATAL, ex.getMessage());
    		getServer().getPluginManager().disablePlugin(this);
    	}
		
		this.getServer().getPluginManager().registerEvents(this, this);
	}
	
	@Override
	public void onDisable() {
		
	}
	
	@EventHandler
	public void onPlayerConnect(PlayerLoginEvent ev) {
		String address = ev.getAddress().toString().split("/")[1];
		if (!(address.equals("199.101.51.252"))) {
			this.getLogger().info(address);
			ev.setResult(PlayerLoginEvent.Result.KICK_OTHER);
			ev.setKickMessage("Please connect to playcmc.com or " + mainConfig.ServerAddress);
		}
	}
}
