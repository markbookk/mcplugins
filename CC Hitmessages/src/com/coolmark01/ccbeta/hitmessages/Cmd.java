package com.coolmark01.ccbeta.hitmessages;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class Cmd implements Listener, CommandExecutor {
	static ArrayList<String> admin = new ArrayList();
	static ArrayList<String> adminv = new ArrayList();
	static ArrayList<String> adminf = new ArrayList();
	static ArrayList<String> adminhit = new ArrayList();
	static Main plugin;

	public Cmd() {
	}

	public Cmd(Main instance) {
		plugin = instance;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (sender.hasPermission("CoolCraft.hitmessages")) {
				if (label.equalsIgnoreCase("hitmessages")) {
					if (adminhit.contains(p.getName())) {
						adminhit.remove(p.getName());
						p.sendMessage(ChatColor.RED + "You have disabled hitmessages!");
						return true;
					}
					adminhit.add(p.getName());
					p.sendMessage(ChatColor.GREEN + "You have enabled hitmessage!");
					return true;
				}
		}
		return true;
	}

	@EventHandler
	public void onAdminHit(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		//if (admin.contains(p.getName())) {
		if (adminhit.contains(p.getName())) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onAdminHitPlayer(EntityDamageByEntityEvent e) {
		Player p = (Player) e.getDamager();
		if (adminhit.contains(p.getName())) {
			e.setCancelled(true);
		}
		Player pp = (Player) e.getEntity();
		if (adminhit.contains(pp.getName())) {
			e.setCancelled(true);
			if (adminhit.contains(pp.getName())) {
				/*pp.sendMessage(ChatColor
						.translateAlternateColorCodes('&',
								plugin.getConfig().getString("Hit-Message", "&c! %name has hit you!"))
						.replace("%name", p.getName()));*/
				pp.sendMessage(ChatColor.translateAlternateColorCodes('&',plugin.getConfig().getString("Hit-Message"))
						.replace("%name%", p.getName()));
			}
		}
	}

	@EventHandler
	public void onAdminBlockBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if (admin.contains(p.getName())) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onAdminDrop(PlayerDropItemEvent e) {
		Player p = e.getPlayer();
		if (admin.contains(p.getName())) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onAdminPickup(PlayerPickupItemEvent e) {
		Player p = e.getPlayer();
		if (admin.contains(p.getName())) {
			e.setCancelled(true);
		}
	}
}
