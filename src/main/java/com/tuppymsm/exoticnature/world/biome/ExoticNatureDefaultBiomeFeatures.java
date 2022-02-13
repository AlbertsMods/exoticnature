package com.tuppymsm.exoticnature.world.biome;

import com.tuppymsm.exoticnature.world.feature.ModPlacedFeatures;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.levelgen.GenerationStep;

public class ExoticNatureDefaultBiomeFeatures {

    public static void addWhimperingWillow(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.WHIMPERING_PLACED);
    }

    public static void addAkebiaVines(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.AKEBIA_VINES_PLACED);
    }
}
