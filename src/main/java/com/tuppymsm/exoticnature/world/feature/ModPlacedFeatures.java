package com.tuppymsm.exoticnature.world.feature;

import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class ModPlacedFeatures {
    public static final PlacedFeature WHIMPERING_PLACED =
            PlacementUtils.register("whimpering_placed", ModConfiguredFeature.WHIMPERING_TREE_CHECKED.placed(VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(1, 0.05f, 2))));
}
