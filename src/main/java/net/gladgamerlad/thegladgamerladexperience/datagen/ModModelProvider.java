package net.gladgamerlad.thegladgamerladexperience.datagen;

import net.gladgamerlad.thegladgamerladexperience.TheGladGamerLadExperience;
import net.gladgamerlad.thegladgamerladexperience.block.ModBlocks;
import net.gladgamerlad.thegladgamerladexperience.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;

public class ModModelProvider extends ModelProvider {

    public ModModelProvider(PackOutput output) {
        super(output, TheGladGamerLadExperience.MODID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        blockModels.createTrivialCube(ModBlocks.CRUSHER.get());
        blockModels.createTrivialCube(ModBlocks.WASHER.get());
        blockModels.createTrivialCube(ModBlocks.CRUDE_IRON_ORE.get());
        blockModels.createTrivialCube(ModBlocks.CRUDE_COPPER_ORE.get());
        blockModels.createTrivialCube(ModBlocks.CRUDE_GOLD_ORE.get());

        itemModels.generateFlatItem(ModItems.CRUSHED_RAW_IRON.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.CRUSHED_RAW_COPPER.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.CRUSHED_RAW_GOLD.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.TOTEM_OF_JIMOTHY.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.CRUSHED_EMERALD.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.HAMMER.get(), ModelTemplates.FLAT_ITEM);
    }
}