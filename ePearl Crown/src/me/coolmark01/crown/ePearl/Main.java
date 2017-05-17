package me.coolmark01.crown.ePearl;

import java.util.HashMap;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;


public class Main extends JavaPlugin {

	private static Main plugin;
	 
	@Override
	public void onEnable() {
		getLogger().info(">> Ender Pearl Cooldown v" + getDescription().getVersion() + " is enabled!<<");
		listeners();
	    ePearlCooldown.cooldown = new HashMap<String, Integer>();
	    ePearlCooldown.cooldownTask = new HashMap<String, BukkitTask>();
	    plugin = this;
	    FileConfiguration config = getConfig();
	    config.options().copyDefaults(true);
	    saveDefaultConfig();
	}
	
	 public static Main getPlugin() {
		  return plugin;
		 }

	@Override
	public void onDisable() {
		getLogger().info(">> Ender Pearl Cooldown v" + getDescription().getVersion() + " is disabled!<<");
	}

	private void listeners() {
		getServer().getPluginManager().registerEvents(new ePearlCooldown(), this);
	}
}
