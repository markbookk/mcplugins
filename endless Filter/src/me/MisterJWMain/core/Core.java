package me.MisterJWMain.core;

import java.util.Arrays;

import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {
	
	public void onEnable(){
		
		if(getConfig().getStringList("FilterWords").isEmpty()){
			
			getConfig().set("FilterWords", Arrays.asList("banana", "fork"));
			getConfig().set("Message", "&4Do not cuss on this server");
			saveConfig();
			
		}
		
		new playerListener(this);
		
	}
	
	public void onDisable(){
		
	}
	
	
	
}
