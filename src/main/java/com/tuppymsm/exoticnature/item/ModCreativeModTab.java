package com.tuppymsm.exoticnature.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModTab {
    public static final CreativeModeTab EXOTIC_NATURE = new CreativeModeTab("ExoticNatureCreativeModeTab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.MANGOSTEEN.get());
        }
    };
}
