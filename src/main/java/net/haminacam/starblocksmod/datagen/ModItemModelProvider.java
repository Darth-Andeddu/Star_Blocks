package net.haminacam.starblocksmod.datagen;

import net.haminacam.starblocksmod.StarBlocksMod;
import net.haminacam.starblocksmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
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
        simpleItem(ModItems.METAL_DETECTOR);

        simpleItem(ModItems.PINE_CONE);
        simpleItem(ModItems.STRAWBERRY);

    }
    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(StarBlocksMod.MOD_ID, "item/" + item.getId().getPath()));
    }
}
