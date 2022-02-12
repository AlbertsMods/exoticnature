package com.tuppymsm.exoticnature.block;

import net.albertsmods.albertslibrary.block.custom.flammable.nether.ModNetherFlammableLeavesBlock;
import net.albertsmods.albertslibrary.block.custom.flammable.nether.ModNetherFlammablePlankBlock;
import net.albertsmods.albertslibrary.block.custom.flammable.nether.ModNetherFlammableRotatedPillarBlock;
import com.tuppymsm.exoticnature.ExoticNature;
import com.tuppymsm.exoticnature.item.ModCreativeModTab;
import com.tuppymsm.exoticnature.item.ModItems;
import com.tuppymsm.exoticnature.world.feature.tree.WhimperingTreeGrower;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ExoticNature.MOD_ID);

    public static final RegistryObject<Block> WHIMPERING_LOG = registerBlock("whimpering_log", () -> new ModNetherFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_STEM)), ModCreativeModTab.EXOTIC_NATURE);
    public static final RegistryObject<Block> WHIMPERING_WOOD = registerBlock("whimpering_wood", () -> new ModNetherFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_HYPHAE)), ModCreativeModTab.EXOTIC_NATURE);
    public static final RegistryObject<Block> WHIMPERING_PLANKS = registerBlock("whimpering_planks", () -> new ModNetherFlammablePlankBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)), ModCreativeModTab.EXOTIC_NATURE);
    public static final RegistryObject<Block> WHIMPERING_LEAVES = registerBlock("whimpering_leaves", () -> new ModNetherFlammableLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)), ModCreativeModTab.EXOTIC_NATURE);
    public static final RegistryObject<Block> WHIMPERING_SAPLING = registerBlock("whimpering_sapling", () -> new SaplingBlock(new WhimperingTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), ModCreativeModTab.EXOTIC_NATURE);
    //public static final RegistryObject<Block> WHIMPERING_SAPLING_SMALL = registerBlock("whimpering_sapling_small", () -> new SaplingBlock(new WhimperingSmallTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), ModCreativeModTab.EXOTIC_NATURE);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;

    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(ModCreativeModTab.EXOTIC_NATURE)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
