package me.coolmark01.endless.chatColor;

import me.coolmark01.endless.chatColor.playerListener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.FileConfigurationOptions;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Core
  extends JavaPlugin
{
  public static Inventory inv;
  
  public void onEnable()
  {
    new playerListener(this);
    
    getConfig().options().copyDefaults();
    
    saveDefaultConfig();
  }
  
  public void onDisable() {}
  
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
  {
    Player player = (Player)sender;
    inv = Bukkit.createInventory(player, 9, "Chat Color");
    
    ItemStack Donator = new ItemStack(Material.WOOL, 1, (short)7);
    ItemStack VIP = new ItemStack(Material.WOOL, 1, (short)8);
    ItemStack Hero = new ItemStack(Material.WOOL, 1, DyeColor.ORANGE.getData());
    ItemStack Saint = new ItemStack(Material.WOOL, 1, DyeColor.LIGHT_BLUE.getData());
    ItemStack Legend = new ItemStack(Material.WOOL, 1, DyeColor.LIME.getData());
    ItemStack God = new ItemStack(Material.WOOL, 1, DyeColor.PURPLE.getData());
    ItemStack Zeus = new ItemStack(Material.WOOL, 1, DyeColor.PINK.getData());
    ItemStack Immortal = new ItemStack(Material.WOOL, 1, DyeColor.GRAY.getData());
    ItemStack Mortal = new ItemStack(Material.WOOL);
    
    setName(Donator, "Dark gray");
    setName(VIP, "Light gray");
    setName(Hero, "Orange");
    setName(Saint, "Light blue");
    setName(Legend, "Lime");
    setName(God, "Purple");
    setName(Zeus, "Pink");
    setName(Immortal, "Dark gray");
    setName(Mortal, "White");
    
    inv.setItem(0, Donator);
    inv.setItem(1, VIP);
    inv.setItem(2, Hero);
    inv.setItem(3, Saint);
    inv.setItem(4, Legend);
    inv.setItem(5, God);
    inv.setItem(6, Zeus);
    inv.setItem(7, Immortal);
    inv.setItem(8, Mortal);
    player.openInventory(inv);
    
    return true;
  }
  
  public ItemStack setName(ItemStack is, String name)
  {
    ItemMeta m = is.getItemMeta();
    m.setDisplayName(name);
    is.setItemMeta(m);
    return is;
  }
}
