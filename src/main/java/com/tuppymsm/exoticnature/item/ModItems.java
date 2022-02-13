package com.tuppymsm.exoticnature.item;

import com.tuppymsm.exoticnature.ExoticNature;
import com.tuppymsm.exoticnature.item.custom.GacArmourItem;
import com.tuppymsm.exoticnature.util.ModSoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.RecordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ExoticNature.MOD_ID);

    public static final RegistryObject<Item> SOUL_BERRY = ITEMS.register("soul_berry", () -> new Item(new Item.Properties().tab(ModCreativeModTab.EXOTIC_NATURE).food(new FoodProperties.Builder().nutrition(2).saturationMod(4.5f).effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 100, 1), 1.0f).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 1), 1.0f).alwaysEat().build())));
    public static final RegistryObject<Item> GAC_FRUIT = ITEMS.register("gac_fruit", () -> new Item(new Item.Properties().tab(ModCreativeModTab.EXOTIC_NATURE).food(new FoodProperties.Builder().nutrition(5).saturationMod(3.5f).build())));
    public static final RegistryObject<Item> GAC_BOOTS = ITEMS.register("gac_boots", () -> new ArmorItem(ModArmourMaterial.GAC, EquipmentSlot.FEET, new Item.Properties().tab(ModCreativeModTab.EXOTIC_NATURE)));
    public static final RegistryObject<Item> GAC_LEGGINGS = ITEMS.register("gac_leggings", () -> new ArmorItem(ModArmourMaterial.GAC, EquipmentSlot.LEGS, new Item.Properties().tab(ModCreativeModTab.EXOTIC_NATURE)));
    public static final RegistryObject<Item> GAC_CHESTPLATE = ITEMS.register("gac_chestplate", () -> new ArmorItem(ModArmourMaterial.GAC, EquipmentSlot.CHEST, new Item.Properties().tab(ModCreativeModTab.EXOTIC_NATURE)));
    public static final RegistryObject<Item> GAC_HELMET = ITEMS.register("gac_helmet", () -> new GacArmourItem(ModArmourMaterial.GAC, EquipmentSlot.HEAD, new Item.Properties().tab(ModCreativeModTab.EXOTIC_NATURE)));
    public static final RegistryObject<Item> EXOTIC_MUSIC_DISC = ITEMS.register("exotic_music_disc", () -> new RecordItem(1, () -> ModSoundEvents.EXOTIC_DISC.get(), new Item.Properties().stacksTo(1).tab(ModCreativeModTab.EXOTIC_NATURE).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> AKEBIA = ITEMS.register("akebia", () -> new Item(new Item.Properties().tab(ModCreativeModTab.EXOTIC_NATURE).food(new FoodProperties.Builder().nutrition(4).saturationMod(2.0f).effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 300, 1), 1.0f).build())));
    public static final RegistryObject<Item> WILD_AKEBIA = ITEMS.register("wild_akebia", () -> new Item(new Item.Properties().tab(ModCreativeModTab.EXOTIC_NATURE).food(new FoodProperties.Builder().nutrition(5).saturationMod(2.0f).effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 200, 1), 1.0f).build())));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
