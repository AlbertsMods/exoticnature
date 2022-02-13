package com.tuppymsm.exoticnature.world.biome;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class ModSurfaceRuleData {

    protected static SurfaceRules.RuleSource makeRules() {
        SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);
        return SurfaceRules.sequence(

        );
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block) {

        return SurfaceRules.state(block.defaultBlockState());
    }
}


