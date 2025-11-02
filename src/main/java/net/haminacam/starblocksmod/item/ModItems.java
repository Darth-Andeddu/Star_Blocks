package net.haminacam.starblocksmod.item;

import net.haminacam.starblocksmod.StarBlocksMod;
import net.haminacam.starblocksmod.item.custom.FuelItem;
import net.haminacam.starblocksmod.item.custom.ModToolTiers;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, StarBlocksMod.MOD_ID);

    public static final RegistryObject<Item> KYBER_CRYSTAL = ITEMS.register("kyber_crystal",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CREDIT = ITEMS.register("credit",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DURASTEEL_INGOT = ITEMS.register("durasteel_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_DURASTEEL = ITEMS.register("raw_durasteel",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LIGHT_SABER = ITEMS.register("light_saber",
            () -> new SwordItem(ModToolTiers.DURASTEEL, 4, 3, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> VIBROBLADE = ITEMS.register("vibroblade",
            () -> new SwordItem(ModToolTiers.DURASTEEL, 4, 3, new Item.Properties().stacksTo(1)));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}