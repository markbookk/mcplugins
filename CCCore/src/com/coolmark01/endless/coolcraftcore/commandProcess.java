package com.coolmark01.endless.coolcraftcore;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.Faction;
import com.massivecraft.factions.struct.Relation;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;
import org.bukkit.util.Vector;
import ru.tehkode.permissions.PermissionManager;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class commandProcess
  implements Listener
{
  public commandProcess(Core core) {}
  
  @EventHandler
  public void warpCommand(PlayerCommandPreprocessEvent event)
  {
    Player player = event.getPlayer();
    if ((event.getMessage().toLowerCase().contains("/f create")) || 
      (event.getMessage().toLowerCase().contains("/f leave")) || 
      (event.getMessage().toLowerCase().contains("/f join")) || 
      (event.getMessage().toLowerCase().contains("/f disband")) || 
      (event.getMessage().toLowerCase().contains("/f ally")) || 
      (event.getMessage().toLowerCase().contains("/f enemy")) || 
      (event.getMessage().toLowerCase().contains("/f neutral")) || 
      (event.getMessage().toLowerCase().contains("/f invite")) || 
      (event.getMessage().toLowerCase().contains("/f kick"))) {
      Bukkit.getScheduler().scheduleSyncDelayedTask(Core.getPlugin(), new Runnable()
      {
        public void run()
        {
          commandProcess.this.setPrefixblue();
        }
      }, 1L);
    }
    if ((event.getMessage().equalsIgnoreCase("/f scoreboard")) || (event.getMessage().equalsIgnoreCase("/f sb")) || 
      (event.getMessage().equalsIgnoreCase("/factions sb")) || 
      (event.getMessage().equalsIgnoreCase("/factions scoreboard")))
    {
      event.setCancelled(true);
      player.sendMessage("You cannot use scoreboards! Sorry!");
    }
    if ((event.getMessage().equalsIgnoreCase("/help")) && (!player.isOp()))
    {
      event.setCancelled(true);
      player.sendMessage(ChatColor.YELLOW + ChatColor.BOLD.toString() + "/rtp" + ChatColor.DARK_GRAY + " | " + 
        ChatColor.GRAY + "Randomly teleports you in the world!");
      player.sendMessage(ChatColor.YELLOW + ChatColor.BOLD.toString() + "/f help" + ChatColor.DARK_GRAY + " | " + 
        ChatColor.GRAY + "Tells you the faction command!");
      player.sendMessage(ChatColor.YELLOW + ChatColor.BOLD.toString() + "/trade" + ChatColor.DARK_GRAY + " | " + 
        ChatColor.GRAY + "Trade witha nother player.");
      player.sendMessage(ChatColor.YELLOW + ChatColor.BOLD.toString() + "/warps" + ChatColor.DARK_GRAY + " | " + 
        ChatColor.GRAY + "Brings up a GUI with the warps.");
      player.sendMessage(ChatColor.YELLOW + ChatColor.BOLD.toString() + "/shop" + ChatColor.DARK_GRAY + " | " + 
        ChatColor.GRAY + "Bring up a shop GUI.");
      player.sendMessage(ChatColor.YELLOW + ChatColor.BOLD.toString() + "/tpa <PlayerName>" + ChatColor.DARK_GRAY + 
        " | " + ChatColor.GRAY + "Sends a request for teleporting to that player.");
      player.sendMessage(ChatColor.YELLOW + ChatColor.BOLD.toString() + "/sethome" + ChatColor.DARK_GRAY + " | " + 
        ChatColor.GRAY + "Set your home so you can use /home!");
      player.sendMessage(ChatColor.YELLOW + ChatColor.BOLD.toString() + "/home" + ChatColor.DARK_GRAY + " | " + 
        ChatColor.GRAY + "Sends you to your home.");
      player.sendMessage(ChatColor.YELLOW + ChatColor.BOLD.toString() + "/pv <#>" + ChatColor.DARK_GRAY + " | " + 
        ChatColor.GRAY + "Sends a request for teleporting to that player.");
      player.sendMessage(ChatColor.YELLOW + ChatColor.BOLD.toString() + "/ah" + ChatColor.DARK_GRAY + " | " + 
        ChatColor.GRAY + "Brings up the Auciton House GUI.");
    }
    else if ((event.getMessage().contains("/pv")) || (event.getMessage().contains("/sethome")) || 
      (event.getMessage().contains("/f sethome")) || (event.getMessage().contains("/tpaccept")))
    {
      int radius = 3;
      for (int i = -radius; i <= radius; i++) {
        for (int j = -radius; j <= radius; j++) {
          for (int k = -radius; k <= radius; k++) {
            if (event.getPlayer().getLocation().getBlock().getRelative(i, j, k).getType().equals(Material.WATER_LILY)) {
              event.setCancelled(true);
            }
          }
        }
      }
      if (event.isCancelled()) {
        player.sendMessage(ChatColor.RED + "Sorry, but you cant open PV's when near a lilly!");
      }
    }
    else if (event.getMessage().contains("/home"))
    {
      player.setVelocity(new Vector(0.0D, 0.1D, 0.0D));
    }
  }
  
  public ChatColor colorOfPlayers(Player player1, Player player2)
  {
    FPlayer fplayer = FPlayers.getInstance().getByPlayer(player1);
    Faction faction = FPlayers.getInstance().getByPlayer(player2).getFaction();
    if (fplayer.getFaction().getRelationTo(faction) == Relation.ENEMY) {
      return ChatColor.RED;
    }
    if (fplayer.getFaction().getRelationTo(faction) == Relation.ALLY) {
      return ChatColor.LIGHT_PURPLE;
    }
    if (fplayer.getFaction().getRelationTo(faction) == Relation.NEUTRAL) {
      return ChatColor.WHITE;
    }
    if (fplayer.getFaction().getRelationTo(faction) == Relation.MEMBER) {
      return ChatColor.AQUA;
    }
    if (fplayer.getFaction().getRelationTo(faction) == Relation.TRUCE) {
      return ChatColor.GREEN;
    }
    return null;
  }
  
  public void setPrefixblue()
  {
    Iterator localIterator2;
    for (Iterator localIterator1 = Bukkit.getOnlinePlayers().iterator(); localIterator1.hasNext(); localIterator2.hasNext())
    {
      Player player = (Player)localIterator1.next();
      
      Scoreboard a = null;
      a = player.getScoreboard();
      if (a == null)
      {
        a = Bukkit.getScoreboardManager().getNewScoreboard();
        player.setScoreboard(a);
      }
      Objective obj = a.getObjective("names");
      if (obj == null) {
        a.registerNewObjective("names", "dummy");
      }
      Team ta = a.getTeam(player.getName());
      if (ta == null) {
        ta = a.registerNewTeam(player.getName());
      }
      if (getRank(player) != null)
      {
        ta.setPrefix(getRank(player) + " " + ChatColor.GRAY);
        ta.removePlayer(player);
        ta.addPlayer(player);
      }
      else
      {
        ta.setPrefix(ChatColor.GRAY);
        ta.removePlayer(player);
        ta.addPlayer(player);
      }
      localIterator2 = Bukkit.getOnlinePlayers().iterator(); continue;Player player2 = (Player)localIterator2.next();
      if (player != player2)
      {
        Team t = a.getTeam(player2.getName());
        if (t == null) {
          t = a.registerNewTeam(player2.getName());
        }
        if (getRank(player2) != null)
        {
          t.setPrefix(getRank(player2) + " " + colorOfPlayers(player, player2));
          t.removePlayer(player2);
          t.addPlayer(player2);
        }
        else
        {
          t.setPrefix(colorOfPlayers(player, player2));
          t.removePlayer(player2);
          t.addPlayer(player2);
        }
      }
    }
  }
  
  public String getRank(Player player)
  {
    String b = a(player);
    if (b.equalsIgnoreCase("mortal")) {
      return null;
    }
    if (b.equals("donator")) {
      return ChatColor.DARK_GRAY + ChatColor.BOLD.toString() + "Donator";
    }
    if (b.equalsIgnoreCase("vip")) {
      return ChatColor.GRAY + ChatColor.BOLD.toString() + "VIP";
    }
    if (b.equalsIgnoreCase("hero")) {
      return ChatColor.YELLOW + ChatColor.BOLD.toString() + "Hero";
    }
    if (b.equalsIgnoreCase("saint")) {
      return ChatColor.DARK_AQUA + ChatColor.BOLD.toString() + "Saint";
    }
    if (b.equalsIgnoreCase("legend")) {
      return ChatColor.DARK_GREEN + ChatColor.BOLD.toString() + "Legend";
    }
    if (b.equalsIgnoreCase("god")) {
      return ChatColor.RED + ChatColor.BOLD.toString() + "God";
    }
    if (b.equalsIgnoreCase("zeus")) {
      return ChatColor.DARK_PURPLE + ChatColor.BOLD.toString() + "Zeus";
    }
    if (b.equalsIgnoreCase("helper")) {
      return ChatColor.DARK_RED + ChatColor.BOLD.toString() + "Helper";
    }
    if (b.equalsIgnoreCase("immortal")) {
      return ChatColor.GOLD + ChatColor.BOLD.toString() + "Immortal";
    }
    if (b.equalsIgnoreCase("chatmod")) {
      return ChatColor.AQUA + ChatColor.BOLD.toString() + "ChatMod";
    }
    if (b.equalsIgnoreCase("moderator")) {
      return ChatColor.DARK_AQUA + ChatColor.BOLD.toString() + "Moderator";
    }
    if (b.equalsIgnoreCase("dev")) {
      return ChatColor.AQUA + ChatColor.BOLD.toString() + "Dev";
    }
    if (b.equalsIgnoreCase("admin")) {
      return ChatColor.RED + ChatColor.BOLD.toString() + "Admin";
    }
    if (b.equalsIgnoreCase("co-owner")) {
      return ChatColor.AQUA + "Co-Owner";
    }
    if (b.equalsIgnoreCase("owner")) {
      return ChatColor.GREEN + ChatColor.BOLD.toString() + "Owner";
    }
    return null;
  }
  
  public String getPrimaryGroup(String world, OfflinePlayer op)
  {
    PermissionUser user = getUser(op);
    if (user == null) {
      return null;
    }
    if (user.getParentIdentifiers(world).size() > 0) {
      return (String)user.getParentIdentifiers(world).get(0);
    }
    return null;
  }
  
  private PermissionUser getUser(OfflinePlayer op)
  {
    return PermissionsEx.getPermissionManager().getUser(op.getUniqueId());
  }
  
  private String a(Player player)
  {
    return getPrimaryGroup(player.getWorld().getName(), player);
  }
}
