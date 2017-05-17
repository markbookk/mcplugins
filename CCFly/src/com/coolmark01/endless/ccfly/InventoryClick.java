/*
 * Decompiled with CFR 0_118.
 * 
 * Could not load the following classes:
 *  org.bukkit.ChatColor
 *  org.bukkit.Material
 *  org.bukkit.entity.HumanEntity
 *  org.bukkit.entity.Player
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.Listener
 *  org.bukkit.event.inventory.InventoryClickEvent
 *  org.bukkit.inventory.Inventory
 *  org.bukkit.inventory.InventoryView
 *  org.bukkit.inventory.ItemStack
 *  org.bukkit.inventory.meta.ItemMeta
 */
package com.coolmark01.endless.ccfly;

import java.util.Map;
import java.util.UUID;
import com.coolmark01.endless.ccfly.Core;
import com.coolmark01.endless.ccfly.GUI;
import com.coolmark01.endless.ccfly.ParticleFly;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InventoryClick
implements Listener {
    public InventoryClick(Core core) {
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player)event.getWhoClicked();
        ItemStack clicked = event.getCurrentItem();
        if (event.isCancelled()) {
            return;
        }
        if (!(player instanceof Player)) {
            return;
        }
        if (clicked == null || clicked.getType() == Material.AIR) {
            return;
        }
        String cleaned = ChatColor.stripColor((String)clicked.getItemMeta().getDisplayName());
        if (event.getInventory().getName().equals(GUI.mainMenu(player).getName())) {
            event.setCancelled(true);
            if (!clicked.hasItemMeta()) {
                return;
            }
            if (clicked.getType().equals((Object)Material.STAINED_GLASS_PANE) || clicked.getType().equals((Object)Material.THIN_GLASS)) {
                event.setCancelled(true);
                return;
            }
            String a = clicked.getItemMeta().getDisplayName();
            this.type(cleaned, "Basic Effect", ParticleFly.BASIC, player, a, "ccfly.ffly.basic");
            this.type(cleaned, "Fire Effect", ParticleFly.FIRE, player, a, "ccfly.ffly.fire");
            this.type(cleaned, "RedWater Effect", ParticleFly.REDSTONEWATER, player, a, "ccfly.ffly.redwater");
            this.type(cleaned, "Magic Effect", ParticleFly.MAGIC, player, a, "ccfly.ffly.magic");
            this.type(cleaned, "Ball Effect", ParticleFly.BALL, player, a, "ccfly.ffly.ball");
            player.openInventory(GUI.mainMenu(player));
            event.setCancelled(true);
        }
    }

    private void type(String itemName, String required, ParticleFly effect, Player player, String selectmsg, String perm) {
        if (itemName.equalsIgnoreCase(required)) {
            if (player.hasPermission(perm)) {
                if (effect.equals((Object)Core.chosen.get(player.getUniqueId()))) {
                    return;
                }
                Core.chosen.put(player.getUniqueId(), effect);
                player.sendMessage(String.valueOf(selectmsg) + (Object)ChatColor.GRAY + ChatColor.BOLD.toString() + " has been selected!");
            } else {
                player.sendMessage((Object)ChatColor.RED + ChatColor.BOLD.toString() + "You do not have: " + selectmsg + (Object)ChatColor.RED + ChatColor.BOLD.toString() + " trail!");
            }
        }
    }
}

