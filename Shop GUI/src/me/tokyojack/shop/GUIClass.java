package me.tokyojack.shop;

import org.bukkit.ChatColor;
import org.bukkit.inventory.Inventory;

public class GUIClass
{
  public GUIClass() {}
  
  public static Inventory mainMenu()
  {
    Inventory inv = org.bukkit.Bukkit.createInventory(null, 27, ChatColor.DARK_AQUA + ChatColor.UNDERLINE.toString() + "Shop");
    
    org.bukkit.inventory.ItemStack weponsarmortools = new ItemBuilder(org.bukkit.Material.IRON_AXE)
      .setName(ChatColor.RED + ChatColor.BOLD.toString() + "Weapons" + ChatColor.GRAY + "/" + ChatColor.GOLD + 
      ChatColor.BOLD + "Armor" + ChatColor.GRAY + "/" + ChatColor.YELLOW + ChatColor.BOLD + "Tools")
      .toItemStack();
    
    org.bukkit.inventory.ItemStack ore = new ItemBuilder(org.bukkit.Material.COAL_ORE).setName(ChatColor.BLUE + ChatColor.BOLD.toString() + "Ore")
      .toItemStack();
    
    org.bukkit.inventory.ItemStack MobItems = new ItemBuilder(org.bukkit.Material.STRING)
      .setName(ChatColor.GRAY + ChatColor.BOLD.toString() + "Mob Drops").toItemStack();
    
    org.bukkit.inventory.ItemStack Brewing = new ItemBuilder(org.bukkit.Material.BREWING_STAND_ITEM)
      .setName(ChatColor.DARK_PURPLE + ChatColor.BOLD.toString() + "Brewing").toItemStack();
    
    org.bukkit.inventory.ItemStack spawner = new ItemBuilder(org.bukkit.Material.MOB_SPAWNER)
      .setName(ChatColor.YELLOW + ChatColor.BOLD.toString() + "Mob Spawners").toItemStack();
    
    org.bukkit.inventory.ItemStack plantsfood = new ItemBuilder(org.bukkit.Material.YELLOW_FLOWER).setName(ChatColor.RED + ChatColor.BOLD.toString() + 
      "Plants" + ChatColor.GRAY + "/" + ChatColor.GREEN + ChatColor.BOLD + "Food").toItemStack();
    
    org.bukkit.inventory.ItemStack blocks = new ItemBuilder(org.bukkit.Material.GRASS)
      .setName(ChatColor.AQUA + ChatColor.BOLD.toString() + "Blocks").toItemStack();
    
    org.bukkit.inventory.ItemStack vipshop = new ItemBuilder(org.bukkit.Material.GOLD_INGOT)
      .setName(ChatColor.GOLD + ChatColor.BOLD.toString() + "VIP " + ChatColor.GOLD + ChatColor.BOLD + "Shop")
      .addLoreLine(ChatColor.RED + ChatColor.ITALIC.toString() + "Only for players with " + ChatColor.GRAY + 
      ChatColor.UNDERLINE.toString() + "Knight Rank or higher")
      .addLoreLine(ChatColor.RED + ChatColor.ITALIC.toString() + "may open this menu").toItemStack();
    
    org.bukkit.inventory.ItemStack tip2 = new ItemBuilder(org.bukkit.Material.BANNER).setName(ChatColor.GOLD + ChatColor.BOLD.toString() + "Tip")
      .addLoreLine(ChatColor.DARK_GRAY + "#1: " + ChatColor.GRAY + "Use " + ChatColor.GRAY + 
      ChatColor.ITALIC.toString() + "Shift Click " + ChatColor.GRAY + 
      "to sell a stack or less when selling!")
      .addLoreLine(ChatColor.DARK_GRAY + "#1: " + ChatColor.GRAY + "Use " + ChatColor.GRAY + 
      ChatColor.ITALIC.toString() + "Shift Click " + ChatColor.GRAY + 
      "to buy the max amount when buying!")
      .toItemStack();
    

    org.bukkit.inventory.ItemStack frame = new ItemBuilder(org.bukkit.Material.STAINED_GLASS_PANE).setName(" ").setDyeColor(org.bukkit.DyeColor.CYAN)
      .toItemStack();
    
    inv.setItem(0, frame);
    inv.setItem(1, frame);
    inv.setItem(2, frame);
    inv.setItem(3, frame);
    inv.setItem(4, frame);
    inv.setItem(5, frame);
    inv.setItem(6, frame);
    inv.setItem(7, frame);
    inv.setItem(8, frame);
    
    inv.setItem(18, tip2);
    inv.setItem(19, frame);
    inv.setItem(20, frame);
    inv.setItem(21, frame);
    inv.setItem(22, frame);
    inv.setItem(23, frame);
    inv.setItem(24, frame);
    inv.setItem(25, frame);
    
    inv.setItem(9, frame);
    inv.setItem(17, frame);
    


    inv.setItem(10, blocks);
    inv.setItem(11, plantsfood);
    inv.setItem(12, weponsarmortools);
    inv.setItem(13, ore);
    inv.setItem(14, MobItems);
    inv.setItem(15, Brewing);
    inv.setItem(16, spawner);
    
    inv.setItem(26, vipshop);
    
    return inv;
  }
  
  public static Inventory vipchooseMenu() {
    Inventory inv = org.bukkit.Bukkit.createInventory(null, 27, ChatColor.DARK_AQUA + ChatColor.UNDERLINE.toString() + "Shop" + 
      ChatColor.BOLD.toString() + " ►" + ChatColor.GOLD + ChatColor.BOLD.toString() + " Vip Menu");
    
    org.bukkit.inventory.ItemStack donator = new ItemBuilder(org.bukkit.Material.EMERALD)
      .setName(ChatColor.DARK_GREEN + ChatColor.BOLD.toString() + "Donator Shop").toItemStack();
    
    org.bukkit.inventory.ItemStack cannon = new ItemBuilder(org.bukkit.Material.TNT)
      .setName(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "Cannon Shop")
      .addLoreLine(ChatColor.RED + ChatColor.ITALIC.toString() + "Only for players with " + ChatColor.GRAY + 
      ChatColor.UNDERLINE.toString() + "Legend Rank or higher")
      .addLoreLine(ChatColor.RED + ChatColor.ITALIC.toString() + " may open this menu").toItemStack();
    
    org.bukkit.inventory.ItemStack frame = new ItemBuilder(org.bukkit.Material.STAINED_GLASS_PANE).setName(" ").setDyeColor(org.bukkit.DyeColor.MAGENTA)
      .toItemStack();
    
    inv.setItem(0, frame);
    inv.setItem(1, frame);
    inv.setItem(2, frame);
    inv.setItem(3, frame);
    inv.setItem(4, frame);
    inv.setItem(5, frame);
    inv.setItem(6, frame);
    inv.setItem(7, frame);
    inv.setItem(8, frame);
    
    inv.setItem(18, frame);
    inv.setItem(19, frame);
    inv.setItem(20, frame);
    inv.setItem(21, frame);
    inv.setItem(22, frame);
    inv.setItem(23, frame);
    inv.setItem(24, frame);
    inv.setItem(25, frame);
    inv.setItem(26, frame);
    
    inv.setItem(9, frame);
    inv.setItem(17, frame);
    
    inv.setItem(11, donator);
    inv.setItem(15, cannon);
    
    return inv;
  }
  
  public static Inventory cannonMenu() {
    Inventory inv = org.bukkit.Bukkit.createInventory(null, 45, 
      ChatColor.GRAY + ChatColor.UNDERLINE.toString() + "Shop" + ChatColor.DARK_GRAY + 
      ChatColor.BOLD.toString() + " ►" + ChatColor.DARK_RED + ChatColor.BOLD.toString() + 
      " Cannon Shop");
    
    org.bukkit.inventory.ItemStack water = new ItemBuilder(org.bukkit.Material.WATER_BUCKET)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$800")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + 
      ChatColor.ITALIC.toString() + "Cannot Sell")
      .setItemAmount(16).toItemStack();
    org.bukkit.inventory.ItemStack redstone = new ItemBuilder(org.bukkit.Material.REDSTONE)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$400")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + 
      ChatColor.ITALIC.toString() + "Cannot Sell")
      .setItemAmount(32).toItemStack();
    org.bukkit.inventory.ItemStack reapeater = new ItemBuilder(org.bukkit.Material.DIODE)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$1600")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + 
      ChatColor.ITALIC.toString() + "Cannot Sell")
      .setItemAmount(16).toItemStack();
    org.bukkit.inventory.ItemStack comparitor = new ItemBuilder(org.bukkit.Material.REDSTONE_COMPARATOR)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$1600")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + 
      ChatColor.ITALIC.toString() + "Cannot Sell")
      .setItemAmount(16).toItemStack();
    org.bukkit.inventory.ItemStack redstonetorch = new ItemBuilder(org.bukkit.Material.REDSTONE_TORCH_ON)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$800")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + 
      ChatColor.ITALIC.toString() + "Cannot Sell")
      .setItemAmount(32).toItemStack();
    org.bukkit.inventory.ItemStack lever = new ItemBuilder(org.bukkit.Material.LEVER)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$500")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + 
      ChatColor.ITALIC.toString() + "Cannot Sell")
      .setItemAmount(8).toItemStack();
    
    org.bukkit.inventory.ItemStack redstoneblock = new ItemBuilder(org.bukkit.Material.REDSTONE_BLOCK)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$1200")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + 
      ChatColor.ITALIC.toString() + "Cannot Sell")
      .setItemAmount(1).toItemStack();
    org.bukkit.inventory.ItemStack ice = new ItemBuilder(org.bukkit.Material.ICE)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$800")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + 
      ChatColor.ITALIC.toString() + "Cannot Sell")
      .setItemAmount(32).toItemStack();
    org.bukkit.inventory.ItemStack stickypiston = new ItemBuilder(org.bukkit.Material.PISTON_STICKY_BASE)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$1600")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + 
      ChatColor.ITALIC.toString() + "Cannot Sell")
      .setItemAmount(16).toItemStack();
    org.bukkit.inventory.ItemStack piston = new ItemBuilder(org.bukkit.Material.PISTON_BASE)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$1600")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + 
      ChatColor.ITALIC.toString() + "Cannot Sell")
      .setItemAmount(16).toItemStack();
    org.bukkit.inventory.ItemStack tnt = new ItemBuilder(org.bukkit.Material.TNT)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$2000")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + 
      ChatColor.ITALIC.toString() + "Cannot Sell")
      .setItemAmount(64).toItemStack();
    org.bukkit.inventory.ItemStack ladder = new ItemBuilder(org.bukkit.Material.LADDER)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$500")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + 
      ChatColor.ITALIC.toString() + "Cannot Sell")
      .setItemAmount(32).toItemStack();
    
    org.bukkit.inventory.ItemStack button = new ItemBuilder(org.bukkit.Material.STONE_BUTTON)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$500")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + 
      ChatColor.ITALIC.toString() + "Cannot Sell")
      .setItemAmount(32).toItemStack();
    
    org.bukkit.inventory.ItemStack trapdoor = new ItemBuilder(org.bukkit.Material.TRAP_DOOR)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$500")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + 
      ChatColor.ITALIC.toString() + "Cannot Sell")
      .setItemAmount(32).toItemStack();
    
    org.bukkit.inventory.ItemStack dropper = new ItemBuilder(org.bukkit.Material.DROPPER)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$3200")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + 
      ChatColor.ITALIC.toString() + "Cannot Sell")
      .setItemAmount(32).toItemStack();
    org.bukkit.inventory.ItemStack dispenser = new ItemBuilder(org.bukkit.Material.DISPENSER)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$3200")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + 
      ChatColor.ITALIC.toString() + "Cannot Sell")
      .setItemAmount(32).toItemStack();
    org.bukkit.inventory.ItemStack glass = new ItemBuilder(org.bukkit.Material.GLASS)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$100")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + 
      ChatColor.ITALIC.toString() + "Cannot Sell")
      .setItemAmount(32).toItemStack();
    org.bukkit.inventory.ItemStack web = new ItemBuilder(org.bukkit.Material.WEB)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$100")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + 
      ChatColor.ITALIC.toString() + "Cannot Sell")
      .setItemAmount(32).toItemStack();
    org.bukkit.inventory.ItemStack sand = new ItemBuilder(org.bukkit.Material.SAND)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$75")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + 
      ChatColor.ITALIC.toString() + "Cannot Sell")
      .setItemAmount(32).toItemStack();
    org.bukkit.inventory.ItemStack redsand = new ItemBuilder(new org.bukkit.inventory.ItemStack(org.bukkit.Material.SAND, 1, (short)1))
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$75")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + 
      ChatColor.ITALIC.toString() + "Cannot Sell")
      .setItemAmount(32).toItemStack();
    
    org.bukkit.inventory.ItemStack frame = new ItemBuilder(org.bukkit.Material.STAINED_GLASS_PANE).setName(" ").setDyeColor(org.bukkit.DyeColor.RED)
      .toItemStack();
    
    inv.setItem(0, frame);
    inv.setItem(1, frame);
    inv.setItem(2, frame);
    inv.setItem(3, frame);
    inv.setItem(4, frame);
    inv.setItem(5, frame);
    inv.setItem(6, frame);
    inv.setItem(7, frame);
    inv.setItem(8, frame);
    inv.setItem(9, frame);
    inv.setItem(18, frame);
    inv.setItem(27, frame);
    inv.setItem(17, frame);
    inv.setItem(26, frame);
    inv.setItem(35, frame);
    inv.setItem(36, frame);
    inv.setItem(37, frame);
    inv.setItem(38, frame);
    inv.setItem(39, frame);
    inv.setItem(40, frame);
    inv.setItem(41, frame);
    inv.setItem(42, frame);
    inv.setItem(43, frame);
    inv.setItem(44, frame);
    
    inv.setItem(10, water);
    inv.setItem(11, redstone);
    inv.setItem(12, reapeater);
    inv.setItem(13, comparitor);
    inv.setItem(14, redstonetorch);
    inv.setItem(15, redstoneblock);
    inv.setItem(16, lever);
    inv.setItem(19, stickypiston);
    inv.setItem(20, piston);
    inv.setItem(21, tnt);
    inv.setItem(22, ladder);
    inv.setItem(23, ice);
    inv.setItem(24, button);
    inv.setItem(25, trapdoor);
    inv.setItem(28, dropper);
    inv.setItem(29, dispenser);
    inv.setItem(30, glass);
    inv.setItem(31, web);
    inv.setItem(32, sand);
    inv.setItem(33, redsand);
    
    return inv;
  }
  
  public static Inventory donatorMenu() {
    Inventory inv = org.bukkit.Bukkit.createInventory(null, 36, 
      ChatColor.DARK_AQUA + ChatColor.UNDERLINE.toString() + "Shop" + ChatColor.DARK_GRAY + 
      ChatColor.BOLD.toString() + " ►" + ChatColor.DARK_GREEN + ChatColor.BOLD.toString() + 
      " Donator Shop");
    org.bukkit.inventory.ItemStack cobblestone = new ItemBuilder(org.bukkit.Material.COBBLESTONE)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$1800")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + 
      ChatColor.ITALIC.toString() + "Cannot Sell")
      .setItemAmount(64).toItemStack();
    org.bukkit.inventory.ItemStack obsidian = new ItemBuilder(org.bukkit.Material.OBSIDIAN)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$750")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + 
      ChatColor.ITALIC.toString() + "Cannot Sell")
      .setItemAmount(64).toItemStack();
    org.bukkit.inventory.ItemStack waterbucket = new ItemBuilder(org.bukkit.Material.WATER_BUCKET)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$50")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + 
      ChatColor.ITALIC.toString() + "Cannot Sell")
      .toItemStack();
    org.bukkit.inventory.ItemStack lavabucket = new ItemBuilder(org.bukkit.Material.LAVA_BUCKET)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$5000")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + 
      ChatColor.ITALIC.toString() + "Cannot Sell")
      .toItemStack();
    org.bukkit.inventory.ItemStack cocoabeans = new ItemBuilder(new org.bukkit.inventory.ItemStack(org.bukkit.Material.COCOA, 64, (short)3))
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$5000")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + 
      ChatColor.ITALIC.toString() + "Cannot Sell")
      .toItemStack();
    org.bukkit.inventory.ItemStack Bowl = new ItemBuilder(org.bukkit.Material.BOWL)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$400")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + 
      ChatColor.ITALIC.toString() + "Cannot Sell")
      .setItemAmount(64).toItemStack();
    
    org.bukkit.inventory.ItemStack flintandsteel = new ItemBuilder(org.bukkit.Material.FLINT_AND_STEEL)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$250")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + 
      ChatColor.ITALIC.toString() + "Cannot Sell")
      .toItemStack();
    org.bukkit.inventory.ItemStack sponge = new ItemBuilder(org.bukkit.Material.SPONGE)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$500")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + 
      ChatColor.ITALIC.toString() + "Cannot Sell")
      .setItemAmount(64).toItemStack();
    org.bukkit.inventory.ItemStack tnt = new ItemBuilder(org.bukkit.Material.TNT)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$2000")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + 
      ChatColor.ITALIC.toString() + "Cannot Sell")
      .setItemAmount(64).toItemStack();
    org.bukkit.inventory.ItemStack hopper = new ItemBuilder(org.bukkit.Material.HOPPER)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$150")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + 
      ChatColor.ITALIC.toString() + "Cannot Sell")
      .setItemAmount(1).toItemStack();
    org.bukkit.inventory.ItemStack gapple = new ItemBuilder(new org.bukkit.inventory.ItemStack(org.bukkit.Material.GOLDEN_APPLE, 1, (short)1))
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$12500")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + 
      ChatColor.ITALIC.toString() + "Cannot Sell")
      .toItemStack();
    org.bukkit.inventory.ItemStack goldenapple = new ItemBuilder(org.bukkit.Material.GOLDEN_APPLE)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$600")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + 
      ChatColor.ITALIC.toString() + "Cannot Sell")
      .toItemStack();
    org.bukkit.inventory.ItemStack xpbottle = new ItemBuilder(org.bukkit.Material.EXP_BOTTLE)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$5000")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + 
      ChatColor.ITALIC.toString() + "Cannot Sell")
      .setItemAmount(16).toItemStack();
    org.bukkit.inventory.ItemStack ceggs = new ItemBuilder(new org.bukkit.inventory.ItemStack(org.bukkit.Material.MONSTER_EGG, 1, (short)50))
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$50000")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + 
      ChatColor.ITALIC.toString() + "Cannot Sell")
      .toItemStack();
    
    org.bukkit.inventory.ItemStack frame = new ItemBuilder(org.bukkit.Material.STAINED_GLASS_PANE).setName(" ").setDyeColor(org.bukkit.DyeColor.LIME)
      .toItemStack();
    
    inv.setItem(0, frame);
    inv.setItem(1, frame);
    inv.setItem(2, frame);
    inv.setItem(3, frame);
    inv.setItem(4, frame);
    inv.setItem(5, frame);
    inv.setItem(6, frame);
    inv.setItem(7, frame);
    inv.setItem(8, frame);
    inv.setItem(9, frame);
    inv.setItem(18, frame);
    inv.setItem(17, frame);
    inv.setItem(26, frame);
    inv.setItem(27, frame);
    inv.setItem(28, frame);
    inv.setItem(29, frame);
    inv.setItem(30, frame);
    inv.setItem(31, frame);
    inv.setItem(32, frame);
    inv.setItem(33, frame);
    inv.setItem(34, frame);
    inv.setItem(35, frame);
    
    inv.setItem(10, cobblestone);
    inv.setItem(11, obsidian);
    inv.setItem(12, lavabucket);
    inv.setItem(13, waterbucket);
    inv.setItem(14, cocoabeans);
    inv.setItem(15, Bowl);
    inv.setItem(16, flintandsteel);
    inv.setItem(19,sponge);
    inv.setItem(20, tnt);
    inv.setItem(21, hopper);
    inv.setItem(22, gapple);
    inv.setItem(23, goldenapple);
    inv.setItem(24, xpbottle);
    inv.setItem(25, ceggs);
    
    return inv;
  }
  
  public static Inventory spawnerMenu() {
    Inventory inv = org.bukkit.Bukkit.createInventory(null, 54, 
      ChatColor.DARK_AQUA + ChatColor.UNDERLINE.toString() + "Shop" + ChatColor.DARK_GRAY + 
      ChatColor.BOLD.toString() + " ►" + ChatColor.YELLOW + ChatColor.BOLD.toString() + 
      " Spawners");
    
    org.bukkit.inventory.ItemStack pig = new ItemBuilder(new org.bukkit.inventory.ItemStack(org.bukkit.Material.MOB_SPAWNER))
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$100000")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell")
      .setName(ChatColor.translateAlternateColorCodes('&', "&7&l[&e&lPig&7&l] &aSpawner")).toItemStack();
    org.bukkit.inventory.ItemStack chicken = new ItemBuilder(new org.bukkit.inventory.ItemStack(org.bukkit.Material.MOB_SPAWNER))
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$100000")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell")
      .setName(ChatColor.translateAlternateColorCodes('&', "&7&l[&e&lChicken&7&l] &aSpawner")).toItemStack();
    
//    org.bukkit.inventory.ItemStack wolf = new ItemBuilder(new org.bukkit.inventory.ItemStack(org.bukkit.Material.MOB_SPAWNER))
//      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$45000")
//      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
//      "Cannot Sell")
//      .setName(ChatColor.translateAlternateColorCodes('&', "&7&l[&e&lWolf&7&l] &aSpawner")).toItemStack();
    
//    org.bukkit.inventory.ItemStack ocelot = new ItemBuilder(new org.bukkit.inventory.ItemStack(org.bukkit.Material.MOB_SPAWNER))
//      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$200000")
//      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
//      "Cannot Sell")
//      .setName(ChatColor.translateAlternateColorCodes('&', "&7&l[&e&lOcelot&7&l] &aSpawner")).toItemStack();
    
//    org.bukkit.inventory.ItemStack sheep = new ItemBuilder(new org.bukkit.inventory.ItemStack(org.bukkit.Material.MOB_SPAWNER))
//      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$65000")
//      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
//      "Cannot Sell")
//      .setName(ChatColor.translateAlternateColorCodes('&', "&7&l[&e&lSheep&7&l] &aSpawner")).toItemStack();
    
//    org.bukkit.inventory.ItemStack horse = new ItemBuilder(new org.bukkit.inventory.ItemStack(org.bukkit.Material.MOB_SPAWNER))
//      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$70000")
//      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
//      "Cannot Sell")
//      .setName(ChatColor.translateAlternateColorCodes('&', "&7&l[&e&lHorse&7&l] &aSpawner")).toItemStack();
    
    org.bukkit.inventory.ItemStack cavespider = new ItemBuilder(new org.bukkit.inventory.ItemStack(org.bukkit.Material.MOB_SPAWNER))
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$80000")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell")
      .setName(ChatColor.translateAlternateColorCodes('&', "&7&l[&e&lCave Spider&7&l] &aSpawner"))
      .toItemStack();
    
    org.bukkit.inventory.ItemStack spider = new ItemBuilder(new org.bukkit.inventory.ItemStack(org.bukkit.Material.MOB_SPAWNER))
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$100000")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell")
      .setName(ChatColor.translateAlternateColorCodes('&', "&7&l[&e&lSpider&7&l] &aSpawner")).toItemStack();
    
    org.bukkit.inventory.ItemStack Skeleton = new ItemBuilder(new org.bukkit.inventory.ItemStack(org.bukkit.Material.MOB_SPAWNER))
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$200000")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell")
      .setName(ChatColor.translateAlternateColorCodes('&', "&7&l[&e&lSkeleton&7&l] &aSpawner")).toItemStack();
    
    org.bukkit.inventory.ItemStack zombie = new ItemBuilder(new org.bukkit.inventory.ItemStack(org.bukkit.Material.MOB_SPAWNER))
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$150000")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell")
      .setName(ChatColor.translateAlternateColorCodes('&', "&7&l[&e&lZombie&7&l] &aSpawner")).toItemStack();
    
    org.bukkit.inventory.ItemStack cow = new ItemBuilder(new org.bukkit.inventory.ItemStack(org.bukkit.Material.MOB_SPAWNER))
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$200000")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell")
      .setName(ChatColor.translateAlternateColorCodes('&', "&7&l[&e&lCow&7&l] &aSpawner")).toItemStack();
    
    org.bukkit.inventory.ItemStack mushroomcow = new ItemBuilder(new org.bukkit.inventory.ItemStack(org.bukkit.Material.MOB_SPAWNER))
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$250000")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell")
      .setName(ChatColor.translateAlternateColorCodes('&', "&7&l[&e&lMooshroom&7&l] &aSpawner"))
      .toItemStack();
    
    org.bukkit.inventory.ItemStack squid = new ItemBuilder(new org.bukkit.inventory.ItemStack(org.bukkit.Material.MOB_SPAWNER))
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$200000")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell")
      .setName(ChatColor.translateAlternateColorCodes('&', "&7&l[&e&lSquid&7&l] &aSpawner")).toItemStack();
    
    org.bukkit.inventory.ItemStack witch = new ItemBuilder(new org.bukkit.inventory.ItemStack(org.bukkit.Material.MOB_SPAWNER))
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$250000")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell")
      .setName(ChatColor.translateAlternateColorCodes('&', "&7&l[&e&lWitch&7&l] &aSpawner")).toItemStack();
    
//    org.bukkit.inventory.ItemStack guardian = new ItemBuilder(new org.bukkit.inventory.ItemStack(org.bukkit.Material.MOB_SPAWNER))
//      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$400000")
//      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
//      "Cannot Sell")
//      .setName(ChatColor.translateAlternateColorCodes('&', "&7&l[&e&lGuardian&7&l] &aSpawner")).toItemStack();
    
//    org.bukkit.inventory.ItemStack villager = new ItemBuilder(new org.bukkit.inventory.ItemStack(org.bukkit.Material.MOB_SPAWNER))
//      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$425000")
//      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
//      "Cannot Sell")
//      .setName(ChatColor.translateAlternateColorCodes('&', "&7&l[&e&lVillager&7&l] &aSpawner")).toItemStack();
//    
//    org.bukkit.inventory.ItemStack Enderman = new ItemBuilder(new org.bukkit.inventory.ItemStack(org.bukkit.Material.MOB_SPAWNER))
//      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$500000")
//      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
//      "Cannot Sell")
//      .setName(ChatColor.translateAlternateColorCodes('&', "&7&l[&e&lEnderman&7&l] &aSpawner")).toItemStack();
    
    org.bukkit.inventory.ItemStack creeper = new ItemBuilder(new org.bukkit.inventory.ItemStack(org.bukkit.Material.MOB_SPAWNER))
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$500000")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell")
      .setName(ChatColor.translateAlternateColorCodes('&', "&7&l[&e&lCreeper&7&l] &aSpawner")).toItemStack();
    
    org.bukkit.inventory.ItemStack blaze = new ItemBuilder(new org.bukkit.inventory.ItemStack(org.bukkit.Material.MOB_SPAWNER))
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$500000")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell")
      .setName(ChatColor.translateAlternateColorCodes('&', "&7&l[&e&lBlaze&7&l] &aSpawner")).toItemStack();
    
//    org.bukkit.inventory.ItemStack pigzombie = new ItemBuilder(new org.bukkit.inventory.ItemStack(org.bukkit.Material.MOB_SPAWNER))
//      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$775000")
//      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
//      "Cannot Sell")
//      .setName(ChatColor.translateAlternateColorCodes('&', "&7&l[&e&lPig Zombie&7&l] &aSpawner"))
//      .toItemStack();
//    
//    org.bukkit.inventory.ItemStack ghast = new ItemBuilder(new org.bukkit.inventory.ItemStack(org.bukkit.Material.MOB_SPAWNER))
//      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$825000")
//      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
//      "Cannot Sell")
//      .setName(ChatColor.translateAlternateColorCodes('&', "&7&l[&e&lGhast&7&l] &aSpawner")).toItemStack();
//    
//    org.bukkit.inventory.ItemStack slime = new ItemBuilder(new org.bukkit.inventory.ItemStack(org.bukkit.Material.MOB_SPAWNER))
//      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$875000")
//      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
//      "Cannot Sell")
//      .setName(ChatColor.translateAlternateColorCodes('&', "&7&l[&e&lSlime&7&l] &aSpawner")).toItemStack();
//    
//    org.bukkit.inventory.ItemStack magmacube = new ItemBuilder(new org.bukkit.inventory.ItemStack(org.bukkit.Material.MOB_SPAWNER))
//      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$925000")
//      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
//      "Cannot Sell")
//      .setName(ChatColor.translateAlternateColorCodes('&', "&7&l[&e&lMagma Cube&7&l] &aSpawner"))
//      .toItemStack();
    
    org.bukkit.inventory.ItemStack frame = new ItemBuilder(org.bukkit.Material.STAINED_GLASS_PANE).setName(" ").setDyeColor(org.bukkit.DyeColor.YELLOW)
      .toItemStack();
    
	    inv.setItem(10, pig);
	    inv.setItem(11, cow);
	    inv.setItem(12, squid);
	    inv.setItem(13, chicken);
	    inv.setItem(14, Skeleton);
	    inv.setItem(15, zombie);
	    inv.setItem(16, spider);
	    inv.setItem(19, cavespider);
	    inv.setItem(20, mushroomcow);
	    inv.setItem(21, witch);
	    inv.setItem(22, blaze);
	    inv.setItem(23, creeper);
	    
	    
    for (int i = 0; i < inv.getSize(); i++) {
      if (((inv.getItem(i) == null) || (inv.getItem(i).getType() == org.bukkit.Material.AIR)) && 
        (i != 39) && (i != 40) && (i != 41) && (i != 42) && (i != 43))
      {
        inv.setItem(i, new ItemBuilder(org.bukkit.Material.STAINED_GLASS_PANE).setName(" ")
          .setDyeColor(org.bukkit.DyeColor.LIGHT_BLUE).toItemStack());
      }
    }
    
    return inv;
  }
  
  public static Inventory mobDrops() {
    Inventory inv = org.bukkit.Bukkit.createInventory(null, 45, 
      ChatColor.DARK_AQUA + ChatColor.UNDERLINE.toString() + "Shop" + ChatColor.DARK_GRAY + 
      ChatColor.BOLD.toString() + " ►" + ChatColor.GRAY + ChatColor.BOLD.toString() + " Mob Drop");
    
    org.bukkit.inventory.ItemStack ghasttear = new ItemBuilder(org.bukkit.Material.GHAST_TEAR)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$300")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$50")
      .setItemAmount(4).toItemStack();
    
    org.bukkit.inventory.ItemStack rottenFlesh = new ItemBuilder(org.bukkit.Material.ROTTEN_FLESH)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$100")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$2")
      .setItemAmount(32).toItemStack();
    
    org.bukkit.inventory.ItemStack goldnuggit = new ItemBuilder(org.bukkit.Material.GOLD_NUGGET)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$256")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$5")
      .setItemAmount(16).toItemStack();
    
    org.bukkit.inventory.ItemStack intsac = new ItemBuilder(org.bukkit.Material.INK_SACK)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$200")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$3")
      .setItemAmount(32).toItemStack();
    
    org.bukkit.inventory.ItemStack leather = new ItemBuilder(org.bukkit.Material.LEATHER)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$100")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$3")
      .setItemAmount(8).toItemStack();
    
    org.bukkit.inventory.ItemStack egg = new ItemBuilder(org.bukkit.Material.EGG)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$100")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$3")
      .setItemAmount(16).toItemStack();
    
    org.bukkit.inventory.ItemStack feather = new ItemBuilder(org.bukkit.Material.FEATHER)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "200")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$2")
      .setItemAmount(32).toItemStack();
    
    org.bukkit.inventory.ItemStack slime = new ItemBuilder(org.bukkit.Material.SLIME_BALL)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$300")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$30")
      .setItemAmount(2).toItemStack();
    
    org.bukkit.inventory.ItemStack blaze = new ItemBuilder(org.bukkit.Material.BLAZE_ROD)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$175")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$15")
      .setItemAmount(4).toItemStack();
    
    org.bukkit.inventory.ItemStack string = new ItemBuilder(org.bukkit.Material.STRING)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$100")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$1")
      .setItemAmount(16).toItemStack();
    
    org.bukkit.inventory.ItemStack spidereye = new ItemBuilder(org.bukkit.Material.SPIDER_EYE)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$100")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$1")
      .setItemAmount(1).toItemStack();
    
    org.bukkit.inventory.ItemStack arrow = new ItemBuilder(org.bukkit.Material.ARROW)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$150")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$2")
      .setItemAmount(32).toItemStack();
    
    org.bukkit.inventory.ItemStack bone = new ItemBuilder(org.bukkit.Material.BONE)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$150")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$2")
      .setItemAmount(32).toItemStack();
    
    org.bukkit.inventory.ItemStack enderpearl = new ItemBuilder(org.bukkit.Material.ENDER_PEARL)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$500")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$20")
      .setItemAmount(16).toItemStack();
    org.bukkit.inventory.ItemStack gunpowder = new ItemBuilder(org.bukkit.Material.getMaterial(289))
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$75")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$10")
      .setItemAmount(4).toItemStack();
    
//    org.bukkit.inventory.ItemStack sulpher = new ItemBuilder(org.bukkit.Material.SULPHUR)
//      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "175")
//      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$6")
//      .setItemAmount(4).toItemStack();
//    org.bukkit.inventory.ItemStack shard = new ItemBuilder(org.bukkit.Material.PRISMARINE_SHARD)
//      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$75")
//      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$5")
//      .toItemStack();
//    org.bukkit.inventory.ItemStack chr = new ItemBuilder(org.bukkit.Material.PRISMARINE_CRYSTALS)
//      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$75")
//      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$5")
//      .toItemStack();
//    org.bukkit.inventory.ItemStack fish = new ItemBuilder(org.bukkit.Material.RAW_FISH)
//      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$75")
//      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$4")
//      .toItemStack();
    org.bukkit.inventory.ItemStack frame = new ItemBuilder(org.bukkit.Material.STAINED_GLASS_PANE).setName(" ").setDyeColor(org.bukkit.DyeColor.GRAY)
      .toItemStack();
    
    inv.setItem(0, frame);
    inv.setItem(1, frame);
    inv.setItem(2, frame);
    inv.setItem(3, frame);
    inv.setItem(4, frame);
    inv.setItem(5, frame);
    inv.setItem(6, frame);
    inv.setItem(7, frame);
    inv.setItem(8, frame);
    
    inv.setItem(36, frame);
    inv.setItem(37, frame);
    inv.setItem(38, frame);
    inv.setItem(39, frame);
    inv.setItem(40, frame);
    inv.setItem(41, frame);
    inv.setItem(42, frame);
    inv.setItem(43, frame);
    inv.setItem(44, frame);
    
    inv.setItem(9, frame);
    inv.setItem(18, frame);
    inv.setItem(27, frame);
    
    inv.setItem(17, frame);
    inv.setItem(26, frame);
    inv.setItem(35, frame);
    
    inv.setItem(10, rottenFlesh);
    inv.setItem(11, goldnuggit);
    inv.setItem(12, ghasttear);
    inv.setItem(13, intsac);
    inv.setItem(14, leather);
    inv.setItem(15, egg);
    inv.setItem(16, feather);
    inv.setItem(19, slime);
    inv.setItem(20, blaze);
    inv.setItem(21, string);
    inv.setItem(22, gunpowder);
    inv.setItem(23, spidereye);
    inv.setItem(24, arrow);
    inv.setItem(25, bone);
    inv.setItem(28, enderpearl);
    
    
    return inv;
  }
  
  public static Inventory oreMenu() {
    Inventory inv = org.bukkit.Bukkit.createInventory(null, 45, 
      ChatColor.DARK_AQUA + ChatColor.UNDERLINE.toString() + "Shop" + ChatColor.DARK_GRAY + 
      ChatColor.BOLD.toString() + " ►" + ChatColor.BLUE + ChatColor.BOLD.toString() + " Ore");
    
    org.bukkit.inventory.ItemStack diamondblock = new ItemBuilder(org.bukkit.Material.DIAMOND_ORE)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$400")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$100")
      .toItemStack();
    org.bukkit.inventory.ItemStack emeraldblock = new ItemBuilder(org.bukkit.Material.EMERALD_BLOCK)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$6750")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$1800")
      .toItemStack();
    
    org.bukkit.inventory.ItemStack goldblock = new ItemBuilder(org.bukkit.Material.GOLD_BLOCK)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.WHITE + 
      ChatColor.ITALIC.toString() + "Cannot Buy")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$450")
      .toItemStack();
    
    org.bukkit.inventory.ItemStack ironblock = new ItemBuilder(org.bukkit.Material.IRON_BLOCK)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$1125")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$135")
      .toItemStack();
    
    org.bukkit.inventory.ItemStack coalblock = new ItemBuilder(org.bukkit.Material.COAL_BLOCK)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$55")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$42")
      .toItemStack();
    
    org.bukkit.inventory.ItemStack lapusblock = new ItemBuilder(org.bukkit.Material.LAPIS_BLOCK)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$130")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$42")
      .toItemStack();
    
    org.bukkit.inventory.ItemStack redstoneblock = new ItemBuilder(org.bukkit.Material.REDSTONE_BLOCK)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$150")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$42")
      .toItemStack();
    
    org.bukkit.inventory.ItemStack diamond = new ItemBuilder(org.bukkit.Material.DIAMOND)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$6400")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$100")
      .setItemAmount(16).toItemStack();
    
    org.bukkit.inventory.ItemStack emerald = new ItemBuilder(org.bukkit.Material.EMERALD)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$12000")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$200")
      .setItemAmount(16).toItemStack();
    
    org.bukkit.inventory.ItemStack gold = new ItemBuilder(org.bukkit.Material.GOLD_INGOT)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.WHITE + 
      ChatColor.ITALIC.toString() + "Cannot Buy")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$45")
      .toItemStack();
    
    org.bukkit.inventory.ItemStack iron = new ItemBuilder(org.bukkit.Material.IRON_INGOT)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$2000")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$10")
      .setItemAmount(16).toItemStack();
    
    org.bukkit.inventory.ItemStack coal = new ItemBuilder(org.bukkit.Material.COAL)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$100")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$5")
      .setItemAmount(16).toItemStack();
    
    org.bukkit.inventory.ItemStack lapis = new ItemBuilder(new org.bukkit.inventory.ItemStack(org.bukkit.Material.INK_SACK, 1, (short)4))
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$200")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$5")
      .setItemAmount(16).toItemStack();
    
    org.bukkit.inventory.ItemStack redstone = new ItemBuilder(org.bukkit.Material.REDSTONE)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$200")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "5")
      .setItemAmount(16).toItemStack();
    
    org.bukkit.inventory.ItemStack quartz = new ItemBuilder(org.bukkit.Material.QUARTZ)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$200")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$5")
      .setItemAmount(16).toItemStack();
    
    org.bukkit.inventory.ItemStack quartzBlock = new ItemBuilder(org.bukkit.Material.QUARTZ_BLOCK)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$800")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$4")
      .setItemAmount(64).toItemStack();
    
    org.bukkit.inventory.ItemStack frame = new ItemBuilder(org.bukkit.Material.STAINED_GLASS_PANE).setName(" ").setDyeColor(org.bukkit.DyeColor.BLACK)
      .toItemStack();
    
    inv.setItem(0, frame);
    inv.setItem(1, frame);
    inv.setItem(2, frame);
    inv.setItem(3, frame);
    inv.setItem(4, frame);
    inv.setItem(5, frame);
    inv.setItem(6, frame);
    inv.setItem(7, frame);
    inv.setItem(8, frame);
    inv.setItem(9, frame);
    inv.setItem(18, frame);
    inv.setItem(27, frame);
    inv.setItem(17, frame);
    inv.setItem(26, frame);
    inv.setItem(35, frame);
    inv.setItem(36, frame);
    inv.setItem(37, frame);
    inv.setItem(38, frame);
    inv.setItem(39, frame);
    inv.setItem(40, frame);
    inv.setItem(41, frame);
    inv.setItem(42, frame);
    inv.setItem(43, frame);
    inv.setItem(44, frame);
    
    inv.setItem(10, diamondblock);
    inv.setItem(11, emeraldblock);
    inv.setItem(12, goldblock);
    inv.setItem(13, ironblock);
    inv.setItem(14, coalblock);
    inv.setItem(15, lapusblock);
    inv.setItem(16, redstoneblock);
    inv.setItem(19, quartzBlock);
    inv.setItem(20, diamond);
    inv.setItem(21, emerald);
    inv.setItem(22, gold);
    inv.setItem(23, iron);
    inv.setItem(24, redstone);
    inv.setItem(25, quartz);
    inv.setItem(28, coal);
    inv.setItem(29, lapis);
    
    return inv;
  }
  
  public static Inventory plantsFoodMenu() {
    Inventory inv = org.bukkit.Bukkit.createInventory(null, 45, 
      ChatColor.DARK_AQUA + ChatColor.UNDERLINE.toString() + "Shop" + ChatColor.DARK_GRAY + 
      ChatColor.BOLD.toString() + " ►" + ChatColor.GREEN + ChatColor.BOLD.toString() + " Plants");
    
    org.bukkit.inventory.ItemStack catus = new ItemBuilder(org.bukkit.Material.CACTUS)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$225")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$3")
      .setItemAmount(16).toItemStack();
    
    org.bukkit.inventory.ItemStack sugarcane = new ItemBuilder(org.bukkit.Material.SUGAR_CANE)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$200")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$3")
      .setItemAmount(16).toItemStack();
    
    org.bukkit.inventory.ItemStack pinkin = new ItemBuilder(org.bukkit.Material.PUMPKIN)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$250")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$6")
      .setItemAmount(1).toItemStack();
    
    org.bukkit.inventory.ItemStack melon = new ItemBuilder(org.bukkit.Material.MELON_BLOCK)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "250")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$6")
      .setItemAmount(1).toItemStack();
//    org.bukkit.inventory.ItemStack melonslice = new ItemBuilder(org.bukkit.Material.MELON)
//      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "550")
//      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$2")
//      .setItemAmount(16).toItemStack();
//    
    org.bukkit.inventory.ItemStack rawpork = new ItemBuilder(org.bukkit.Material.PORK)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$125")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$1")
      .setItemAmount(16).toItemStack();
    
    org.bukkit.inventory.ItemStack cookedporl = new ItemBuilder(org.bukkit.Material.GRILLED_PORK)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$150")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$1")
      .setItemAmount(16).toItemStack();
    
    org.bukkit.inventory.ItemStack rawbeef = new ItemBuilder(org.bukkit.Material.RAW_BEEF)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$125")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$1")
      .setItemAmount(16).toItemStack();
    
    org.bukkit.inventory.ItemStack cookedbeef = new ItemBuilder(org.bukkit.Material.COOKED_BEEF)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$150")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$1")
      .setItemAmount(16).toItemStack();
    
    org.bukkit.inventory.ItemStack apple = new ItemBuilder(org.bukkit.Material.APPLE)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$250")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$10")
      .setItemAmount(8).toItemStack();
    
    org.bukkit.inventory.ItemStack gapple = new ItemBuilder(new org.bukkit.inventory.ItemStack(org.bukkit.Material.GOLDEN_APPLE, 1, (short)1))
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$15000")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + 
      ChatColor.ITALIC.toString() + "Cannot Sell")
      .toItemStack();
    
    org.bukkit.inventory.ItemStack goldenapple = new ItemBuilder(org.bukkit.Material.GOLDEN_APPLE)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$10000")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + 
      ChatColor.ITALIC.toString() + "Cannot Sell")
      .toItemStack();

    org.bukkit.inventory.ItemStack carrot = new ItemBuilder(org.bukkit.Material.CARROT_ITEM)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$700")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$4")
      .setItemAmount(8).toItemStack();
    
    org.bukkit.inventory.ItemStack wheat = new ItemBuilder(org.bukkit.Material.WHEAT)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$150")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$4")
      .setItemAmount(16).toItemStack();
    org.bukkit.inventory.ItemStack bread = new ItemBuilder(org.bukkit.Material.BREAD)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$425")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell")
      .setItemAmount(16).toItemStack();
    org.bukkit.inventory.ItemStack pumpkinpie = new ItemBuilder(org.bukkit.Material.PUMPKIN_PIE)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$50")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell")
      .setItemAmount(4).toItemStack();
    org.bukkit.inventory.ItemStack potato = new ItemBuilder(org.bukkit.Material.POTATO_ITEM)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$150")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$1")
      .setItemAmount(16).toItemStack();
//    org.bukkit.inventory.ItemStack chicken = new ItemBuilder(org.bukkit.Material.RAW_CHICKEN)
//      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$125")
//      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$2")
//      .setItemAmount(16).toItemStack();
//    org.bukkit.inventory.ItemStack cookechicken = new ItemBuilder(org.bukkit.Material.COOKED_CHICKEN)
//      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$150")
//      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$3")
//      .setItemAmount(16).toItemStack();
    
    org.bukkit.inventory.ItemStack lilypad = new ItemBuilder(org.bukkit.Material.WATER_LILY)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$250")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell")
      .setItemAmount(16).toItemStack();
    
    org.bukkit.inventory.ItemStack frame = new ItemBuilder(org.bukkit.Material.STAINED_GLASS_PANE).setName(" ").setDyeColor(org.bukkit.DyeColor.GREEN)
      .toItemStack();
    
    inv.setItem(0, frame);
    inv.setItem(1, frame);
    inv.setItem(2, frame);
    inv.setItem(3, frame);
    inv.setItem(4, frame);
    inv.setItem(5, frame);
    inv.setItem(6, frame);
    inv.setItem(7, frame);
    inv.setItem(8, frame);
    inv.setItem(9, frame);
    inv.setItem(18, frame);
    inv.setItem(27, frame);
    inv.setItem(17, frame);
    inv.setItem(26, frame);
    inv.setItem(35, frame);
    inv.setItem(36, frame);
    inv.setItem(37, frame);
    inv.setItem(38, frame);
    inv.setItem(39, frame);
    inv.setItem(40, frame);
    inv.setItem(41, frame);
    inv.setItem(42, frame);
    inv.setItem(43, frame);
    inv.setItem(44, frame);
    
    inv.setItem(10, catus);
    inv.setItem(11, sugarcane);
    inv.setItem(12, pinkin);
    inv.setItem(13, melon);
    inv.setItem(15, rawpork);
    inv.setItem(16, cookedporl);
    inv.setItem(19, rawbeef);
    inv.setItem(20, cookedbeef);
    inv.setItem(21, apple);
    inv.setItem(22, gapple);
    inv.setItem(23, goldenapple);
    inv.setItem(24, wheat);
    inv.setItem(25, bread);
    inv.setItem(28, pumpkinpie);
    inv.setItem(29, lilypad);
    inv.setItem(30, potato);
    

    return inv;
  }
  
  public static Inventory armorweponsyoolsMenu() {
    Inventory inv = org.bukkit.Bukkit.createInventory(null, 45, 
      ChatColor.DARK_AQUA + ChatColor.UNDERLINE.toString() + "Shop" + ChatColor.DARK_GRAY + 
      ChatColor.BOLD.toString() + " ►" + ChatColor.RED + ChatColor.BOLD.toString() + " Stuff");
    
    org.bukkit.inventory.ItemStack fishingrod = new ItemBuilder(org.bukkit.Material.FISHING_ROD)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$50")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell")
      .toItemStack();
    
    org.bukkit.inventory.ItemStack bow = new ItemBuilder(org.bukkit.Material.BOW)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$50")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell")
      .toItemStack();
    
    org.bukkit.inventory.ItemStack ironsword = new ItemBuilder(org.bukkit.Material.IRON_SWORD)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$240")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell")
      .toItemStack();
    org.bukkit.inventory.ItemStack ironaxe = new ItemBuilder(org.bukkit.Material.IRON_AXE)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$360")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell")
      .toItemStack();
    
    org.bukkit.inventory.ItemStack ironspade = new ItemBuilder(org.bukkit.Material.IRON_SPADE)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$120")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell")
      .toItemStack();
    
    org.bukkit.inventory.ItemStack ironpicaxe = new ItemBuilder(org.bukkit.Material.IRON_PICKAXE)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "360")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell")
      .toItemStack();
    
    org.bukkit.inventory.ItemStack ironhoe = new ItemBuilder(org.bukkit.Material.IRON_HOE)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$240")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell")
      .toItemStack();
    
    org.bukkit.inventory.ItemStack diamondsword = new ItemBuilder(org.bukkit.Material.DIAMOND_SWORD)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$190")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell")
      .toItemStack();
    
    org.bukkit.inventory.ItemStack diamondaxe = new ItemBuilder(org.bukkit.Material.DIAMOND_AXE)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$870")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell")
      .toItemStack();
    
    org.bukkit.inventory.ItemStack diamondshovel = new ItemBuilder(org.bukkit.Material.DIAMOND_SPADE)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$290")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell")
      .toItemStack();
    
    org.bukkit.inventory.ItemStack diamondpickaxe = new ItemBuilder(org.bukkit.Material.DIAMOND_PICKAXE)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$870")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell")
      .toItemStack();
    
    org.bukkit.inventory.ItemStack diamondhoe = new ItemBuilder(org.bukkit.Material.DIAMOND_HOE)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$500")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell")
      .toItemStack();
    
    org.bukkit.inventory.ItemStack diamondhelmit = new ItemBuilder(org.bukkit.Material.DIAMOND_HELMET)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$1450")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell")
      .toItemStack();
    
    org.bukkit.inventory.ItemStack diamondchest = new ItemBuilder(org.bukkit.Material.DIAMOND_CHESTPLATE)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$2250")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell")
      .toItemStack();
    
    org.bukkit.inventory.ItemStack diamondpants = new ItemBuilder(org.bukkit.Material.DIAMOND_LEGGINGS)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$1960")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell")
      .toItemStack();
    
    org.bukkit.inventory.ItemStack diamondsboots = new ItemBuilder(org.bukkit.Material.DIAMOND_BOOTS)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$1120")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell")
      .toItemStack();
    


    org.bukkit.inventory.ItemStack frame = new ItemBuilder(org.bukkit.Material.STAINED_GLASS_PANE).setName(" ").setDyeColor(org.bukkit.DyeColor.ORANGE)
      .toItemStack();
    
    inv.setItem(0, frame);
    inv.setItem(1, frame);
    inv.setItem(2, frame);
    inv.setItem(3, frame);
    inv.setItem(4, frame);
    inv.setItem(5, frame);
    inv.setItem(6, frame);
    inv.setItem(7, frame);
    inv.setItem(8, frame);
    inv.setItem(9, frame);
    inv.setItem(18, frame);
    inv.setItem(27, frame);
    inv.setItem(17, frame);
    inv.setItem(26, frame);
    inv.setItem(35, frame);
    inv.setItem(36, frame);
    inv.setItem(37, frame);
    inv.setItem(38, frame);
    inv.setItem(39, frame);
    inv.setItem(40, frame);
    inv.setItem(41, frame);
    inv.setItem(42, frame);
    inv.setItem(43, frame);
    inv.setItem(44, frame);
    
    inv.setItem(10, ironsword);
    inv.setItem(11, ironaxe);
    inv.setItem(12, ironspade);
    inv.setItem(13, ironpicaxe);
    inv.setItem(14, ironhoe);
    inv.setItem(19, diamondsword);
    inv.setItem(20, diamondaxe);
    inv.setItem(21, diamondshovel);
    inv.setItem(22, diamondpickaxe);
    inv.setItem(23, diamondhoe);
    inv.setItem(28, diamondhelmit);
    inv.setItem(29, diamondchest);
    inv.setItem(30, diamondpants);
    inv.setItem(31, diamondsboots);
    
    inv.setItem(33, bow);
    inv.setItem(34, fishingrod);
    
    return inv;
  }
  
  public static Inventory blockMenu() {
    Inventory inv = org.bukkit.Bukkit.createInventory(null, 54, 
      ChatColor.DARK_AQUA + ChatColor.UNDERLINE.toString() + "Shop" + ChatColor.DARK_GRAY + 
      ChatColor.BOLD.toString() + " ►" + ChatColor.AQUA + ChatColor.BOLD.toString() + " Blocks");
    
    org.bukkit.inventory.ItemStack hopper = new ItemBuilder(org.bukkit.Material.HOPPER)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$25000")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell")
      .toItemStack();
    org.bukkit.inventory.ItemStack sponge = new ItemBuilder(org.bukkit.Material.SPONGE)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$150")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell")
      .setItemAmount(12).toItemStack();
    
    org.bukkit.inventory.ItemStack glass = new ItemBuilder(org.bukkit.Material.GLASS)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$200")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell")
      .setItemAmount(64).toItemStack();
    
    org.bukkit.inventory.ItemStack tnt = new ItemBuilder(org.bukkit.Material.TNT)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$5000")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "5")
      .setItemAmount(64).toItemStack();
    
    org.bukkit.inventory.ItemStack stickypiston = new ItemBuilder(org.bukkit.Material.PISTON_STICKY_BASE)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$500")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell")
      .toItemStack();
    
    org.bukkit.inventory.ItemStack piston = new ItemBuilder(org.bukkit.Material.PISTON_BASE)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$350")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell")
      .toItemStack();
    
    org.bukkit.inventory.ItemStack mycelium = new ItemBuilder(org.bukkit.Material.MYCEL)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$250")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell")
      .setItemAmount(32).toItemStack();
    
    org.bukkit.inventory.ItemStack endstone = new ItemBuilder(org.bukkit.Material.ENDER_STONE)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$250")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell")
      .setItemAmount(16).toItemStack();
    
    org.bukkit.inventory.ItemStack ice = new ItemBuilder(org.bukkit.Material.ICE)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$10000")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell")
      .setItemAmount(64).toItemStack();
    
    org.bukkit.inventory.ItemStack web = new ItemBuilder(org.bukkit.Material.WEB)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$1000")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell")
      .setItemAmount(16).toItemStack();
    
    org.bukkit.inventory.ItemStack netherfence = new ItemBuilder(org.bukkit.Material.NETHER_FENCE)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$200")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell")
      .setItemAmount(64).toItemStack();
    
    org.bukkit.inventory.ItemStack soulsand = new ItemBuilder(org.bukkit.Material.SOUL_SAND)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$200")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$1")
      .setItemAmount(32).toItemStack();
    
    org.bukkit.inventory.ItemStack netherrack = new ItemBuilder(org.bukkit.Material.NETHERRACK)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$505")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell")
      .setItemAmount(64).toItemStack();
    
    org.bukkit.inventory.ItemStack gravel = new ItemBuilder(org.bukkit.Material.GRAVEL)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$175")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell")
      .setItemAmount(64).toItemStack();
    
    org.bukkit.inventory.ItemStack netherstair = new ItemBuilder(org.bukkit.Material.NETHER_BRICK_STAIRS)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$200")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell")
      .setItemAmount(32).toItemStack();
    
    org.bukkit.inventory.ItemStack netherbirckblock = new ItemBuilder(org.bukkit.Material.NETHER_BRICK)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$275")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$2")
      .setItemAmount(64).toItemStack();
    
    org.bukkit.inventory.ItemStack obsidian = new ItemBuilder(org.bukkit.Material.OBSIDIAN)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$3000")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$2")
      .setItemAmount(64).toItemStack();
    
    org.bukkit.inventory.ItemStack glowstone = new ItemBuilder(org.bukkit.Material.GLOWSTONE)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$500")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$2")
      .setItemAmount(64).toItemStack();
    
    org.bukkit.inventory.ItemStack mossyBrick = new ItemBuilder(new org.bukkit.inventory.ItemStack(org.bukkit.Material.SMOOTH_BRICK, 1, (short)1))
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$350")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell")
      .setItemAmount(64).toItemStack();
    
    org.bukkit.inventory.ItemStack brick = new ItemBuilder(org.bukkit.Material.SMOOTH_BRICK)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$350")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell")
      .setItemAmount(64).toItemStack();
    
    org.bukkit.inventory.ItemStack paternSandstone = new ItemBuilder(new org.bukkit.inventory.ItemStack(org.bukkit.Material.SANDSTONE, 1, (short)1))
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$175")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell")
      .setItemAmount(16).toItemStack();
    
    org.bukkit.inventory.ItemStack smoothSandstone = new ItemBuilder(new org.bukkit.inventory.ItemStack(org.bukkit.Material.SANDSTONE, 2, (short)2))
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$150")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell")
      .setItemAmount(16).toItemStack();
    
    org.bukkit.inventory.ItemStack sandstone = new ItemBuilder(org.bukkit.Material.SANDSTONE)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$150")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell")
      .setItemAmount(16).toItemStack();
    
    org.bukkit.inventory.ItemStack sand = new ItemBuilder(org.bukkit.Material.SAND)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$350")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell")
      .setItemAmount(64).toItemStack();
    
    org.bukkit.inventory.ItemStack redSand = new ItemBuilder(new org.bukkit.inventory.ItemStack(org.bukkit.Material.SAND, 1, (short)1))
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$350")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell")
      .setItemAmount(64).toItemStack();
    
    org.bukkit.inventory.ItemStack jungleWood = new ItemBuilder(new org.bukkit.inventory.ItemStack(org.bukkit.Material.LOG, 3, (short)3))
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$300")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$3")
      .setItemAmount(64).toItemStack();
    
    org.bukkit.inventory.ItemStack brichWood = new ItemBuilder(new org.bukkit.inventory.ItemStack(org.bukkit.Material.LOG, 2, (short)2))
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$300")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$3")
      .setItemAmount(64).toItemStack();
    
    org.bukkit.inventory.ItemStack spruceWood = new ItemBuilder(new org.bukkit.inventory.ItemStack(org.bukkit.Material.LOG, 1, (short)1))
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$300")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$3")
      .setItemAmount(64).toItemStack();
    
    org.bukkit.inventory.ItemStack DOakWord = new ItemBuilder(new org.bukkit.inventory.ItemStack(org.bukkit.Material.LOG_2, 1, (short)1))
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$300")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$3")
      .setItemAmount(64).toItemStack();
    
    org.bukkit.inventory.ItemStack oak = new ItemBuilder(org.bukkit.Material.LOG)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$300")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$3")
      .setItemAmount(64).toItemStack();
    
    org.bukkit.inventory.ItemStack acarcia = new ItemBuilder(org.bukkit.Material.LOG_2)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$300")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$3")
      .setItemAmount(64).toItemStack();
    
    org.bukkit.inventory.ItemStack stone = new ItemBuilder(org.bukkit.Material.STONE)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$600")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "3")
      .setItemAmount(64).toItemStack();
    
    org.bukkit.inventory.ItemStack cobble = new ItemBuilder(org.bukkit.Material.COBBLESTONE)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$500")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$2")
      .setItemAmount(64).toItemStack();
    
    org.bukkit.inventory.ItemStack grass = new ItemBuilder(org.bukkit.Material.GRASS)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$385")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "1")
      .setItemAmount(64).toItemStack();
    
    org.bukkit.inventory.ItemStack dirt = new ItemBuilder(org.bukkit.Material.DIRT)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$350")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "1")
      .setItemAmount(64).toItemStack();
    
    org.bukkit.inventory.ItemStack quartzBlock = new ItemBuilder(org.bukkit.Material.QUARTZ_BLOCK)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$800")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "3")
      .setItemAmount(64).toItemStack();
    
    org.bukkit.inventory.ItemStack lava = new ItemBuilder(org.bukkit.Material.HAY_BLOCK)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$100")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "1")
      .setItemAmount(1).toItemStack();
    org.bukkit.inventory.ItemStack frame = new ItemBuilder(org.bukkit.Material.STAINED_GLASS_PANE).setName(" ").setDyeColor(org.bukkit.DyeColor.BLUE)
      .toItemStack();
    
    inv.setItem(8, frame);
    inv.setItem(9, frame);
    inv.setItem(18, frame);
    inv.setItem(27, frame);
    inv.setItem(17, frame);
    inv.setItem(26, frame);
    inv.setItem(35, frame);
    inv.setItem(45, frame);
    inv.setItem(36, frame);
    inv.setItem(7, frame);
    inv.setItem(0, frame);
    inv.setItem(53, frame);
    inv.setItem(44, frame);
    
    inv.setItem(10, hopper);
    inv.setItem(11, sponge);
    inv.setItem(12, glass);
    inv.setItem(13, obsidian);
    inv.setItem(14, tnt);
    inv.setItem(15, stickypiston);
    inv.setItem(16, piston);
    inv.setItem(19, glowstone);
    inv.setItem(20, endstone);
    inv.setItem(21, lava);
    inv.setItem(22, ice);
    inv.setItem(23, web);
    inv.setItem(24, netherfence);
    inv.setItem(25, soulsand);
    inv.setItem(28, netherrack);
    inv.setItem(29, gravel);
    inv.setItem(30, netherstair);
    inv.setItem(31, netherbirckblock);
    inv.setItem(32, quartzBlock);
    inv.setItem(33, sand);
    inv.setItem(34, redSand);
    
    inv.setItem(37, sandstone);
    inv.setItem(38, smoothSandstone);
    inv.setItem(39, paternSandstone);
    inv.setItem(40, oak);
    inv.setItem(41, DOakWord);
    inv.setItem(42, jungleWood);
    inv.setItem(43, acarcia);
    
    inv.setItem(46, spruceWood);
    inv.setItem(47, brichWood);
    





    inv.setItem(1, mossyBrick);
    inv.setItem(2, brick);
    inv.setItem(3, stone);
    inv.setItem(4, cobble);
    inv.setItem(5, grass);
    inv.setItem(6, dirt);
    inv.setItem(7, mycelium);
    
    return inv;
  }
  
  public static Inventory brewingMenu() {
    Inventory inv = org.bukkit.Bukkit.createInventory(null, 36, 
      ChatColor.DARK_AQUA + ChatColor.UNDERLINE.toString() + "Shop" + ChatColor.DARK_GRAY + 
      ChatColor.BOLD.toString() + " ►" + ChatColor.DARK_PURPLE + ChatColor.BOLD.toString() + 
      " Brewing");
    org.bukkit.inventory.ItemStack caldorin = new ItemBuilder(org.bukkit.Material.CAULDRON_ITEM)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$500")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell")
      .toItemStack();
    org.bukkit.inventory.ItemStack brewingstand = new ItemBuilder(org.bukkit.Material.BREWING_STAND_ITEM)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$250")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell")
      .toItemStack();
    org.bukkit.inventory.ItemStack redmushroom = new ItemBuilder(org.bukkit.Material.RED_MUSHROOM)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$75")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$10")
      .toItemStack();
    org.bukkit.inventory.ItemStack brownmushoom = new ItemBuilder(org.bukkit.Material.BROWN_MUSHROOM)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$75")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$10")
      .toItemStack();
    org.bukkit.inventory.ItemStack glassbottle = new ItemBuilder(org.bukkit.Material.GLASS_BOTTLE)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$150")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell")
      .setItemAmount(32).toItemStack();
    org.bukkit.inventory.ItemStack magmacream = new ItemBuilder(org.bukkit.Material.MAGMA_CREAM)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$150")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$15")
      .toItemStack();
    org.bukkit.inventory.ItemStack specmelon = new ItemBuilder(org.bukkit.Material.SPECKLED_MELON)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$100")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$10")
      .toItemStack();
    org.bukkit.inventory.ItemStack sugar = new ItemBuilder(org.bukkit.Material.SUGAR)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$100")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + 
      ChatColor.ITALIC.toString() + "Cannot Sell")
      .setItemAmount(4).toItemStack();
    org.bukkit.inventory.ItemStack glowstone = new ItemBuilder(org.bukkit.Material.GLOWSTONE_DUST)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$100")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + ChatColor.ITALIC + 
      "Cannot Sell")
      .setItemAmount(4).toItemStack();
    org.bukkit.inventory.ItemStack goldencarrot = new ItemBuilder(org.bukkit.Material.GOLDEN_CARROT)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$225")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.WHITE + 
      ChatColor.ITALIC.toString() + "Cannot Sell")
      .setItemAmount(4).toItemStack();
    org.bukkit.inventory.ItemStack carrot = new ItemBuilder(org.bukkit.Material.CARROT_ITEM)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$100")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$3")
      .setItemAmount(4).toItemStack();
    org.bukkit.inventory.ItemStack netherwart = new ItemBuilder(org.bukkit.Material.NETHER_STALK)
      .addLoreLine(ChatColor.GREEN + ChatColor.BOLD.toString() + "Buy: " + ChatColor.GRAY + "$200")
      .addLoreLine(ChatColor.RED + ChatColor.BOLD.toString() + "Sell: " + ChatColor.GRAY + "$3")
      .setItemAmount(4).toItemStack();
    
    org.bukkit.inventory.ItemStack frame = new ItemBuilder(org.bukkit.Material.STAINED_GLASS_PANE).setName(" ").setDyeColor(org.bukkit.DyeColor.PURPLE)
      .toItemStack();
    
    inv.setItem(0, frame);
    inv.setItem(1, frame);
    inv.setItem(2, frame);
    inv.setItem(3, frame);
    inv.setItem(4, frame);
    inv.setItem(5, frame);
    inv.setItem(6, frame);
    inv.setItem(7, frame);
    inv.setItem(8, frame);
    inv.setItem(9, frame);
    inv.setItem(18, frame);
    inv.setItem(17, frame);
    inv.setItem(26, frame);
    inv.setItem(27, frame);
    inv.setItem(28, frame);
    inv.setItem(29, frame);
    inv.setItem(30, frame);
    inv.setItem(31, frame);
    inv.setItem(32, frame);
    inv.setItem(33, frame);
    inv.setItem(34, frame);
    inv.setItem(35, frame);
    
    inv.setItem(10, caldorin);
    inv.setItem(11, brewingstand);
    inv.setItem(12, redmushroom);
    inv.setItem(13, brownmushoom);
    inv.setItem(14, glassbottle);
    inv.setItem(15, magmacream);
    inv.setItem(16, specmelon);
    inv.setItem(19, sugar);
    inv.setItem(20, glowstone);
    inv.setItem(21, goldencarrot);
    inv.setItem(22, carrot);
    inv.setItem(23, netherwart);
    
    return inv;
  }
}
