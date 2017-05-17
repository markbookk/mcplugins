package me.coolmark01.crown.stoneSworders;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class preventStoneSworders implements Listener {

	@EventHandler
	public void onUse(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player) {
			Player p = (Player) e.getDamager();
			if (e.getDamage() != 0) {
				if (p.getItemInHand().getType() ==Material.STONE_SWORD && p.getItemInHand().getType() != null) {
					//p.sendMessage("" + p.getItemInHand().getType().toString());
					e.setDamage(1);
				} else
					return;
			} else
				return;
		} else
			return;
	}
}
