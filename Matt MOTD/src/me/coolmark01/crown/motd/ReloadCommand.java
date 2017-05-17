package me.coolmark01.crown.motd;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (cmd.getName().equalsIgnoreCase("mattmotd")) {
			if (sender.hasPermission("mattmotd.reload")) {
				if (args.length == 1) {
					if (args[0].equalsIgnoreCase("reload")) {
						Core.getPlugin().reloadConfig();
						sender.sendMessage(ChatColor.RED + "The MOTD Plugin has been reloaded!");
					}
				}
			}

		}
		return false;

	}

}
