package com.coolmark01.endless.coolcraftcore;

import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import ru.tehkode.permissions.PermissionManager;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class BlockBreak
  implements Listener
{
  public BlockBreak(Core core) {}
  
  @EventHandler
  public void warpCommand(BlockBreakEvent event)
  {
    Player player = event.getPlayer();
    String group = a(player);
    if ((group.equalsIgnoreCase("donator")) || (group.equalsIgnoreCase("vip")) || (group.equalsIgnoreCase("hero")) || 
      (group.equalsIgnoreCase("saint")) || (group.equalsIgnoreCase("legend")) || (group.equalsIgnoreCase("god")) || 
      (group.equalsIgnoreCase("zeus")) || (group.equalsIgnoreCase("immortal"))) {
      return;
    }
    if ((event.getBlock().equals(Material.AIR)) || (event.getBlock() == null)) {
      return;
    }
    if (event.getBlock().equals(Material.MOB_SPAWNER))
    {
      event.setCancelled(true);
      player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "You must have " + ChatColor.GRAY + 
        ChatColor.BOLD.toString() + "a rank " + ChatColor.RED + ChatColor.BOLD.toString() + 
        "to mine spawners!");
    }
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
