/*
 * Decompiled with CFR 0_118.
 * 
 * Could not load the following classes:
 *  org.bukkit.enchantments.Enchantment
 *  org.bukkit.enchantments.EnchantmentTarget
 *  org.bukkit.inventory.ItemStack
 */
package com.coolmark01.endless.ccfly;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;

public class CustomEnchantment
extends Enchantment {
    public CustomEnchantment(int id) {
        super(id);
    }

    public boolean canEnchantItem(ItemStack item) {
        return true;
    }

    public boolean conflictsWith(Enchantment other) {
        return false;
    }

    public EnchantmentTarget getItemTarget() {
        return null;
    }

    public int getMaxLevel() {
        return 1;
    }

    public String getName() {
        return " ";
    }

    public int getId() {
        return 69;
    }

    public int getStartLevel() {
        return 1;
    }
}

