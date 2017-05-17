package me.MisterJWMain.core;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import net.md_5.bungee.api.ChatColor;

public class playerListener implements Listener {
	
	Core m;
	FileConfiguration config;
	
	
	public playerListener(Core c){
		
		c.getServer().getPluginManager().registerEvents(this, c);
		
		m = c;
		
		config = m.getConfig();
		
	}
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e){
		
		String msg = e.getMessage().toString();
		
		msg = msg.toLowerCase().replaceAll(" ", "");
		
		
		for(Object i : config.getList("FilterWords").toArray()){
			String str = i.toString();
			if(msg.contains(str.toLowerCase()) && !e.getPlayer().hasPermission("endless.filter.bypass")){
				
				e.setCancelled(true);
				e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Message")));
				
			}
			
		}
		
	}
}
