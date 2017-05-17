package me.coolmark01.crown.ePearl;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class ePearlCooldown implements Listener {

	static HashMap<String, Integer> cooldown = new HashMap<String, Integer>();
	static HashMap<String, BukkitTask> cooldownTask = new HashMap<String, BukkitTask>();

	@EventHandler
	public void onUse(PlayerInteractEvent event) {
		if (!(event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR)) {
			return;
		}
		Player player = event.getPlayer();
		if (event.getItem() == null || event.getMaterial() == Material.AIR)
			return;
		if (!player.hasPermission("epearl.bypass")) { // Permission
			if (!(event.getMaterial() == Material.ENDER_PEARL)) { // If it is
																	// not an
																	// EPearl
				return;
			} else { // If it is a EPearl
				int seconds = Main.getPlugin().getConfig().getInt("Ender-Pearl-Second-Cooldown") + 1;
				if (!(cooldown.containsKey(player.getName()))) { // If player
																	// hasn't
																	// thrown
																	// EPearl
					cooldown.put(player.getName(), seconds); // Set Time
					cooldownTask.put(player.getName(), new BukkitRunnable() {
						@Override
						public void run() {
							if (cooldown.containsKey(player.getName())) {
								if (cooldown.get(player.getName()) == 1) {
									cooldown.remove(player.getName());
									cooldownTask.remove(player.getName());
									this.cancel();
								} else {
									cooldown.put(player.getName(), cooldown.get(player.getName()) - 1);
								}
							}
						}
					}.runTaskTimer(Main.getPlugin(), 0L, 20L));
				} else /* Can't throw because of timer */ {
					event.setCancelled(true);
					player.sendMessage(ChatColor
							.translateAlternateColorCodes('&',
									Main.getPlugin().getConfig().getString("Cooldown-Message"))
							.replaceAll("%time%", (cooldown.get(player.getName())).toString()));
					return;
				}

			}
		}
	}
}