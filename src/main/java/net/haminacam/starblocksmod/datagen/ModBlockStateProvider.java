package net.haminacam.starblocksmod.datagen;

import net.haminacam.starblocksmod.StarBlocksMod;
import net.haminacam.starblocksmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, StarBlocksMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.KYBER_CRYSTAL_BLOCK);
        blockWithItem(ModBlocks.DURASTEEL_BLOCK);
        blockWithItem(ModBlocks.RAW_DURASTEEL_BLOCK);

        blockWithItem(ModBlocks.KYBER_CRYSTAL_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_KYBER_CRYSTAL_ORE);
        blockWithItem(ModBlocks.DURASTEEL_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_DURASTEEL_ORE);
        blockWithItem(ModBlocks.SOUND_BLOCK);

    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
