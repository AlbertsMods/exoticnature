package com.tuppymsm.exoticnature.world.biome;

import com.tuppymsm.exoticnature.ExoticNature;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class ModBiomeInit {

    public static final ResourceKey<Biome> EUCALYPTUS_EDGE = register("eucalyptus_edge");
    public static final ResourceKey<Biome> RAINFOREST = register("rainforest");

    private static ResourceKey<Biome> register(String name) {
        return  ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ExoticNature.MOD_ID, name));
    }
}
