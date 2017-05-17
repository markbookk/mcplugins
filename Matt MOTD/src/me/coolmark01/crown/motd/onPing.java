package me.coolmark01.crown.motd;

import java.util.Iterator;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class onPing implements Listener {

	
	public Iterator<String> iterator = Core.plugin.getConfig().getStringList("MotdList").iterator();
	public void setIterator() {	
		iterator = Core.plugin.getConfig().getStringList("MotdList").iterator();
	}

	@EventHandler
	public void onPingEvent(ServerListPingEvent e) {
		e.setMotd(motd());
	}
	
	public String motd() {
		if (Core.plugin.getConfig().getStringList("MotdList") != null) {
			if (!(iterator.hasNext())) {
				setIterator();
			}
			while (iterator.hasNext()) {
				return ChatColor.translateAlternateColorCodes('&', iterator.next());
			}


		} else 
			return (ChatColor.RED + "Please change MOTD on config!!!");
		return null;

	}

}
