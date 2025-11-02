package net.haminacam.starblocksmod.datagen;

import net.haminacam.starblocksmod.StarBlocksMod;
import net.haminacam.starblocksmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
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

        stairsBlock(((StairBlock) ModBlocks.DURASTEEL_STAIRS.get()), blockTexture(ModBlocks.DURASTEEL_BLOCK.get()));
        slabBlock(((SlabBlock) ModBlocks.DURASTEEL_SLAB.get()), blockTexture(ModBlocks.DURASTEEL_BLOCK.get()), blockTexture(ModBlocks.DURASTEEL_BLOCK.get()));

        buttonBlock(((ButtonBlock) ModBlocks.DURASTEEL_BUTTON.get()), blockTexture(ModBlocks.DURASTEEL_BLOCK.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.DURASTEEL_PRESSURE_PLATE.get()), blockTexture(ModBlocks.DURASTEEL_BLOCK.get()));

        fenceBlock(((FenceBlock) ModBlocks.DURASTEEL_FENCE.get()), blockTexture(ModBlocks.DURASTEEL_BLOCK.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.DURASTEEL_FENCE_GATE.get()), blockTexture(ModBlocks.DURASTEEL_BLOCK.get()));
        wallBlock(((WallBlock) ModBlocks.DURASTEEL_WALL.get()), blockTexture(ModBlocks.DURASTEEL_BLOCK.get()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
