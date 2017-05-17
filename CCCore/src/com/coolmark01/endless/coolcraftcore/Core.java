package com.coolmark01.endless.coolcraftcore;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Scoreboard;

public class Core
  extends JavaPlugin
  implements CommandExecutor
{
  private static Core plugin;
  
  public static Core getPlugin()
  {
    return plugin;
  }
  
  Scoreboard sb = null;
  
  public void onEnable()
  {
    plugin = this;
    
    getLogger().info(">>Plugin " + getDescription().getVersion() + "Is enabled!");
    getCommand("wild").setExecutor(this);
    getCommand("rule").setExecutor(this);
    getCommand("base").setExecutor(this);
    getCommand("nv").setExecutor(this);
    getCommand("nightvison").setExecutor(this);
    getCommand("enemy").setExecutor(this);
    getCommand("ally").setExecutor(this);
    getCommand("fsocialspy").setExecutor(this);
    getCommand("ts").setExecutor(this);
    getCommand("teamspeak").setExecutor(this);
    
    RegisterListeners();
  }
  
  public void onDisable()
  {
    getLogger().info(">>Plugin " + getDescription().getVersion() + "Is Disable!");
  }
  
  public void RegisterListeners()
  {
    PluginManager pm = getServer().getPluginManager();
    pm.registerEvents(new EntityDamage(this), this);
    pm.registerEvents(new commandProcess(this), this);
    pm.registerEvents(new playerJoin(this), this);
    pm.registerEvents(new BlockBreak(this), this);
    pm.registerEvents(new PlayerChat(this), this);
    pm.registerEvents(new FactionCreate(this), this);
    pm.registerEvents(new FactionDisband(this), this);
    pm.registerEvents(new FactionChange(this), this);
    pm.registerEvents(new RelationA(this), this);
  }
  
  List<UUID> enabled = new ArrayList();
  public static List<UUID> socialspy = new ArrayList();
  
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
  {
    Player player = (Player)sender;
    if ((sender instanceof Player))
    {
      if (label.equalsIgnoreCase("wild"))
      {
        player.chat("/rtp");
        return true;
      }
      if (label.equalsIgnoreCase("rule"))
      {
        player.chat("/rules");
        return true;
      }
      if (label.equalsIgnoreCase("base"))
      {
        player.chat("/f home");
        return true;
      }
      if (label.equalsIgnoreCase("enemy"))
      {
        player.chat("/f enemy " + args[0]);
        return true;
      }
      if (label.equalsIgnoreCase("ally"))
      {
        player.chat("/f ally " + args[0]);
        return true;
      }
      if (label.equalsIgnoreCase("ts")) {
        player.sendMessage(ChatColor.DARK_GRAY + ChatColor.BOLD.toString() + "[" + ChatColor.BLUE + 
          ChatColor.BOLD.toString() + "TEAM SPEAK" + ChatColor.DARK_GRAY + ChatColor.BOLD.toString() + 
          "] " + ChatColor.GRAY + ChatColor.ITALIC.toString() + "coolcraftpvp.net");
      }
      if (label.equalsIgnoreCase("teamspeak")) {
        player.sendMessage(ChatColor.DARK_GRAY + ChatColor.BOLD.toString() + "[" + ChatColor.BLUE + 
          ChatColor.BOLD.toString() + "TEAM SPEAK" + ChatColor.DARK_GRAY + ChatColor.BOLD.toString() + 
          "] " + ChatColor.GRAY + ChatColor.ITALIC.toString() + "coolcraftpvp.net");
      }
      if (label.equalsIgnoreCase("fsocialspy")) {
        if (player.hasPermission("cccore.fsocialspy"))
        {
          if (!socialspy.contains(player.getUniqueId()))
          {
            player.sendMessage(ChatColor.GRAY + ChatColor.BOLD.toString() + "Faction Social Spy: " + 
              ChatColor.GREEN + ChatColor.BOLD.toString() + "Enabled!");
            socialspy.add(player.getUniqueId());
          }
          else
          {
            player.sendMessage(ChatColor.GRAY + ChatColor.BOLD.toString() + "Faction Social Spy: " + 
              ChatColor.RED + ChatColor.BOLD.toString() + "Disabled!");
            socialspy.remove(player.getUniqueId());
          }
        }
        else {
          player.sendMessage(ChatColor.RED + "You dont have the right permissons!");
        }
      }
      if (((label.equalsIgnoreCase("nv")) || (label.equalsIgnoreCase("nightvison"))) && 
        (player.hasPermission("cccore.nv"))) {
        if (!this.enabled.contains(player.getUniqueId()))
        {
          player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 2000000000, 4));
          player.sendMessage(ChatColor.AQUA + ChatColor.BOLD.toString() + "Night Vision " + 
            ChatColor.GREEN + ChatColor.BOLD.toString() + "Enabled");
          this.enabled.add(player.getUniqueId());
        }
        else
        {
          player.removePotionEffect(PotionEffectType.NIGHT_VISION);
          player.sendMessage(ChatColor.AQUA + ChatColor.BOLD.toString() + "Night Vision " + ChatColor.RED + 
            ChatColor.BOLD + "Disabled");
          this.enabled.remove(player.getUniqueId());
        }
      }
    }
    return false;
  }
}
