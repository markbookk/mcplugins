package me.coolmark01.crown.motd;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {

	public static Core plugin;
	
	@Override
	public void onEnable() {
		getLogger().info(">>> Custom MOTD v " + getDescription().getVersion() + " has been initialized. <<<");
		plugin = this;
		FileConfiguration config = getConfig();
		config.options().copyDefaults(true);
		saveDefaultConfig();
		listeners();
		getCommand("mattmotd").setExecutor(new ReloadCommand());
		
	}
	
	public static Core getPlugin() {
		return plugin;
	}

	@Override
	public void onDisable() {
		getLogger().info(">>> Custom MOTD v " + getDescription().getVersion() + " has been disabled. <<<");
	}

	private void listeners() {
		getServer().getPluginManager().registerEvents(new onPing(), this);
	}
}
