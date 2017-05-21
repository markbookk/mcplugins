package me.tokyojack.shop;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import net.milkbowl.vault.economy.EconomyResponse;


public class InventoryClick
  implements Listener
{
  public InventoryClick(Core core) {}
  
  @EventHandler
  public void onInventoryClick(InventoryClickEvent event)
  {
    Player player = (Player)event.getWhoClicked();
    
    ItemStack clicked = event.getCurrentItem();
    if (event.isCancelled())
      return;
    if (!(player instanceof Player)) {
      return;
    }
    if ((clicked == null) || (clicked.getType() == Material.AIR)) {
      return;
    }
    String cleaned = ChatColor.stripColor(clicked.getItemMeta().getDisplayName());
    
    if (event.getInventory().getName().equals(GUIClass.mainMenu().getName())) {
      event.setCancelled(true);
      
      if (!clicked.hasItemMeta())
        return;
      if (((clicked.getType().equals(Material.STAINED_GLASS_PANE)) || 
        (clicked.getType().equals(Material.THIN_GLASS))) && 
        (clicked.getDurability() != 0)) {
        event.setCancelled(true);
        return;
      }
      

      if (cleaned.equalsIgnoreCase("Ore")) {
        player.openInventory(GUIClass.oreMenu());
        event.setCancelled(true);
      }
      if (cleaned.equalsIgnoreCase("Mob Drops")) {
        player.openInventory(GUIClass.mobDrops());
        event.setCancelled(true);
      }
      if (cleaned.equalsIgnoreCase("Brewing")) {
        player.openInventory(GUIClass.brewingMenu());
        event.setCancelled(true);
      }
      if (cleaned.equalsIgnoreCase("Mob Spawners")) {
        player.openInventory(GUIClass.spawnerMenu());
        

        event.setCancelled(true);
      }
      if (cleaned.equalsIgnoreCase("Plants/Food")) {
        player.openInventory(GUIClass.plantsFoodMenu());
        event.setCancelled(true);
      }
      if (cleaned.equalsIgnoreCase("Blocks")) {
        player.openInventory(GUIClass.blockMenu());
        event.setCancelled(true);
      }
      if (cleaned.equalsIgnoreCase("weapons/armor/tools")) {
        player.openInventory(GUIClass.armorweponsyoolsMenu());
        event.setCancelled(true);
      }
      if (cleaned.equalsIgnoreCase("Vip Shop")) {
        player.openInventory(GUIClass.vipchooseMenu());
        event.setCancelled(true);
      }
      event.setCancelled(true);
    }
    
    if ((event.getInventory().getName().equals(GUIClass.armorweponsyoolsMenu().getName())) || 
      (event.getInventory().getName().equals(GUIClass.blockMenu().getName())) || 
      (event.getInventory().getName().equals(GUIClass.brewingMenu().getName())) || 
      (event.getInventory().getName().equals(GUIClass.oreMenu().getName())) || 
      (event.getInventory().getName().equals(GUIClass.plantsFoodMenu().getName())) || 
      (event.getInventory().getName().equals(GUIClass.mobDrops().getName())) || 
      (event.getInventory().getName().equals(GUIClass.cannonMenu().getName())) || 
      (event.getInventory().getName().equals(GUIClass.donatorMenu().getName())) 
      //|| 
      //(event.getInventory().getName().equals(GUIClass.spawnerMenu().getName()))
      ) 
    {
      event.setCancelled(true);
      
      if (!clicked.hasItemMeta())
        return;
      if (((clicked.getType().equals(Material.STAINED_GLASS_PANE)) || 
        (clicked.getType().equals(Material.THIN_GLASS))) && 
        (clicked.getDurability() != 0)) {
        event.setCancelled(true);
        return;
      }
      
      // I find this line useless since there isn't cobblestone in donatorMenu
      if ((event.getInventory().getName().equals(GUIClass.donatorMenu().getName())) && 
        (clicked.getType().equals(Material.COBBLESTONE))) {
        if (slotsleft(player) < 10) {
          player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "Inventory full!");
          return;
        }
        if (Core.economy.getBalance(player.getName()) >= 640.0D) {
          EconomyResponse r = Core.economy.withdrawPlayer(player.getName(), 640.0D);
          if (r.transactionSuccess()) {
            player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "$640");
            for (int i = 0; i < 10; i++)
            {
              player.getInventory().addItem(new ItemStack[] { new ItemStack(clicked.getType(), (short)clicked.getAmount()) });
            }
            event.setCancelled(true);
            return;
          }
        }
      }
      


      if ((event.isLeftClick()) && (!event.isShiftClick())) {
        if (!clicked.hasItemMeta()) {
          return;
        }
        if (clicked.getType() == Material.THIN_GLASS) {
          event.setCancelled(true);
          return;
        }
        
        String cleanedLore = ChatColor.stripColor((String)clicked.getItemMeta().getLore().get(0));
        try
        {
          String getNum = cleanedLore.replace("Buy: ", "").replace("$", "");
          if (getNum.equals("Cannot Buy")) {
            player.sendMessage(ChatColor.RED + "You cannot buy" + ChatColor.GRAY + " Gold Ingot!");
            event.setCancelled(true);
            return;
          }
          if (Core.economy.getBalance(player.getName()) >= Integer.parseInt(getNum)) {
            if (player.getInventory().firstEmpty() == -1) {
              player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "Inventory full!");
              return;
            }
            EconomyResponse r = Core.economy.withdrawPlayer(player.getName(), Integer.parseInt(getNum));
            if (r.transactionSuccess()) {
              player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "$" + getNum);
              

              player.getInventory().addItem(new ItemStack[] { new ItemBuilder(clicked.getType()).setName(clicked.getItemMeta().getDisplayName()).setDurability((byte)clicked.getDurability()).setItemAmount((short)clicked.getAmount()).toItemStack() });
              
              event.setCancelled(true);
            }
          }
          else {
            player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "Not enough Money!");
            return;
          }
        }
        catch (NumberFormatException ex) {
          return;
        }
      }
      
      if ((event.isLeftClick()) && (event.isShiftClick())) {
        if (!clicked.hasItemMeta())
          return;
        String cleanedLore = ChatColor.stripColor((String)clicked.getItemMeta().getLore().get(0));
        try
        {
          String getNum = cleanedLore.replace("Buy: ", "").replace("$", "");
          int amount = clicked.getType().getMaxStackSize();
          int amountmoney = Integer.parseInt(getNum) * amount / clicked.getAmount(); //Max amount divided by amount clicked times the price
          if (player.getInventory().firstEmpty() == -1) {
            player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "You need: " + ChatColor.GRAY + 
              "10 Empty Slots" + ChatColor.RED + " to buy!");
            return;
          }
          if (Core.economy.getBalance(player.getName()) >= amountmoney) {
            EconomyResponse r = Core.economy.withdrawPlayer(player.getName(), amountmoney);
            if (r.transactionSuccess())
            {
              player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "$" + amountmoney);
              player.getInventory().addItem(new ItemStack[] { new ItemStack(clicked.getType(), 
                (short)clicked.getMaxStackSize(), (byte)clicked.getDurability()) });
              
              event.setCancelled(true);
            }
          }
          else
          {
            int i = 0;
            i++;
            if (i == 2) {
              player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "Not enough Money!");
              i = 0;
            }
          }
        } catch (NumberFormatException ex) {
          return;
        }
      }
      if ((event.isRightClick()) && (!event.isShiftClick())) {
        if (!clicked.hasItemMeta())
          return;
        String cleanedLore = ChatColor.stripColor((String)clicked.getItemMeta().getLore().get(1));
        try {
          String getNum = cleanedLore.replace("Sell: ", "").replace("$", ""); //In case the price doesn't have "$" you don't replace the whole string right away.
          
          if (getNum.equals("Cannot Sell")) {
            event.setCancelled(true);
            player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "You cannot sell this item!");
            return;
          }
          
          if (getNum.contains(":")) {
            if (clicked.getType().equals(Material.REDSTONE)) {
              if (InventoryContain(player, Material.REDSTONE, 16).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 75.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.REDSTONE, 16);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$75");
                  event.setCancelled(true);
                }
              }
              else {
                player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "You need " + 
                  ChatColor.GRAY + ChatColor.BOLD.toString() + "16 Redstone " + ChatColor.RED + 
                  ChatColor.BOLD.toString() + "To sell!");
                return;
              }
            }
            if (clicked.getType().equals(Material.IRON_BLOCK)) {
              if (InventoryContain(player, Material.IRON_BLOCK, 16).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 2160.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.IRON_BLOCK, 16);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$2160");
                  event.setCancelled(true);
                }
              }
              else {
                player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "You need " + 
                  ChatColor.GRAY + ChatColor.BOLD.toString() + "16 Iron Blocks " + ChatColor.RED + 
                  ChatColor.BOLD.toString() + "To sell!");
                return;
              }
            }
            if (clicked.getType().equals(Material.QUARTZ)) {
              if (InventoryContain(player, Material.QUARTZ, 16).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 75.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.QUARTZ, 16);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$75");
                  event.setCancelled(true);
                }
              }
              else {
                player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "You need " + 
                  ChatColor.GRAY + ChatColor.BOLD.toString() + "16 Quartz " + ChatColor.RED + 
                  ChatColor.BOLD.toString() + "To sell!");
                return;
              }
            }
            if (clicked.getType().equals(Material.COAL)) {
              if (InventoryContain(player, Material.COAL, 16).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 75.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.COAL, 16);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$75");
                  event.setCancelled(true);
                }
              }
              else {
                player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "You need " + 
                  ChatColor.GRAY + ChatColor.BOLD.toString() + "16 Coal " + ChatColor.RED + 
                  ChatColor.BOLD.toString() + "To sell!");
                return;
              }
            }
            
            if (clicked.getType().equals(Material.SUGAR_CANE)) {
              if (InventoryContain(player, Material.SUGAR_CANE, 16).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 48.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.SUGAR_CANE, 16);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$48");
                  event.setCancelled(true);
                }
              }
              else {
                player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "You need " + 
                  ChatColor.GRAY + ChatColor.BOLD.toString() + "16 Sugar Cane " + ChatColor.RED + 
                  ChatColor.BOLD.toString() + "To sell!");
                return;
              }
            }
            if (clicked.getType().equals(Material.ROTTEN_FLESH)) {
              if (InventoryContain(player, Material.ROTTEN_FLESH, 32).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 225.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.ROTTEN_FLESH, 32);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$225");
                  event.setCancelled(true);
                }
              }
              else {
                player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "You need " + 
                  ChatColor.GRAY + ChatColor.BOLD.toString() + "32 Rotten Flesh " + 
                  ChatColor.RED + ChatColor.BOLD.toString() + "To sell!");
                return;
              }
            }
            
            if ((clicked.getType().equals(Material.LOG)) && 
              (clicked.getDurability() == 3)) {
              if (InventoryContainItem(player, Material.LOG, 16, 3).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 35.0D);
                if (r.transactionSuccess()) {
                  InventorySearchItem(player, Material.LOG, 16, 3);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$35");
                  event.setCancelled(true);
                }
              }
              else {
                player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "You need " + 
                  ChatColor.GRAY + ChatColor.BOLD.toString() + "16 Jungle Wood " + 
                  ChatColor.RED + ChatColor.BOLD.toString() + "To sell!");
                return;
              }
            }
            
            if ((clicked.getType().equals(Material.LOG)) && 
              (clicked.getDurability() == 2)) {
              if (InventoryContainItem(player, Material.LOG, 16, 2).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 35.0D);
                if (r.transactionSuccess()) {
                  InventorySearchItem(player, Material.LOG, 16, 2);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$35");
                  event.setCancelled(true);
                }
              }
              else {
                player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "You need " + 
                  ChatColor.GRAY + ChatColor.BOLD.toString() + "16 Birch Wood " + 
                  ChatColor.RED + ChatColor.BOLD.toString() + "To sell!");
                return;
              }
            }
            

            if ((clicked.getType().equals(Material.LOG)) && 
              (clicked.getDurability() == 1)) {
              if (InventoryContainItem(player, Material.LOG, 16, 1).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 35.0D);
                if (r.transactionSuccess()) {
                  InventorySearchItem(player, Material.LOG, 16, 1);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$35");
                  event.setCancelled(true);
                }
              }
              else {
                player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "You need " + 
                  ChatColor.GRAY + ChatColor.BOLD.toString() + "16 Spruce Wood " + 
                  ChatColor.RED + ChatColor.BOLD.toString() + "To sell!");
                return;
              }
            }
            
            if ((clicked.getType().equals(Material.LOG_2)) && 
              (clicked.getDurability() == 1)) {
              if (InventoryContainItem(player, Material.LOG_2, 16, 1).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 35.0D);
                if (r.transactionSuccess()) {
                  InventorySearchItem(player, Material.LOG_2, 16, 1);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$35");
                  event.setCancelled(true);
                }
              }
              else
              {
                player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "You need " + 
                  ChatColor.GRAY + ChatColor.BOLD.toString() + "16 Dark Oak Wood " + 
                  ChatColor.RED + ChatColor.BOLD.toString() + "To sell!");
                return;
              }
            }
            

            if ((clicked.getType().equals(Material.LOG)) && 
              (clicked.getDurability() == 0)) {
              if (InventoryContainItem(player, Material.LOG, 16, 0).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 35.0D);
                if (r.transactionSuccess()) {
                  InventorySearchItem(player, Material.LOG, 16, 0);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$35");
                  event.setCancelled(true);
                }
              }
              else {
                player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "You need " + 
                  ChatColor.GRAY + ChatColor.BOLD.toString() + "16 Oak Wood " + 
                  ChatColor.RED + ChatColor.BOLD.toString() + "To sell!");
                return;
              }
            }
            

            if ((clicked.getType().equals(Material.INK_SACK)) && 
              (clicked.getDurability() == 4)) {
              if (InventoryContainItem(player, Material.INK_SACK, 16, 4).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 75.0D);
                if (r.transactionSuccess()) {
                  InventorySearchItem(player, Material.INK_SACK, 16, 4);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$75");
                  event.setCancelled(true);
                }
              }
              else {
                player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "You need " + 
                  ChatColor.GRAY + ChatColor.BOLD.toString() + "16 Oak Wood " + 
                  ChatColor.RED + ChatColor.BOLD.toString() + "To sell!");
                return;
              }
            }
            

            if (clicked.getType().equals(Material.LOG_2)) {
              if (InventoryContain(player, Material.LOG_2, 16).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 35.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.LOG_2, 16);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$35");
                  event.setCancelled(true);
                }
              }
              else {
                player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "You need " + 
                  ChatColor.GRAY + ChatColor.BOLD.toString() + "16 Arcania Wood " + 
                  ChatColor.RED + ChatColor.BOLD.toString() + "To sell!");
                return;
              }
            }
            
            if (clicked.getType().equals(Material.ENDER_PEARL)) {
              if (InventoryContain(player, Material.ENDER_PEARL, 16).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 320.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.ENDER_PEARL, 16);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$320");
                  event.setCancelled(true);
                }
              }
              else {
                player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "You need " + 
                  ChatColor.GRAY + ChatColor.BOLD.toString() + "16 Ender Pearl " + ChatColor.RED + 
                  ChatColor.BOLD.toString() + "To sell!");
                return;
              }
            }
            
            if (clicked.getType().equals(Material.BLAZE_ROD)) {
              if (InventoryContain(player, Material.BLAZE_ROD, 64).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 960.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.BLAZE_ROD, 64);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$960");
                  event.setCancelled(true);
                }
              }
              else {
                player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "You need " + 
                  ChatColor.GRAY + ChatColor.BOLD.toString() + "64 Blaze Rods " + ChatColor.RED + 
                  ChatColor.BOLD.toString() + "To sell!");
                return;
              }
            }
            
            if ((clicked.getType().equals(Material.SMOOTH_BRICK)) && 
              (clicked.getDurability() == 0)) {
              if (InventoryContainItem(player, Material.SMOOTH_BRICK, 64, 0).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 175.0D);
                if (r.transactionSuccess()) {
                  InventorySearchItem(player, Material.SMOOTH_BRICK, 64, 0);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$175");
                  event.setCancelled(true);
                }
              }
              else {
                player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "You need " + 
                  ChatColor.GRAY + ChatColor.BOLD.toString() + "64 Smooth Brick " + 
                  ChatColor.RED + ChatColor.BOLD.toString() + "To sell!");
                return;
              }
            }
            

            if (clicked.getType().equals(Material.STONE)) {
              if (InventoryContain(player, Material.STONE, 64).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 175.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.STONE, 64);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$175");
                  event.setCancelled(true);
                }
              }
              else {
                player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "You need " + 
                  ChatColor.GRAY + ChatColor.BOLD.toString() + "64 Stone " + ChatColor.RED + 
                  ChatColor.BOLD.toString() + "To sell!");
                return;
              }
            }
            
            if (clicked.getType().equals(Material.COBBLESTONE)) {
              if (InventoryContain(player, Material.COBBLESTONE, 64).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 125.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.COBBLESTONE, 64);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$125");
                  event.setCancelled(true);
                }
              }
              else {
                player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "You need " + 
                  ChatColor.GRAY + ChatColor.BOLD.toString() + "64 Cobble Stone " + 
                  ChatColor.RED + ChatColor.BOLD.toString() + "To sell!");
                return;
              }
            }
            
            if (clicked.getType().equals(Material.QUARTZ_BLOCK)) {
              if (InventoryContain(player, Material.QUARTZ_BLOCK, 64).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 250.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.QUARTZ_BLOCK, 64);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$250");
                  event.setCancelled(true);
                }
              }
              else {
                player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "You need " + 
                  ChatColor.GRAY + ChatColor.BOLD.toString() + "64 Quartz Blocks Rods " + 
                  ChatColor.RED + ChatColor.BOLD.toString() + "To sell!");
                return;
              }
            }
            if (clicked.getType().equals(Material.STRING)) {
              if (InventoryContain(player, Material.STRING, 16).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 16.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.STRING, 16);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$16");
                  event.setCancelled(true);
                }
              }
              else {
                player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "You need " + 
                  ChatColor.GRAY + ChatColor.BOLD.toString() + "16 String" + ChatColor.RED + 
                  ChatColor.BOLD.toString() + "To sell!");
                return;
              }
            }
            
            if (clicked.getType().equals(Material.FEATHER)) {
              if (InventoryContain(player, Material.FEATHER, 16).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 16.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.FEATHER, 16);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$16");
                  event.setCancelled(true);
                }
              }
              else {
                player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "You need " + 
                  ChatColor.GRAY + ChatColor.BOLD.toString() + "16 Feather" + ChatColor.RED + 
                  ChatColor.BOLD.toString() + "To sell!");
                return;
              }
            }
            if (clicked.getType().equals(Material.PUMPKIN)) {
              if (InventoryContain(player, Material.PUMPKIN, 16).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 16.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.PUMPKIN, 16);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$10");
                  event.setCancelled(true);
                }
              }
              else {
                player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "You need " + 
                  ChatColor.GRAY + ChatColor.BOLD.toString() + "16 Pumpkins" + ChatColor.RED + 
                  ChatColor.BOLD.toString() + "To sell!");
                return;
              }
            }
            if (clicked.getType().equals(Material.ARROW)) {
              if (InventoryContain(player, Material.ARROW, 16).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 32.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.ARROW, 16);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$32");
                  event.setCancelled(true);
                }
              }
              else {
                player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "You need " + 
                  ChatColor.GRAY + ChatColor.BOLD.toString() + "16 Arrow" + ChatColor.RED + 
                  ChatColor.BOLD.toString() + "To sell!");
                return;
              }
            }
            
            if (clicked.getType().equals(Material.SPIDER_EYE)) {
              if (InventoryContain(player, Material.SPIDER_EYE, 16).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 150.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.SPIDER_EYE, 16);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$150");
                  event.setCancelled(true);
                }
              }
              else {
                player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "You need " + 
                  ChatColor.GRAY + ChatColor.BOLD.toString() + "16 Fermented Eyes" + 
                  ChatColor.RED + ChatColor.BOLD.toString() + "To sell!");
                return;
              }
            }
            if (clicked.getType().equals(Material.BONE)) {
              if (InventoryContain(player, Material.BONE, 16).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 32.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.BONE, 16);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$32");
                  event.setCancelled(true);
                }
              }
              else {
                player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "You need " + 
                  ChatColor.GRAY + ChatColor.BOLD.toString() + "16 Bone" + ChatColor.RED + 
                  ChatColor.BOLD.toString() + "To sell!");
                return;
              }
            }
          }
          
          if (InventoryContain(player, clicked.getType(), 1).booleanValue()) {
            EconomyResponse r = Core.economy.depositPlayer(player.getName(), Integer.parseInt(getNum));
            if (r.transactionSuccess()) {
              InventorySearch(player, clicked.getType(), 1);
              player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$" + getNum);
              event.setCancelled(true);
            }
          } else {
            player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + 
              "You don't have that item in your inventory!");
            return;
          }
        } catch (NumberFormatException ex) {
          return;
        }
      }
      
      if ((event.isRightClick()) && (event.isShiftClick())) {
        if (!clicked.hasItemMeta())
          return;
        String cleanedLore = ChatColor.stripColor((String)clicked.getItemMeta().getLore().get(1));
        try {
          String getNum = cleanedLore.replace("Sell: ", "").replace("$", "");
          
          if (getNum.equals("Cannot Sell")) {
            event.setCancelled(true);
            player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "You cannot sell this item!");
            return;
          }
          if (getNum.contains(":")) {
            if (clicked.getType().equals(Material.REDSTONE)) {
              if (InventoryContain(player, Material.REDSTONE, 64).booleanValue()) {
                player.sendMessage("64");
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 300.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.REDSTONE, 64);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$" + 300);
                  event.setCancelled(true);
                  return;
                }
              }
              
              if (InventoryContain(player, Material.REDSTONE, 48).booleanValue()) {
                player.sendMessage("48");
                
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 225.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.REDSTONE, 48);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$" + 225);
                  event.setCancelled(true);
                  return;
                }
              }
              if (InventoryContain(player, Material.REDSTONE, 32).booleanValue()) {
                player.sendMessage("32");
                
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 150.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.REDSTONE, 32);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$" + 150);
                  event.setCancelled(true);
                  return;
                }
              }
              if (InventoryContain(player, Material.REDSTONE, 16).booleanValue()) {
                player.sendMessage("16");
                
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 75.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.REDSTONE, 16);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$75");
                  event.setCancelled(true);
                }
              }
              else {
                player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "You need " + 
                  ChatColor.GRAY + ChatColor.BOLD.toString() + "16 Redstone" + ChatColor.RED + 
                  ChatColor.BOLD.toString() + "To sell!");
                return;
              }
            }
            
            if ((clicked.getType().equals(Material.SMOOTH_BRICK)) && 
              (clicked.getDurability() == 0)) {
              if (InventoryContainItem(player, Material.SMOOTH_BRICK, 64, 0).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 175.0D);
                if (r.transactionSuccess()) {
                  InventorySearchItem(player, Material.SMOOTH_BRICK, 64, 0);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$175");
                  event.setCancelled(true);
                }
              }
              else {
                player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "You need " + 
                  ChatColor.GRAY + ChatColor.BOLD.toString() + "64 Smooth Brick " + 
                  ChatColor.RED + ChatColor.BOLD.toString() + "To sell!");
                return;
              }
            }
            

            if (clicked.getType().equals(Material.IRON_BLOCK)) {
              if (InventoryContain(player, Material.IRON_BLOCK, 64).booleanValue()) {
                player.sendMessage("64");
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 8640.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.IRON_BLOCK, 64);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$" + 8640);
                  event.setCancelled(true);
                  return;
                }
              }
              
              if (InventoryContain(player, Material.IRON_BLOCK, 48).booleanValue()) {
                player.sendMessage("48");
                
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 6480.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.IRON_BLOCK, 48);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$" + 6480);
                  event.setCancelled(true);
                  return;
                }
              }
              if (InventoryContain(player, Material.IRON_BLOCK, 32).booleanValue()) {
                player.sendMessage("32");
                
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 4320.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.IRON_BLOCK, 32);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$" + 4320);
                  event.setCancelled(true);
                  return;
                }
              }
              if (InventoryContain(player, Material.IRON_BLOCK, 16).booleanValue()) {
                player.sendMessage("16");
                
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 2160.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.IRON_BLOCK, 16);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$2160");
                  event.setCancelled(true);
                }
              }
              else {
                player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "You need " + 
                  ChatColor.GRAY + ChatColor.BOLD.toString() + "16 Iron Blocks" + ChatColor.RED + 
                  ChatColor.BOLD.toString() + "To sell!");
                return;
              }
            }
            
            if (clicked.getType().equals(Material.STONE)) {
              if (InventoryContain(player, Material.STONE, 64).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 175.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.STONE, 64);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$175");
                  event.setCancelled(true);
                }
              }
              else {
                player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "You need " + 
                  ChatColor.GRAY + ChatColor.BOLD.toString() + "64 Stone " + ChatColor.RED + 
                  ChatColor.BOLD.toString() + "To sell!");
                return;
              }
            }
            
            if (clicked.getType().equals(Material.COBBLESTONE)) {
              if (InventoryContain(player, Material.COBBLESTONE, 64).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 125.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.COBBLESTONE, 64);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$125");
                  event.setCancelled(true);
                }
              }
              else {
                player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "You need " + 
                  ChatColor.GRAY + ChatColor.BOLD.toString() + "64 Cobble Stone " + 
                  ChatColor.RED + ChatColor.BOLD.toString() + "To sell!");
                return;
              }
            }
            
            if (clicked.getType().equals(Material.QUARTZ)) {
              if (InventoryContain(player, Material.QUARTZ, 64).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 300.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.QUARTZ, 64);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$" + 300);
                  event.setCancelled(true);
                  return;
                }
              }
              if (InventoryContain(player, Material.QUARTZ, 48).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 225.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.QUARTZ, 48);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$" + 225);
                  event.setCancelled(true);
                  return;
                }
              }
              if (InventoryContain(player, Material.QUARTZ, 32).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 150.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.QUARTZ, 32);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$" + 150);
                  event.setCancelled(true);
                  return;
                }
              }
              if (InventoryContain(player, Material.QUARTZ, 16).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 75.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.QUARTZ, 16);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$75");
                  event.setCancelled(true);
                }
              }
              else {
                player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "You need " + 
                  ChatColor.GRAY + ChatColor.BOLD.toString() + "16 Quartz" + ChatColor.RED + 
                  ChatColor.BOLD.toString() + "To sell!");
                return;
              }
            }
            
            if (clicked.getType().equals(Material.COAL)) {
              if (InventoryContain(player, Material.COAL, 64).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 300.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.COAL, 64);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$" + 300);
                  event.setCancelled(true);
                  return;
                }
              }
              if (InventoryContain(player, Material.COAL, 48).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 225.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.COAL, 48);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$" + 225);
                  event.setCancelled(true);
                  return;
                }
              }
              if (InventoryContain(player, Material.COAL, 32).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 150.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.COAL, 32);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$" + 148);
                  event.setCancelled(true);
                  return;
                }
              }
              if (InventoryContain(player, Material.COAL, 16).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 75.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.COAL, 16);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$75");
                  event.setCancelled(true);
                }
              }
              else {
                player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "You need " + 
                  ChatColor.GRAY + ChatColor.BOLD.toString() + "16 Coal" + ChatColor.RED + 
                  ChatColor.BOLD.toString() + "To sell!");
                return;
              }
            }
            
            if (clicked.getType().equals(Material.SUGAR_CANE)) {
              if (InventoryContain(player, Material.SUGAR_CANE, 64).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 192.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.SUGAR_CANE, 64);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$" + 192);
                  event.setCancelled(true);
                  return;
                }
              }
              if (InventoryContain(player, Material.SUGAR_CANE, 48).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 144.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.SUGAR_CANE, 48);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$" + 144);
                  event.setCancelled(true);
                  return;
                }
              }
              if (InventoryContain(player, Material.SUGAR_CANE, 32).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 96.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.SUGAR_CANE, 32);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$" + 96);
                  event.setCancelled(true);
                  return;
                }
              }
              if (InventoryContain(player, Material.SUGAR_CANE, 16).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 48.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.SUGAR_CANE, 16);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$48");
                  event.setCancelled(true);
                }
              }
              else {
                player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "You need " + 
                  ChatColor.GRAY + ChatColor.BOLD.toString() + "16 Sugar Cane" + ChatColor.RED + 
                  ChatColor.BOLD.toString() + "To sell!");
                return;
              }
            }
            
            if (clicked.getType().equals(Material.PUMPKIN)) {
              if (InventoryContain(player, Material.PUMPKIN, 64).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 24.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.SUGAR_CANE, 64);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$" + 80);
                  event.setCancelled(true);
                  return;
                }
              }
              if (InventoryContain(player, Material.PUMPKIN, 48).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 60.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.PUMPKIN, 48);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$" + 60);
                  event.setCancelled(true);
                  return;
                }
              }
              if (InventoryContain(player, Material.PUMPKIN, 32).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 40.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.PUMPKIN, 32);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$" + 40);
                  event.setCancelled(true);
                  return;
                }
              }
              if (InventoryContain(player, Material.PUMPKIN, 16).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 20.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.PUMPKIN, 16);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$20");
                  event.setCancelled(true);
                }
              }
              else {
                player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "You need " + 
                  ChatColor.GRAY + ChatColor.BOLD.toString() + "16 Pumpkins " + ChatColor.RED + 
                  ChatColor.BOLD.toString() + "To sell!");
                return;
              }
            }
            if (clicked.getType().equals(Material.ROTTEN_FLESH)) {
              if (InventoryContain(player, Material.ROTTEN_FLESH, 64).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 450.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.ROTTEN_FLESH, 64);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$" + 450);
                  event.setCancelled(true);
                  return;
                }
              }
              if (InventoryContain(player, Material.ROTTEN_FLESH, 32).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 225.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.ROTTEN_FLESH, 32);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$225");
                  event.setCancelled(true);
                }
              }
              else {
                player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "You need " + 
                  ChatColor.GRAY + ChatColor.BOLD.toString() + "32 Rotten Flesh" + ChatColor.RED + 
                  ChatColor.BOLD.toString() + "To sell!");
                return;
              }
            }
            if (clicked.getType().equals(Material.ENDER_PEARL)) {
              if (InventoryContain(player, Material.ENDER_PEARL, 16).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 320.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.ENDER_PEARL, 16);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$320");
                  event.setCancelled(true);
                }
              }
              else {
                player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "You need " + 
                  ChatColor.GRAY + ChatColor.BOLD.toString() + "16 Ender Pearl" + ChatColor.RED + 
                  ChatColor.BOLD.toString() + "To sell!");
                return;
              }
            }
            if (clicked.getType().equals(Material.BLAZE_ROD)) {
              if (InventoryContain(player, Material.BLAZE_ROD, 64).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 960.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.BLAZE_ROD, 64);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$960");
                  event.setCancelled(true);
                }
              }
              else {
                player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "You need " + 
                  ChatColor.GRAY + ChatColor.BOLD.toString() + "64 Blaze Rods" + ChatColor.RED + 
                  ChatColor.BOLD.toString() + "To sell!");
                return;
              }
            }
            
            if (clicked.getType().equals(Material.QUARTZ_BLOCK)) {
              if (InventoryContain(player, Material.QUARTZ_BLOCK, 64).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 250.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.QUARTZ_BLOCK, 64);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$250");
                  event.setCancelled(true);
                }
              }
              else {
                player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "You need " + 
                  ChatColor.GRAY + ChatColor.BOLD.toString() + "64 Blaze Rods" + ChatColor.RED + 
                  ChatColor.BOLD.toString() + "To sell!");
                return;
              }
            }
            
            if (clicked.getType().equals(Material.STRING)) {
              if (InventoryContain(player, Material.STRING, 64).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 400.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.STRING, 64);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$" + 400);
                  event.setCancelled(true);
                  return;
                }
              }
              if (InventoryContain(player, Material.STRING, 48).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 300.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.STRING, 48);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$" + 300);
                  event.setCancelled(true);
                  return;
                }
              }
              if (InventoryContain(player, Material.STRING, 32).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 200.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.STRING, 32);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$" + 200);
                  event.setCancelled(true);
                  return;
                }
              }
              if (InventoryContain(player, Material.STRING, 16).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 100.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.STRING, 16);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$100");
                  event.setCancelled(true);
                }
              }
              else {
                player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "You need " + 
                  ChatColor.GRAY + ChatColor.BOLD.toString() + "16 String" + ChatColor.RED + 
                  ChatColor.BOLD.toString() + "To sell!");
                return;
              }
            }
            
            if (clicked.getType().equals(Material.FEATHER)) {
              if (InventoryContain(player, Material.FEATHER, 64).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 64.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.FEATHER, 64);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$" + 64);
                  event.setCancelled(true);
                  return;
                }
              }
              if (InventoryContain(player, Material.FEATHER, 48).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 48.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.FEATHER, 48);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$" + 48);
                  event.setCancelled(true);
                  return;
                }
              }
              if (InventoryContain(player, Material.FEATHER, 32).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 32.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.FEATHER, 32);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$" + 32);
                  event.setCancelled(true);
                  return;
                }
              }
              
              if (InventoryContain(player, Material.FEATHER, 16).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 16.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.FEATHER, 16);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$16");
                  event.setCancelled(true);
                }
              }
              else {
                player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "You need " + 
                  ChatColor.GRAY + ChatColor.BOLD.toString() + "16 Feather" + ChatColor.RED + 
                  ChatColor.BOLD.toString() + "To sell!");
                return;
              }
            }
            
            if ((clicked.getType().equals(Material.LOG)) && 
              (clicked.getDurability() == 0)) {
              if (InventoryContainItem(player, Material.LOG, 64, 0).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 140.0D);
                if (r.transactionSuccess()) {
                  InventorySearchItem(player, Material.LOG, 64, 0);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$" + 140);
                  event.setCancelled(true);
                  return;
                }
              }
              if (InventoryContainItem(player, Material.LOG, 48, 0).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 105.0D);
                if (r.transactionSuccess()) {
                  InventorySearchItem(player, Material.LOG, 48, 0);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$" + 105);
                  event.setCancelled(true);
                  return;
                }
              }
              if (InventoryContainItem(player, Material.LOG, 32, 0).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 70.0D);
                if (r.transactionSuccess()) {
                  InventorySearchItem(player, Material.LOG, 32, 0);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$" + 70);
                  event.setCancelled(true);
                  return;
                }
              }
              if (InventoryContainItem(player, Material.LOG, 16, 0).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 35.0D);
                if (r.transactionSuccess()) {
                  InventorySearchItem(player, Material.LOG, 16, 0);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$35");
                  event.setCancelled(true);
                }
              }
              else {
                player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "You need " + 
                  ChatColor.GRAY + ChatColor.BOLD.toString() + "16 Oak Wood " + 
                  ChatColor.RED + ChatColor.BOLD.toString() + "To sell!");
                return;
              }
            }
            

            if ((clicked.getType().equals(Material.INK_SACK)) && 
              (clicked.getDurability() == 4)) {
              if (InventoryContainItem(player, Material.INK_SACK, 64, 4).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 300.0D);
                if (r.transactionSuccess()) {
                  InventorySearchItem(player, Material.INK_SACK, 64, 4);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$" + 300);
                  event.setCancelled(true);
                  return;
                }
              }
              if (InventoryContainItem(player, Material.INK_SACK, 48, 4).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 225.0D);
                if (r.transactionSuccess()) {
                  InventorySearchItem(player, Material.INK_SACK, 48, 4);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$" + 225);
                  event.setCancelled(true);
                  return;
                }
              }
              if (InventoryContainItem(player, Material.INK_SACK, 32, 4).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 150.0D);
                if (r.transactionSuccess()) {
                  InventorySearchItem(player, Material.INK_SACK, 32, 4);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$" + 150);
                  event.setCancelled(true);
                  return;
                }
              }
              if (InventoryContainItem(player, Material.INK_SACK, 16, 4).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 75.0D);
                if (r.transactionSuccess()) {
                  InventorySearchItem(player, Material.INK_SACK, 16, 4);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$75");
                  event.setCancelled(true);
                }
              }
              else {
                player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "You need " + 
                  ChatColor.GRAY + ChatColor.BOLD.toString() + "16 Lapius " + ChatColor.RED + 
                  ChatColor.BOLD.toString() + "To sell!");
                return;
              }
            }
            

            if ((clicked.getType().equals(Material.LOG)) && 
              (clicked.getDurability() == 1)) {
              if (InventoryContainItem(player, Material.LOG, 64, 1).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 140.0D);
                if (r.transactionSuccess()) {
                  InventorySearchItem(player, Material.LOG, 64, 1);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$" + 140);
                  event.setCancelled(true);
                  return;
                }
              }
              if (InventoryContainItem(player, Material.LOG, 48, 1).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 105.0D);
                if (r.transactionSuccess()) {
                  InventorySearchItem(player, Material.LOG, 48, 1);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$" + 105);
                  event.setCancelled(true);
                  return;
                }
              }
              if (InventoryContainItem(player, Material.LOG, 32, 1).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 70.0D);
                if (r.transactionSuccess()) {
                  InventorySearchItem(player, Material.LOG, 32, 1);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$" + 70);
                  event.setCancelled(true);
                  return;
                }
              }
              if (InventoryContainItem(player, Material.LOG, 16, 1).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 35.0D);
                if (r.transactionSuccess()) {
                  InventorySearchItem(player, Material.LOG, 16, 1);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$35");
                  event.setCancelled(true);
                }
              }
              else {
                player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "You need " + 
                  ChatColor.GRAY + ChatColor.BOLD.toString() + "16 Spruce Wood " + 
                  ChatColor.RED + ChatColor.BOLD.toString() + "To sell!");
                return;
              }
            }
            

            if ((clicked.getType().equals(Material.LOG)) && 
              (clicked.getDurability() == 2)) {
              if (InventoryContainItem(player, Material.LOG, 64, 2).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 140.0D);
                if (r.transactionSuccess()) {
                  InventorySearchItem(player, Material.LOG, 64, 2);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$" + 140);
                  event.setCancelled(true);
                  return;
                }
              }
              if (InventoryContainItem(player, Material.LOG, 48, 2).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 105.0D);
                if (r.transactionSuccess()) {
                  InventorySearchItem(player, Material.LOG, 48, 2);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$" + 105);
                  event.setCancelled(true);
                  return;
                }
              }
              if (InventoryContainItem(player, Material.LOG, 32, 2).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 70.0D);
                if (r.transactionSuccess()) {
                  InventorySearchItem(player, Material.LOG, 32, 2);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$" + 70);
                  event.setCancelled(true);
                  return;
                }
              }
              if (InventoryContainItem(player, Material.LOG, 16, 2).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 35.0D);
                if (r.transactionSuccess()) {
                  InventorySearchItem(player, Material.LOG, 16, 2);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$35");
                  event.setCancelled(true);
                }
              }
              else {
                player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "You need " + 
                  ChatColor.GRAY + ChatColor.BOLD.toString() + "16 Birch Wood " + 
                  ChatColor.RED + ChatColor.BOLD.toString() + "To sell!");
                return;
              }
            }
            

            if ((clicked.getType().equals(Material.LOG_2)) && 
              (clicked.getDurability() == 1)) {
              if (InventoryContainItem(player, Material.LOG_2, 64, 1).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 140.0D);
                if (r.transactionSuccess()) {
                  InventorySearchItem(player, Material.LOG_2, 64, 1);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$" + 140);
                  event.setCancelled(true);
                  return;
                }
              }
              if (InventoryContainItem(player, Material.LOG_2, 48, 1).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 105.0D);
                if (r.transactionSuccess()) {
                  InventorySearchItem(player, Material.LOG_2, 48, 1);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$" + 105);
                  event.setCancelled(true);
                  return;
                }
              }
              if (InventoryContainItem(player, Material.LOG_2, 32, 1).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 70.0D);
                if (r.transactionSuccess()) {
                  InventorySearchItem(player, Material.LOG_2, 32, 1);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$" + 70);
                  event.setCancelled(true);
                  return;
                }
              }
              if (InventoryContainItem(player, Material.LOG_2, 16, 1).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 35.0D);
                if (r.transactionSuccess()) {
                  InventorySearchItem(player, Material.LOG_2, 16, 1);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$35");
                  event.setCancelled(true);
                }
              }
              else {
                player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "You need " + 
                  ChatColor.GRAY + ChatColor.BOLD.toString() + "16 Dark Oak Wood " + 
                  ChatColor.RED + ChatColor.BOLD.toString() + "To sell!");
                return;
              }
            }
            

            if ((clicked.getType().equals(Material.LOG)) && 
              (clicked.getDurability() == 3)) {
              if (InventoryContainItem(player, Material.LOG, 64, 3).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 140.0D);
                if (r.transactionSuccess()) {
                  InventorySearchItem(player, Material.LOG, 64, 3);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$" + 140);
                  event.setCancelled(true);
                  return;
                }
              }
              if (InventoryContainItem(player, Material.LOG, 48, 3).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 105.0D);
                if (r.transactionSuccess()) {
                  InventorySearchItem(player, Material.LOG, 48, 3);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$" + 105);
                  event.setCancelled(true);
                  return;
                }
              }
              if (InventoryContainItem(player, Material.LOG, 32, 3).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 70.0D);
                if (r.transactionSuccess()) {
                  InventorySearchItem(player, Material.LOG, 32, 3);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$" + 70);
                  event.setCancelled(true);
                  return;
                }
              }
              if (InventoryContainItem(player, Material.LOG, 16, 3).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 35.0D);
                if (r.transactionSuccess()) {
                  InventorySearchItem(player, Material.LOG, 16, 3);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$35");
                  event.setCancelled(true);
                }
              }
              else {
                player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "You need " + 
                  ChatColor.GRAY + ChatColor.BOLD.toString() + "16 Jungle Wood " + 
                  ChatColor.RED + ChatColor.BOLD.toString() + "To sell!");
                return;
              }
            }
            

            if (clicked.getType().equals(Material.ARROW)) {
              if (InventoryContain(player, Material.ARROW, 64).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 400.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.ARROW, 64);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$" + 400);
                  event.setCancelled(true);
                  return;
                }
              }
              if (InventoryContain(player, Material.ARROW, 48).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 300.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.ARROW, 48);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$" + 300);
                  event.setCancelled(true);
                  return;
                }
              }
              if (InventoryContain(player, Material.ARROW, 32).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 200.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.ARROW, 32);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$" + 200);
                  event.setCancelled(true);
                  return;
                }
              }
              if (InventoryContain(player, Material.ARROW, 16).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 100.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.ARROW, 16);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$100");
                  event.setCancelled(true);
                }
              }
              else {
                player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "You need " + 
                  ChatColor.GRAY + ChatColor.BOLD.toString() + "16 Arrows" + ChatColor.RED + 
                  ChatColor.BOLD.toString() + "To sell!");
                return;
              }
            }
            
            if (clicked.getType().equals(Material.SPIDER_EYE)) {
              if (InventoryContain(player, Material.SPIDER_EYE, 64).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 600.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.SPIDER_EYE, 64);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$" + 600);
                  event.setCancelled(true);
                  return;
                }
              }
              if (InventoryContain(player, Material.SPIDER_EYE, 48).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 450.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.SPIDER_EYE, 48);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$" + 450);
                  event.setCancelled(true);
                  return;
                }
              }
              if (InventoryContain(player, Material.SPIDER_EYE, 32).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 300.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.SPIDER_EYE, 32);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$" + 300);
                  event.setCancelled(true);
                  return;
                }
              }
              if (InventoryContain(player, Material.SPIDER_EYE, 16).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 150.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.SPIDER_EYE, 16);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$150");
                  event.setCancelled(true);
                }
              }
              else {
                player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "You need " + 
                  ChatColor.GRAY + ChatColor.BOLD.toString() + "16 Spider Eye" + ChatColor.RED + 
                  ChatColor.BOLD.toString() + "To sell!");
                return;
              }
            }
            if (clicked.getType().equals(Material.BONE)) {
              if (InventoryContain(player, Material.BONE, 64).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 200.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.BONE, 64);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$" + 200);
                  event.setCancelled(true);
                  return;
                }
              }
              if (InventoryContain(player, Material.BONE, 48).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 150.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.BONE, 48);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$" + 150);
                  event.setCancelled(true);
                  return;
                }
              }
              if (InventoryContain(player, Material.BONE, 32).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 100.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.BONE, 32);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$" + 100);
                  event.setCancelled(true);
                  return;
                }
              }
              if (InventoryContain(player, Material.BONE, 16).booleanValue()) {
                EconomyResponse r = Core.economy.depositPlayer(player.getName(), 50.0D);
                if (r.transactionSuccess()) {
                  InventorySearch(player, Material.BONE, 16);
                  player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$50");
                  event.setCancelled(true);
                }
              }
              else {
                player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "You need " + 
                  ChatColor.GRAY + ChatColor.BOLD.toString() + "16 Bones" + ChatColor.RED + 
                  ChatColor.BOLD.toString() + "To sell!");
                return;
              }
            }
          }
          
          int amountmoney = Integer.parseInt(getNum);
          
          if (InventoryContain(player, clicked.getType(), getamount(player, clicked.getType())).booleanValue()) {
            EconomyResponse r = Core.economy.depositPlayer(player.getName(), 
              getamount(player, clicked.getType()) * amountmoney);
            if (r.transactionSuccess()) {
              player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "$" + 
                getamount(player, clicked.getType()) * amountmoney);
              InventorySearch(player, clicked.getType(), getamount(player, clicked.getType()));
              event.setCancelled(true);
            }
          } else {
            player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + 
              "You don't have that item in your inventory!");
            return;
          }
        } catch (NumberFormatException ex) {
          return;
        }
      }
      event.setCancelled(true);
    }
    else if (event.getInventory().getName().equals(GUIClass.spawnerMenu().getName()))
    {
      event.setCancelled(true);
      String name = ChatColor.stripColor(clicked.getItemMeta().getDisplayName());
      String cleanedLore = ChatColor.stripColor((String)clicked.getItemMeta().getLore().get(0));
      
      String getNum = cleanedLore.replace("Buy: ", "").replace("$", "");
      int amountmoney = Integer.parseInt(getNum);
      if (player.getInventory().firstEmpty() == -1)
      {
        player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "You need: " + ChatColor.GRAY + 
          "1 Empty Slots" + ChatColor.RED + " to buy!");
        return;
      }
      if (Core.economy.getBalance(player.getName()) >= amountmoney)
      {
        EconomyResponse r = Core.economy.withdrawPlayer(player.getName(), amountmoney);
        if (r.transactionSuccess())
        {
          player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + amountmoney + "$");
          if (name.toLowerCase().contains("pig")) {
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), 
              "silkspawners give " + player.getName() + " pig 1");
          }
          if (name.toLowerCase().contains("cow")) {
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), 
              "silkspawners give " + player.getName() + " cow 1");
          }
          if (name.toLowerCase().contains("squid")) {
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), 
              "silkspawners give " + player.getName() + " squid 1");
          }
          if (name.toLowerCase().contains("chicken")) {
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), 
              "silkspawners give " + player.getName() + " chicken 1");
          }
          if (name.toLowerCase().contains("skeleton")) {
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), 
              "silkspawners give " + player.getName() + " skeleton 1");
          }
          if (name.toLowerCase().contains("zombie")) {
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), 
              "silkspawners give " + player.getName() + " zombie 1");
          }
          if (name.toLowerCase().contains("spider")) {
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), 
              "silkspawners give " + player.getName() + " spider 1");
          }
          if (name.toLowerCase().contains("cave Spider")) {
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), 
              "silkspawners give " + player.getName() + " cavespider 1");
          }
          if (name.toLowerCase().contains("witch")) {
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), 
              "silkspawners give " + player.getName() + " witch 1");;
          }
          if (name.toLowerCase().contains("blaze")) {
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), 
              "silkspawners give " + player.getName() + " blaze 1");
          }
          if (name.toLowerCase().contains("creeper")) {
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), 
              "silkspawners give " + player.getName() + " creeper 1");
          }
          if (name.toLowerCase().contains("mooshroom")) {
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), 
              "silkspawners give " + player.getName() + " mooshroom 1");
          }
          event.setCancelled(true);
        }
      }
      else
      {
        player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "Not enough Money!");
      }
    }
    else if (event.getInventory().getName().equals(GUIClass.vipchooseMenu().getName())) {
      event.setCancelled(true);
      
      String cleaned1 = ChatColor.stripColor(clicked.getItemMeta().getDisplayName());
      
      if ((clicked.getType().equals(Material.STAINED_GLASS_PANE)) || (clicked.getType().equals(Material.THIN_GLASS)) || 
        (clicked.getItemMeta().getDisplayName().equals(" "))) {
        event.setCancelled(true);
        return;
      }
      
      if ((cleaned1.equals("Donator Shop")) && 
        (player.hasPermission("globa.donator"))) {
        player.openInventory(GUIClass.donatorMenu());
        event.setCancelled(true);
      }
      
      if (cleaned1.equals("Cannon Shop")) {
        if (player.hasPermission("global.legend")) {
          player.openInventory(GUIClass.cannonMenu());
          event.setCancelled(true);
        }
        event.setCancelled(true);
      }
    }
  }
  
  public Boolean InventoryContain(Player player, Material item, int amount)
  {
    for (ItemStack a : player.getInventory().getContents()) {
      if ((a != null) && 
        (a.getType().equals(item)) && (a.getAmount() >= amount)) {
        return Boolean.valueOf(true);
      }
    }
    
    return Boolean.valueOf(false);
  }
  
  public Boolean InventoryContainItem(Player player, Material item, int amount, int Dur) {
    for (ItemStack a : player.getInventory().getContents()) {
      if ((a != null) && 
        (a.getType().equals(item)) && (a.getAmount() >= amount) && (a.getDurability() == Dur)) {
        return Boolean.valueOf(true);
      }
    }
    
    return Boolean.valueOf(false);
  }
  
  public int getamount(Player player, Material item) {
    for (ItemStack a : player.getInventory().getContents()) {
      if ((a != null) && 
        (a.getType().equals(item))) {
        return a.getAmount();
      }
    }
    
    return 0;
  }
  
  public void InventorySearch(Player player, Material item, int AmountRemoved) {
    for (int i = 0; i < player.getInventory().getSize(); i++) {
      ItemStack itm = player.getInventory().getItem(i);
      if ((itm != null) && (itm.getType().equals(item))) {
        int amt = itm.getAmount() - AmountRemoved;
        itm.setAmount(amt);
        player.getInventory().setItem(i, amt > 0 ? itm : null);
        player.updateInventory();
        break;
      }
    }
  }
  

  public void InventorySearchItem(Player player, Material item, int AmountRemoved, int dur)
  {
    for (int i = 0; i < player.getInventory().getSize(); i++) {
      ItemStack itm = player.getInventory().getItem(i);
      if ((itm != null) && (itm.getType().equals(item)) && (itm.getDurability() == dur)) {
        int amt = itm.getAmount() - AmountRemoved;
        itm.setAmount(amt);
        player.getInventory().setItem(i, amt > 0 ? itm : null);
        player.updateInventory();
        break;
      }
    }
  }
  

  public int slotsleft(Player player)
  {
    int count = 0;
    Inventory contents = player.getInventory();
    for (ItemStack a : contents) {
      if ((a == null) || (a.equals(Material.AIR))) {
        count++;
      }
    }
    return count;
  }
}
