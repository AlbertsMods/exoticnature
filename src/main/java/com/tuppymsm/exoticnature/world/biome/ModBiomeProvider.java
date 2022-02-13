package com.tuppymsm.exoticnature.world.biome;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.SurfaceRules;
import terrablender.api.BiomeProvider;
import terrablender.worldgen.TBClimate;

import java.util.Optional;
import java.util.function.Consumer;

public class ModBiomeProvider extends BiomeProvider
{
    public ModBiomeProvider(ResourceLocation name, int overworldWeight, int netherWeight)
    {
        super(name, overworldWeight, netherWeight);
    }
    @Override
    public void addOverworldBiomes(Registry<Biome> registry, Consumer<Pair<TBClimate.ParameterPoint, ResourceKey<Biome>>> mapper)
    {
    }
    @Override
    public void addNetherBiomes(Registry<Biome> registry, Consumer<Pair<TBClimate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        //this.addBiomeSimilar(mapper, Biomes.SOUL_SAND_VALLEY, ModBiomeInit.WHIMPERING_WOODS);
    }

    @Override
    public Optional<SurfaceRules.RuleSource> getNetherSurfaceRules()
    {
        return Optional.of(ModSurfaceRuleData.makeRules());
    }
    @Override
    public Optional<SurfaceRules.RuleSource> getOverworldSurfaceRules()
    {
        return Optional.of(ModSurfaceRuleData.makeRules());
    }
}

