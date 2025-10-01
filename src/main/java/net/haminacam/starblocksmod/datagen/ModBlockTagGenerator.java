package net.haminacam.starblocksmod.datagen;

import net.haminacam.starblocksmod.StarBlocksMod;
import net.haminacam.starblocksmod.block.ModBlocks;
import net.haminacam.starblocksmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                                @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, StarBlocksMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
                .add(ModBlocks.KYBER_CRYSTAL_ORE.get()).addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                ModBlocks.DURASTEEL_BLOCK.get(),
                ModBlocks.RAW_DURASTEEL_BLOCK.get(),
                ModBlocks.DURASTEEL_ORE.get(),
                ModBlocks.DEEPSLATE_DURASTEEL_ORE.get(),
                ModBlocks.KYBER_CRYSTAL_BLOCK.get(),
                ModBlocks.KYBER_CRYSTAL_ORE.get(),
                ModBlocks.DEEPSLATE_KYBER_CRYSTAL_ORE.get(),
                ModBlocks.SOUND_BLOCK.get()
        );

        this.tag(BlockTags.NEEDS_IRON_TOOL).add(
                ModBlocks.DURASTEEL_BLOCK.get(),
                ModBlocks.RAW_DURASTEEL_BLOCK.get(),
                ModBlocks.DURASTEEL_ORE.get(),
                ModBlocks.DEEPSLATE_DURASTEEL_ORE.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(
                ModBlocks.KYBER_CRYSTAL_BLOCK.get(),
                ModBlocks.KYBER_CRYSTAL_ORE.get(),
                ModBlocks.DEEPSLATE_KYBER_CRYSTAL_ORE.get()
        );
    }
}
