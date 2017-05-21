package com.coolmark01.ccbeta.hitmessages;


import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main
  extends JavaPlugin
  implements Listener
{
  public void onEnable()
  {
    saveDefaultConfig();
    System.out.println("Made for: EndlessMC");
    getCommand("hitmessages").setExecutor(new Cmd());
    getCommand("staff").setExecutor(new Cmd());
    Bukkit.getServer().getPluginManager().registerEvents(new Cmd(this), this);
  }
  
  public void onDisable()
  {
    saveDefaultConfig();
  }
}
