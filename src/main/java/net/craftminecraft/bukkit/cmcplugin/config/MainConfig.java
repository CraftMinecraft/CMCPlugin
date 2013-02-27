package net.craftminecraft.bukkit.cmcplugin.config;

import org.bukkit.plugin.Plugin;

public class MainConfig extends Config{
	public MainConfig(Plugin plugin) {
		this.setFile(plugin);
	}

	public String ServerAddress = "your server address here";
}
