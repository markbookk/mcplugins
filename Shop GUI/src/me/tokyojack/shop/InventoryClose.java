package me.tokyojack.shop;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.scheduler.BukkitScheduler;

public class InventoryClose implements org.bukkit.event.Listener
{
  public InventoryClose(Core core) {}
  
  @org.bukkit.event.EventHandler
  public void onInventoryClick(InventoryCloseEvent event)
  {
    String name = ChatColor.stripColor(event.getInventory().getName());
    final Player player = (Player)event.getPlayer();
    
    if (name.equals(ChatColor.stripColor(GUIClass.armorweponsyoolsMenu().getName()))) {
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Core.getPlugin(), new Runnable()
      {
        public void run() {
          player.closeInventory();
          player.openInventory(GUIClass.mainMenu());
        }
        
      }, 5L);
    }
    if (name.equals(ChatColor.stripColor(GUIClass.blockMenu().getName()))) {
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Core.getPlugin(), new Runnable()
      {
        public void run() {
          player.closeInventory();
          player.openInventory(GUIClass.mainMenu());
        }
        
      }, 5L);
    }
    if (name.equals(ChatColor.stripColor(GUIClass.brewingMenu().getName()))) {
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Core.getPlugin(), new Runnable()
      {
        public void run() {
          player.closeInventory();
          player.openInventory(GUIClass.mainMenu());
        }
        
      }, 5L);
    }
    if (name.equals(ChatColor.stripColor(GUIClass.mobDrops().getName()))) {
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Core.getPlugin(), new Runnable()
      {
        public void run() {
          player.closeInventory();
          player.openInventory(GUIClass.mainMenu());
        }
        
      }, 5L);
    }
    if (name.equals(ChatColor.stripColor(GUIClass.oreMenu().getName()))) {
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Core.getPlugin(), new Runnable()
      {
        public void run() {
          player.closeInventory();
          player.openInventory(GUIClass.mainMenu());
        }
        
      }, 5L);
    }
    if (name.equals(ChatColor.stripColor(GUIClass.plantsFoodMenu().getName()))) {
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Core.getPlugin(), new Runnable()
      {
        public void run() {
          player.closeInventory();
          player.openInventory(GUIClass.mainMenu());
        }
        

      }, 5L);
    }
    if (name.equals(ChatColor.stripColor(GUIClass.spawnerMenu().getName()))) {
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Core.getPlugin(), new Runnable()
      {
        public void run() {
          player.closeInventory();
          player.openInventory(GUIClass.mainMenu());
        }
        
      }, 5L);
    }
    
    if (name.equals(ChatColor.stripColor(GUIClass.cannonMenu().getName()))) {
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Core.getPlugin(), new Runnable()
      {
        public void run() {
          player.closeInventory();
          player.openInventory(GUIClass.vipchooseMenu());
        }
        

      }, 5L);
    }
    
    if (name.equals(ChatColor.stripColor(GUIClass.donatorMenu().getName()))) {
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Core.getPlugin(), new Runnable()
      {
        public void run() {
          player.closeInventory();
          player.openInventory(GUIClass.vipchooseMenu());
        }
        
      }, 5L);
    }
  }
}
