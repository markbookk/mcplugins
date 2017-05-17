package me.coolmark01.crown.antiVillager;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class AntiVillager implements Listener {
	@EventHandler
	public void onUse(PlayerInteractEntityEvent e) {
		Player p = e.getPlayer();
		if (e.getRightClicked().getType() != EntityType.VILLAGER)
			return;
		e.setCancelled(true);
		p.sendMessage(ChatColor.RED + "You can't use villager trading!");
		p.playSound(p.getLocation(), Sound.ANVIL_LAND, 1, 2);
	}
}
