package me.coolmark01.crown.stoneSworders;

import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {
	 
	@Override
	public void onEnable() {
		getLogger().info(">> Stone Sworders v" + getDescription().getVersion() + " is enabled!<<");
		listeners();
	}
	@Override
	public void onDisable() {
		getLogger().info(">> Stone Sworders v" + getDescription().getVersion() + " is disabled!<<");
	}

	private void listeners() {
		getServer().getPluginManager().registerEvents(new preventStoneSworders(), this);
	}
}
