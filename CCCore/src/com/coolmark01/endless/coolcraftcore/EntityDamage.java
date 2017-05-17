package com.coolmark01.endless.coolcraftcore;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.Vector;

public class EntityDamage
  implements Listener
{
  public EntityDamage(Core core) {}
  
  @EventHandler
  public void onHit(EntityDamageByEntityEvent event)
  {
    if ((event.getEntity() instanceof Blaze))
    {
      final Monster m = (Blaze)event.getEntity();
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Core.getPlugin(), new Runnable()
      {
        public void run()
        {
          m.setVelocity(new Vector());
        }
      }, 1L);
    }
    if ((event.getDamager() instanceof Arrow))
    {
      Arrow arrow = (Arrow)event.getDamager();
      if ((arrow.getShooter() instanceof Player))
      {
        Player damager = (Player)arrow.getShooter();
        damager.playSound(damager.getLocation(), Sound.ITEM_PICKUP, 1.0F, 4.0F);
      }
    }
  }
}
