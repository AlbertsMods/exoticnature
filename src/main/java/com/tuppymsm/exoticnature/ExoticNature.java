package com.tuppymsm.exoticnature;

import com.tuppymsm.exoticnature.block.ModBlocks;
import com.tuppymsm.exoticnature.block.ModWoodTypes;
import com.tuppymsm.exoticnature.entity.ModEntityTypes;
import com.tuppymsm.exoticnature.util.ModSoundEvents;
import com.tuppymsm.exoticnature.world.biome.*;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.tuppymsm.exoticnature.item.ModItems;
import terrablender.api.BiomeProviders;

@Mod(ExoticNature.MOD_ID)
public class ExoticNature {
    public static final String MOD_ID = "exoticnature";

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public ExoticNature() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        ModItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModSoundEvents.SOUND_EVENTS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModEntityTypes.ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WHIMPERING_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WHIMPERING_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.AKEBIA_VINE.get(), RenderType.translucent());

        WoodType.register(ModWoodTypes.WHIMPERING);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        Sheets.addWoodType(ModWoodTypes.WHIMPERING);
    }
    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            BiomeProviders.register(new ModBiomeProvider(new ResourceLocation(MOD_ID, "biome_provider"), 0, 0));
        });
    }
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
        }
    }
}
