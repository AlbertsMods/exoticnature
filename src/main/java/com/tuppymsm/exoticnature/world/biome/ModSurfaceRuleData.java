package com.tuppymsm.exoticnature.world.biome;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class ModSurfaceRuleData {

    private static final SurfaceRules.RuleSource SOUL_SOIL =  makeStateRule(Blocks.SOUL_SOIL);
    private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final SurfaceRules.RuleSource NETHERRACK = makeStateRule(Blocks.NETHERRACK);

    protected static SurfaceRules.RuleSource makeRules() {
        SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);
        SurfaceRules.RuleSource grassSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT);

        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomeInit.WHIMPERING_WOODS), SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SOUL_SOIL)),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomeInit.WHIMPERING_WOODS), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, NETHERRACK)),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomeInit.WHIMPERING_WOODS), SurfaceRules.ifTrue(SurfaceRules.UNDER_CEILING, NETHERRACK))
        );
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block) {

        return SurfaceRules.state(block.defaultBlockState());
    }
}


