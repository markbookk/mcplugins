package me.coolmark01.McBukkit.GodMode;

import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {

	@Override
	public void onEnable() {
		getLogger().info(">> Tutorial v" + getDescription().getVersion() + " is enabled!<<");
		listeners();
		getCommand("godmode").setExecutor(new GodMode());
	}

	@Override
	public void onDisable() {
		getLogger().info(">> Tutorial v" + getDescription().getVersion() + " is disabled!<<");
	}

	private void listeners() {
		getServer().getPluginManager().registerEvents(new GodMode(this), this);
	}
}
