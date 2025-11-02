package net.haminacam.starblocksmod.item.custom;

import net.haminacam.starblocksmod.StarBlocksMod;
import net.haminacam.starblocksmod.item.ModItems;
import net.haminacam.starblocksmod.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {

    public static final Tier DURASTEEL = TierSortingRegistry.registerTier(
            new ForgeTier(5, 1500, 5f, 4f, 25,
                    ModTags.Blocks.NEEDS_DURASTEEL_TOOL, () -> Ingredient.of(ModItems.DURASTEEL_INGOT.get())),
            new ResourceLocation(StarBlocksMod.MOD_ID, "durasteel"), List.of(Tiers.NETHERITE), List.of());

}
