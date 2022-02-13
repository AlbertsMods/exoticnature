package com.tuppymsm.exoticnature.world.feature;

import com.tuppymsm.exoticnature.ExoticNature;
import com.tuppymsm.exoticnature.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.RandomSpreadFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.BendingTrunkPlacer;

import java.util.List;

public class ModConfiguredFeature {
    // Whimpering Tree
    public static final ConfiguredFeature<?, ?> WHIMPERING_TREE = FeatureUtils.register("azalea_tree",
            Feature.TREE.configured((new TreeConfiguration.TreeConfigurationBuilder
                    (BlockStateProvider.simple(ModBlocks.WHIMPERING_LOG.get()), new BendingTrunkPlacer
                            (4, 2, 0, 3, UniformInt.of
                                    (1, 2)), new WeightedStateProvider
                            (SimpleWeightedRandomList.<BlockState>builder().add
                                    (Blocks.GOLD_BLOCK.defaultBlockState(), 3).add
                                    (Blocks.DIAMOND_BLOCK.defaultBlockState(), 1)), new
                            RandomSpreadFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), ConstantInt.of(2),
                            50), new TwoLayersFeatureSize(1, 0, 1)))
                    .dirt(BlockStateProvider.simple(Blocks.SOUL_SOIL)).forceDirt().build()));

    public static final ConfiguredFeature<RandomFeatureConfiguration, ?> WHIMPERING_TREE_CHECKED =
            FeatureUtils.register("whimpering_feature",
                    Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(
                            WHIMPERING_TREE.filteredByBlockSurvival(ModBlocks.WHIMPERING_SAPLING.get()), 0.1f)),
                            WHIMPERING_TREE.filteredByBlockSurvival(ModBlocks.WHIMPERING_SAPLING.get()))));

    // Other
    public static final ConfiguredFeature<?, ?> AKEBIA_VINE = createConfiguredFeature("akebia_vine", Feature.VINES.configured(NoneFeatureConfiguration.NONE));


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
