package net.craftminecraft.bukkit.cmcplugin.config;

import java.io.File;

import org.bukkit.plugin.Plugin;

public class MainConfig extends Config{
	public MainConfig(Plugin plugin) {
		CONFIG_FILE = new File(plugin.getDataFolder(), "config.yml");
        CONFIG_HEADER = "PlotMe Configration File - See http://www.craftminecraft.net for settings";
	}

	public String ServerAddress = "your server address here";
	
	public String ApiKey = "";
}
