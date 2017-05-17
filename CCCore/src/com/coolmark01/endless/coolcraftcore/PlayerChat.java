package com.coolmark01.endless.coolcraftcore;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.Faction;
import com.massivecraft.factions.struct.ChatMode;
import java.util.List;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChat
  implements Listener
{
  public PlayerChat(Core core) {}
  
  @EventHandler
  public void warpCommand(AsyncPlayerChatEvent event)
  {
    Player player = event.getPlayer();
    FPlayer fp = FPlayers.getInstance().getByPlayer(player);
    if (!Core.socialspy.isEmpty()) {
      if (fp.getChatMode().equals(ChatMode.FACTION)) {
        for (UUID a : Core.socialspy)
        {
          Player player1 = Bukkit.getPlayer(a);
          player1.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "-(FCF) " + ChatColor.AQUA + 
            player.getName() + " " + ChatColor.RED + ChatColor.BOLD.toString() + 
            FPlayers.getInstance().getByPlayer(player).getFaction().getTag() + ":" + ChatColor.GOLD + 
            " " + event.getMessage());
        }
      } else if (fp.getChatMode().equals(ChatMode.ALLIANCE)) {
        for (UUID a : Core.socialspy)
        {
          Player player1 = Bukkit.getPlayer(a);
          player1.sendMessage(ChatColor.LIGHT_PURPLE + ChatColor.BOLD.toString() + "-(FCA) " + ChatColor.AQUA + 
            player.getName() + " " + ChatColor.BLUE + ChatColor.UNDERLINE.toString() + 
            ChatColor.BOLD.toString() + 
            FPlayers.getInstance().getByPlayer(player).getFaction().getTag() + ":" + ChatColor.GOLD + 
            " " + event.getMessage());
        }
      } else if (fp.getChatMode().equals(ChatMode.TRUCE)) {
        for (UUID a : Core.socialspy)
        {
          Player player1 = Bukkit.getPlayer(a);
          player1.sendMessage(ChatColor.DARK_PURPLE + ChatColor.BOLD.toString() + "-(FCT) " + ChatColor.AQUA + 
            player.getName() + " " + ChatColor.BLUE + ChatColor.UNDERLINE.toString() + 
            ChatColor.BOLD.toString() + 
            FPlayers.getInstance().getByPlayer(player).getFaction().getTag() + ":" + ChatColor.GOLD + 
            " " + event.getMessage());
        }
      }
    }
  }
}
