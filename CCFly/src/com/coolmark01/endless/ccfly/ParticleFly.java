/*
 * Decompiled with CFR 0_118.
 */
package com.coolmark01.endless.ccfly;

import com.coolmark01.endless.ccfly.ParticleEffect;

public enum ParticleFly {
    BASIC(new ParticleEffect[]{ParticleEffect.CLOUD, ParticleEffect.SNOW_SHOVEL}),
    FIRE(new ParticleEffect[]{ParticleEffect.SMOKE_LARGE, ParticleEffect.FLAME}),
    REDSTONEWATER(new ParticleEffect[]{ParticleEffect.WATER_DROP, ParticleEffect.REDSTONE}),
    MAGIC(new ParticleEffect[]{ParticleEffect.ENCHANTMENT_TABLE, ParticleEffect.CRIT_MAGIC}),
    BALL(new ParticleEffect[]{ParticleEffect.SLIME, ParticleEffect.SNOWBALL}),
    WATER(new ParticleEffect[]{ParticleEffect.WATER_WAKE, ParticleEffect.WATER_SPLASH});
    
    private ParticleEffect[] parts;

    private ParticleFly(String a, int n2, ParticleEffect[] arrparticleEffect) {
        this.parts = a;
    }

    public ParticleEffect[] a() {
        return this.parts;
    }
}

