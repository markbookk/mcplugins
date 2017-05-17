package me.tokyojack.shop;

import org.bukkit.ChatColor;
import org.bukkit.inventory.Inventory;

public class armortoolswepons
{
  public armortoolswepons() {}
  
  public static Inventory brewingMenu()
  {
    Inventory inv = org.bukkit.Bukkit.createInventory(null, 45, 
      ChatColor.GRAY + ChatColor.UNDERLINE.toString() + "Shop " + ChatColor.DARK_GRAY + 
      ChatColor.BOLD.toString() + "►" + ChatColor.RED + ChatColor.BOLD.toString() + "Wepons" + ChatColor.GRAY + "/" + ChatColor.GOLD + 
      ChatColor.BOLD + "Armor" + ChatColor.GRAY + "/" + ChatColor.YELLOW + ChatColor.BOLD + "Tools");
    
    org.bukkit.inventory.ItemStack fishingrod = new ItemBuilder(org.bukkit.Material.FISHING_ROD)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$50", 0)
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell", 1)
      .toItemStack();
    
    org.bukkit.inventory.ItemStack bow = new ItemBuilder(org.bukkit.Material.BOW)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$50", 0)
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell", 1)
      .toItemStack();
    
    org.bukkit.inventory.ItemStack ironsword = new ItemBuilder(org.bukkit.Material.IRON_SWORD)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$240", 0)
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "50", 1)
      .toItemStack();
    org.bukkit.inventory.ItemStack ironaxe = new ItemBuilder(org.bukkit.Material.IRON_AXE)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$360", 0)
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "75", 1)
      .toItemStack();
    
    org.bukkit.inventory.ItemStack ironspade = new ItemBuilder(org.bukkit.Material.IRON_SPADE)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$120", 0)
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "25", 1)
      .toItemStack();
    
    org.bukkit.inventory.ItemStack ironpicaxe = new ItemBuilder(org.bukkit.Material.IRON_PICKAXE)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "360", 0)
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "75", 1)
      .toItemStack();
    
    org.bukkit.inventory.ItemStack ironhoe = new ItemBuilder(org.bukkit.Material.IRON_HOE)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$240", 0)
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "50", 1)
      .toItemStack();
    
    org.bukkit.inventory.ItemStack diamondsword = new ItemBuilder(org.bukkit.Material.DIAMOND_SWORD)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$190", 0)
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "100", 1)
      .toItemStack();
    
    org.bukkit.inventory.ItemStack diamondaxe = new ItemBuilder(org.bukkit.Material.DIAMOND_AXE)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$190", 0)
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "100", 1)
      .toItemStack();
    
    org.bukkit.inventory.ItemStack diamondshovel = new ItemBuilder(org.bukkit.Material.DIAMOND_SPADE)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$190", 0)
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "100", 1)
      .toItemStack();
    
    org.bukkit.inventory.ItemStack diamondpickaxe = new ItemBuilder(org.bukkit.Material.DIAMOND_PICKAXE)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$190", 0)
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "100", 1)
      .toItemStack();
    
    org.bukkit.inventory.ItemStack diamondhoe = new ItemBuilder(org.bukkit.Material.DIAMOND_HOE)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$190", 0)
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "100", 1)
      .toItemStack();
    
    org.bukkit.inventory.ItemStack diamondhelmit = new ItemBuilder(org.bukkit.Material.DIAMOND_HELMET)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$1450", 0)
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "250", 1)
      .toItemStack();
    
    org.bukkit.inventory.ItemStack diamondchest = new ItemBuilder(org.bukkit.Material.DIAMOND_CHESTPLATE)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$2250", 0)
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "400", 1)
      .toItemStack();
    
    org.bukkit.inventory.ItemStack diamondpants = new ItemBuilder(org.bukkit.Material.DIAMOND_LEGGINGS)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$1960", 0)
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "350", 1)
      .toItemStack();
    
    org.bukkit.inventory.ItemStack diamondsboots = new ItemBuilder(org.bukkit.Material.DIAMOND_BOOTS)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$1120", 0)
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "200", 1)
      .toItemStack();
    

    inv.setItem(0, diamondsboots);
    inv.setItem(1, fishingrod);
    inv.setItem(2, bow);
    inv.setItem(3, ironsword);
    inv.setItem(4, ironaxe);
    inv.setItem(5, ironspade);
    inv.setItem(6, ironpicaxe);
    inv.setItem(7, ironhoe);
    inv.setItem(8, diamondsword);
    inv.setItem(9, diamondaxe);
    inv.setItem(10, diamondshovel);
    inv.setItem(11, diamondpickaxe);
    inv.setItem(12, diamondhoe);
    inv.setItem(13, diamondhelmit);
    inv.setItem(14, diamondchest);
    inv.setItem(15, diamondpants);
    

    return inv;
  }
}
