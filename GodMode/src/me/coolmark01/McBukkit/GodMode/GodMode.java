package me.coolmark01.McBukkit.GodMode;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class GodMode implements CommandExecutor, Listener {
	static List<String> name = new ArrayList<String>();
	static int hits;
	static Timer timer = new Timer();
	static long startTime = 0;
	static long totalTime = 0;
	static long readableTime = 0;
	

	public GodMode(Core core) {
		// TODO Auto-generated constructor stub
	}

	public GodMode() {
		// TODO Auto-generated constructor stub
	}
	
	public List<String> getList() {
		return name;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] arg) {
		if (sender instanceof Player) {
			if (label.equalsIgnoreCase("godmode")) {
				Player p = (Player) sender;
				if (name.contains(p.getName())) {
					name.remove(p.getName());
					p.sendMessage(ChatColor.RED + "God-Mode Disabled!");
					hits = 0;
					totalTime = 0;

				} else {
					name.add(p.getName());
					p.sendMessage(ChatColor.GOLD + "God-Mode Enabled! ");
					hits = 0;
					startTime = System.currentTimeMillis();
					
				}

			}
		}
		return true;
	}

	@EventHandler
	public void onUse(EntityDamageEvent event) {
		if (event.getEntity() instanceof Player) {
			Player player = (Player) event.getEntity();
			if (name.contains(player.getName())) {
				event.setCancelled(true);
				hits ++;
				totalTime += startTime;
				readableTime = (totalTime / 1000000000)/1000;
				player.sendMessage(ChatColor.RED + "You have been hit " + hits + ChatColor.BLUE + ChatColor.BOLD.toString() + " times in " + readableTime + " seconds!");

			}

		}

	}

}
