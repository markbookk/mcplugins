/*
 * Decompiled with CFR 0_118.
 * 
 * Could not load the following classes:
 *  com.connorlinfoot.actionbarapi.ActionBarAPI
 *  com.massivecraft.factions.FPlayer
 *  com.massivecraft.factions.FPlayers
 *  com.massivecraft.factions.Faction
 *  com.massivecraft.factions.iface.RelationParticipator
 *  com.massivecraft.factions.struct.Relation
 *  org.bukkit.Bukkit
 *  org.bukkit.ChatColor
 *  org.bukkit.GameMode
 *  org.bukkit.Location
 *  org.bukkit.Material
 *  org.bukkit.Server
 *  org.bukkit.block.Block
 *  org.bukkit.block.BlockFace
 *  org.bukkit.command.Command
 *  org.bukkit.command.CommandExecutor
 *  org.bukkit.command.CommandSender
 *  org.bukkit.command.PluginCommand
 *  org.bukkit.entity.Entity
 *  org.bukkit.entity.Player
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.Listener
 *  org.bukkit.event.player.PlayerCommandPreprocessEvent
 *  org.bukkit.event.player.PlayerJoinEvent
 *  org.bukkit.event.player.PlayerMoveEvent
 *  org.bukkit.event.player.PlayerQuitEvent
 *  org.bukkit.event.player.PlayerToggleFlightEvent
 *  org.bukkit.inventory.Inventory
 *  org.bukkit.inventory.InventoryView
 *  org.bukkit.plugin.Plugin
 *  org.bukkit.plugin.PluginDescriptionFile
 *  org.bukkit.plugin.PluginManager
 *  org.bukkit.plugin.java.JavaPlugin
 *  org.bukkit.scheduler.BukkitScheduler
 */
package com.coolmark01.endless.ccfly;

import com.connorlinfoot.actionbarapi.ActionBarAPI;
import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.Faction;
import com.massivecraft.factions.iface.RelationParticipator;
import com.massivecraft.factions.struct.Relation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;
import com.coolmark01.endless.ccfly.CustomEnchantment;
import com.coolmark01.endless.ccfly.GUI;
import com.coolmark01.endless.ccfly.InventoryClick;
import com.coolmark01.endless.ccfly.ParticleEffect;
import com.coolmark01.endless.ccfly.ParticleFly;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public class Core
extends JavaPlugin
implements Listener,
CommandExecutor {
    public static Map<UUID, ParticleFly> chosen = new HashMap<UUID, ParticleFly>();
    List<UUID> a = new ArrayList<UUID>();
    List<UUID> staff = new ArrayList<UUID>();
    public static CustomEnchantment ench = new CustomEnchantment(69);
    public Map<UUID, Integer> que1 = new HashMap<UUID, Integer>();
    public Map<UUID, Integer> que2 = new HashMap<UUID, Integer>();
    public Map<UUID, Integer> que3 = new HashMap<UUID, Integer>();
    public Map<UUID, Integer> amounts = new HashMap<UUID, Integer>();
    public Map<UUID, Integer> amounts1 = new HashMap<UUID, Integer>();
    public Map<UUID, Integer> amounts2 = new HashMap<UUID, Integer>();
    List<UUID> bad = new ArrayList<UUID>();
    public Map<UUID, Integer> que = new HashMap<UUID, Integer>();

    public void onEnable() {
        this.getLogger().info(">>Plugin " + this.getDescription().getVersion() + "Is enabled!");
        this.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this);
        this.getCommand("ffly").setExecutor((CommandExecutor)this);
        this.getCommand("fflycos").setExecutor((CommandExecutor)this);
        PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents((Listener)new InventoryClick(this), (Plugin)this);
    }

    public void onDisable() {
        this.getLogger().info(">>Plugin " + this.getDescription().getVersion() + "Is Disable!");
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player)sender;
            if (cmd.getName().equalsIgnoreCase("ffly")) {
                if (player.getGameMode() != GameMode.CREATIVE) {
                    if (player.hasPermission("ccfly.fly")) {
                        FPlayer fp = FPlayers.getInstance().getByPlayer(player);
                        if (fp.isInOwnTerritory()) {
                            if (fp.hasFaction()) {
                                for (Entity a : player.getNearbyEntities(255.0, 255.0, 255.0)) {
                                    if (!(a instanceof Player)) continue;
                                    Player player2 = (Player)a;
                                    FPlayer fplayer = FPlayers.getInstance().getByPlayer(player2);
                                    Faction faction = FPlayers.getInstance().getByPlayer(player).getFaction();
                                    if (fplayer.getFaction().getRelationTo((RelationParticipator)faction) == Relation.ENEMY && !this.staff.contains((Object)a)) {
                                        player.sendMessage((Object)ChatColor.RED + "There are enemy players nearby.");
                                        return false;
                                    }
                                    if (fplayer.getFaction().getRelationTo((RelationParticipator)faction) != Relation.NEUTRAL || this.staff.contains((Object)a)) continue;
                                    player.sendMessage((Object)ChatColor.RED + "There are neutral players nearby.");
                                    return false;
                                }
                                if (!player.isFlying() && !player.getAllowFlight()) {
                                    this.a.add(player.getUniqueId());
                                    player.setAllowFlight(true);
                                    player.setFlying(true);
                                    player.sendMessage((Object)ChatColor.GRAY + ChatColor.BOLD.toString() + "Flying: " + (Object)ChatColor.GREEN + (Object)ChatColor.BOLD + (Object)ChatColor.ITALIC + "On");
                                    this.multiple(player);
                                } else if (player.isFlying() && player.getAllowFlight()) {
                                    player.setAllowFlight(false);
                                    player.setFlying(false);
                                    this.a.remove(player.getUniqueId());
                                    this.stop(player);
                                    player.sendMessage((Object)ChatColor.GRAY + ChatColor.BOLD.toString() + "Flying: " + (Object)ChatColor.RED + (Object)ChatColor.BOLD + (Object)ChatColor.ITALIC + "Off");
                                } else if (!player.isFlying() && player.getAllowFlight()) {
                                    player.setAllowFlight(false);
                                    player.setFlying(false);
                                    this.a.remove(player.getUniqueId());
                                    this.stop(player);
                                    player.sendMessage((Object)ChatColor.GRAY + ChatColor.BOLD.toString() + "Flying: " + (Object)ChatColor.RED + (Object)ChatColor.BOLD + (Object)ChatColor.ITALIC + "Off");
                                }
                            } else {
                                player.sendMessage((Object)ChatColor.RED + "You must have a faction todo this command!");
                            }
                        } else if (this.que1.containsKey(player.getUniqueId()) && player.isFlying() && player.getAllowFlight()) {
                            Bukkit.getServer().getScheduler().cancelTask(this.que1.get(player.getUniqueId()).intValue());
                            this.que1.remove(player.getUniqueId());
                            this.amounts.remove(player.getUniqueId());
                            player.setAllowFlight(false);
                            player.setFlying(false);
                            this.a.remove(player.getUniqueId());
                            this.stop(player);
                            player.sendMessage((Object)ChatColor.GRAY + ChatColor.BOLD.toString() + "Flying: " + (Object)ChatColor.RED + (Object)ChatColor.BOLD + (Object)ChatColor.ITALIC + "Off");
                        } else {
                            player.sendMessage((Object)ChatColor.RED + "You are in the enemy land!");
                        }
                    } else {
                        player.sendMessage((Object)ChatColor.DARK_RED + "You do not have access to that command.");
                    }
                } else {
                    player.sendMessage((Object)ChatColor.RED + "You must not be in creative!");
                }
            } else if (cmd.getName().equalsIgnoreCase("fflycos")) {
                player.openInventory(GUI.mainMenu(player));
            }
        } else {
            sender.sendMessage((Object)ChatColor.RED + "Only players can do this command!");
        }
        return false;
    }

    @EventHandler
    public void warpCommand(PlayerCommandPreprocessEvent event) {
        if (event.getMessage().equalsIgnoreCase("/staff")) {
            if (this.staff.contains(event.getPlayer().getUniqueId())) {
                this.staff.remove(event.getPlayer().getUniqueId());
            } else {
                this.staff.add(event.getPlayer().getUniqueId());
            }
        }
        if (event.getMessage().equalsIgnoreCase("/fly")) {
            if (this.a.contains((Object)event.getPlayer())) {
                this.a.remove(event.getPlayer().getUniqueId());
            }
            this.a.remove(event.getPlayer().getUniqueId());
            if (this.que1.containsKey(event.getPlayer().getUniqueId())) {
                Bukkit.getServer().getScheduler().cancelTask(this.que1.get(event.getPlayer().getUniqueId()).intValue());
                this.que1.remove(event.getPlayer().getUniqueId());
                this.amounts.remove(event.getPlayer().getUniqueId());
            }
            if (this.que2.containsKey(event.getPlayer().getUniqueId()) && this.amounts1.containsKey(event.getPlayer().getUniqueId())) {
                event.getPlayer().setFlying(false);
                event.getPlayer().setAllowFlight(false);
                this.bad.remove(event.getPlayer().getUniqueId());
                Bukkit.getServer().getScheduler().cancelTask(this.que2.get(event.getPlayer().getUniqueId()).intValue());
                this.que2.remove(event.getPlayer().getUniqueId());
                this.amounts1.remove(event.getPlayer().getUniqueId());
            }
            if (this.que3.containsKey(event.getPlayer().getUniqueId()) && this.amounts2.containsKey(event.getPlayer().getUniqueId())) {
                event.getPlayer().setFlying(false);
                event.getPlayer().setAllowFlight(false);
                this.bad.remove(event.getPlayer().getUniqueId());
                Bukkit.getServer().getScheduler().cancelTask(this.que3.get(event.getPlayer().getUniqueId()).intValue());
                this.que3.remove(event.getPlayer().getUniqueId());
                this.amounts2.remove(event.getPlayer().getUniqueId());
            }
        }
        if (event.getMessage().equalsIgnoreCase("/gm 1") || event.getMessage().equalsIgnoreCase("/gamemode 1") || event.getMessage().equalsIgnoreCase("/gamemode 3") || event.getMessage().equalsIgnoreCase("/gm 3")) {
            if (this.a.contains((Object)event.getPlayer())) {
                this.a.remove(event.getPlayer().getUniqueId());
            }
            this.a.remove(event.getPlayer().getUniqueId());
            if (this.que1.containsKey(event.getPlayer().getUniqueId())) {
                Bukkit.getServer().getScheduler().cancelTask(this.que1.get(event.getPlayer().getUniqueId()).intValue());
                this.que1.remove(event.getPlayer().getUniqueId());
                this.amounts.remove(event.getPlayer().getUniqueId());
            }
            if (this.que2.containsKey(event.getPlayer().getUniqueId()) && this.amounts1.containsKey(event.getPlayer().getUniqueId())) {
                event.getPlayer().setFlying(false);
                event.getPlayer().setAllowFlight(false);
                this.bad.remove(event.getPlayer().getUniqueId());
                Bukkit.getServer().getScheduler().cancelTask(this.que2.get(event.getPlayer().getUniqueId()).intValue());
                this.que2.remove(event.getPlayer().getUniqueId());
                this.amounts1.remove(event.getPlayer().getUniqueId());
            }
            if (this.que3.containsKey(event.getPlayer().getUniqueId()) && this.amounts2.containsKey(event.getPlayer().getUniqueId())) {
                event.getPlayer().setFlying(false);
                event.getPlayer().setAllowFlight(false);
                this.bad.remove(event.getPlayer().getUniqueId());
                Bukkit.getServer().getScheduler().cancelTask(this.que3.get(event.getPlayer().getUniqueId()).intValue());
                this.que3.remove(event.getPlayer().getUniqueId());
                this.amounts2.remove(event.getPlayer().getUniqueId());
            }
        }
    }

    @EventHandler
    public void warpCommand(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        FPlayer fp = FPlayers.getInstance().getByPlayer(player);
        if (!(player.isFlying() || player.getAllowFlight() || player.getGameMode() == GameMode.CREATIVE || !fp.isInOwnTerritory() || !this.a.contains(player.getUniqueId()) || this.staff.contains(player.getUniqueId()) || this.que2.containsKey(player.getUniqueId()) || this.que3.containsKey(player.getUniqueId()) || this.bad.contains(player.getUniqueId()))) {
            player.setAllowFlight(true);
            player.setFlying(true);
        }
        if (player.isFlying() && player.getAllowFlight() && player.getGameMode() != GameMode.CREATIVE && this.a.contains(player.getUniqueId()) && !this.staff.contains(player.getUniqueId())) {
            if (fp.isInOwnTerritory() && !this.bad.contains(player.getUniqueId())) {
                for (Entity a : player.getNearbyEntities(255.0, 255.0, 255.0)) {
                    if (!(a instanceof Player)) continue;
                    Player player2 = (Player)a;
                    FPlayer fplayer = FPlayers.getInstance().getByPlayer(player2);
                    Faction faction = FPlayers.getInstance().getByPlayer(player).getFaction();
                    if (fplayer.getFaction().getRelationTo((RelationParticipator)faction) == Relation.ENEMY && !this.staff.contains((Object)a)) {
                        if (this.que.containsKey(player.getUniqueId()) && !this.que2.containsKey(player.getUniqueId())) {
                            this.multiple2(player);
                        }
                        return;
                    }
                    if (fplayer.getFaction().getRelationTo((RelationParticipator)faction) != Relation.NEUTRAL || this.staff.contains((Object)a)) continue;
                    if (this.que.containsKey(player.getUniqueId()) && !this.que3.containsKey(player.getUniqueId())) {
                        this.multiple3(player);
                    }
                    return;
                }
                if (this.bad.contains(player.getUniqueId())) {
                    this.bad.remove(player.getUniqueId());
                }
                player.setAllowFlight(true);
                if (this.que1.containsKey(player.getUniqueId())) {
                    Bukkit.getServer().getScheduler().cancelTask(this.que1.get(player.getUniqueId()).intValue());
                    this.que1.remove(player.getUniqueId());
                    this.amounts.remove(player.getUniqueId());
                }
                if (this.que2.containsKey(event.getPlayer().getUniqueId()) && this.amounts1.containsKey(event.getPlayer().getUniqueId())) {
                    event.getPlayer().setFlying(false);
                    event.getPlayer().setAllowFlight(false);
                    Bukkit.getServer().getScheduler().cancelTask(this.que2.get(event.getPlayer().getUniqueId()).intValue());
                    this.que2.remove(event.getPlayer().getUniqueId());
                    this.amounts1.remove(event.getPlayer().getUniqueId());
                }
                if (this.que3.containsKey(event.getPlayer().getUniqueId()) && this.amounts2.containsKey(event.getPlayer().getUniqueId())) {
                    event.getPlayer().setFlying(false);
                    event.getPlayer().setAllowFlight(false);
                    Bukkit.getServer().getScheduler().cancelTask(this.que3.get(event.getPlayer().getUniqueId()).intValue());
                    this.que3.remove(event.getPlayer().getUniqueId());
                    this.amounts2.remove(event.getPlayer().getUniqueId());
                }
                return;
            }
            if (!(this.que1.containsKey(player.getUniqueId()) || this.que2.containsKey(player.getUniqueId()) || this.que3.containsKey(player.getUniqueId()) || this.bad.contains(player.getUniqueId()))) {
                this.multiple1(player);
            }
        }
    }

    @EventHandler
    public void onPlayerFly(PlayerToggleFlightEvent e) {
        Player player = e.getPlayer();
        FPlayer fp = FPlayers.getInstance().getByPlayer(player);
        if (!(player.getGameMode() == GameMode.CREATIVE || fp.isInOwnTerritory() || player.getAllowFlight() || player.isFlying() || !this.a.contains(player.getUniqueId()) || this.bad.contains(player.getUniqueId()))) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void warpCommand(final PlayerJoinEvent event) {
        final FPlayer fp = FPlayers.getInstance().getByPlayer(event.getPlayer());
        Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)this, new Runnable(){

            @Override
            public void run() {
                if (event.getPlayer().getLocation().getBlock().getRelative(BlockFace.DOWN).getType() != Material.AIR || event.getPlayer().isFlying() && fp.isInOwnTerritory()) {
                    Core.this.multiple(event.getPlayer());
                } else {
                    event.getPlayer().setAllowFlight(false);
                    event.getPlayer().setFlying(false);
                }
            }
        }, 5);
    }

    @EventHandler
    public void warpCommand(PlayerQuitEvent event) {
        if (event.getPlayer().getLocation().getBlock().getRelative(BlockFace.DOWN).getType() != Material.AIR || event.getPlayer().isFlying()) {
            this.stop(event.getPlayer());
        }
    }

    public void multiple1(final Player player) {
        if (this.a.contains(player.getUniqueId())) {
            this.amounts.put(player.getUniqueId(), 5);
            this.que1.put(player.getUniqueId(), Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask((Plugin)this, new Runnable(){
                int i;

                @Override
                public void run() {
                    if (this.i <= 0 && Core.this.que1.containsKey(player.getUniqueId()) && Core.this.amounts.containsKey(player.getUniqueId())) {
                        player.setFlying(false);
                        player.setAllowFlight(false);
                        Bukkit.getServer().getScheduler().cancelTask(Core.this.que1.get(player.getUniqueId()).intValue());
                        Core.this.que1.remove(player.getUniqueId());
                        Core.this.amounts.remove(player.getUniqueId());
                    }
                    ActionBarAPI.sendActionBar((Player)player, (String)((Object)ChatColor.RED + "Fly will disable in: " + this.i));
                    --this.i;
                }
            }, 0, 20));
        }
    }

    public void multiple2(final Player player) {
        if (this.a.contains(player.getUniqueId())) {
            this.amounts1.put(player.getUniqueId(), 5);
            this.que2.put(player.getUniqueId(), Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask((Plugin)this, new Runnable(){
                int i;

                @Override
                public void run() {
                    if (this.i <= 0 && Core.this.que2.containsKey(player.getUniqueId()) && Core.this.amounts1.containsKey(player.getUniqueId())) {
                        player.setFlying(false);
                        player.setAllowFlight(false);
                        Core.this.bad.add(player.getUniqueId());
                        Bukkit.getServer().getScheduler().cancelTask(Core.this.que2.get(player.getUniqueId()).intValue());
                        Core.this.que2.remove(player.getUniqueId());
                        Core.this.amounts1.remove(player.getUniqueId());
                    }
                    ActionBarAPI.sendActionBar((Player)player, (String)((Object)ChatColor.RED + "Enemy near by, disabling in: " + this.i));
                    --this.i;
                }
            }, 0, 20));
        }
    }

    public void multiple3(final Player player) {
        if (this.a.contains(player.getUniqueId())) {
            this.amounts2.put(player.getUniqueId(), 5);
            this.que3.put(player.getUniqueId(), Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask((Plugin)this, new Runnable(){
                int i;

                @Override
                public void run() {
                    if (this.i <= 0 && Core.this.que3.containsKey(player.getUniqueId()) && Core.this.amounts2.containsKey(player.getUniqueId())) {
                        player.setFlying(false);
                        player.setAllowFlight(false);
                        Core.this.bad.add(player.getUniqueId());
                        Bukkit.getServer().getScheduler().cancelTask(Core.this.que3.get(player.getUniqueId()).intValue());
                        Core.this.que3.remove(player.getUniqueId());
                        Core.this.amounts2.remove(player.getUniqueId());
                    }
                    ActionBarAPI.sendActionBar((Player)player, (String)((Object)ChatColor.RED + "Nutral near by, disabling in: " + this.i));
                    --this.i;
                }
            }, 0, 20));
        }
    }

    public void stop(Player player) {
        if (this.que.containsKey(player.getUniqueId())) {
            Bukkit.getServer().getScheduler().cancelTask(this.que.get(player.getUniqueId()).intValue());
            this.que.remove(player.getUniqueId());
        }
    }

    public void multiple(final Player player) {
        this.que.put(player.getUniqueId(), Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask((Plugin)this, new Runnable(){

            @Override
            public void run() {
                if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.AIR && player.isFlying() && !Core.this.staff.contains(player.getUniqueId())) {
                    ParticleFly type;
                    ParticleEffect[] part;
                    if (Core.chosen.containsKey(player.getUniqueId())) {
                        type = Core.chosen.get(player.getUniqueId());
                    } else {
                        Core.chosen.put(player.getUniqueId(), ParticleFly.BASIC);
                        type = Core.chosen.get(player.getUniqueId());
                    }
                    if (Core.chosen.containsKey(player.getUniqueId())) {
                        part = Core.chosen.get(player.getUniqueId()).a();
                    } else {
                        Core.chosen.put(player.getUniqueId(), ParticleFly.BASIC);
                        part = Core.chosen.get(player.getUniqueId()).a();
                    }
                    if (!player.hasPermission("ccfly.particlestop")) {
                        ParticleEffect[] arrparticleEffect = part;
                        int n = arrparticleEffect.length;
                        int n2 = 0;
                        while (n2 < n) {
                            ParticleEffect asd = arrparticleEffect[n2];
                            if (asd == ParticleEffect.WATER_DROP && !type.equals((Object)ParticleFly.REDSTONEWATER)) {
                                asd.display(0.0f, 0.0f, 0.0f, 0.0f, 1, player.getLocation().add(0.05, -0.2, 0.0), 100.0);
                            } else if (asd == ParticleEffect.CRIT_MAGIC) {
                                asd.display(0.0f, 0.0f, 0.0f, 0.0f, 1, player.getLocation(), 100.0);
                            } else if (asd == ParticleEffect.ENCHANTMENT_TABLE) {
                                asd.display(0.0f, 0.0f, 0.0f, 0.0f, 1, player.getLocation(), 100.0);
                            } else if (part.equals((Object)ParticleFly.WATER)) {
                                asd.display(0.0f, 0.0f, 0.0f, 0.0f, 1, player.getLocation().add(0.0, 0.1, 0.0), 100.0);
                            } else {
                                asd.display(0.0f, 0.0f, 0.0f, 0.0f, 1, player.getLocation().add(0.0, -0.2, 0.0), 100.0);
                            }
                            ++n2;
                        }
                    }
                }
            }
        }, 0, 1));
    }

}

