package me.tokyojack.shop;

import java.util.logging.Logger;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;

public class Core extends org.bukkit.plugin.java.JavaPlugin implements org.bukkit.command.CommandExecutor
{
  public static Economy economy = null;
  
  public Core() {}
  
  public static Core getPlugin() { return plugin; }
  

  private static Core plugin;
  public void onEnable()
  {
    plugin = this;
    
    getLogger().info(">>Plugin " + getDescription().getVersion() + "Is enabled!");
    
    getCommand("shop").setExecutor(this);
    getCommand("shops").setExecutor(this);
    
    getServer().getPluginManager().registerEvents(new InventoryClick(this), this);
    getServer().getPluginManager().registerEvents(new InventoryClose(this), this);
    
    if ((Bukkit.getPluginManager().getPlugin("Vault") == null) || 
      (!Bukkit.getPluginManager().getPlugin("Vault").isEnabled())) {
      Bukkit.getLogger().warning("Vault not found, so some features may not be available");
    } else {
      setupEconomy();
      Bukkit.getLogger().info("Vault has been found and hooked into successfully");
    }
  }
  
  public void onDisable()
  {
    getLogger().info(">>Plugin " + getDescription().getVersion() + "Is Disable!");
  }
  
  private boolean setupEconomy() {
    RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager()
      .getRegistration(Economy.class);
    if (economyProvider != null) {
      economy = (Economy)economyProvider.getProvider();
    }
    
    return economy != null;
  }
  
  public boolean onCommand(org.bukkit.command.CommandSender sender, Command command, String label, String[] args) {
    if ((!(sender instanceof Player)) && (
      (label.equalsIgnoreCase("shop")) || (label.equalsIgnoreCase("shops")))) {
      Player player = Bukkit.getPlayer(args[0]);
      player.openInventory(GUIClass.mainMenu());
    }
    
    if ((sender instanceof Player)) {
      Player player = (Player)sender;
      if ((label.equalsIgnoreCase("shop")) || (label.equalsIgnoreCase("shops"))) {
        if (player.hasPermission("shopgui.shop")) {
          player.openInventory(GUIClass.mainMenu());
          return true;
        }
        player.performCommand("warp Shop");
        return true;
      }
    }
    
    return false;
  }
}
