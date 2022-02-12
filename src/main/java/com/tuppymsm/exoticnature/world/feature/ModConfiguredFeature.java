package com.tuppymsm.exoticnature.world.feature;

import com.tuppymsm.exoticnature.ExoticNature;
import com.tuppymsm.exoticnature.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;

import java.util.List;

public class ModConfiguredFeature {
    // Whimpering Tree
    public static final ConfiguredFeature<TreeConfiguration, ?> WHIMPERING_TREE =
            FeatureUtils.register("whimpering", Feature.TREE.configured(
                    new TreeConfiguration.TreeConfigurationBuilder(
                            BlockStateProvider.simple(ModBlocks.WHIMPERING_LOG.get()),
                            new FancyTrunkPlacer(12, 13, 8),
                            BlockStateProvider.simple(Blocks.OAK_LEAVES),
                            new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 9),
                            new TwoLayersFeatureSize(6,0,2)).build()));

    public static final ConfiguredFeature<RandomFeatureConfiguration, ?> WHIMPERING_TREE_CHECKED =
            FeatureUtils.register("whimpering_feature",
                    Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(
                            WHIMPERING_TREE.filteredByBlockSurvival(ModBlocks.WHIMPERING_SAPLING.get()), 0.1f)),
                            WHIMPERING_TREE.filteredByBlockSurvival(ModBlocks.WHIMPERING_SAPLING.get()))));
    // Small Whimpering Tree
    public static final ConfiguredFeature<TreeConfiguration, ?> WHIMPERING_TREE_SMALL =
            FeatureUtils.register("whimpering_small", Feature.TREE.configured(
                    new TreeConfiguration.TreeConfigurationBuilder(
                            BlockStateProvider.simple(ModBlocks.WHIMPERING_LOG.get()),
                            new FancyTrunkPlacer(4, 1, 2),
                            BlockStateProvider.simple(Blocks.JUNGLE_LEAVES),
                            new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 2),
                            new TwoLayersFeatureSize(3,0,1)).build()));

    public static final ConfiguredFeature<RandomFeatureConfiguration, ?> WHIMPERING_TREE_SMALL_CHECKED =
            FeatureUtils.register("whimpering_small_feature",
                    Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(
                            WHIMPERING_TREE.filteredByBlockSurvival(ModBlocks.WHIMPERING_SAPLING_SMALL.get()), 0.1f)),
                            WHIMPERING_TREE.filteredByBlockSurvival(ModBlocks.WHIMPERING_SAPLING_SMALL.get()))));


    public static <FC extends FeatureConfiguration, F extends Feature<FC>, CF extends ConfiguredFeature<FC, F>> CF createConfiguredFeature(String id, CF configuredFeature) {
        ResourceLocation enID = new ResourceLocation(ExoticNature.MOD_ID, id);
        if (BuiltinRegistries.CONFIGURED_FEATURE.keySet().contains(enID))
            throw new IllegalStateException("Configured Feature ID: \"" + enID.toString() + "\" already exists in the Configured Features registry!");

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, enID, configuredFeature);
        if (configuredFeature == null) {
            String s = "";
        }
        return configuredFeature;
    }
}
