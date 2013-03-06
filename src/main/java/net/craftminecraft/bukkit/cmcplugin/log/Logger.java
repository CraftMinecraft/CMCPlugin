package net.craftminecraft.bukkit.cmcplugin.log;

import net.craftminecraft.bukkit.cmcplugin.log.LogLevels;
import net.craftminecraft.bukkit.cmcplugin.CMCPlugin;

public class Logger {
	public Logger(CMCPlugin p) {
		
	}
	
	public void log (String message) {
		log(LogLevels.NONE, message);
	}
	
	public void log (LogLevels type, String message) {
		switch (type) {
		case INFO:
			System.out.print("[BanSync] [INFO] " + message);
			break;
		case WARNING:
			System.out.print("[BanSync] [WARNING] " + message);
			break;
        case SEVERE:
            System.out.print("[BanSync] [SEVERE] " + message);
            break;
        case FATAL:
            System.out.print("[BanSync] [FATAL] " + message);
            break;
        default:
            System.out.print("[BanSync] " + message);
            break;
		}
	}
}
