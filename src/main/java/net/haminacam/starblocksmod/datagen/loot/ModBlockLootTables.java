package net.haminacam.starblocksmod.datagen.loot;

import net.haminacam.starblocksmod.block.ModBlocks;
import net.haminacam.starblocksmod.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.DURASTEEL_BLOCK.get());
        this.dropSelf(ModBlocks.KYBER_CRYSTAL_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_DURASTEEL_BLOCK.get());

        this.add(ModBlocks.DURASTEEL_ORE.get(),
                block -> createOreDrops(ModBlocks.DURASTEEL_ORE.get(), ModItems.RAW_DURASTEEL.get()));
        this.add(ModBlocks.DEEPSLATE_DURASTEEL_ORE.get(),
                block -> createOreDrops(ModBlocks.DEEPSLATE_DURASTEEL_ORE.get(), ModItems.RAW_DURASTEEL.get()));
        this.add(ModBlocks.KYBER_CRYSTAL_ORE.get(),
                block -> createOreDrops(ModBlocks.KYBER_CRYSTAL_ORE.get(), ModItems.KYBER_CRYSTAL.get()));
        this.add(ModBlocks.DEEPSLATE_KYBER_CRYSTAL_ORE.get(),
                block -> createOreDrops(ModBlocks.DEEPSLATE_KYBER_CRYSTAL_ORE.get(), ModItems.KYBER_CRYSTAL.get()));

        this.dropSelf(ModBlocks.DURASTEEL_STAIRS.get());
        this.dropSelf(ModBlocks.DURASTEEL_BUTTON.get());
        this.dropSelf(ModBlocks.DURASTEEL_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.DURASTEEL_FENCE.get());
        this.dropSelf(ModBlocks.DURASTEEL_FENCE_GATE.get());
        this.dropSelf(ModBlocks.DURASTEEL_WALL.get());

        this.add(ModBlocks.DURASTEEL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DURASTEEL_SLAB.get()));

    }

    protected LootTable.Builder createOreDrops(Block pBlock, Item item){
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0f, 5.0f)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }


    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
