package net.haminacam.starblocksmod.block;

import net.haminacam.starblocksmod.StarBlocksMod;
import net.haminacam.starblocksmod.item.ModItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
public static final DeferredRegister<Block> BLOCKS =
        DeferredRegister.create(ForgeRegistries.BLOCKS, StarBlocksMod.MOD_ID);

public static final RegistryObject<Block> DURASTEEL_BLOCK = registerBlock("durasteel_block",
        () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

public static final RegistryObject<Block> RAW_DURASTEEL_BLOCK = registerBlock("raw_durasteel_block",
        () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

public static final RegistryObject<Block> KYBER_CRYSTAL_BLOCK = registerBlock("kyber_crystal_block",
        () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));

public static final RegistryObject<Block> DURASTEEL_ORE = registerBlock("durasteel_ore",
        () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));

public static final RegistryObject<Block> DEEPSLATE_DURASTEEL_ORE = registerBlock("deepslate_durasteel_ore",
        () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));

public static final RegistryObject<Block> KYBER_CRYSTAL_ORE = registerBlock("kyber_crystal_ore",
        () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                .strength(3f).requiresCorrectToolForDrops(), UniformInt.of(4, 7)));

public static final RegistryObject<Block> DEEPSLATE_KYBER_CRYSTAL_ORE = registerBlock("deepslate_kyber_crystal_ore",
        () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                .strength(6f).requiresCorrectToolForDrops(), UniformInt.of(4, 8)));

public static final RegistryObject<Block> DURASTEEL_STAIRS = registerBlock("durasteel_stairs",
        () -> new StairBlock(() -> ModBlocks.DURASTEEL_BLOCK.get().defaultBlockState(),
                BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
public static final RegistryObject<Block> DURASTEEL_SLAB = registerBlock("durasteel_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

public static final RegistryObject<Block> DURASTEEL_BUTTON = registerBlock("durasteel_button",
        () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON),
                BlockSetType.IRON, 10, true));
public static final RegistryObject<Block> DURASTEEL_PRESSURE_PLATE = registerBlock("durasteel_pressure_plate",
        () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK),
                BlockSetType.IRON));

public static final RegistryObject<Block> DURASTEEL_FENCE = registerBlock("durasteel_fence",
        () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
public static final RegistryObject<Block> DURASTEEL_FENCE_GATE = registerBlock("durasteel_fence_gate",
        () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK), SoundEvents.CHAIN_PLACE, SoundEvents.ANVIL_BREAK));
public static final RegistryObject<Block> DURASTEEL_WALL = registerBlock("durasteel_wall",
        () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
    RegistryObject<T> toReturn = BLOCKS.register(name, block);
    registerBlockItem(name, toReturn);
    return toReturn;
}


private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
    return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
}

public static void register(IEventBus eventBus){
    BLOCKS.register(eventBus);
}
}
