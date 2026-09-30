package net.gladgamerlad.thegladgamerladexperience.datagen;

import net.gladgamerlad.thegladgamerladexperience.TheGladGamerLadExperience;
import net.gladgamerlad.thegladgamerladexperience.block.ModBlocks;
import net.gladgamerlad.thegladgamerladexperience.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.data.PackOutput;

public class ModModelProvider extends ModelProvider {

    public ModModelProvider(PackOutput output) {
        super(output, TheGladGamerLadExperience.MODID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        blockModels.createHorizontallyRotatedBlock(ModBlocks.CRUSHER.get(), TexturedModel.ORIENTABLE);
        blockModels.createHorizontallyRotatedBlock(ModBlocks.WASHER.get(), TexturedModel.ORIENTABLE);
        blockModels.createTrivialCube(ModBlocks.CRUDE_IRON_ORE.get());
        blockModels.createTrivialCube(ModBlocks.CRUDE_COPPER_ORE.get());
        blockModels.createTrivialCube(ModBlocks.CRUDE_GOLD_ORE.get());

        itemModels.generateFlatItem(ModItems.CRUSHED_RAW_IRON.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.CRUSHED_RAW_COPPER.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.CRUSHED_RAW_GOLD.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.TOTEM_OF_JIMOTHY.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.CRUSHED_EMERALD.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.IRON_HAMMER.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.DIAMOND_HAMMER.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.NETHERITE_HAMMER.get(), ModelTemplates.FLAT_ITEM);
    }
}