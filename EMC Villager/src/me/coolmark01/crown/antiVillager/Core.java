package me.coolmark01.crown.antiVillager;

import org.bukkit.craftbukkit.Main;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {

	private static Main plugin;

	@Override
	public void onEnable() {
		getLogger().info(">> Anti Villager Trade v" + getDescription().getVersion() + " is enabled!<<");
		listeners();
	}

	@Override
	public void onDisable() {
		getLogger().info(">> Anti Villager Trade v" + getDescription().getVersion() + " is disabled!<<");
	}

	private void listeners() {
		getServer().getPluginManager().registerEvents(new AntiVillager(), this);
	}
}
