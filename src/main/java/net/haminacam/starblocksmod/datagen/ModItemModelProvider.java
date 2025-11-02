package net.haminacam.starblocksmod.datagen;

import net.haminacam.starblocksmod.StarBlocksMod;
import net.haminacam.starblocksmod.block.ModBlocks;
import net.haminacam.starblocksmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, StarBlocksMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.DURASTEEL_INGOT);
        simpleItem(ModItems.RAW_DURASTEEL);
        simpleItem(ModItems.KYBER_CRYSTAL);

        simpleItem(ModItems.CREDIT);

        fenceItem(ModBlocks.DURASTEEL_FENCE, ModBlocks.DURASTEEL_BLOCK);
        buttonItem(ModBlocks.DURASTEEL_BUTTON, ModBlocks.DURASTEEL_BLOCK);
        wallItem(ModBlocks.DURASTEEL_WALL, ModBlocks.DURASTEEL_BLOCK);

        evenSimplerBlockItem(ModBlocks.DURASTEEL_STAIRS);
        evenSimplerBlockItem(ModBlocks.DURASTEEL_SLAB);
        evenSimplerBlockItem(ModBlocks.DURASTEEL_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.DURASTEEL_FENCE_GATE);


    }
    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(StarBlocksMod.MOD_ID, "item/" + item.getId().getPath()));
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block){
        this.withExistingParent(StarBlocksMod.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    public void trapdoorItem(RegistryObject<Block> block){
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture", new ResourceLocation(StarBlocksMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture", new ResourceLocation(StarBlocksMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall", new ResourceLocation(StarBlocksMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(StarBlocksMod.MOD_ID, "item/" + item.getId().getPath()));
    }

}
