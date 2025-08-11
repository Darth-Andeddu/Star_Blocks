package net.haminacam.starblocksmod.item;


import net.haminacam.starblocksmod.StarBlocksMod;
import net.haminacam.starblocksmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, StarBlocksMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> STAR_BLOCKS_TAB = CREATIVE_MODE_TABS.register("star_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.KYBER_CRYSTAL.get()))
                    .title(Component.translatable("creativetab.star_blocks_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.KYBER_CRYSTAL.get());
                        pOutput.accept(ModItems.CREDIT.get());
                        pOutput.accept(ModItems.DURASTEEL_INGOT.get());
                        pOutput.accept(ModItems.RAW_DURASTEEL.get());

                        pOutput.accept(ModBlocks.DURASTEEL_BLOCK.get());
                        pOutput.accept(ModBlocks.RAW_DURASTEEL_BLOCK.get());
                        pOutput.accept(ModBlocks.KYBER_CRYSTAL_BLOCK.get());

                        pOutput.accept(ModBlocks.DURASTEEL_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_DURASTEEL_ORE.get());
                        pOutput.accept(ModBlocks.KYBER_CRYSTAL_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_KYBER_CRYSTAL_ORE.get());
                    })
                    .build());


    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
