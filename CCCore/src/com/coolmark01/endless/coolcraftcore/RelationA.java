package com.coolmark01.endless.coolcraftcore;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.Faction;
import com.massivecraft.factions.event.FactionRelationWishEvent;
import com.massivecraft.factions.struct.Relation;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;
import ru.tehkode.permissions.PermissionManager;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class RelationA
  implements Listener
{
  public RelationA(Core core) {}
  
  @EventHandler
  public void onUse(FactionRelationWishEvent event)
  {
    Bukkit.getScheduler().scheduleSyncDelayedTask(Core.getPlugin(), new Runnable()
    {
      public void run()
      {
        RelationA.this.setPrefixblue();
      }
    }, 1L);
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
