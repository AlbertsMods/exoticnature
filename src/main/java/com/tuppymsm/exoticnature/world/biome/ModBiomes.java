package com.tuppymsm.exoticnature.world.biome;

import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBiomes {

    @SubscribeEvent
    public static void registerBiomes(RegistryEvent.Register<Biome> event) {

        IForgeRegistry<Biome> registry = event.getRegistry();

        // Overworld

        // Nether
        registry.register(ModNetherBiomes.whimperingWoods().setRegistryName(ModBiomeInit.WHIMPERING_WOODS.location()));
    }
}
