/*
 * Decompiled with CFR 0_118.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.ChatColor
 *  org.bukkit.DyeColor
 *  org.bukkit.Material
 *  org.bukkit.entity.Player
 *  org.bukkit.inventory.Inventory
 *  org.bukkit.inventory.InventoryHolder
 *  org.bukkit.inventory.ItemStack
 */
package com.coolmark01.endless.ccfly;

import java.util.Map;
import java.util.UUID;
import com.coolmark01.endless.ccfly.Core;
import com.coolmark01.endless.ccfly.ItemBuilder;
import com.coolmark01.endless.ccfly.ParticleFly;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public class GUI {
    public static Inventory mainMenu(Player player) {
        Inventory inv = Bukkit.createInventory((InventoryHolder)null, (int)27, (String)((Object)ChatColor.DARK_AQUA + ChatColor.BOLD.toString() + "FFly Trails"));
        ItemStack frame = new ItemBuilder(Material.STAINED_GLASS_PANE).setName(" ").setDyeColor(DyeColor.LIGHT_BLUE).toItemStack();
        ParticleFly a = ParticleFly.BASIC;
        if (Core.chosen.containsKey(player.getUniqueId()) && !a.equals((Object)ParticleFly.BALL)) {
            a = Core.chosen.get(player.getUniqueId());
        }
        ItemStack ball = a == ParticleFly.BALL ? new ItemBuilder(Material.SLIME_BALL).setName((Object)ChatColor.GREEN + ChatColor.BOLD.toString() + "Ball" + (Object)ChatColor.GOLD + ChatColor.BOLD.toString() + " Effect").setLore(" ", (Object)ChatColor.GRAY + "Avaliable: " + (Object)ChatColor.GREEN + ChatColor.BOLD.toString() + "YES").setGlowing().toItemStack() : (player.hasPermission("ccfly.ffly.ball") ? new ItemBuilder(Material.SLIME_BALL).setName((Object)ChatColor.GREEN + ChatColor.BOLD.toString() + "Ball" + (Object)ChatColor.GOLD + ChatColor.BOLD.toString() + " Effect").setLore(" ", (Object)ChatColor.GRAY + "Avaliable: " + (Object)ChatColor.GREEN + ChatColor.BOLD.toString() + "YES").toItemStack() : new ItemBuilder(Material.SLIME_BALL).setName((Object)ChatColor.GREEN + ChatColor.BOLD.toString() + "Ball" + (Object)ChatColor.GOLD + ChatColor.BOLD.toString() + " Effect").setLore(" ", (Object)ChatColor.GRAY + "Avaliable: " + (Object)ChatColor.RED + ChatColor.BOLD.toString() + "NO").toItemStack());
        ItemStack fire = a == ParticleFly.FIRE ? new ItemBuilder(Material.NETHERRACK).setName((Object)ChatColor.RED + ChatColor.BOLD.toString() + "F" + (Object)ChatColor.DARK_RED + ChatColor.BOLD.toString() + "i" + (Object)ChatColor.RED + ChatColor.BOLD.toString() + "r" + (Object)ChatColor.DARK_RED + ChatColor.BOLD.toString() + "e " + (Object)ChatColor.GRAY + (Object)ChatColor.GOLD + ChatColor.BOLD.toString() + "Effect").setLore(" ", (Object)ChatColor.GRAY + "Avaliable: " + (Object)ChatColor.GREEN + ChatColor.BOLD.toString() + "YES").setGlowing().toItemStack() : (player.hasPermission("ccfly.ffly.fire") ? new ItemBuilder(Material.NETHERRACK).setName((Object)ChatColor.RED + ChatColor.BOLD.toString() + "F" + (Object)ChatColor.DARK_RED + ChatColor.BOLD.toString() + "i" + (Object)ChatColor.RED + ChatColor.BOLD.toString() + "r" + (Object)ChatColor.DARK_RED + ChatColor.BOLD.toString() + "e " + (Object)ChatColor.GRAY + (Object)ChatColor.GOLD + ChatColor.BOLD.toString() + "Effect").setLore(" ", (Object)ChatColor.GRAY + "Avaliable: " + (Object)ChatColor.GREEN + ChatColor.BOLD.toString() + "YES").toItemStack() : new ItemBuilder(Material.NETHERRACK).setName((Object)ChatColor.RED + ChatColor.BOLD.toString() + "F" + (Object)ChatColor.DARK_RED + ChatColor.BOLD.toString() + "i" + (Object)ChatColor.RED + ChatColor.BOLD.toString() + "r" + (Object)ChatColor.DARK_RED + ChatColor.BOLD.toString() + "e " + (Object)ChatColor.GRAY + (Object)ChatColor.GOLD + ChatColor.BOLD.toString() + "Effect").setLore(" ", (Object)ChatColor.GRAY + "Avaliable: " + (Object)ChatColor.RED + ChatColor.BOLD.toString() + "NO").toItemStack());
        ItemStack magic = a == ParticleFly.MAGIC ? new ItemBuilder(Material.ENCHANTMENT_TABLE).setName((Object)ChatColor.DARK_AQUA + ChatColor.BOLD.toString() + "Magic" + (Object)ChatColor.GOLD + ChatColor.BOLD.toString() + " Effect").setLore(" ", (Object)ChatColor.GRAY + "Avaliable: " + (Object)ChatColor.GREEN + ChatColor.BOLD.toString() + "YES").setGlowing().toItemStack() : (player.hasPermission("ccfly.ffly.magic") ? new ItemBuilder(Material.ENCHANTMENT_TABLE).setName((Object)ChatColor.DARK_AQUA + ChatColor.BOLD.toString() + "Magic" + (Object)ChatColor.GOLD + ChatColor.BOLD.toString() + " Effect").setLore(" ", (Object)ChatColor.GRAY + "Avaliable: " + (Object)ChatColor.GREEN + ChatColor.BOLD.toString() + "YES").toItemStack() : new ItemBuilder(Material.ENCHANTMENT_TABLE).setName((Object)ChatColor.DARK_AQUA + ChatColor.BOLD.toString() + "Magic" + (Object)ChatColor.GOLD + ChatColor.BOLD.toString() + " Effect").setLore(" ", (Object)ChatColor.GRAY + "Avaliable: " + (Object)ChatColor.RED + ChatColor.BOLD.toString() + "NO").toItemStack());
        ItemStack redwater = a == ParticleFly.REDSTONEWATER ? new ItemBuilder(Material.REDSTONE).setName((Object)ChatColor.RED + ChatColor.BOLD.toString() + "Red" + (Object)ChatColor.AQUA + ChatColor.BOLD.toString() + "Water" + (Object)ChatColor.GOLD + ChatColor.BOLD.toString() + " Effect").setLore(" ", (Object)ChatColor.GRAY + "Avaliable: " + (Object)ChatColor.GREEN + ChatColor.BOLD.toString() + "YES").setGlowing().toItemStack() : (player.hasPermission("ccfly.ffly.redwater") ? new ItemBuilder(Material.REDSTONE).setName((Object)ChatColor.RED + ChatColor.BOLD.toString() + "Red" + (Object)ChatColor.AQUA + ChatColor.BOLD.toString() + "Water" + (Object)ChatColor.GOLD + ChatColor.BOLD.toString() + " Effect").setLore(" ", (Object)ChatColor.GRAY + "Avaliable: " + (Object)ChatColor.GREEN + ChatColor.BOLD.toString() + "YES").toItemStack() : new ItemBuilder(Material.REDSTONE).setName((Object)ChatColor.RED + ChatColor.BOLD.toString() + "Red" + (Object)ChatColor.AQUA + ChatColor.BOLD.toString() + "Water" + (Object)ChatColor.GOLD + ChatColor.BOLD.toString() + " Effect").setLore(" ", (Object)ChatColor.GRAY + "Avaliable: " + (Object)ChatColor.RED + ChatColor.BOLD.toString() + "NO").toItemStack());
        ItemStack basic = a == ParticleFly.BASIC ? new ItemBuilder(Material.WOOL).setName((Object)ChatColor.WHITE + ChatColor.BOLD.toString() + "Basic" + (Object)ChatColor.GOLD + ChatColor.BOLD.toString() + " Effect").setLore(" ", (Object)ChatColor.GRAY + "Avaliable: " + (Object)ChatColor.GREEN + ChatColor.BOLD.toString() + "YES").setGlowing().toItemStack() : (player.hasPermission("ccfly.fly") ? new ItemBuilder(Material.WOOL).setName((Object)ChatColor.WHITE + ChatColor.BOLD.toString() + "Basic" + (Object)ChatColor.GOLD + ChatColor.BOLD.toString() + " Effect").setLore(" ", (Object)ChatColor.GRAY + "Avaliable: " + (Object)ChatColor.GREEN + ChatColor.BOLD.toString() + "YES").toItemStack() : new ItemBuilder(Material.WOOL).setName((Object)ChatColor.WHITE + ChatColor.BOLD.toString() + "Basic" + (Object)ChatColor.GOLD + ChatColor.BOLD.toString() + " Effect").setLore(" ", (Object)ChatColor.GRAY + "Avaliable: " + (Object)ChatColor.RED + ChatColor.BOLD.toString() + "NO").toItemStack());
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
        inv.setItem(9, basic);
        inv.setItem(10, fire);
        inv.setItem(11, redwater);
        inv.setItem(12, magic);
        inv.setItem(13, ball);
        return inv;
    }
}

