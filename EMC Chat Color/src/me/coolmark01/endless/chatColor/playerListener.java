package me.coolmark01.endless.chatColor;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.PluginManager;

public class playerListener
  implements Listener
{
  public static Core main;
  
  public playerListener(Core m)
  {
    main = m;
    
    main.getServer().getPluginManager().registerEvents(this, main);
  }
  
  @EventHandler
  public void onClick(InventoryClickEvent e)
  {
    if (e.getInventory().getTitle() == "Chat Color")
    {
      Player player = (Player)e.getWhoClicked();
      if (e.getSlot() == 0) {
        if (player.hasPermission("endless.chatcolor.donator"))
        {
          main.getConfig().set(player.getName(), Integer.valueOf(1));
          main.saveConfig();
          player.sendMessage(ChatColor.GRAY + "You have changed your chat color!");
        }
        else
        {
          player.sendMessage("You do not have permissions to do this!");
        }
      }
      if (e.getSlot() == 1) {
        if (player.hasPermission("endless.chatcolor.vip"))
        {
          main.getConfig().set(player.getName(), Integer.valueOf(2));
          main.saveConfig();
          player.sendMessage(ChatColor.DARK_GRAY + "You have changed your chat color!");
        }
        else
        {
          player.sendMessage("You do not have permissions to do this!");
        }
      }
      if (e.getSlot() == 2) {
        if (player.hasPermission("endless.chatcolor.hero"))
        {
          main.getConfig().set(player.getName(), Integer.valueOf(3));
          main.saveConfig();
          player.sendMessage(ChatColor.GOLD + "You have changed your chat color!");
        }
        else
        {
          player.sendMessage("You do not have permissions to do this!");
        }
      }
      if (e.getSlot() == 3) {
        if (player.hasPermission("endless.chatcolor.saint"))
        {
          main.getConfig().set(player.getName(), Integer.valueOf(4));
          main.saveConfig();
          player.sendMessage(ChatColor.AQUA + "You have changed your chat color!");
        }
        else
        {
          player.sendMessage("You do not have permissions to do this!");
        }
      }
      if (e.getSlot() == 4) {
        if (player.hasPermission("endless.chatcolor.legend"))
        {
          main.getConfig().set(player.getName(), Integer.valueOf(5));
          main.saveConfig();
          player.sendMessage(ChatColor.GREEN + "You have changed your chat color!");
        }
        else
        {
          player.sendMessage("You do not have permissions to do this!");
        }
      }
      if (e.getSlot() == 5) {
        if (player.hasPermission("endless.chatcolor.god"))
        {
          main.getConfig().set(player.getName(), Integer.valueOf(6));
          main.saveConfig();
          player.sendMessage(ChatColor.DARK_PURPLE + "You have changed your chat color!");
        }
        else
        {
          player.sendMessage("You do not have permissions to do this!");
        }
      }
      if (e.getSlot() == 6) {
        if (player.hasPermission("endless.chatcolor.zeus"))
        {
          main.getConfig().set(player.getName(), Integer.valueOf(7));
          main.saveConfig();
          player.sendMessage(ChatColor.LIGHT_PURPLE + "You have changed your chat color!");
        }
        else
        {
          player.sendMessage("You do not have permissions to do this!");
        }
      }
      if (e.getSlot() == 7) {
        if (player.hasPermission("endless.chatcolor.immortal"))
        {
          main.getConfig().set(player.getName(), Integer.valueOf(8));
          main.saveConfig();
          player.sendMessage(ChatColor.DARK_GRAY + "You have changed your chat color!");
        }
        else
        {
          player.sendMessage("You do not have permissions to do this!");
        }
      }
      if (e.getSlot() == 8)
      {
        main.getConfig().set(player.getName(), Integer.valueOf(0));
        main.saveConfig();
        player.sendMessage("You have reset your chat color to white!");
      }
      e.setCancelled(true);
      player.closeInventory();
    }
  }
  
  @EventHandler
  public void onChat(AsyncPlayerChatEvent e)
  {
    if ((e.getMessage().contains("cchat owner") && e.getPlayer().hasPermission("cchat.owner"))) {
    	e.setCancelled(true);
    	main.getConfig().set(e.getPlayer().getName(), Integer.valueOf(9));
    	main.saveConfig();
    	e.getPlayer().sendMessage("" + ChatColor.RED + "You Chat Color has been reset to the Owner's color!");
    }
    switch (main.getConfig().getInt(e.getPlayer().getName()))
    {
    case 1: 
      e.setMessage(ChatColor.GRAY + e.getMessage());
    case 2: 
      e.setMessage(ChatColor.DARK_GRAY + e.getMessage());
    case 3: 
      e.setMessage(ChatColor.GOLD + e.getMessage());
    case 4: 
      e.setMessage(ChatColor.AQUA + e.getMessage());
    case 5: 
      e.setMessage(ChatColor.GREEN + e.getMessage());
    case 6: 
      e.setMessage(ChatColor.DARK_PURPLE + e.getMessage());
    case 7: 
      e.setMessage(ChatColor.LIGHT_PURPLE + e.getMessage());
    case 8: 
      e.setMessage(ChatColor.DARK_GRAY + e.getMessage());
    case 0: 
      e.setMessage(ChatColor.WHITE + e.getMessage());
    case 9:
      e.setMessage(ChatColor.DARK_RED + e.getMessage());
    }
  }
}
